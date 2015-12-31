/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;

/**
 *
 * @author Pablito
 */
public class Swapping {
    public static void swap(int a, int b, int[] A){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
