package modelo;

import java.util.Date;

/**
 * Modelo que representa un registro de mantención TI.
 * Incluye fecha de inicio, fecha de término y estado del equipo.
 */
public class MantencionTI {

    private int    idMantencion;
    private int    idActivo;
    private int    idUsuarioSoporte;
    private String tipoMantencion;      // 'PREVENTIVO' | 'CORRECTIVO'
    private String descripcionFalla;
    private String accionRealizada;
    private Date   fechaInicio;         // antes: fechaMantencion
    private Date   fechaTermino;        // NUEVO: puede ser null si aún no termina
    private Date   proximaRevision;
    private String estadoEquipo;        // NUEVO: 'OPERATIVO' | 'EN_ESPERA_REPUESTO' | 'EN_REPARACION'

    public MantencionTI() {}

    // ── getters / setters ──────────────────────────────────

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