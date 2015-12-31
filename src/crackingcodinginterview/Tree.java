/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Pablo
 * @param <T>
 */
public class Tree <T>{
    public static class Node <T> {
        private final T value;
        private final List<Node> children;
        
        public Node(T value){
            this.value = value;
            this.children = new ArrayList<>();
        }
        
        public void addChildren(Node... children){
            this.children.addAll(Arrays.asList(children));
        }
        
        public T getValue(){
            return value;
        }
        public List<Node> getChildren(){
            return children;
        }
    }
    
    private Node root;
    
    public Tree(){
        this.root = null;
    }
    
    public Tree(Node root){
        this.root = root;
    }
    
    public void setRoot(Node root){
        this.root = root;
    }
}
