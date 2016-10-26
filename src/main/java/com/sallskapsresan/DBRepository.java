package com.sallskapsresan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBRepository {

    @Autowired
    DataSource datasource;

    public void createPasswords() throws NoSuchAlgorithmException {
        for (int i = 0; i < 50; i++) {
            try (Connection conn = datasource.getConnection();

                 PreparedStatement ps = conn.prepareStatement("UPDATE [dbo].[Users] SET HashedPassword = ?, Salt = ? WHERE UserID = ?")) {

                String salt = createSalt();
                String password = "123";


                ps.setString(1, hashedPassword(password, salt));
                ps.setString(2, salt);
                ps.setLong(3, i);
                ps.executeUpdate();

                System.out.println("new password " + i);
            } catch (SQLException e) {
                throw new RuntimeException("Fel i addUser");
            }
        }
    }

//    public void addUser(User user) {
//        try (Connection conn = datasource.getConnection();
//             PreparedStatement ps = conn.prepareStatement("EXEC addUser ?,?,?,?,?")) {
//            ps.setString(1, user.getFirstname());
//            ps.setString(2, user.getLastname());
//            ps.setString(3, user.getUsername());
//            ps.setString(4, user.getPassword());
//            ps.setString(5, user.getEmail());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException("Fel i addUser");
//        }
//    }

    public void addUser(User user) throws NoSuchAlgorithmException {
        try (Connection conn = datasource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO Users (FirstName, LastName, UserName, HashedPassword, Email, Salt) VALUES (?, ?, ?, ?, ?, ?)")) {
            String salt = createSalt();

            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getUsername());
            ps.setString(4, hashedPassword(user.getPassword(), salt));
            ps.setString(5, user.getEmail());
            ps.setString(6, salt);
            ps.executeUpdate();

            System.out.println("Sent to database");
        }
        catch (SQLException e) {
            throw new RuntimeException("Fel i addUser");
        }
    }


    public boolean validateUsername(User user) {
        try (Connection conn = datasource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM [dbo].[Users] WHERE UserName = ?")) {
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            return !rs.next();
        } catch (SQLException e) {
            throw new RuntimeException("Fel i addUser");
        }
    }

    public void setPersonalityType(User user) {
        try (Connection conn = datasource.getConnection();
             PreparedStatement ps = conn.prepareStatement("EXEC setPersonalityType ?,?")) {
            ps.setString(1, user.getUsername());
            ps.setLong(2, user.getPersonalityType().ordinal() + 1);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Fel i setPersonalityType");
        }
    }

    private long getPersonalityTypeID(PersonalityType personalityType) {
        try (Connection conn = datasource.getConnection();
             PreparedStatement ps = conn.prepareStatement("EXEC getPersonalityTypeID ?")) {
            ps.setString(1, personalityType.name());
            ResultSet rs = ps.executeQuery();
            long id = 1;
            if (rs.next())
                id = rs.getInt("PersonalityTypeID");
            return id;
        } catch (SQLException e) {
            throw new RuntimeException("Fel i setPersonalityType");
        }
    }

    public User getUser(String username) {
        try (Connection conn = datasource.getConnection();
             PreparedStatement ps = conn.prepareStatement("EXEC getUser ?")) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            User user = new User();
            if (rs.next()) {
                user.setFirstname(rs.getString("FirstName"));
                user.setLastname(rs.getString("LastName"));
                user.setEmail(rs.getString("EMail"));
//                user.setJoined(rs.getTimestamp("Created").toLocalDateTime());
//                user.setLastlogin(rs.getTimestamp("LastLogin").toLocalDateTime());
                user.setUserID(rs.getLong("UserID"));
                user.setPersonalityType(getPersonalityType(rs.getLong("Personality_ID")));
            }
            user.setUsername(username);
            return user;
        } catch (SQLException e) {
            throw new RuntimeException("Fel i getUser");
        }
    }

    private PersonalityType getPersonalityType(long personality_id) {
        try (Connection conn = datasource.getConnection();
             PreparedStatement ps = conn.prepareStatement("EXEC getPersonalityType ?")) {
            ps.setLong(1, personality_id);
            ResultSet rs = ps.executeQuery();
            PersonalityType pt = PersonalityType.DEFAULT;
            if (rs.next()) {
                pt = PersonalityType.getPersonalityType(rs.getString("PersonalityType"));
            }
            return pt;
        } catch (SQLException e) {
            throw new RuntimeException("Fel i getPersonalityType");
        }
    }

