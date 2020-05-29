package com.aula;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CalculoHash {
    public static void main(String[] args) {
        try {
            byte [] valores = new byte[] {1, 2, 3 ,4};

            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte [] resultado = digest.digest(valores);
            BigInteger bigInteger = new BigInteger(resultado);
            System.out.println(bigInteger.toString(16));
            System.out.println();

            digest.update(new byte[] {1, 2});
            digest.update(new byte[] {3, 4});
            resultado = digest.digest();
            bigInteger = new BigInteger(resultado);
            System.out.println(bigInteger.toString(16));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
