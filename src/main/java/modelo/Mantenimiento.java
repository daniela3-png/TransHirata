package modelo;

import java.util.Date;

public class Mantenimiento {
    private int id; 
    private String patente;
    private int kilometrajeProgramado;
    private Date fecha;
    private String solicitadoPor;
    private boolean realizado;

    public Mantenimiento() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getKilometrajeProgramado() {
        return kilometrajeProgramado;
    }

    public void setKilometrajeProgramado(int kilometrajeProgramado) {
        this.kilometrajeProgramado = kilometrajeProgramado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSolicitadoPor() {
        return solicitadoPor;
    }

    public void setSolicitadoPor(String solicitadoPor) {
        this.solicitadoPor = solicitadoPor;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }
}