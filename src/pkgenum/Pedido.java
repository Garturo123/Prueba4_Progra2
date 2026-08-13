package pkgenum;


public abstract class Pedido {
    protected final int id;
    protected final String cliente;
    protected final double monto;
    protected EstadoPedido estado;
    
    public Pedido(int id, String cliente, double monto){
        this.id = id;
        this.cliente = cliente;
        this.monto = monto;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public double getMonto() {
        return monto;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
    public abstract double calcularCostoEnvio();
    public abstract String getTipo();
    
    @Override
    public String toString(){
        return "Pedido " + id
                + " [" + getTipo()
                + ", cliente: " + cliente
                + ", monto: $" + monto
                + ", estado: " + estado + " - " + estado.getDescripcion()
                + ", costo de envío: $" + calcularCostoEnvio()
                + "]";
    }
}
