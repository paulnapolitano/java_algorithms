/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;
import java.util.EmptyStackException;

/**
 *
 * @author Pablo
 */

// 3.1 Three in One: Describe how you could use a single array to implement 
// three stacks
public class FixedMultiStack {
    private final int numStacks = 3;
    private final int stackCapacity;
    private final int[] values;
    private final int[] sizes;
    
    public FixedMultiStack(int stackCapacityVal){
        values = new int[numStacks*stackCapacityVal];
        sizes = new int[numStacks];
        stackCapacity = stackCapacityVal;
    }
    
    public void push(int stackNum, int value) throws FullStackException{
        values[stackNum*stackCapacity + sizes[stackNum]] = value;
        sizes[stackNum]++;
    }
    
    public int pop(int stackNum) throws EmptyStackException{
        int poppedVal = values[stackNum*stackCapacity + sizes[stackNum] - 1];
        values[stackNum*stackCapacity + sizes[stackNum] - 1]--;
        sizes[stackNum]--;
        return poppedVal;
    }
    
    public int peek(int stackNum){
        return values[stackNum*stackCapacity + sizes[stackNum] - 1];
    }
    
    public int size(int stackNum){
        return sizes[stackNum];
    }
    
    public int topIndex(int stackNum){
        return stackNum*stackCapacity;
    }
    
    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }
    
    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }
}
