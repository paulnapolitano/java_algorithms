/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Objects;

/**
 *
 * @author Pablo
 */
public class LinkedListAlgorithms {
    // 2.1 Write code to remove duplicates from an unsorted linked list
    public static LinkedList<Integer> removeDups(LinkedList<Integer> inputList){
        HashMap<Integer, Boolean> tracker = new HashMap<>();
        ListIterator<Integer> listIterator = inputList.listIterator();
        
        Integer node;
        while(listIterator.hasNext()){
            node = listIterator.next();
            if(tracker.containsKey(node)){
                listIterator.remove();
            } else {
                tracker.put(node, true);
            }
        }
        
        return inputList;
    }
    // Follow-up: How would you solve this problem if a temporary buffer is not
    // allowed?
    public static LinkedList<Integer> removeDupsNoBuffer(LinkedList<Integer> inputList){
        Integer leadNode;
        Integer seekNode;
        int length = inputList.size();
        
        for(int leader = 0; leader < length; leader++){
            leadNode = inputList.get(leader);
            for(int seeker = leader+1; seeker < length; seeker++){
                seekNode = inputList.get(seeker);
                if(Objects.equals(seekNode, leadNode)){
                    inputList.remove(seeker);
                    length = inputList.size();
                    seeker--;
                }
            }
        }
        
        return inputList;
    }
    
    // 2.2 Return Kth to Last: Implement an algorithm to find the kth to last
    // element of a singly linked list
    public static SinglyLinkedList.Node kToLast(SinglyLinkedList inLink, int k){
        SinglyLinkedList.Node follower = inLink.first();
        SinglyLinkedList.Node leader = inLink.first();
        
        // Throw exception if K is too large or too small
        if(k >= inLink.size() || k < 0){
            throw new IndexOutOfBoundsException();
        }
        
        for(int l = 0; l < k; l++ ){
            leader = leader.getNext();
        }
        
        while(leader.hasNext()){
            leader = leader.getNext();
            follower = follower.getNext();
        }
        
        return follower;
    }
    
    // 2.3 Delete Middle Node: Implement an algorithm to delete a node in the
    // middle of a singly linked list, given only access to that node.
    // EXAMPLE
    // Input: the node c from the linked list a->b->c->d->e
    // Output: nothing is returned, but the new linekd list looks like 
    //         a->b->d->e
    public static void deleteMiddleNode(SinglyLinkedList inLink, 
                                        SinglyLinkedList.Node inNode){
        Object tempData;
        
        while(inNode.getNext().hasNext()){
            tempData = inNode.getData();
            inNode.setData(inNode.getNext().getData());
            inNode = inNode.getNext();
            inNode.setData(tempData);
        }
        inNode.setNext(null);
    }
    
    // 2.4 Partition: Write code to partition a linked list around a value x, 
    // such that all nodes less than x come before all nodes greater than or 
    // equal to x. If x is contained within the list, the values of x only need
    // to be after the elements less than x (see below).
    // EXAMPLE
    // Input:  3->5->8->5->10->2->1 [partition=5]
    // Output: 3->1->2->10->5->5->8
    public static void partition(SinglyLinkedList inLink, Integer partVal){
        SinglyLinkedList.Node previous = inLink.first();
        SinglyLinkedList.Node current  = inLink.first().getNext();
        
        while(previous.hasNext()){
            if((int) current.getData() < partVal){
                previous.setNext(current.getNext());
                current.setNext(inLink.first());
                inLink.setFirst(current);
                current = previous.getNext();
            } else {
                previous = current;
                current = current.getNext();
            }
        }
    }
    
