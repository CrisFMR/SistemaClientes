package cl.praxis.module.modelo;

public class Cliente {
    //-----Atributos-----
    private String runCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String aniosCliente;
    private CategoriaEnum nombreCategoria;

    //-----Constructores-----
    ///Vacio
    public Cliente() {
    }
    ///Con Parametros
    public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
                   CategoriaEnum nombreCategoria) {
        this.runCliente = runCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.aniosCliente = aniosCliente;
        this.nombreCategoria = nombreCategoria;
    }

    //-----Getters and Setters-----
    public String getRunCliente() {
        return runCliente;
    }

    public void setRunCliente(String runCliente) {
        this.runCliente = runCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getAniosCliente() {
        return aniosCliente;
    }

    public void setAniosCliente(String aniosCliente) {
        this.aniosCliente = aniosCliente;
    }

    public CategoriaEnum getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(CategoriaEnum nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    // -----toString()-----
    @Override
    public String toString() {
        return "------- Datos Cliente ------\n" + "\n"
                + "RUN del Cliente: " + runCliente + "\n"
                + "Nombre del Cliente: " + nombreCliente + "\n"
                + "Apellido del Cliente: " + apellidoCliente + "\n"
                + "Años como Cliente: " + aniosCliente + "\n"
                + "Categoria del Cliete: " + nombreCategoria + "\n" + "\n"
                + "----------------------------";
    }

    public String toStringFile() {
        return
                runCliente + "," +
                        nombreCliente + "," +
                        apellidoCliente + "," +
                        aniosCliente + "," +
                        nombreCategoria;
    }
}