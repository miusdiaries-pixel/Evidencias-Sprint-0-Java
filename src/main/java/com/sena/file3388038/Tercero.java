package com.sena.file3388038;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Tercero {

    record Edades(int edadYears, int edadMonths, int edadDays, LocalDate fechaToday, String fechaBorn){}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Por favor, diligencie su fecha de nacimiento (yyyy-MM-dd) ===");

        System.out.print("Fecha de nacimiento: ");
        String fechaBorn = scanner.nextLine();

        LocalDate fechaNac = LocalDate.parse(fechaBorn, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate fechaToday = LocalDate.now();
        int edadYears = Period.between(fechaNac, fechaToday).getYears();
        int edadMonths = Period.between(fechaNac, fechaToday).getMonths();
        int edadDays = Period.between(fechaNac, fechaToday).getDays();

        Edades aprendiz = new Edades(edadYears, edadMonths, edadDays, fechaToday, fechaBorn);

        System.out.println("\n--- BIENVENIDO/A APRENDIZ ---");
        System.out.println("Sus datos son: ");
        System.out.println("Fecha de nacimiento: " + aprendiz.fechaBorn());
        System.out.println("Edad calculada: " + aprendiz.edadYears());
        System.out.println("Edad en años: " + aprendiz.edadYears());
        System.out.println("Edad en meses: " + aprendiz.edadMonths());
        System.out.println("Edad en días: " + aprendiz.edadDays());
        System.out.println("Fecha actual: " + aprendiz.fechaToday());

        scanner.close();
    }
}