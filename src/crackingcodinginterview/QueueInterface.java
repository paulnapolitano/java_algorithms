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
public interface QueueInterface<T> {
    public void push(T newVal);
    public T pop();
    public T peek();
    public boolean isEmpty();
    public boolean isFull();
    public int size();
    public int capacity();
}
