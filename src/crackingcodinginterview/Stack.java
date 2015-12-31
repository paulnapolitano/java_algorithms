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
public class Stack {
    private int[] values;
    private int size;
    
    public Stack(int capacity){
        values = new int[capacity];
        size = 0;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean isFull(){
        return size + 1 == values.length;
    }
    
    public void push(int pushVal){
        if(isFull()){
            throw new FullStackException();
        }
        
        values[size + 1] = pushVal;
        size++;
    }
    
    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        
        int popVal = values[size];
        values[size] = 0;
        size--;
        return popVal;
    }
    
    public int peek(){
        return values[size];
    }
    
    public int size(){
        return size;
    }
    
    public int capacity(){
        return values.length;
    }
}
