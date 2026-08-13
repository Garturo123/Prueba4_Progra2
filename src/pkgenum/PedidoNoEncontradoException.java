package pkgenum;

public class PedidoNoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;

    public PedidoNoEncontradoException(int id) {
        super("No se encontró el pedido con id " + id + ".");
    }
}
