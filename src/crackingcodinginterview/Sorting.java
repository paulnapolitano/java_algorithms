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
public class Sorting {
    
    public static int[] insertionSort(int[] arrayToSort){
        int size = arrayToSort.length;
        int key;
        int j;
        int i;
        
        for(j=1; j<size; j++){
            key = arrayToSort[j];
            for(i = j-1; i>-1 && arrayToSort[i]>key; i--){
                arrayToSort[i+1] = arrayToSort[i];
            }
            arrayToSort[i+1] = key;
        }
        
        return arrayToSort;
    }
    
    public static int[] reverseInsertionSort(int[] arrayToSort){
        int size = arrayToSort.length;
        int key;
        int j;
        int i;
        
        for(j=1; j<size; j++){
            key = arrayToSort[j];
            for(i = j-1; i>-1 && arrayToSort[i]<key; i--){
                arrayToSort[i+1] = arrayToSort[i];
            }
            arrayToSort[i+1] = key;
        }
        
        return arrayToSort;
    }
    
    // ALGORITHMS 2.3-1
    public static int[] mergeSortSentinel(int[] arrayToSort){
        int size = arrayToSort.length;

        if(size<=1){
            return arrayToSort;
        }
        
        // Split array into left and right halves
        int[] leftArray = Arrays.copyOfRange(arrayToSort, 0, size/2);
        int[] rightArray = Arrays.copyOfRange(arrayToSort, size/2, size);
        
        // Merge-sort left and right halves
        leftArray = mergeSortSentinel(leftArray);
        rightArray = mergeSortSentinel(rightArray);
        
        // Give left and right arrays "sentinels" by copying arrays with 
        // original length + 1
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        
        int[] leftArraySentinel = new int[leftSize + 1];
        int[] rightArraySentinel = new int[rightSize + 1];
        
        System.arraycopy(leftArray, 0, leftArraySentinel, 0, leftSize);
        System.arraycopy(rightArray, 0, rightArraySentinel, 0, rightSize);
        
        leftArraySentinel[leftSize] = Integer.MAX_VALUE;
        rightArraySentinel[rightSize] = Integer.MAX_VALUE;
        
        // Merge left and right halves into sorted array
        int j = 0;
        int i = 0;
        
        for(int k=0; k<size; k++){
            if(leftArraySentinel[i]<rightArraySentinel[j]){
                arrayToSort[k] = leftArray[i];
                i++;
            }
            else {
                arrayToSort[k] = rightArray[j];
                j++;                
            }
        }
        
        return arrayToSort;
    }
    
    // ALGORITHMS 2.3-2
    public static int[] mergeSort(int[] arrayToSort){
        // Check for base case
        int size = arrayToSort.length;
        if(size<=1){
            return arrayToSort;
        }
        
        // Split array in half
        int[] leftArray = Arrays.copyOfRange(arrayToSort, 0, size/2);
        int[] rightArray = Arrays.copyOfRange(arrayToSort, size/2, size);
        
        // Sort each half
        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);
        
        // Merge the two halves
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        
        int j = 0;
        int i = 0;
        
        for(int k=0; k<size; k++){
            if(i>=leftSize){
                System.arraycopy(rightArray, j, arrayToSort, k, size-k);
                return arrayToSort;
            }
            else if(j>=rightSize){
                System.arraycopy(leftArray, i, arrayToSort, k, size-k);
                return arrayToSort;               
            }
            else if(leftArray[i]<rightArray[j]){
                arrayToSort[k] = leftArray[i];
                i++;
            }
            else{
                arrayToSort[k] = rightArray[j];
                j++;
            }
        }
        
        return arrayToSort;
    }
    
    public static char[] mergeSort(char[] arrayToSort){
        // Check for base case
        int size = arrayToSort.length;
        if(size<=1){
            return arrayToSort;
        }
        
        // Split array in half
        char[] leftArray = Arrays.copyOfRange(arrayToSort, 0, size/2);
        char[] rightArray = Arrays.copyOfRange(arrayToSort, size/2, size);
        
        // Sort each half
        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);
        
        // Merge the two halves
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        
        int j = 0;
        int i = 0;
        
        for(int k=0; k<size; k++){
            if(i>=leftSize){
                System.arraycopy(rightArray, j, arrayToSort, k, size-k);
                return arrayToSort;
            }
            else if(j>=rightSize){
                System.arraycopy(leftArray, i, arrayToSort, k, size-k);
                return arrayToSort;               
            }
            else if(leftArray[i]<rightArray[j]){
                arrayToSort[k] = leftArray[i];
                i++;
            }
            else{
                arrayToSort[k] = rightArray[j];
                j++;
            }
        }
        
        return arrayToSort;        
    }
    
    // ALGORITHMS 2.3-6
    public static int[] insertionSortBinarySearch(int[] arrayToSort){
        int size = arrayToSort.length;
        int key;
        int j;
        int i;
        
        for(j=1; j<size; j++){
            key = arrayToSort[j];
            // Binary search rest of array for correct slot
            int[] subArray = Arrays.copyOfRange(arrayToSort, 0, j);
            i = Searching.binarySearchClosest(key, subArray);
            
            // Swap key into correct slot
            Swapping.swap(i, j, arrayToSort);
        }
        
        return arrayToSort;
    }
    
    // ALGORITHMS P 2-2
    public static int[] bubbleSort(int[] arrayToSort){
        int size = arrayToSort.length;
        int key;
        int i;
        int j;
        
        for(i=0; i<size; i++){
            for(j=size-1; j>i; j--){
                if(arrayToSort[j]<arrayToSort[j-1]){
                    Swapping.swap(j, j-1, arrayToSort);
                }
            }
        }
        
        return arrayToSort;
    }
}
