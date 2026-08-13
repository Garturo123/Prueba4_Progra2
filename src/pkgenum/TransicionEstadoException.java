package pkgenum;

/**
 * Excepción base para los errores al cambiar el estado de un pedido.
 */
public class TransicionEstadoException extends TransicionEstadoEnum {
    private static final long serialVersionUID = 1L;

    public TransicionEstadoException(EstadoPedido actual, EstadoPedido nuevo) {
        super(actual, nuevo);
    }
}
