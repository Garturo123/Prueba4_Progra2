package pkgenum;

public class PedidoNoEncontradoException extends Exception {

    public PedidoNoEncontradoException(int id) {
        super("No se encontro el pedido con el id: "+ id);
    }

   
    
}
