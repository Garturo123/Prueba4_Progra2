package pkgenum;

public class PedidoNoEncontradoException extends Exception {

    public PedidoNoEncontradoException(int id) {
        super("No se encontró el pedido con id " + id + ".");
    }
}
