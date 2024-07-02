package PrimeList;

import java.util.ArrayList;

public class PrimeList extends ArrayList<Integer> {

    @Override
    public boolean add(Integer number) {
        if (!isPrime(number)) {
            throw new IllegalArgumentException("El numero no es primo: " + number);
        }
        return super.add(number);
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof Integer && isPrime((Integer) o)) {
            return super.remove(o);
        } else {
            throw new IllegalArgumentException("El numero no es primo o no es del tipo Integer: " + o);
        }
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int getPrimesCount() {
        return this.size();
    }
}