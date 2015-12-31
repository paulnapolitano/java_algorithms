/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;
import java.util.LinkedList;

/**
 *
 * @author Pablo
 * @param <T> Object-based class that makes up each element of the queue
 */
public class Queue<T> {
    private final LinkedList<T> values;

    public Queue(){
        values = new LinkedList<>();
    }
    
    public void enqueue(T newVal){
        values.addFirst(newVal);
    }
    
    public T dequeue() {
        return values.removeLast();
    }
    
    public T peek() {
        return values.peekLast();
    }
    
    public int size() {
        return values.size();
    }
    
    public boolean isEmpty() {
        return values.isEmpty();
    }
    
    @Override
    public String toString(){
        return values.toString();
    }
}
