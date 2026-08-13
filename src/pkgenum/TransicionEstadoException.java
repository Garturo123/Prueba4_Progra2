package pkgenum;

public class TransicionEstadoException extends TransicionEstadoEnum {

    public TransicionEstadoException(EstadoPedido actual, EstadoPedido nuevo) {
        super(actual, nuevo);
    }
}
