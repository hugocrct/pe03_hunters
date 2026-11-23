package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public static int menu() {
        while (true) {
            System.out.println("Indica quin exercici vols executar:");
            System.out.println("1) Exercici 1");
            System.out.println("2) Exercici 2");
            System.out.println("3) Exercici 3");
            System.out.println("4) Exercici 4");
            System.out.println("5) Mostrar comparativa");
            System.out.println("0) Sortir");

            try {
                int resposta = sc.nextInt();
                sc.nextLine();
                return resposta;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Has d'introduir un numero.");
            }
        }
    }
}
