package cl.praxis.module.servicio;

import cl.praxis.module.modelo.Cliente;

import java.util.List;


public abstract class Exportador {

    public abstract void exportar(String fileName, List<Cliente> clientes);

}