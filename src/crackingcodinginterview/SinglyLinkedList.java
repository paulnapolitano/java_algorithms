/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Pablo
 */
public class SinglyLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;
    
    public SinglyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }
    
    public SinglyLinkedList(Node firstVal){
        first = firstVal;
        size = 1;
        Node current = first;
        while(current.getNext() != null){
            current = current.getNext();
            size++;
        }
        last = current;
    }
    
    public void add(T data) {
        if(data == null) { 
            throw new NullPointerException("The argument for add is null");
        }
        if(!isEmpty()) {
            Node<T> prev = last;
            last = new Node<>(data);
            prev.next = last;
        }
        else {
            last = new Node<>(data);
            first = last;
        }
        size++;
    }
    
    public void addFront(T data) {
        if(data == null) { 
            throw new NullPointerException("The argument for add is null");
        }
        if(!isEmpty()) {
            Node newFirst = new Node<>(data);
            newFirst.next = first;
            first = newFirst;
        }
        else {
            last = new Node<>(data);
            first = last;
        }
        size++;
    }
    
    public SinglyLinkedList reverse() {
        SinglyLinkedList reverseLinked = new SinglyLinkedList();
        Node current = first;
        while(current != null){
            Object data = current.data;
            reverseLinked.addFront(data);
            current = current.next;
        }
        
        return reverseLinked;
    }
    
    public boolean isEmpty(){
        return (size == 0);
    }
    
    private int getSize(){
        return size;
    }
    
    public void setFirst(Node firstNode){
        first = firstNode;
    }
    
    public int size(){
        return getSize();
    }

    public void add(T data, int index){
        Node temp = new Node(data);
        Node current = first;
        
        if(current != null){
            for(int i = 0; i < index && current.getNext() != null; i++){
                current = current.getNext();
            }
        }
        
        temp.setNext(current.getNext());
        current.setNext(temp);
        
        size++;
    }
    
    public T get(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node current = first;
        
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return (T) current.data;
    }
    
    public Node first(){
        return first;
    }
    
    public Node last(){
        return last;
    }
    
    // Remove all nodes with given data in linked list
    public boolean remove(T data){
        if(isEmpty()){
            throw new IllegalStateException("Cannot remove from empty list!");
        }
        
        boolean result = false;
        Node previous = first;
        Node current = first;
        
        while(current.next != null || current == last){
            // Check if each node's data matches given data
            if(current.data.equals(data)){
                // Remove last remaining node
                if(size == 1){
                    first = null;
                    last = null;
                // Remove first node
                } else if(current.equals(first)){
                    first = first.next;
                // Remove last node
                } else if(current.equals(last)){
                    last = previous; 
                    last.next = null;
                // Remove middle node
                } else {
                    previous.next = current.next;
                }
                
                size--;
                result = true;
                break;
            }
            previous = current;
            current = current.next;
        }
        return result;
    }
    
    // Remove node at given index
    public boolean remove(int index){
        if(isEmpty()){
            throw new IllegalStateException("Cannot remove from empty list!");
        }
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        
        Node current = first;
        Node previous = first;

        for(int i = 0; i < index; i++){
            previous = current;
            current = current.next;
        }
        
        // Remove last remaining node
        if(size == 1){
            first = null;
            last = null;
        // Remove first node
        } else if(current.equals(first)){ 
            first = first.next;
        // Remove last node
        } else if(current.equals(last)){
            last = previous; 
            last.next = null;
        // Remove middle node
        } else { 
            previous.next = current.next; 
        }
        size--;
        return true;
    }
    
    @Override
    public String toString() {
        String output = "";
        
        if(!isEmpty()){
            Node current = first;
            while(current != null) {
                output += "[" + current.data.toString() + "]->";
                current = current.next;
            }
        }
        return output;
    }
    
    public class Node<T>{
        private Node next;
        private T data;
        
        public Node(T dataVal){
            next = null;
            data = dataVal;
        }
        
        public Node(T dataVal, Node nextVal){
            next = nextVal;
            data = dataVal;
        }
        
        public T getData(){
            return data;
        }
        
        public Node getNext(){
            return next;
        }
        
        public void setData(T dataVal){
            data = dataVal;
        }
        
        public void setNext(Node nextVal){
            next = nextVal;
        }
        
        public boolean hasNext(){
            return next != null;
        }
        
        @Override
        public String toString(){
            return "[" + data + "]";
        }
    }
    
    @Override
    public Iterator<T> iterator() { return new LinkedListIterator(); }
    
    private class LinkedListIterator implements Iterator<T> {
        private Node current = first;
        
        @Override
        public T next() {
            if(!hasNext()) { throw new NoSuchElementException(); }
            T data = (T) current.data;
            current = current.next;
            return data;
        }
        
        @Override
        public boolean hasNext() { return current.next != null; }
        
        @Override
        public void remove() { throw new UnsupportedOperationException(); } 
    }
}
