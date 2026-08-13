package pkgenum;

/**
 * Nombre conservado por compatibilidad con la versión inicial del proyecto.
 *
 * Se recomienda usar {@link TransicionEstadoException} en el código nuevo.
 */
public class TransicionEstadoEnum extends Exception {
    private static final long serialVersionUID = 1L;

    public TransicionEstadoEnum(EstadoPedido actual, EstadoPedido nuevo) {
        super("No se puede cambiar el estado del pedido de " + actual + " a " + nuevo + ".");
    }
}
