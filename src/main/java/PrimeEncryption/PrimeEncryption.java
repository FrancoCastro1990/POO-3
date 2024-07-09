package PrimeEncryption;

import PrimeList.PrimeList;
import EncryptionResult.EncryptionResult;
import PrimeThread.PrimesThread;

import java.util.List;

public class PrimeEncryption {

    private PrimeList primeList;

    public PrimeEncryption() {
        this.primeList = new PrimeList();
    }
    // Generar una lista de números primos
    private  List<Integer> generatePrimes(int n) {
        this.primeList.clear();
        while(primeList.getPrimesCount()<n){
            try {
                int prime = (int)(Math.random()*128);
                if(primeList.isPrime(prime)) {
                    primeList.add(prime);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return primeList;
    }

    public  String encrypt(String input) {
        List<Integer> primes = generatePrimes(input.length());
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char originalChar = input.charAt(i);
            int prime = primes.get(i);
            char encryptedChar = (char) (originalChar + prime);
            encrypted.append(encryptedChar);
        }

        return encrypted.toString();
    }

    public List<Integer> getPrimeList() {
        return primeList;
    }

    // Desencriptar el string
    public String decrypt(String input, List<Integer> primes) {
        //List<Integer> primes = generatePrimes(input.length());
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char encryptedChar = input.charAt(i);
            int prime = primes.get(i);
            char originalChar = (char) (encryptedChar - prime);
            decrypted.append(originalChar);
        }

        return decrypted.toString();
    }

    public void encryptAndDecryptWithThreads(String input, String outputFilePath) {
        EncryptionResult result = new EncryptionResult();

        Runnable encryptTask = new PrimesThread(this, input, outputFilePath, true, result);
        Runnable decryptTask = new PrimesThread(this, null, outputFilePath, false, result);

        Thread encryptThread = new Thread(encryptTask);
        Thread decryptThread = new Thread(decryptTask);

        encryptThread.start();
        decryptThread.start();

        try {
            encryptThread.join();
            decryptThread.join();
            System.out.println("Encriptación y desencriptación completadas.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
