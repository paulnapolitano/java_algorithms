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

// 3.4 Queue via Stacks: Implement a MyQueue class which implements a queue
// using two stacks
public class MyQueue {
    private final Stack storageStack;
    private final Stack popStack;
    private int size;
    
    public MyQueue(int capacity){
        storageStack = new Stack(capacity);
        popStack = new Stack(capacity);
        size = 0;
    }
    
    public void flipToStorage(){
        while(!popStack.isEmpty()){
            storageStack.push(popStack.pop());
        }
    }
    
    public void flipToPop(){
        while(!storageStack.isEmpty()){
            popStack.push(storageStack.pop());
        }
    }
    
    public void push(int value){
        flipToStorage();
        storageStack.push(value);
        size++;
    }
    
    public int pop(){
        flipToPop();
        int popVal = popStack.pop();
        size--;
        return popVal;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean isFull(){
        return size == storageStack.capacity();
    }
}
