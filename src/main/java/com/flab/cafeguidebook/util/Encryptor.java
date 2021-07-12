package com.flab.cafeguidebook.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

  public static final String ENCRYPTION_TYPE = "SHA-256";

  public static String sha256Encrypt(String password){

    String encrytedPassword;
    MessageDigest sh;

    try {
      sh = MessageDigest.getInstance(ENCRYPTION_TYPE);
      sh.update(password.getBytes());
      byte[] byteData = sh.digest();
      StringBuilder sb = new StringBuilder();
      for (byte byteDatum : byteData) {
        sb.append(Integer.toString((byteDatum & 0xff) + 0x100, 16).substring(1));
      }
      encrytedPassword = sb.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
    return encrytedPassword;
  }
}
