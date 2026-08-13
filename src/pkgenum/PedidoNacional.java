package pkgenum;

public class PedidoNacional extends Pedido {
    private final double tarifaBase;
    private final double tarifaPorKilometro;
    private final double distanciaKm;

    public PedidoNacional(int id, String cliente, double monto,
            double tarifaBase, double tarifaPorKilometro, double distanciaKm) {
        super(id, cliente, monto);
        this.tarifaBase = tarifaBase;
        this.tarifaPorKilometro = tarifaPorKilometro;
        this.distanciaKm = distanciaKm;
    }

    @Override
    public double calcularCostoEnvio() {
        return tarifaBase + tarifaPorKilometro * distanciaKm;
    }

    @Override
    public String getTipo() {
        return "NACIONAL";
    }
}
