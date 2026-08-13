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
    
    public boolean transicionarA(EstadoPedido nuevoEstado){
        if(this.esFinal)
            return false;
        boolean valido = false;
        
        switch (this) {
            case PENDIENTE:
                if(nuevoEstado==PROCESANDO || nuevoEstado == CANCELADO)
                    valido = true;
                break;
            case PROCESANDO:
                if(nuevoEstado==ENVIADO || nuevoEstado == CANCELADO)
                    valido = true;
                break;
            case ENVIADO:
                if(nuevoEstado==ENTREGADO || nuevoEstado == CANCELADO)
                    valido = true;
                break;
            default:
                valido=false;
                break;
        }
        return valido;
    }
}
