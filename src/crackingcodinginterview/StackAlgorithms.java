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


public class StackAlgorithms {
    
    // 3.5 Sort Stack: Write a program to sort a stack such that the smallest 
    // items are on the top. You can use an additional temporary stack, but you 
    // may not copy the elements into any other data structure (such as an 
    // array). The stack supports the following operations: push, pop, peek, and
    // isEmpty.
    public static void sortStack(Stack inputStack){
        int size = inputStack.size();
        Stack tempStack = new Stack(inputStack.capacity());
        int popVal;
        
        while(tempStack.size() < size){
            popVal = inputStack.pop();
            tempStack.push(popVal);
            if(inputStack.peek() < popVal && !inputStack.isEmpty()){
                popVal = inputStack.pop();
                while(!tempStack.isEmpty()){
                    inputStack.push(tempStack.pop());
                }
                inputStack.push(popVal);
            }
        }
        
        while(!tempStack.isEmpty()){
            inputStack.push(tempStack.pop());
        }
    }
}
