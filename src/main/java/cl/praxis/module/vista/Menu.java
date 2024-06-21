package cl.praxis.module.vista;

import cl.praxis.module.modelo.CategoriaEnum;
import cl.praxis.module.modelo.Cliente;
import cl.praxis.module.servicio.ArchivoServicio;
import cl.praxis.module.servicio.ClienteServicio;
import cl.praxis.module.servicio.ExportadorCsv;
import cl.praxis.module.servicio.ExportadorTxt;
import cl.praxis.module.utilidades.Utilidad;

import java.util.Scanner;

public class Menu {
    private ClienteServicio clienteServicio = new ClienteServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio();
    private ExportadorCsv exportadorCsv = new ExportadorCsv();
    private ExportadorTxt exportadorTxt = new ExportadorTxt();
    String fileName = "Clientes";
    String fileName1 = "DBClientes.csv";
    private Scanner sc = new Scanner(System.in);

    public void iniciarMenu() {
        String opcion;
        do {
            Utilidad.titulo("Menu Principal");
            System.out.println("1. Listar");
            System.out.println("2. Agregar Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Cargar Datos");
            System.out.println("5. Exportar Datos");
            System.out.println("6. Salir");
            Utilidad.separador();
            System.out.print("Ingrese una opción: ");
            opcion = sc.nextLine();
            Utilidad.separador();

            switch (opcion) {
                case "1":
                    listarClientes();
                    break;

                case "2":
                    agregarCliente();
                    break;

                case "3":
                    editarCliente();
                    break;

                case "4":
                    cargarDatos();
                    break;

                case "5":
                    exportarDatos();
                    break;

                case "6":
                    terminarPrograma();
                    break;

                default:
                    break;
            }

        } while (true);
    }

    public void listarClientes() {
        Utilidad.tiempoEspera("Cargando", 100);
        Utilidad.separador();
        Utilidad.subTitulo("Listado");
        clienteServicio.listarClientes();
        Utilidad.pressEnter();
    }

    public void agregarCliente() {
        Cliente cliente = new Cliente();
        Utilidad.subTitulo("Agregar Cliente");;

        System.out.print("Ingrese RUN del Cliente: ");
        cliente.setRunCliente(Utilidad.validar(sc));
        System.out.print("Ingrese Nombre del Cliente: ");
        cliente.setNombreCliente(Utilidad.validar(sc));
        System.out.print("Ingrese Apellido del Cliente: ");
        cliente.setApellidoCliente(Utilidad.validar(sc));
        System.out.print("Ingrese Años como Cliente: ");
        cliente.setAniosCliente(Utilidad.validar(sc));
        cliente.setNombreCategoria(CategoriaEnum.ACTIVO);

        clienteServicio.agregarCliente(cliente);

    }

    public void editarCliente() {
        Utilidad.subTitulo("Editar Cliente");
        System.out.print("Ingrese RUN del Cliente: ");
        clienteServicio.editarCliente(Utilidad.validar(sc));

    }

    public void cargarDatos() {
        Utilidad.subTitulo("Cargar datos");
        System.out.println("Ingrese ruta, ej: 'cl/praxis/modulo/DBClientes.csv'");
        archivoServicio.cargarDatos(Utilidad.validar(sc), clienteServicio);
    }

    public void exportarDatos() {
        String opcion;
        Utilidad.subTitulo("Exportar Datos");
        System.out.println("1-Formato .csv");
        System.out.println("2-Formato .txt");
        System.out.println("3-Salir");
        System.out.println("");
        System.out.print("Ingrese una opción para exportar: ");
        opcion = sc.nextLine();

        System.out.println("Ingrese la ruta, ej: cl/praxis/modulo/");
        String ruta = Utilidad.validar(sc);

        if (!opcion.isEmpty()) {
            switch (opcion) {
                case "1":
                    exportadorCsv.exportar(ruta, clienteServicio.getListaClientes());
                    break;

                case "2":
                    exportadorTxt.exportar(ruta, clienteServicio.getListaClientes());
                    break;

                case "3":
                    System.out.println("Regresar al menu princial");
                    break;

                default:
                    exportarDatos();
                    break;
            }
        }
    }

    public void terminarPrograma() {
        System.out.println("Cerrando programa");
        Utilidad.tiempoEspera("Cargando", 100);
        System.out.println("Gracias por usar este programa");
        System.exit(0);
    }
}