    // 2.5 Sum Lists: You have two numbers represented by a linked list, where
    // each node contains a single digit. The digits are stored in reverse
    // order, such that the 1's digit is at the head of the list. Write a
    // function that adds the two numbers and returns the sum as a linked list.
    // EXAMPLE
    // Input: (7->1->6) + (5->9->2). That is, 617 + 295.
    // Output: 2->1->9. That is, 912.
    public static SinglyLinkedList sumLists(SinglyLinkedList<Integer> aNumLink,
                                            SinglyLinkedList<Integer> bNumLink){
        SinglyLinkedList listSum = new SinglyLinkedList();

        // Pad shorter list with 0s
        while(aNumLink.size()<bNumLink.size()){
            aNumLink.add(0);
        }
        while(aNumLink.size()>bNumLink.size()){
            bNumLink.add(0);
        }

        SinglyLinkedList.Node aCurrent = aNumLink.first();
        SinglyLinkedList.Node bCurrent = bNumLink.first();
        int carry = 0;
        int sum;
        
        while(aCurrent != null){
            sum = (int) aCurrent.getData() + (int) bCurrent.getData() + carry;
            if(sum>10){
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            listSum.add(sum);
            aCurrent = aCurrent.getNext();
            bCurrent = bCurrent.getNext();
        }
        if(carry == 1){
            listSum.add(carry);
        }
        
        return listSum;
    }
    
    // *************** SEE BOOK (RECURSIVE) ***************
    // FOLLOW UP
    // Suppose the digits are stored in forward order. Repeat the above problem.
    // EXAMPLE
    // Input: (6->1->7) + (2->9->5). That is, 617 + 295.
    // Output: 9->1->2. That is, 912.    
    public class PartialSum {
        public SinglyLinkedList.Node sum;
        public int carry;
        
        PartialSum(){
            sum = null;
            carry = 0;
        }
    }
    
    // 2.6 Palindrome: Implement a function to check if a linked list is a
    // palindrome
    public static boolean palindrome(SinglyLinkedList inputLinked){
        // Construct linked list in reverse, and compare to original
        SinglyLinkedList reverseLinked = inputLinked.reverse();
        SinglyLinkedList.Node inputCurrent = inputLinked.first();
        SinglyLinkedList.Node reverseCurrent = reverseLinked.first();
        while(inputCurrent != null){
            if(inputCurrent.getData() != reverseCurrent.getData()){
                return false;
            }
            inputCurrent = inputCurrent.getNext();
            reverseCurrent = reverseCurrent.getNext();
        }
        return true;
    }
    
    // 2.7 Intersection: Given two (singly) linked lists, determine if the two
    // lists intersect. Return the intersecting node. Note that the intersection
    // is defined based on reference, not value. That is, if the kth node of the
    // first linked list is the exact same node (by reference) as the jth node
    // of the second linked list, then they are intersecting.
    public static SinglyLinkedList.Node intersection(
                                                SinglyLinkedList aLinkedList, 
                                                SinglyLinkedList bLinkedList){
        if(aLinkedList.last() != bLinkedList.last()){
            return null;
        } 
        
        while(aLinkedList.size() > bLinkedList.size()){
            aLinkedList.remove(0);
        }
        while(aLinkedList.size() < bLinkedList.size()){
            bLinkedList.remove(0);
        }
        
        SinglyLinkedList.Node aCurrent = aLinkedList.first();
        SinglyLinkedList.Node bCurrent = bLinkedList.first();
        
        while(aCurrent != null){
            if(aCurrent == bCurrent){
                return aCurrent;
            } else {
                aCurrent = aCurrent.getNext();
                bCurrent = bCurrent.getNext();
            } 
        }
        
        return null;
    }
    
    // 2.8 Loop Detection: Given a circular linked list, implement an algorithm
    // that returns the node at the beginning of the loop.
    // DEFINITION
    // Circular linked list: A (corrupt) linked list in which a node's next 
    // pointer points to an earlier node, so as to make a loop in the linked 
    // list
    // EXAMPLE
    // Input:  A->B->C->D->E->C [the same C as earlier]
    // Output: C
    public static SinglyLinkedList.Node loopDetection(
                                        SinglyLinkedList linkedList){
        HashMap<SinglyLinkedList.Node, Boolean> nodeTracker = new HashMap<>();
        SinglyLinkedList.Node current = linkedList.first();
        
        while(current != null){
            if(nodeTracker.containsKey(current)){
                return current;
            } else {
                nodeTracker.put(current, true);
                current = current.getNext();
            } 
        }
        
        return null;
    }
}