//    public boolean validatePassword(String username, String password) {
//        try (Connection conn = datasource.getConnection();
//             PreparedStatement ps = conn.prepareStatement("EXEC validatePassword ?,?")) {
//            ps.setString(1, username);
//            ps.setString(2, password);
//            ResultSet rs = ps.executeQuery();
//            return rs.next();
//        } catch (SQLException e) {
//            throw new RuntimeException("Fel i validatePassword");
//        }
//    }

    public boolean validatePassword(String username, String password) throws NoSuchAlgorithmException {

        try (Connection conn = datasource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT HashedPassword, Salt FROM [dbo].[Users] WHERE Username = ?")) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString(1).trim();
                String salt = rs.getString(2).trim();
                String hash = hashedPassword(password, salt);
                if (storedHash.equals(hash)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Fel i validatePassword");
        }
        return false;
    }


    public void insertFavoritesForUser(long userID, List<Long> countryIDs, boolean favorite) {
        System.out.println(userID);
        try (Connection conn = datasource.getConnection();
        PreparedStatement ps = conn.prepareStatement("EXEC insertEvaluationsForUser ?,?,?")) {
            for (Long id : countryIDs) {
                ps.setLong(1,userID);
                ps.setLong(2,id);
                ps.setBoolean(3,favorite);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException("Fel i insertFavorites");
        }
    }

    public Destinations getListOfDestinations(){
        try (Connection conn = datasource.getConnection();
             PreparedStatement ps = conn.prepareStatement("EXEC getAllCountries")) {
            ResultSet rs = ps.executeQuery();
            Destinations listOfAllDestinations = new Destinations();
            while (rs.next()) {
                listOfAllDestinations.getListDestinations().add(new Destination(rs.getInt("CountryID"), rs.getString("CountryName")));
            }
            return listOfAllDestinations;
        } catch (SQLException e) {
            throw new RuntimeException("Fel i getListOfAllDestinations");
        }
    }

    public Destinations getSuggestions(User user) {
        try (Connection conn = datasource.getConnection();
             PreparedStatement ps = conn.prepareStatement("EXEC getSuggestions ?, ?")) {
            ps.setLong(1, user.getUserID());
            ps.setLong(2, user.getPersonalityType().ordinal() + 1);
            ResultSet rs = ps.executeQuery();
            Destinations listOfSuggestions = new Destinations();
            while (rs.next()) {
                listOfSuggestions.getListDestinations().add(new Destination(rs.getInt("CountryID"), rs.getString("CountryName")));
            }
            return listOfSuggestions;
        } catch (SQLException e) {
            throw new RuntimeException("Fel i getSuggestions");
        }
    }
    public Destinations getListOfFavourites(User user) {
        try (Connection conn = datasource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT DR.Country_ID, CT.CountryName FROM [dbo].[DestinationRanking] AS DR INNER JOIN [dbo].[Countries] AS CT ON DR.Country_ID=CT.CountryID WHERE DR.User_ID = ?")) {
            ps.setLong(1, user.getUserID());
            ResultSet rs = ps.executeQuery();
            Destinations listOfSuggestions = new Destinations();
            while (rs.next()) {
                listOfSuggestions.getListDestinations().add(new Destination(rs.getInt("Country_ID"), rs.getString("CountryName")));
            }
            return listOfSuggestions;
        } catch (SQLException e) {
            throw new RuntimeException("Fel i getListOfFavourites");
        }
    }

    private String hashedPassword (String password, String salt) throws NoSuchAlgorithmException {
        byte[] hash = MessageDigest.getInstance("SHA-256").digest((salt + password).getBytes());
        String hashed = DatatypeConverter.printBase64Binary(hash);
        return hashed;
    }

    private String createSalt () {
        SecureRandom sr = new SecureRandom();
        byte bytes[] = new byte[20];
        sr.nextBytes(bytes);
        return DatatypeConverter.printBase64Binary(bytes);
    }


}

