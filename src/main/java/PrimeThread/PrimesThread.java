package PrimeThread;

import EncryptionResult.EncryptionResult;
import PrimeEncryption.PrimeEncryption;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimesThread  implements Runnable {
    private PrimeEncryption primeEncryption;
    private String input;
    private String filePath;
    private boolean isEncrypting;
    private EncryptionResult result;

    public PrimesThread(PrimeEncryption primeEncryption, String input, String filePath, boolean isEncrypting, EncryptionResult result) {
        this.primeEncryption = primeEncryption;
        this.input = input;
        this.filePath = filePath;
        this.isEncrypting = isEncrypting;
        this.result = result;
    }

    @Override
    public void run() {
        if (isEncrypting) {
            String encryptedText = primeEncryption.encrypt(input);
            List<Integer> primes = primeEncryption.getPrimeList();
            result.setResult(encryptedText, primes);
            saveToCSV(encryptedText, primes);
        } else {
            try {
                String[] data = result.getResult();
                String encryptedText = data[0];
                List<Integer> primes = stringToPrimes(data[1]);
                String decryptedText = primeEncryption.decrypt(encryptedText, primes);
                System.out.println("Texto desencriptado: " + decryptedText);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveToCSV(String encryptedText, List<Integer> primes) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Encrypted Text,Prime Numbers\n");
            writer.write(encryptedText + "," + primesToString(primes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String primesToString(List<Integer> primes) {
        return primes.stream()
                .map(Object::toString)
                .reduce((a, b) -> a + ";" + b)
                .orElse("");
    }

    private List<Integer> stringToPrimes(String primesString) {
        return Arrays.stream(primesString.split(";"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}