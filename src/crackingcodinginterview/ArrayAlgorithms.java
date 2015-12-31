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
public class ArrayAlgorithms {
    /* 1.7 Rotate Matrix: Given an image represented by an NxN matrix, where
     * pixel in the image is 4 bytes, write a method to rotate the image by 90
     * degrees. Can you do this in place?
    */
    public static int[][] rotateMatrix(int[][] inputMatrix){
        /* x x x x     a a a b     b b b c 
           x x x x --> d a b b --> a b c c
           x x x x     d d c b     a a d c
           x x x x     d c c c     a d d d
        */
        int n = inputMatrix[0].length;
        int a;

        for(int depth=0; depth<(n/2); depth++){
            for(int j=depth; j<(n-depth-1); j++){
                a = inputMatrix[j][depth];
                inputMatrix[j][depth] = inputMatrix[n-depth-1][j];
                inputMatrix[n-depth-1][j] = inputMatrix[n-j-1][n-depth-1];
                inputMatrix[n-j-1][n-depth-1] = inputMatrix[depth][n-j-1];
                inputMatrix[depth][n-j-1] = a;
            }
        }
        return inputMatrix;
    }
    
    /* 1.8 Zero Matrix: Write an algorithm such taht if an element in an MxN 
     * matrix is 0, its entire row and column are set to 0.
    */
    public static int[][] zeroMatrix(int[][] zeroMatrix){
        // MxN = numRows x numCols
        int numRows = zeroMatrix.length;
        int numCols = zeroMatrix[0].length;       
        
        // Use row 0 and column 0 to mark rows and columns for zeroification
        boolean zeroFirstRow = false;
        boolean zeroFirstCol = false;
        int row;
        int col;
        
        // Check if a zero already exists in first column
        for(row=0; row<numRows; row++){
            if(zeroMatrix[row][0]==0){
                zeroFirstCol = true;
            }
        }
        
        // Check if a zero already exists in first row
        for(col=0; col<numCols; col++){
            if(zeroMatrix[0][col]==0){
                zeroFirstRow = true;
            }
        }
        
        // Mark first row and column with zeroes based on rest of matrix
        for(col=1; col<numCols; col++){
            for(row=1; row<numRows; row++){
                if(zeroMatrix[row][col] == 0){
                    zeroMatrix[0][col] = 0;
                    zeroMatrix[row][0] = 0;
                }
            }
        }
        
        // Revisit first row and first column and zeroify rest of matrix
        for(row=1; row<numRows; row++){
            if(zeroMatrix[row][0]==0){
                for(col=1; col<numCols; col++){
                    zeroMatrix[row][col]=0;
                }
            }
        }
        for(col=1; col<numCols; col++){
            if(zeroMatrix[0][col]==0){
                for(row=1; row<numRows; row++){
                    zeroMatrix[row][col]=0;
                }
            }
        }
        
        // Zeroify first row and/or column if necessary
        if(zeroFirstCol){
            for(row=0; row<numRows; row++){
                zeroMatrix[row][0] = 0;
            }
        }
        if(zeroFirstRow){
            for(col=0; col<numCols; col++){
                zeroMatrix[0][col] = 0;
            }
        }
        
        return zeroMatrix;
    }
}
