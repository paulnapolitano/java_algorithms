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
public class Integers {
    public static boolean isOdd(int num){
        // Bitwise AND on last bit
        if((num & 1) == 0){
            return false;
        } else { 
            return true;
        }
    }
}
