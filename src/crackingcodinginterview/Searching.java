/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;

import java.util.Arrays;

/**
 *
 * @author Pablito
 */
public class Searching {
    
    // Algorithms 2.3-5
    public static Integer binarySearch(int val, int[] A){
        int size = A.length;
        if(size==0){
            return null;
        }
        else if(size==1){
            if(A[0]==val){
                return 0;
            }
            else{
                return null;
            }
        }
        
        int midpoint = size/2;
        if(A[midpoint] == val){
            return midpoint;
        }
        else if(A[midpoint]<val){
            int[] subArray = Arrays.copyOfRange(A, midpoint, size);
            if(binarySearch(val, subArray)==null){
                return null;
            }
            else{
                return midpoint + binarySearch(val, subArray);
            }
        }
            
        else{
            int[] subArray = Arrays.copyOfRange(A, 0, midpoint);
            if(binarySearch(val, subArray)==null){
                return null;
            }
            else{
                return binarySearch(val, subArray);
            }
        }
    }
    
    public static Integer binarySearchClosest(int val, int[] A){
        int size = A.length;
        if(size==0){
            return 0;
        }
        else if(size==1){
            if(val>=A[0]){
                return 1;
            }
            else{
                return 0;
            }
        }
        
        int midpoint = size/2;
        if(A[midpoint]<val){
            int[] subArray = Arrays.copyOfRange(A, midpoint, size);
            return midpoint + binarySearchClosest(val, subArray);
        }
        else{
            int[] subArray = Arrays.copyOfRange(A, 0, midpoint);
            return binarySearchClosest(val, subArray);
        }
    }
}
