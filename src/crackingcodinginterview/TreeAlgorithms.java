/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;

import java.util.Arrays;

/**
 *
 * @author Pablo
 */
public class TreeAlgorithms {
    // 4.2 Minimal Tree: Given a sorted (increasing order) array with unique 
    // integer elements, write an algorithm to create a binary search tree with
    // minimal height.
    public static BinaryTree minimalTree(int[] sortedArray){
        int size = sortedArray.length;
        
        // Depth is the highest power of two that fits into size, plus one
        // depth = (int) log_2(size) + 1
        int depth = 1;
        for(int newSize = size; newSize > 1; newSize = newSize/2){
            depth += 1;
        }
        
        BinaryTree.Node rootNode;
        rootNode = getRoot(sortedArray, depth);
        
        return new BinaryTree(rootNode);
    }
    
    public static BinaryTree.Node getRoot(int[] sortedArray, int depth){
        int size = sortedArray.length;
        if(size == 1){
            return new BinaryTree.Node(sortedArray[0]);
        }
        
        int rootIndex = (int) Math.pow(2, (depth - 1)) - 1;
        
        BinaryTree.Node rootNode;
        rootNode = new BinaryTree.Node(sortedArray[rootIndex]);
        
        int[] leftArray = Arrays.copyOfRange(sortedArray, 0, rootIndex);
        BinaryTree.Node leftRoot = getRoot(leftArray, depth-1);
        rootNode.addLeftChild(leftRoot);

        if(size > 2){
            int[] rightArray = Arrays.copyOfRange(sortedArray, 
                                                  rootIndex + 1,
                                                  size);
            BinaryTree.Node rightRoot = getRoot(rightArray, depth-1);
            rootNode.addRightChild(rightRoot);
        }
        
        return rootNode;
    }
    
    // 4.3 
}
