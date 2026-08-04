package com.sena.file3388038;

import java.util.Scanner;

public class Segundo {
    record Datos(int documento, String nombre, int edad, double estatura, boolean estudia){}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Por favor, diligencie los siguientes datos ===");

        System.out.print("Número de documento: ");
        String numDoc = scanner.nextLine();
        int documento = Integer.parseInt(numDoc);

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        String numEdad = scanner.nextLine();
        int edad = Integer.parseInt(numEdad);

        System.out.print("Estatura: ");
        String numEstatura = scanner.nextLine();
        double estatura = Double.parseDouble(numEstatura);

        System.out.print("¿Es aprendiz activo? (true/false): ");
        String numEstudia = scanner.nextLine();

        boolean estudia = Boolean.parseBoolean(numEstudia);

        Datos aprendiz = new Datos(documento, nombre, edad, estatura, estudia);

        System.out.println("\n--- BIENVENIDO/A APRENDIZ ---");
        System.out.println("Sus datos son: ");
        System.out.println("Número de documento: " + aprendiz.documento());
        System.out.println("Nombre completo: " + aprendiz.nombre());
        System.out.println("Edad: " + aprendiz.edad());
        System.out.println("Estatura: " + aprendiz.estatura());
        System.out.println("Estado: " + aprendiz.estudia());

        scanner.close();
    }
}