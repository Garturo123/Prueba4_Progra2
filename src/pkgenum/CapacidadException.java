/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgenum;

/**
 *
 * @author gaat1
 */
public class CapacidadException extends Exception{
    private static final long serialVersionUID = 1L;

    public CapacidadException(int capacidad) {
        super("Se alcanzó la capacidad máxima de " + capacidad + " pedidos.");
    }
}
