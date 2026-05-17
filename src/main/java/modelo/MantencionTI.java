package modelo;

import java.util.Date;

public class MantencionTI {

    private int    idMantencion;
    private int    idActivo;
    private int    idUsuarioSoporte;
    private String tipoMantencion;   
    private String descripcionFalla;
    private String accionRealizada;
    private Date   fechaInicio; 
    private Date   fechaTermino; 
    private Date   proximaRevision;
    private String estadoEquipo; 

    public MantencionTI() {}

    public int getIdMantencion() { return idMantencion; }
    public void setIdMantencion(int idMantencion) { this.idMantencion = idMantencion; }

    public int getIdActivo() { return idActivo; }
    public void setIdActivo(int idActivo) { this.idActivo = idActivo; }

    public int getIdUsuarioSoporte() { return idUsuarioSoporte; }
    public void setIdUsuarioSoporte(int idUsuarioSoporte) { this.idUsuarioSoporte = idUsuarioSoporte; }

    public String getTipoMantencion() { return tipoMantencion; }
    public void setTipoMantencion(String tipoMantencion) { this.tipoMantencion = tipoMantencion; }

    public String getDescripcionFalla() { return descripcionFalla; }
    public void setDescripcionFalla(String descripcionFalla) { this.descripcionFalla = descripcionFalla; }

    public String getAccionRealizada() { return accionRealizada; }
    public void setAccionRealizada(String accionRealizada) { this.accionRealizada = accionRealizada; }

    /** Fecha/hora en que se inició la mantención. */
    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    /** Fecha/hora en que terminó la mantención (null = aún en curso). */
    public Date getFechaTermino() { return fechaTermino; }
    public void setFechaTermino(Date fechaTermino) { this.fechaTermino = fechaTermino; }

    public Date getProximaRevision() { return proximaRevision; }
    public void setProximaRevision(Date proximaRevision) { this.proximaRevision = proximaRevision; }

    /** Estado actual del equipo tras la mantención. */
    public String getEstadoEquipo() { return estadoEquipo; }
    public void setEstadoEquipo(String estadoEquipo) { this.estadoEquipo = estadoEquipo; }

    // ── alias de compatibilidad (evita romper código existente) ──

    /** @deprecated Usar {@link #getFechaInicio()} */
    @Deprecated
    public Date getFechaMantencion() { return fechaInicio; }
    /** @deprecated Usar {@link #setFechaInicio(Date)} */
    @Deprecated
    public void setFechaMantencion(Date fecha) { this.fechaInicio = fecha; }
}