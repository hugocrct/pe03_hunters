package com.example;

import static com.example.PdfUtils.pdfBox;
import static com.example.Utilitats.afegirZeros;
import static com.example.Utilitats.capçalera;
import static com.example.Utilitats.mostrarEstadistiques;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercicis {
    static int missio = 0;

    public static void exercici1() {
        missio = 1;
        String ruta = "src/main/resources/01_caixa_forta.pdf";
        String llarg = "4 digits";
        boolean trobat = false;
        int numero = 0;
        int intents = 0;
        capçalera(missio, llarg);
        long inici = System.nanoTime();
        while (!trobat && numero <= 9999) {
            String password = String.valueOf(numero);
            while (password.length() < 4) {
                password = "0" + password;
            }
            System.out.println("Comprovant: " + password);
            intents++;
            trobat = pdfBox(password, ruta);
            if (trobat) {
                System.out.println("Contrasenya trobada: " + password);
            }
            numero++;
        }
        mostrarEstadistiques(missio, inici, intents);
        if (!trobat) {
            System.out.println("No s'ha trobat la contrasenya.");
        }
    }

    public static void exercici2() {
        missio = 2;
        String ruta = "src/main/resources/02_projecte_secret.pdf";
        String llarg = "6 caracters: 2 lletres i 4 digits";
        String[] lletres = { "a", "e", "i", "o", "t", "u", "r" };
        String primeraLletra = "c";
        String password = "";
        boolean trobat = false;
        int intents = 0;
        int lletra = 0;
        capçalera(missio, llarg);
        long inici = System.nanoTime();
        while (!trobat && lletra < lletres.length) {
            int numero = 0;
            while (!trobat && numero <= 9999) {
                String digits = afegirZeros(numero, 4);
                password = primeraLletra + lletres[lletra] + digits;
                System.out.println("Comprovant: " + password);
                intents++;
                trobat = pdfBox(password, ruta);
                numero++;
            }

            lletra++;
        }

        mostrarEstadistiques(missio, inici, intents);
        if (trobat) {
            System.out.println("Contrasenya trobada: " + password);
        } else {
            System.out.println("No s'ha trobat la contrasenya!");
        }

    }

    public static void exercici3() {
        missio = 3;
        String ruta = "src/main/resources/03_contrasenya_director.pdf";
        String rutaDiccionari = "src/main/resources/diccionari.txt";
        String llarg = "Paraules del diccionari";
        boolean trobat = false;
        int intents = 0;
        capçalera(missio, llarg);
        long inici = System.nanoTime();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaDiccionari))) {
            String linea;
            while (!trobat && (linea = lector.readLine()) != null) {
                System.out.println("Comprovant: " + linea);
                intents++;
                trobat = pdfBox(linea, ruta);
                if (trobat) {
                    System.out.println("Contrasenya trobada: " + linea);
                }
            }
            mostrarEstadistiques(missio, inici, intents);
            if (!trobat) {
                System.out.println("No s'ha trobat la contrasenya!");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    public static void exercici4() {
        missio = 4;
        String ruta = "src/main/resources/04_arxiu_ultrasecret.pdf";
        String rutaDiccionari = "src/main/resources/diccionari.txt";
        String llarg = "Paraules del diccionari + 2 digits";
        boolean trobat = false;
        int intents = 0;
        capçalera(missio, llarg);
        long inici = System.nanoTime();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaDiccionari))) {
            String linea;
            while (!trobat && (linea = lector.readLine()) != null) {
                if (linea.isEmpty()) {
                    continue;
                }
                String palabraMayuscula = linea.substring(0, 1).toUpperCase() + linea.substring(1);
                int numero = 0;
                while (!trobat && numero <= 99) {
                    String digits = afegirZeros(numero, 2);
                    String password = linea + digits;
                    System.out.println("Comprovant: " + password);
                    intents++;
                    trobat = pdfBox(password, ruta);
                    if (!trobat) {
                        password = palabraMayuscula + digits;
                        System.out.println("Comprovant: " + password);
                        intents++;
                        trobat = pdfBox(password, ruta);
                    }
                    if (trobat) {
                        System.out.println("Contrasenya trobada: " + password);
                    }
                    numero++;
                }
            }
            mostrarEstadistiques(missio, inici, intents);
            if (!trobat) {
                System.out.println("No s'ha trobat la contrasenya!");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
