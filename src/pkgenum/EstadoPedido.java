/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgenum;

/**
 *
 * @author gaat1
 */
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
    
    /**
     * Indica si el pedido puede pasar de este estado al estado recibido.
     *
     * @param nuevoEstado estado al que se desea transicionar
     * @return {@code true} si la transición está permitida
     */
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

    /**
     * Conserva el nombre usado originalmente por el proyecto.
     *
     * @deprecated use {@link #puedeTransicionarA(EstadoPedido)}
     */
    @Deprecated
    public boolean transicionarA(EstadoPedido nuevoEstado) {
        return puedeTransicionarA(nuevoEstado);
    }
}
