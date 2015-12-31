/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 *
 * @author Pablo
 */
public class BinaryTree {
    public static class Node {
        private final int value;
        private Node leftChild;
        private Node rightChild;
        
        public Node(int val){
            value = val;
            leftChild = null;
            rightChild = null;
        }
        
        public void addLeftChild(Node leftChildNode){
            leftChild = leftChildNode;
        }
        public void addRightChild(Node rightChildNode){
            rightChild = rightChildNode;
        }
        
        public int getValue(){ return value; }
        public Node getLeftChild(){ return leftChild; }
        public Node getRightChild(){ return rightChild; }

        public void setLeftChild(Node leftChild){
            this.leftChild = leftChild; 
        }
        public void setRightChild(Node rightChild){
            this.rightChild = rightChild; 
        }
        
        public boolean hasLeftChild(){ 
            return leftChild != null;
        }
        public boolean hasRightChild(){ 
            return rightChild != null;
        }
        
        public boolean hasBothChildren(){
            return hasLeftChild() && hasRightChild();
        }
        public boolean hasNoChildren(){
            return !hasLeftChild() && !hasRightChild();
        }
        
        @Override
        public String toString(){
            return "Node " + value;
        }
    }
    
    private final Node root;
    

    public BinaryTree(Node rootNode){
        root = rootNode;
    }
    
    public Node getRoot(){
        return root;
    }
    
    @Override
    public String toString(){
        String outputString = "";
        outputString += "Root: " + root + "\n";
        outputString += stringify(root);
        return outputString;
    }
    
    public String stringify(Node rootNode){
        String outputString = "";
        
        if(rootNode.hasLeftChild()){
            outputString += stringify(rootNode.getLeftChild());
        }
        
        outputString += rootNode + "\n";
        
        if(rootNode.hasRightChild()){
            outputString += stringify(rootNode.getRightChild());
        }
        
        return outputString;
    }
    
    // 4.3 List of Depths: Given a binary tree, design an algorithm which
    // creates a linked list of all the nodes at each depth (e.g., if you have 
    // a tree with depth D, you'll have D linked lists).
    public List<LinkedList> linkedListsByDepth(){
        int depth = 1;
        List<LinkedList> output = new ArrayList<>();
        output.add(new LinkedList());
        output.get(depth-1).add(traverseToLinked(root, depth + 1, output));
        
        return output;
    }
    
    public Node traverseToLinked(Node rootNode, int depth, 
                                 List<LinkedList> output){
        if(output.size() < depth){
            output.add(new LinkedList());
        }
        
        if(rootNode.hasLeftChild()){
            Node lc = rootNode.getLeftChild();
            output.get(depth - 1).add(traverseToLinked(lc, depth + 1, output));
        }
        
        if(rootNode.hasRightChild()){
            Node rc = rootNode.getRightChild();
            output.get(depth - 1).add(traverseToLinked(rc, depth + 1, output));
        }
        
        return rootNode;
    }
    
    // 4.4 Check Balanced: Implement a function to check if a binary tree is
    // balanced. For the purposes of this question, a balanced tree is defined
    // to be a tree such that the heights of the two subtrees of any node never
    // differ by more than one.
    public boolean isBalanced(){
        int maxDepth = getMaxDepth(root);
        return maxDepth != -1;
    }
    
    public Integer getMaxDepth(Node rootNode){
        int leftMax;
        int rightMax;
        
        if(!rootNode.hasLeftChild() && !rootNode.hasRightChild()){
            return 1;
        } else if(!rootNode.hasLeftChild()){
            leftMax = 0;
            rightMax = getMaxDepth(rootNode.getRightChild());
        } else if(!rootNode.hasRightChild()){
            leftMax = getMaxDepth(rootNode.getLeftChild());
            rightMax = 0;
        } else {
            leftMax = getMaxDepth(rootNode.getLeftChild());
            rightMax = getMaxDepth(rootNode.getRightChild());
        }
        
        if(leftMax == -1 || rightMax == -1){
            return -1;
        } else if(Math.abs(leftMax - rightMax) > 1) {
            return -1;
        } else if(leftMax > rightMax) {
            return 1 + leftMax;
        } else {
            return 1 + rightMax;
        }
    }
    
    // 4.5 Validate BST: Implement a function to check if a binary tree is a 
    // binary search tree
    public boolean isBinarySearchTree(){
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean checkBST(Node rootNode, int min, int max){
        // Assume binary search tree is defined as having all left nodes smaller
        // or equal to middle node, which is smaller or equal to all right nodes
        
        int rootVal = rootNode.getValue();
        int leftVal;
        int rightVal;
        boolean ruleCheck;
        boolean boundsCheck;
        Node leftChild;
        Node rightChild;
        
        // A node with no children meets BST criteria as long as it falls within
        // its bounds (less than all nodes above and to its right, greater than
        // all nodes above and to its left)
        if(!rootNode.hasLeftChild() && !rootNode.hasRightChild()){
            return rootVal >= min && rootVal <= max;
        
        // A node with only a left child needs recursive check on left child and 
        // needs to meet rule and fall within bounds
        } else if (!rootNode.hasRightChild()){
            leftVal = rootNode.getLeftChild().getValue();
            ruleCheck = leftVal <= rootVal;
            boundsCheck = rootVal >= min && rootVal <= max;
            leftChild = rootNode.getLeftChild();
            return ruleCheck && checkBST(leftChild, min, rootVal);
        
        // A node with only a right child needs recursive check on right child 
        // and needs to meet rule and fall within bounds
        } else if (!rootNode.hasLeftChild()){
            rightVal = rootNode.getRightChild().getValue();
            ruleCheck = rootVal <= rightVal && rootVal >= min && rootVal <= max;
            boundsCheck = rootVal >= min && rootVal <= max;
            rightChild = rootNode.getRightChild();
            return ruleCheck && checkBST(rightChild, rootVal, max);
        
        // A node with both children needs both children to be recursively 
        // checked and needs to meet rule and fall within bounds
        } else {
            leftVal = rootNode.getLeftChild().getValue();
            rightVal = rootNode.getRightChild().getValue();
            boundsCheck = rootVal >= min && rootVal <= max;
            ruleCheck = leftVal <= rootVal && rootVal <= rightVal;
            return ruleCheck && checkBST(rootNode.getRightChild(), rootVal, max)
                             && checkBST(rootNode.getLeftChild(), min, rootVal);
        }
    }
}
