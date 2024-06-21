package cl.praxis.module.servicio;

import cl.praxis.module.modelo.CategoriaEnum;
import cl.praxis.module.modelo.Cliente;
import cl.praxis.module.utilidades.Utilidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteServicio {
    //-----Atributos-----
    private List<Cliente> listaClientes;
    Scanner sc = new Scanner(System.in);

    //-----Constructores-----

    public ClienteServicio() {
        listaClientes = new ArrayList<Cliente>();
    }

    //-----Métodos-----
    public void listarClientes() {
        if (listaClientes != null && !listaClientes.isEmpty()) {
            for (Cliente cliente : listaClientes) {
                Utilidad.imprimir(cliente.toString());
            }

        } else {
            System.out.println("Lista vacia, agregar clientes");
        }
    }

    public void agregarCliente(Cliente cliente) {

        if (!cliente.getRunCliente().isEmpty()) {
            if (listaClientes != null) {
                listaClientes.add(cliente);
                Utilidad.separador();
                Utilidad.tiempoEspera("Cargando", 100);
                System.out.println("Cliente Agregado a lista");
                Utilidad.pressEnter();
            }
        } else
            System.out.println("El cliente no puede ser nulo");
    }

    public void editarCliente(String run) {
        if (listaClientes != null) {
            for (Cliente cliente : listaClientes) {
                if (cliente.getRunCliente().equals(run)) {
                    Utilidad.separador();
                    System.out.println("Acciones Disponibles:");
                    System.out.println("1. Cambiar el estado del cliente");
                    System.out.println("2. Editar los datos ingresados del cliente");
                    Utilidad.separador();
                    System.out.print("\nSeleccione que desea hacer: ");
                    String opcion = sc.nextLine();
                    Utilidad.separador();

                    switch (opcion) {
                        case "1":
                            editarEstadoCliente(cliente);
                            break;

                        case "2":
                            editarCamposCliente(cliente);
                            break;

                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                }
            }
        }
    }

    public void editarEstadoCliente(Cliente cliente) {
        int opcion;
        Utilidad.tiempoEspera("Actualizando estado", 100);
        System.out.println("El estado actual es: " + cliente.getNombreCategoria().toString());
        Utilidad.separador();
        if (cliente.getNombreCategoria() != CategoriaEnum.ACTIVO) {
            System.out.println("1- Si desea cambiar el estado del cliente a Activo");
            System.out.println("2- Si desea mantener el estado del cliente Inactivo");
        } else {
            System.out.println("1- Si desea cambiar el estado del cliente a Inactivo");
            System.out.println("2- Si desea mantener el estado del cliente Activo");
        }
        Utilidad.separador();
        System.out.print("Ingrese opción: ");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
                Utilidad.tiempoEspera("Cargando", 100);
                System.out.println("Categoría actualizada");
                break;

            case 2:
                cliente.setNombreCategoria(CategoriaEnum.ACTIVO);
                Utilidad.tiempoEspera("Cargando", 100);
                System.out.println("Categoría actualizada");
                break;

            case 3:
                System.out.println("Regresando al menu principal");
                Utilidad.tiempoEspera("Cargando", 100);
                break;

            default:
                System.out.println("Opción no válida");
                Utilidad.separador();
                editarEstadoCliente(cliente);
                break;

        }
        Utilidad.pressEnter();
    }

    public void editarCamposCliente(Cliente cliente) {
        String opcion;
        Utilidad.subTitulo("Actualizando datos");

        System.out.println("1-El RUN del Cliente es: " + cliente.getRunCliente().toString());
        System.out.println("2-El Nombre del Cliente es: " + cliente.getNombreCliente().toString());
        System.out.println("3-El Apellido del Cliente es: " + cliente.getApellidoCliente());
        System.out.println("4-Los años como Cliente son: " + cliente.getAniosCliente() +" años");
        System.out.println("5-Salir");
        Utilidad.separador();


        System.out.print("Ingrese opción a editar de los datos del cliente: ");

        opcion = sc.nextLine();
        System.out.println("");

        switch (opcion) {
            case "1":
                System.out.print("Ingrese nuevo RUN del cliente: ");
                cliente.setRunCliente(Utilidad.validar(sc));
                System.out.println("\n");
                Utilidad.tiempoEspera("Actualizando", 100);
                System.out.println("Dato actualizado correctamente");
                break;

            case "2":
                System.out.print("Ingrese nuevo Nombre del cliente: ");
                cliente.setNombreCliente(Utilidad.validar(sc));
                System.out.println("\n");
                Utilidad.tiempoEspera("Actualizando", 100);
                System.out.println("Dato actualizado correctamente");

                break;

            case "3":
                System.out.print("Ingrese nuevo Apellido del cliente: ");
                cliente.setApellidoCliente(Utilidad.validar(sc));
                System.out.println("\n");
                Utilidad.tiempoEspera("Actualizando", 100);
                System.out.println("Dato actualizado correctamente");
                break;

            case "4":
                System.out.print("Ingrese años como cliente: ");
                cliente.setAniosCliente(Utilidad.validar(sc));
                System.out.println("\n");
                Utilidad.tiempoEspera("Actualizando", 100);
                System.out.println("Dato actualizado correctamente");
                break;

            case "5":
                System.out.println("Regresando al menu principal");
                Utilidad.tiempoEspera("Cargando", 100);
                break;

            default:
                System.out.println("Opción no válida");

                Utilidad.separador();
                editarCamposCliente(cliente);
                break;
        }
        Utilidad.pressEnter();
    }

    //-----Getters & Setters-----
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
}