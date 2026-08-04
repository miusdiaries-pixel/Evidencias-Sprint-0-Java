package com.sena.file3388038;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Quinto {

    record Estudiante(String documento, String nombre, String fechaNacStr, int edad, String rango, String estrato, String programa, String jornada, String fechaIns, LocalDate fechaActual, long diasIns){}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Por favor, diligencie los datos del aprendiz ===");

        System.out.print("Documento de identidad: ");
        String documento = scanner.nextLine();

        System.out.print("Nombre del aprendiz: ");
        String nombre = scanner.nextLine();

        System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
        String fechaNacStr = scanner.nextLine();

        System.out.print("Estrato: ");
        String estrato = scanner.nextLine();

        System.out.print("Programa: ");
        String programa = scanner.nextLine();

        System.out.print("Jornada: ");
        String jornada = scanner.nextLine();

        System.out.print("Fecha de inscripción (yyyy-MM-dd): ");
        String fechaInsStr = scanner.nextLine();

        LocalDate fechaNac = LocalDate.parse(fechaNacStr, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaIns = LocalDate.parse(fechaInsStr, DateTimeFormatter.ISO_LOCAL_DATE);
        int edad = Period.between(fechaNac, fechaActual).getYears();
        long diasIns = ChronoUnit.DAYS.between(fechaIns, fechaActual);

        boolean esMayorDeEdad = edad >= 18;
        String rango = esMayorDeEdad ? "Mayor de edad" : "Menor de edad";

        Estudiante aprendiz = new Estudiante(documento, nombre, fechaNacStr, edad, rango, estrato, programa, jornada, fechaInsStr, fechaActual, diasIns);

        System.out.println("\n--- DATOS DEL APRENDIZ ---");
        System.out.println("Documento: " + aprendiz.documento());
        System.out.println("Nombre: " + aprendiz.nombre());
        System.out.println("Fecha de nacimiento: " + aprendiz.fechaNacStr());
        System.out.println("Edad: " + aprendiz.edad());
        System.out.println("Rango de edad: " + aprendiz.rango());
        System.out.println("Estrato: " + aprendiz.estrato());
        System.out.println("Programa: " + aprendiz.programa());
        System.out.println("Jornada: " + aprendiz.jornada());
        System.out.println("Fecha de inscripción: " + aprendiz.fechaIns());
        System.out.println("Fecha actual: " + aprendiz.fechaActual());
        System.out.println("Días transcurridos desde la inscripción: " + aprendiz.diasIns());

        scanner.close();
    }
}