/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Pablo
 * @param <T>
 */
public class ProjectTree<T> {
    public static class Node<T> {
        private T value;
        private List<Node<T>> children;
        private List<Node<T>> parents;
        
        public Node(T value) {
            this.value    = value;
            this.children = new ArrayList<>();
            this.parents  = new ArrayList<>();
        }
        
        public void setValue(T value){ this.value = value; }
        public void addChildren(List<Node<T>> children){
            this.children = children;
        }
        public void addParents(List<Node<T>> parents){ this.parents = parents; }
        
        public T             getValue()    { return value;    }
        public List<Node<T>> getChildren() { return children; }
        public List<Node<T>> getParents()  { return parents;  }
    }
    
    private final List<Node<T>> projects;
    
    public ProjectTree(List<T> projects, List<Tuple<T>> dependencies){
        for(T projectVal : projects){
            
        }
        
    }
}
