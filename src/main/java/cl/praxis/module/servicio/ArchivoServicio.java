package cl.praxis.module.servicio;

import cl.praxis.module.modelo.CategoriaEnum;
import cl.praxis.module.modelo.Cliente;
import cl.praxis.module.utilidades.Utilidad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArchivoServicio {

    public ArrayList<Cliente> cargarDatos(String path, ClienteServicio clienteServicio) {
        ArrayList<Cliente> listarClientes = new ArrayList<Cliente>();
        Scanner sc = new Scanner(System.in);

        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linea = br.readLine();

            while (linea != null) {
                ArrayList<String> lista = new ArrayList<String>(Arrays.asList(linea.split(",")));

                Cliente cliente = new Cliente();
                cliente.setRunCliente(lista.get(0));
                cliente.setNombreCliente(lista.get(1));
                cliente.setApellidoCliente(lista.get(2));
                cliente.setAniosCliente(lista.get(3));
                cliente.setNombreCategoria(CategoriaEnum.valueOf(lista.get(4)));

                listarClientes.add(cliente);
                linea = br.readLine();
            }
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!listarClientes.isEmpty()) {
            clienteServicio.getListaClientes().addAll(listarClientes);

            Utilidad.separador();
            Utilidad.tiempoEspera("Cargando", 100);
            System.out.println("\nDatos cargados correctamente en la lista");
            System.out.println("Presione Enter para continuar:");
            System.out.println(sc.nextLine());

        }
        return listarClientes;
    }
}