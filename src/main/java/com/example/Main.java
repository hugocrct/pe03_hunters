package com.example;

import static com.example.Menu.menu;
import static com.example.Exercicis.exercici1;
import static com.example.Exercicis.exercici2;
import static com.example.Exercicis.exercici3;
import static com.example.Exercicis.exercici4;
import static com.example.Utilitats.mostrarComparativa;;

public class Main {

    public static void main(String[] args) {
        int exercici;
        do {
            exercici = menu();
            switch (exercici) {
                case 1:
                    exercici1();
                    break;
                case 2:
                    exercici2();
                    break;
                case 3:
                    exercici3();
                    break;
                case 4:
                    exercici4();
                    break;
                case 5:
                    mostrarComparativa();
                    break;
                case 0:
                    System.out.println("Sortint del programa...");
                    break;
                default:
                    System.out.println("Opció incorrecta.");
                    break;
            }
        } while (exercici != 0);
    }
}
