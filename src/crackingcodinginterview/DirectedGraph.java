/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Pablo
 */
public class DirectedGraph {
    public Map<Node, List<Node>> adjacencyMap = new HashMap<>();
    
    public static class Node{
        private int value;
        private boolean visited;
        
        public Node(int value){ 
            this.value = value; 
            this.visited = false;
        }
        
        public int getValue(){ return value; }
        public void setValue(int newVal){ value = newVal; }
        
        public void visit(){ visited = true; }
        public void unvisit() { visited = false; }
        public boolean isVisited() { return visited; }
        
        @Override
        public String toString(){
            return "Node " + value;
        }
    }
    
    public void addNode(Node newNode){
        if(!adjacencyMap.containsKey(newNode)){
            adjacencyMap.put(newNode, new ArrayList<>());
        }
    }
    
    public void addNodes(Node... newNodes){
        for(Node newNode: newNodes){
            if(!adjacencyMap.containsKey(newNode)){
                adjacencyMap.put(newNode, new ArrayList<>());
            }
        }
    }
    
    // Creates directed link from fromNode to all toNodes
    public void addAdjacency(Node fromNode, Node... toNodes){
        if(adjacencyMap.containsKey(fromNode)){
            List adjacencyList = adjacencyMap.get(fromNode);
            adjacencyList.addAll(Arrays.asList(toNodes));
            for(Node toNode : toNodes){
                if(!adjacencyMap.containsKey(toNode)){
                    adjacencyMap.put(toNode, new ArrayList<>());
                }
            }
        } else {
            List adjacencyList = new ArrayList<>();
            adjacencyList.addAll(Arrays.asList(toNodes));
            for(Node toNode : toNodes){
                if(!adjacencyMap.containsKey(toNode)){
                    adjacencyMap.put(toNode, new ArrayList<>());
                }
            }
            adjacencyMap.put(fromNode, adjacencyList);
        }
    }
    
    // 4.1 Route Between Nodes: Given a directed graph, design an algorithm
    // to find out whether there is a route between two nodes.
    public boolean routeBetweenNodesExists(Node aNode, Node bNode){
        // Unvisit all nodes
        adjacencyMap.keySet().stream().forEach((node) -> { node.unvisit(); });
        Queue<Node> aVisitQueue = new Queue<>();
        Queue<Node> bVisitQueue = new Queue<>();
        aVisitQueue.enqueue(aNode);
        bVisitQueue.enqueue(bNode);
        Node aCheckNode;
        Node bCheckNode;
                
        // Pseudo-bidirectional Breadth-first Search
        while(!aVisitQueue.isEmpty() || !bVisitQueue.isEmpty()){
            // Alternate popping from queues until both run empty

            // Pop from Queue A
            if(!aVisitQueue.isEmpty()){
                // Pop next node from queue that originated from A
                aCheckNode = aVisitQueue.dequeue();

                // If A has not found B, add all unvisited nodes to visit queue
                for(Node childNode : adjacencyMap.get(aCheckNode)){
                    if(childNode == bNode){ return true; }
                    
                    if(!childNode.isVisited()){ 
                        aVisitQueue.enqueue(childNode); 
                    }
                }

                // Mark current node as visited
                aCheckNode.visit();
            }
            
            // Pop from Queue B
            if(!bVisitQueue.isEmpty()){
                // Pop next node from queue that originated from B
                bCheckNode = bVisitQueue.dequeue();

                // If B has not found A, add all unvisited nodes to visit queue
                for(Node childNode : adjacencyMap.get(bCheckNode)){
                    if(bCheckNode == aNode){ return true; }
                    
                    if(!childNode.isVisited()){ 
                        bVisitQueue.enqueue(childNode); 
                    }
                }

                // Mark current node as visited
                bCheckNode.visit();
            }
        }
        
        // If both queues were exhausted without finding the other node, there
        // must not exist a path between the two nodes.
        return false;
    }
    
    @Override
    public String toString(){
        String outputString = "";
        for(Node diNode: adjacencyMap.keySet()){
            outputString += diNode + ", \tChildren = " + adjacencyMap.get(diNode);
            outputString += "\n";
        }
        return outputString;
    }
}
