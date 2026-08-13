
package pkgenum;


public enum EstadoPedido {
    PENDIENTE("Pedido registrado, esperado procesamiento",false,1),
    PROCESANDO("Pedido siendo procesado", false, 2),
    ENVIADO("Pedido camino al cliente", false, 3),
    ENTREGADO("Pedido entregado al cliente", true, 0),
    CANCELADO("Pedido cancelado",true,0);
    
    private final String descripcion;
    private final boolean esFinal;
    private final int diasEstimado;
    
    EstadoPedido(String desc, boolean esFinal, int dias){
        this.descripcion = desc;
        this.esFinal = esFinal;
        this.diasEstimado = dias;
    }

    public boolean isEsFinal() {
        return esFinal;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    public boolean puedeTransicionarA(EstadoPedido nuevoEstado) {
        if (esFinal || nuevoEstado == null) {
            return false;
        }

        switch (this) {
            case PENDIENTE:
                return nuevoEstado == PROCESANDO || nuevoEstado == CANCELADO;
            case PROCESANDO:
                return nuevoEstado == ENVIADO || nuevoEstado == CANCELADO;
            case ENVIADO:
                return nuevoEstado == ENTREGADO;
            default:
                return false;
        }
    }

    public boolean transicionarA(EstadoPedido nuevoEstado) {
        return puedeTransicionarA(nuevoEstado);
    }
}
