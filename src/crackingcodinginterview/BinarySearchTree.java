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
public class BinarySearchTree extends BinaryTree{
    public static class Node extends BinaryTree.Node {
        private Node parent = null;
        
        Node(int value){
            super(value);
        }
        
        Node(int value, Node parentNode){
            super(value);
            parent = parentNode;
        }
        
        public Node getParent(){
            return parent;
        }
        public void setParent(Node parent){
            this.parent = parent;
        }
        
        public boolean hasParent(){
            return parent != null;
        }
        
        public void addLeftChild(Node leftChildNode){
            leftChildNode.setParent(this);
            setLeftChild(leftChildNode);
        }
        public void addRightChild(Node rightChildNode){
            rightChildNode.setParent(this);
            setRightChild(rightChildNode);
        }
        
        // 4.6 Write an algorithm to find the "next" node (i.e., in-order 
        // successor of a given node in a binary search tree. You may assume 
        // that each node has a link to its parent
        public Node getNext(){
            return getNextChecker(this, this);
        }
        
        private static Node getNextChecker(Node original, Node current){
            // Conditions for SAME:
            // -- this >= original AND !(LC >= original)
            
            // Conditions for PARENT:
            // -- this IS original AND !RC.exists()
            // -- this < original  AND RC >= original
            
            // Conditions for LC:
            // -- LC > original
            
            // Conditions for RC:
            // -- this IS original AND RC.exists()
            
            System.out.println("Current:  " + current);
            System.out.println("Original: " + original);
            
            if(current == original){
                if(current.hasRightChild()){
                    Node rightChild = (Node) current.getRightChild();
                    return getNextChecker(original, rightChild);
                } else {
                    return getNextChecker(original, current.getParent());
                }
            } else if(current.getValue() >= original.getValue()){
                if(current.hasLeftChild() && 
                      current.getLeftChild().getValue() >= original.getValue()
                      && current.getLeftChild() != original){
                    Node leftChild = (Node) current.getLeftChild();
                    return getNextChecker(original, leftChild);
                } else {
                    return current;
                }
            } else {
                if(!(current.hasRightChild() && 
                     current.getRightChild().getValue() > original.getValue())){
                    return getNextChecker(original, current.getParent());
                }
            }
            
            throw new NoNextNodeException(); 
        }
    }
    
    public BinarySearchTree(Node rootNode){
        super(rootNode);
    }   
    
    
   
}
