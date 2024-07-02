package Manager;

import PrimeList.PrimeList;

import java.util.ArrayList;

public class Manager {
    private PrimeList primeList;

    public Manager(){
        primeList= new PrimeList();
    }

    public void addPrime(int prime) {
        System.out.println("-------------------");

        System.out.println("Intentando agregar el numero "+prime);
        try {
            primeList.add((Integer) prime);
            System.out.println("Numero "+prime+" agregado correctamente");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("-------------------");

        }
    }

    public void removePrime(int prime) {
        System.out.println("-------------------");
        System.out.println("Intentando eliminar el numero "+prime);
        try {
            primeList.remove((Integer) prime);
            System.out.println("Numero "+prime+" eliminado correctamente");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("-------------------");
        }
    }

    public int getPrimeListSize() {
        return primeList.size();
    }
}
