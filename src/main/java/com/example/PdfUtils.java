package com.example;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PdfUtils {

    public static Boolean pdfBox(String password, String ruta) {
        try (PDDocument document = Loader.loadPDF(new File(ruta), password)) {
            System.out.println("PDF obert correctament!");
            System.out.println("Nombre de pàgines: " + document.getNumberOfPages());
            return true;
        } catch (IOException e) {
            System.out.println("No s'ha pogut obrir el PDF.");
            System.out.println("Motiu: " + e.getMessage());
            return false;
        }

    }
}
