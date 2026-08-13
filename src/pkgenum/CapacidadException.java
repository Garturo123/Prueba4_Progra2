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

    public CapacidadException(int capacidad) {
        super("Capacidad maxima alcanzadaa( "+capacidad+" ) de pedidos.");
        
    }
    
}
