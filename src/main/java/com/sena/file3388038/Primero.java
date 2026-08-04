package com.sena.file3388038;

import java.util.Scanner;

public class Primero {
    record Info(String nombre, String ciudad, String programa){}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Por favor, diligencie los siguientes datos ===");

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();

        System.out.print("Programa de formación: ");
        String programa = scanner.nextLine();

        Info estudiante = new Info(nombre, ciudad, programa);

        System.out.println("\n--- BIENVENIDO/A ---");
        System.out.println("Hola " + estudiante.nombre() + ", tu ciudad es: " + estudiante.ciudad() + " y tu programa de formación es: " + estudiante.programa());

        scanner.close();
    }
}