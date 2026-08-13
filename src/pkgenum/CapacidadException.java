
package pkgenum;


public class CapacidadException extends Exception{

    public CapacidadException(int capacidad) {
        super("Se alcanzó la capacidad máxima de " + capacidad + " pedidos.");
    }
}
