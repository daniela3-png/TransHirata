package modelo;

public class SesionUsuario {
    private static Usuario usuarioLogueado;

    public static void iniciarSesion(Usuario usuario) {
        usuarioLogueado = usuario;
    }

    public static Usuario getUsuario() {
        return usuarioLogueado;
    }

    public static String getNombreCompleto() {
        if (usuarioLogueado != null) {
            return usuarioLogueado.getNombre() + " " + usuarioLogueado.getApellido();
        }
        throw new IllegalStateException("Error: Se intentó acceder al nombre sin una sesión activa.");
    }

    public static String getRol() {
        return (usuarioLogueado != null) ? usuarioLogueado.getRol() : "";
    }

    public static void cerrarSesion() {
        usuarioLogueado = null;
    }
}