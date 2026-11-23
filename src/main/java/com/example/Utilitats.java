package com.example;

public class Utilitats {

    public static String afegirZeros(int numero, int longitud) {
        String text = String.valueOf(numero);

        while (text.length() < longitud) {
            text = "0" + text;
        }

        return text;
    }

    static int[] intentsExercicis = new int[4];
    static double[] tempsExercicis = new double[4];
    static double[] velocitatExercicis = new double[4];
    static boolean[] exercicisExecutats = new boolean[4];

    public static void mostrarEstadistiques(int missio, long inici, int intents) {
        long finalitzacio = System.nanoTime();
        double temps = (finalitzacio - inici) / 1_000_000_000.0;
        double velocitat = 0;
        if (temps > 0) {
            velocitat = intents / temps;
        }
        int posicio = missio - 1;
        intentsExercicis[posicio] = intents;
        tempsExercicis[posicio] = temps;
        velocitatExercicis[posicio] = velocitat;
        exercicisExecutats[posicio] = true;
        System.out.println("Intents: " + intents);
        System.out.println("Temps: " + temps + " segons");
        System.out.println("Velocitat: " + velocitat + " intents per segon");
    }

    public static void capçalera(int missio2, String llarg) {
        System.out.println("===============================================================");
        System.out.println("PDF HUNTERS - MISSIÓ " + missio2);
        System.out.println("===============================================================");
        System.out.println("Estratègia: Força burta");
        System.out.println("Longitud: " + llarg);
        System.out.println("Iniciant cerca......");
    }

    public static void mostrarComparativa() {
    boolean totsExecutats = true;
    for (int i = 0; i < exercicisExecutats.length; i++) {
        if (!exercicisExecutats[i]) {
            System.out.println("Falta executar l'exercici " + (i + 1));
            totsExecutats = false;
        }
    }
    if (!totsExecutats) {
        System.out.println("Has d'executar tots els exercicis abans de mostrar la comparativa.");
        return;
    }
    String[] estrategies = {"Força bruta", "Força bruta restringida", "Diccionari", "Diccionari + variants"};
    System.out.println("--------------------------------------------------------------------------------");
    System.out.printf("%-7s | %-24s | %-10s | %-12s | %-12s%n", "Missió", "Estratègia", "Intents", "Temps (s)", "Intents/s");
    System.out.println("--------------------------------------------------------------------------------");
    for (int i = 0; i < exercicisExecutats.length; i++) {
        System.out.printf("%-7d | %-24s | %-10d | %-12.3f | %-12.2f%n", i + 1, estrategies[i], intentsExercicis[i], tempsExercicis[i], velocitatExercicis[i]);
    }
    System.out.println("--------------------------------------------------------------------------------");
}
}
