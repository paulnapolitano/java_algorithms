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
public class DoublyLinkedList<T> {
    private Node first;
    private Node last;
    private int size;
    
    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }
    
    public DoublyLinkedList(Node firstVal) { 
        first = firstVal;
        last  = firstVal;
        size = 1;
    }
    
    public void add(T dataVal) {
        Node newNode = new Node(dataVal);
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
    }
    
    public void addFront(T dataVal) {
        Node newNode = new Node(dataVal);
        first.prev = newNode;
        newNode.next = first;
        first = newNode;
    }
    
    public Node first(){ return first; }
    public Node last() { return last; }
    public int  size() { return size; }
    
    public class Node {
        private T data;
        private Node next;
        private Node prev;
    
        public Node() {
            data = null;
            next = null;
            prev = null;
        }
    
        public Node(T dataVal) {
            data = dataVal;
            next = null;
            prev = null;
        }
        
        public Node(T dataVal, Node nextVal) {
            data = dataVal;
            next = nextVal;
            prev = null;
        }
        
        public Node(T dataVal, Node nextVal, Node prevVal) {
            data = dataVal;
            next = nextVal;
            prev = prevVal;
        }
        
        public void setNext(Node nextVal){ next = nextVal; }
        public void setPrev(Node prevVal){ prev = prevVal; }
        public void setData(T    dataVal){ data = dataVal; }
        
        public Node getNext(){ return next; }
        public Node getPrev(){ return prev; }
        public T    getData(){ return data; }
    }
    
    
}
