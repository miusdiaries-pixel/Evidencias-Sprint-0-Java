package com.sena.file3388038;

import java.util.Scanner;

public class Cuarto {

    record Estudiante(int edad, double notaObt, String rango, boolean estado, String desempeno){}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Por favor, diligencie los siguientes datos ===");

        System.out.print("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.print("Nota: ");
        double notaObt = Double.parseDouble(scanner.nextLine().replace(',', '.'));

        boolean esMayorDeEdad = edad >= 18;
        String rango = esMayorDeEdad ? "Mayor de edad" : "Menor de edad";

        boolean estado = notaObt >= 3.0;

        String desempeno;
        if (notaObt < 3.0) {
            desempeno = "Bajo";
        } else if (notaObt <= 3.9) {
            desempeno = "Básico";
        } else if (notaObt <= 4.5) {
            desempeno = "Alto";
        } else {
            desempeno = "Superior";
        }

        Estudiante persona = new Estudiante(edad, notaObt, rango, estado, desempeno);

        System.out.println("\n--- DATOS DEL ESTUDIANTE ---");
        System.out.println("Edad: " + persona.edad());
        System.out.println("Nota obtenida: " + persona.notaObt());
        System.out.println("Rango de edad: " + persona.rango());
        System.out.println("¿Está aprobado?: " + (persona.estado() ? "Aprobado" : "Reprobado"));
        System.out.println("Nivel de desempeño: " + persona.desempeno());

        scanner.close();
    }
}