package pkgenum;

public class TransicionEstadoInvalidaException extends TransicionEstadoException {

    public TransicionEstadoInvalidaException(EstadoPedido actual, EstadoPedido nuevo) {
        super(actual, nuevo);
    }
}
