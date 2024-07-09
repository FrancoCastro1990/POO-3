package EncryptionResult;
import java.util.List;

public class EncryptionResult {
    private String encryptedText;
    private List<Integer> primes;
    private boolean ready = false;

    public synchronized void setResult(String encryptedText, List<Integer> primes) {
        this.encryptedText = encryptedText;
        this.primes = primes;
        this.ready = true;
        notify();
    }

    public synchronized String[] getResult() throws InterruptedException {
        while (!ready) {
            wait();
        }
        ready = false;
        return new String[]{encryptedText, primesToString(primes)};
    }

    private String primesToString(List<Integer> primes) {
        return primes.stream()
                .map(Object::toString)
                .reduce((a, b) -> a + ";" + b)
                .orElse("");
    }
}