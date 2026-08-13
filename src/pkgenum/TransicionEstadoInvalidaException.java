package pkgenum;

/**
 * Se produce cuando el cambio de estado solicitado no está permitido.
 */
public class TransicionEstadoInvalidaException extends TransicionEstadoException {
    private static final long serialVersionUID = 1L;

    public TransicionEstadoInvalidaException(EstadoPedido actual, EstadoPedido nuevo) {
        super(actual, nuevo);
    }
}
