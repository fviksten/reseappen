package com.sallskapsresan;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Hashing {

    private String hashedPassword;

    private String salt;

    public String getHashedPassword(String password, String salt) throws NoSuchAlgorithmException {
        byte[] hash = MessageDigest.getInstance("SHA-256").digest((salt + password).getBytes());
        String hashed = DatatypeConverter.printBase64Binary(hash);
        return hashed;
    }

    public String getSalt() {
        SecureRandom sr = new SecureRandom();
        byte bytes[] = new byte[20];
        sr.nextBytes(bytes);
        return DatatypeConverter.printBase64Binary(bytes);
    }
}
