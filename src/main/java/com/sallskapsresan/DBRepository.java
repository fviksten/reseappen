package com.sallskapsresan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Created by Emil Båth on 2016-10-19.
 */
@Component
public class DBRepository {

    @Autowired
    DataSource datasource;

    public void addUser(User user) {
        try (Connection conn = datasource.getConnection();
             PreparedStatement ps = conn.prepareStatement("EXEC addUser ?,?,?,?,?")) {
            ps.setString(1,user.getFirstname());
            ps.setString(2,user.getLastname());
            ps.setString(3,user.getUsername());
            ps.setString(4,user.getPassword());
            ps.setString(5,user.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("fel i addUser");
        }
    }

    public User getUser(String username) {
        try (Connection conn = datasource.getConnection();
             PreparedStatement ps = conn.prepareStatement("EXEC getUser ?")) {
            ps.setString(1,username);
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
        }catch(SQLException e) {
            throw new RuntimeException("fel i getUser");
        }
    }

    private PersonalityType getPersonalityType(long personality_id) {
        try (Connection conn = datasource.getConnection();
        PreparedStatement ps = conn.prepareStatement("EXEC getPersonalityType ?")) {
            ps.setLong(1,personality_id);
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

    public boolean validatePassword(String username, String password) {
        try (Connection conn = datasource.getConnection();
        PreparedStatement ps = conn.prepareStatement("EXEC validatePassword ?,?")){
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException("FEL i validatePassword");
        }
    }
}
