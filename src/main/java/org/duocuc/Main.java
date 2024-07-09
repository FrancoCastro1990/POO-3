package org.duocuc;

import PrimeEncryption.PrimeEncryption;

public class Main {
    public static void main(String[] args) {
        PrimeEncryption encryption = new PrimeEncryption();
        String textToEncrypt = "Prueba";
        String outputFilePath = "encrypted_output.csv";

        encryption.encryptAndDecryptWithThreads(textToEncrypt, outputFilePath);
    }
}