package pkgenum;

public class GestorPedidos {
    private final Pedido[] pedidos;
    
    private int cantidad;
    
    public GestorPedidos(int size) {
        pedidos = new Pedido[size];
        cantidad = 0;
    }
    
    public void agregarPedido(Pedido p) throws CapacidadException {
        if (cantidad == pedidos.length) {
            throw new CapacidadExcedidaException(pedidos.length);
        }
        pedidos[cantidad] = p;
        cantidad++;
    }

    public Pedido buscarPorId(int id) throws PedidoNoEncontradoException {
        for (int i = 0; i < cantidad; i++) {
            if (pedidos[i].getId() == id) {
                return pedidos[i];
            }
        }
        throw new PedidoNoEncontradoException(id);
    }

    public void cambiarEstado(int id, EstadoPedido nuevoEstado)
            throws PedidoNoEncontradoException, TransicionEstadoException {
        Pedido pedido = buscarPorId(id);
        EstadoPedido estadoActual = pedido.getEstado();

        if (!estadoActual.puedeTransicionarA(nuevoEstado)) {
            throw new TransicionEstadoInvalidaException(estadoActual, nuevoEstado);
        }

        pedido.setEstado(nuevoEstado);
    }

    public Pedido[] listarPorEstado(EstadoPedido estado) {
        int coincidencias = 0;
        for (int i = 0; i < cantidad; i++) {
            if (pedidos[i].getEstado() == estado) {
                coincidencias++;
            }
        }

        Pedido[] resultado = new Pedido[coincidencias];
        int posicion = 0;
        for (int i = 0; i < cantidad; i++) {
            if (pedidos[i].getEstado() == estado) {
                resultado[posicion] = pedidos[i];
                posicion++;
            }
        }
        return resultado;
    }
}
