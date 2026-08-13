package pkgenum;

public class PedidoInternacional extends Pedido {
    private final double tarifaBase;
    private final String paisDestino;
    private final double costoAduana;

    public PedidoInternacional(int id, String cliente, double monto,
            double tarifaBase, String paisDestino, double costoAduana) {
        super(id, cliente, monto);
        this.tarifaBase = tarifaBase;
        this.paisDestino = paisDestino;
        this.costoAduana = costoAduana;
    }

    public PedidoInternacional(int id, String cliente, double monto,
            String paisDestino, double tarifaBase, double costoAduana) {
        this(id, cliente, monto, tarifaBase, paisDestino, costoAduana);
    }

    @Override
    public double calcularCostoEnvio() {
        return tarifaBase + costoAduana;
    }

    @Override
    public String getTipo() {
        return "INTERNACIONAL (" + paisDestino + ")";
    }

    @Override
    public String toString() {
        return super.toString() + ", país de destino: " + paisDestino;
    }
}
