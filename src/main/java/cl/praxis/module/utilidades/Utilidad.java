package cl.praxis.module.utilidades;

import java.util.Scanner;

public class Utilidad {
    public static final String green = "\u001B[32m";
    public static final String reset = "\u001B[0m";

    public static void tiempoEspera(String mensaje, int sleepTimer) {
        System.out.print("|>" + mensaje + "<|");
        for (int i=0; i< 10; i++) {
            try {
                System.out.print(".");
                Thread.sleep(sleepTimer);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n");
    }

    public static void pressEnter() {
        String textoEnNegrita = "Java_Prof_Level";
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPresione "+ green + "'Enter'"+ reset + " para continuar");
        System.out.println(sc.nextLine());
    }


    public static void separador() {
        System.out.println("=================================");

    }

    public static void titulo(String mensaje) {
        Utilidad.separador();
        System.out.println("---------|" + mensaje + "|--------");
        Utilidad.separador();
    }

    public static void subTitulo(String mensaje) {
        System.out.println("|------<" + mensaje + ">------|\n");

    }

    public static void imprimir(String mensaje) {
        System.out.println(mensaje);

    }

    public static String validar(Scanner sc) {
        String entry = "";

        do {
            entry = sc.nextLine();

            if (entry.isEmpty()) {
                Utilidad.imprimir("No se han ingresado Datos");
            }

        } while (entry.isEmpty());
        return entry;
    }
}