/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

/**
 *
 * @author USUARIO
 */
public class EJugadorNoValidoException extends Exception{
    public EJugadorNoValidoException(){
        super();
    }
    
    public EJugadorNoValidoException(String s){
        super(s);
    }
}
