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
public class SetOfStacks {    
    public class SubStack {
        private final int[] values;
        private int size;
        
        public SubStack(int capacity){
            values = new int[capacity];
            size = 0;
        }
        
        public void push(int pushVal) throws FullStackException {
            if(isFull()){
                throw new FullStackException();
            }
            
            values[size + 1] = pushVal;
            size++;
        }
        
        public int pop() throws EmptyStackException {
            if(isEmpty()){
                throw new EmptyStackException();
            }
            
            int popVal = values[size];
            values[size] = 0;
            size--;
            return popVal;
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        public boolean isFull() {
            return size + 1 == values.length;
        }
    }
    
    private final SubStack[] subStacks;
    private int currentStack;
    
    public SetOfStacks(int numSubStacks, int capacity){
        subStacks = new SubStack[numSubStacks];
        for(int i = 0; i < numSubStacks; i++){
            subStacks[i] = new SubStack(capacity);
        }
        
        currentStack = 0;
    }
    
    public int pop() throws EmptyStackException {
        int popVal;
        
        try {
            popVal = subStacks[currentStack].pop();
        } catch(EmptyStackException e) {
            if(currentStack == 0){
                throw new EmptyStackException();
            }
            currentStack--;
            popVal = subStacks[currentStack].pop();
        }
        
        return popVal;
    }
    
    public void push(int pushVal) throws FullStackException {
        try {
            subStacks[currentStack].push(pushVal);
        } catch(FullStackException e) {
            if(currentStack == subStacks.length){
                throw new FullStackException();
            }
            
            currentStack++;
            subStacks[currentStack].push(pushVal);
        }
    }
    
    public int popAt(int stackNum){
        return subStacks[stackNum].pop();
    }
}
