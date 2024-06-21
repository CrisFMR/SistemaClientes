package cl.praxis.module.servicio;

import cl.praxis.module.modelo.Cliente;
import cl.praxis.module.utilidades.Utilidad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class ExportadorCsv extends Exportador {
    Scanner sc = new Scanner(System.in);

    @Override
    public void exportar(String path, List<Cliente> clientes) {
        String fileName;
        System.out.println("Escriba nombre del archivo. Ej: DBClientes.csv");
        fileName = sc.nextLine();
        createDir(path);
        createFile(path, fileName, clientes);

    }

    private static void createDir(String dirName) {
        File directorio = new File(dirName);

        if (directorio.exists()) {
            Utilidad.tiempoEspera("Creando Directorio", 100);
            System.out.println("\nDirectorio ya existe, validar ubicación");
        } else {
            directorio.mkdir();
            Utilidad.tiempoEspera("Creando Directorio", 100);
            System.out.println("\nDirectorio creado exitosamente");
        }
    }

    private static void createFile(String path, String fileName, List<Cliente> clientes) {
        File file = new File(path + "/" + fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
                Utilidad.tiempoEspera("Creando Archivo", 100);
                System.out.println("\nArchivo creado exitosamente");
            } else {
                Utilidad.tiempoEspera("Creando Archivo", 100);
                System.out.println("\nArchivo ya existe, ");
                Utilidad.tiempoEspera("Sobreescribiendo", 100);
                System.out.println("\nArchivo Sobreescrito exitosamente");
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Cliente cliente : clientes) {
                bw.write(cliente.toStringFile());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Datos exportados correctamente en formato .csv");
            System.out.println("");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}