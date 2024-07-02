package org.duocuc;

import Manager.Manager;
import PrimeList.PrimeList;


public class Main {
    public static void main(String[] args) {

        System.out.println("Sistema de pruebas PrimeSecure.");
        System.out.println("Implementacion de PrimeList.");
        System.out.println("Solo se permiten agregar numeros primos y eliminar por numeros primos.");


        Manager primeListManager = new Manager();

        System.out.println("largo de la lista antes de iniciar pruebas = "+primeListManager.getPrimeListSize());
        System.out.println("--------");
        System.out.println("Pruebas de agregar: ");
        primeListManager.addPrime(1);
        primeListManager.addPrime(3);
        primeListManager.addPrime(5);
        primeListManager.addPrime(7);
        primeListManager.addPrime(8);

        System.out.println("largo de la lista luego intentar ingresar 1, 3, 5, 7 y 8 = "+primeListManager.getPrimeListSize());
        System.out.println("--------");

        System.out.println("Pruebas de eliminar: ");
        primeListManager.removePrime(1);
        primeListManager.removePrime(3);
        primeListManager.removePrime(5);
        primeListManager.removePrime(7);
        primeListManager.removePrime(8);

        System.out.println("largo de la lista luego intentar eliminar 1, 3, 5, 7 y 8 = "+primeListManager.getPrimeListSize());
        System.out.println("--------");

        System.out.println("Fin de pruebas.");
    }
}