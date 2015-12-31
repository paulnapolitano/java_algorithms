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
public class NoNextNodeException extends RuntimeException {
    public NoNextNodeException(){
        super();
    }
    
    public NoNextNodeException(String s){
        super(s);
    }
}
