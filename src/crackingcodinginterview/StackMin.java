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
public class StackMin {
    private StackNode[] stackNodes;
    private int topIndex;
    
    public class StackNode {
        private final int value;
        private final int prevMin;
        
        public StackNode(int value, int prevMin){
            this.value = value;
            this.prevMin = prevMin;
        }
        
        public int getValue(){ return value; }
        public int getPrevMin(){ return prevMin; }
    }
    
    public StackMin(int capacity){
        stackNodes = new StackNode[capacity];
        topIndex = 0;
    }
    
    public int pop() throws EmptyStackException{
        int popVal = stackNodes[topIndex].getValue();
        topIndex--;
        return popVal;
    }
    
    public void push(int pushVal) throws FullStackException{
        int newMinimum;
        
        if(topIndex == 0){
            newMinimum = pushVal;
        } else {
            int lastMinimum = stackNodes[topIndex].getPrevMin();
            newMinimum = pushVal > lastMinimum ? lastMinimum: pushVal;
        }
        
        stackNodes[topIndex+1] = new StackNode(pushVal, newMinimum);
        topIndex ++;
    }
    
    public int peek() {
        return stackNodes[topIndex].getValue();
    }
    
    public int min() {
        if(isEmpty()){
            return 0;
        } else {
            return stackNodes[topIndex].getPrevMin();
        }
    }
    
    public boolean isEmpty(){
        return topIndex == 0;
    }
    
    public boolean isFull(){
        return topIndex == stackNodes.length;
    }
}
