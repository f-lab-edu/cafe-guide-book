package com.flab.cafeguidebook.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EncryptorTest {

    @Test
    void sha256Test(){
      String pw = "Cafe1234!";
      String encryptedPw = Encryptor.sha256Encrypt(pw);
      assertEquals("85241b23384a05f9575031ab319030c74611daab389c0263b1000d7b27b0fcf1",
          encryptedPw);
    }
}
