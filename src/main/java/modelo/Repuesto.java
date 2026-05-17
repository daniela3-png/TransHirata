package modelo;

public class Repuesto {
    private int idRepuesto;
    private String nombrePieza;
    private String tipoPieza;
    private int stockActual;
    private String estadoPieza;
    private String categoria;  

    public Repuesto() {
    }

    public int getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(int idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombrePieza() {
        return nombrePieza;
    }

    public void setNombrePieza(String nombrePieza) {
        this.nombrePieza = nombrePieza;
    }

    public String getTipoPieza() {
        return tipoPieza;
    }

    public void setTipoPieza(String tipoPieza) {
        this.tipoPieza = tipoPieza;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public String getEstadoPieza() {
        return estadoPieza;
    }

    public void setEstadoPieza(String estadoPieza) {
        this.estadoPieza = estadoPieza;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}