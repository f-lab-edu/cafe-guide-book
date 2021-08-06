package com.flab.cafeguidebook.util;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

public class HashingUtil {

  public static String sha256Hashing(String originalPassword) {
    return Hashing.sha256()
        .hashString(originalPassword, StandardCharsets.UTF_8)
        .toString();
  }

  public static Boolean isMatchWithSha256Hashing(String originalPassword, String hashedPassword) {
    return hashedPassword.equals(sha256Hashing(originalPassword));
  }
}
