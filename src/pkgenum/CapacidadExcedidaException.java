package pkgenum;

/**
 * Se produce al intentar agregar un pedido a un gestor lleno.
 */
public class CapacidadExcedidaException extends CapacidadException {
    private static final long serialVersionUID = 1L;

    public CapacidadExcedidaException(int capacidad) {
        super(capacidad);
    }
}
