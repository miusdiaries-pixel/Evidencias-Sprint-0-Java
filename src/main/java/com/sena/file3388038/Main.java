package com.sena.file3388038;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int contadorTurno = 1;
    private static int contadorEspecial = 1;

    // Se agrega el atributo 'atendido' al record
    record Turno(String numero, String documento, String nombre, int edad,
                 boolean adultoMayor, boolean discapacidad,
                 String tipoServicios, String horaLlegada, boolean atendido) {

        @Override
        public String toString() {
            return String.format(
                    "Turno: %-6s | Doc: %-12s | Nombre: %-20s | Edad: %3d | Servicio: %-12s | Hora: %s | Estado: %s",
                    numero, documento, nombre, edad, tipoServicios, horaLlegada, (atendido ? "Atendido" : "No atendido"));
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Turno> turnosAsignados = new ArrayList<>();

        System.out.println("=== SISTEMA DE ASIGNACIÓN DE TURNOS - ATENCIÓN INTEGRAL S.A.S ===");

        boolean continuar = true;

        while (continuar) {

            System.out.println("\n=== Nuevo Registro ===");

            System.out.print("Número de documento: ");
            String documento = scanner.nextLine();

            System.out.print("Nombre Completo: ");
            String nombre = scanner.nextLine();

            System.out.println("Fecha de nacimiento: (yyyy-MM-dd)");
            String fechaNacStr = scanner.nextLine();

            LocalDate fechaNac = LocalDate.parse(fechaNacStr, DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate hoy = LocalDate.now();
            int edad = Period.between(fechaNac, hoy).getYears();

            boolean esAdultoMayor = edad >= 60;

            System.out.println("Tipos de servicio disponibles:");
            System.out.println("1. Facturación");
            System.out.println("2. Información");
            System.out.println("3. PQRS");
            System.out.println("4. Asesoría");

            System.out.print("Seleccione el número del servicio (1-4): ");
            int opcion = Integer.parseInt(scanner.nextLine());

            String tipoServicio = switch (opcion) {
                case 1 -> "Facturación";
                case 2 -> "Información";
                case 3 -> "PQRS";
                case 4 -> "Asesoría";
                default -> "No especificado";
            };

            System.out.print("¿Presenta alguna condición de discapacidad? (Sí/No): ");
            String discapacidad = scanner.nextLine();

            boolean tieneDiscapacidad =
                    discapacidad.equalsIgnoreCase("Sí") ||
                            discapacidad.equalsIgnoreCase("Si");

            LocalTime ahora = LocalTime.now();
            String horaLlegada = ahora.format(DateTimeFormatter.ofPattern("HH:mm"));

            int numeroTurno;

            if (esAdultoMayor || tieneDiscapacidad) {
                numeroTurno = contadorEspecial++;
            } else {
                numeroTurno = contadorTurno++;
            }

            // Captura de la condición del turno atendido
            System.out.print("¿Su turno fue atendido? (S/N): ");
            String atencionStr = scanner.nextLine();
            boolean fueAtendido = atencionStr.equalsIgnoreCase("S") || atencionStr.equalsIgnoreCase("Sí");

            Turno turno = new Turno(
                    String.valueOf(numeroTurno),
                    documento,
                    nombre,
                    edad,
                    esAdultoMayor,
                    tieneDiscapacidad,
                    tipoServicio,
                    horaLlegada,
                    fueAtendido);

            turnosAsignados.add(turno);

            System.out.println("\n--- TURNO ASIGNADO ---");
            System.out.println("Número: " + turno.numero());
            System.out.println("Usuario: " + turno.nombre() + " (" + turno.documento() + ")");
            System.out.println("Edad: " + turno.edad() + " años " +
                    (turno.adultoMayor() ? "(Adulto mayor)" : ""));
            System.out.println("Discapacidad: " + (turno.discapacidad() ? "Sí" : "No"));
            System.out.println("Servicio: " + turno.tipoServicios());
            System.out.println("Hora llegada: " + turno.horaLlegada());
            System.out.println("Estado atención: " + (turno.atendido() ? "Atendido" : "No atendido"));
            System.out.println("---------------------------------------\n");

            System.out.print("¿Registrar otro turno? (S/N): ");
            String respuesta = scanner.nextLine();

            continuar = respuesta.equalsIgnoreCase("S") ||
                    respuesta.equalsIgnoreCase("Sí");
        }

        System.out.println("\n=== LISTADO DE TURNOS (FIN DE JORNADA) ===");
        System.out.println("Total de turnos registrados: " + turnosAsignados.size());
        System.out.println("________________________________________________________________________________________________________________________");

        System.out.printf("%-6s %-14s %-22s %-5s %-14s %-28s %-8s %-12s%n",
                "Turno", "Documento", "Nombre", "Edad", "Servicio", "Tipo de atención", "Hora", "Estado");

        System.out.println("________________________________________________________________________________________________________________________");

        for (Turno t : turnosAsignados) {

            String tipoAtencion;

            if (t.discapacidad()) {
                tipoAtencion = "Persona con discapacidad";
            } else {
                tipoAtencion = "Persona sin discapacidad";
            }

            System.out.printf("%-6s %-14s %-22s %-5d %-14s %-28s %-8s %-12s%n",
                    t.numero(),
                    t.documento(),
                    t.nombre(),
                    t.edad(),
                    t.tipoServicios(),
                    tipoAtencion,
                    t.horaLlegada(),
                    (t.atendido() ? "Atendido" : "No atendido"));
        }

        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        scanner.close();
    }
}