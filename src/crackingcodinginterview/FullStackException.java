/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;

/**
 *
 * @author Pablo
 */
public class FullStackException extends RuntimeException{
    public FullStackException(){
        super();
    }
    
    public FullStackException(String message){
        super(message);
    }
}
