package pkgenum;

public class TransicionEstadoEnum extends Exception{

    public TransicionEstadoEnum(EstadoPedido actual, EstadoPedido nuevo) {
        super("No me puede pasar de "+ actual+" a "+nuevo+" estado actual final: "+actual.isEsFinal());
    }
    
}
