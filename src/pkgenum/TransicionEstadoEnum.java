package pkgenum;

public class TransicionEstadoEnum extends Exception {

    public TransicionEstadoEnum(EstadoPedido actual, EstadoPedido nuevo) {
        super("No se puede cambiar el estado del pedido de " + actual + " a " + nuevo + ".");
    }
}
