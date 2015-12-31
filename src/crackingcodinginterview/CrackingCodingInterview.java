/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingcodinginterview;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;
/**
 *
 * @author Pablito
 */
public class CrackingCodingInterview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1.1
        String testStr1 = "World";      // True
        String testStr2 = "Hello";      // False
        System.out.println("===== 1.1 =====");
        System.out.println("Using hash map...");
        System.out.print(testStr1 + ": ");
        System.out.println(StringAlgorithms.hasAllUniqueChars(testStr1));
        System.out.print(testStr2 + ": ");
        System.out.println(StringAlgorithms.hasAllUniqueChars(testStr2));    
        System.out.println("Using no data structures...");
        System.out.print(testStr1 + ": ");
        System.out.println(StringAlgorithms.hasAllUniqueCharsPrimitive(testStr1));
        System.out.print(testStr2 + ": ");
        System.out.println(StringAlgorithms.hasAllUniqueCharsPrimitive(testStr2));   
        System.out.println();
        
        // 1.2
        testStr1 = "toastyfresh";
        testStr2 = "oatsyetfhrs";
        String testStr3 = "hello";
        String testStr4 = "helloworlds";
        System.out.println("===== 1.2 =====");
        System.out.println(testStr1 + " and " + testStr2 + " permutation?");
        System.out.println(StringAlgorithms.isPermutation(testStr1, testStr2));
        System.out.println(testStr2 + " and " + testStr3 + " permutation?");
        System.out.println(StringAlgorithms.isPermutation(testStr2, testStr3));  
        System.out.println(testStr1 + " and " + testStr4 + " permutation?");
        System.out.println(StringAlgorithms.isPermutation(testStr1, testStr4));
        System.out.println();

        // 1.3
        char[] testCharArray = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm',
                                'i', 't', 'h', ' ', ' ', ' ', ' '};
        int size = 13;
        String inputString = new String(testCharArray);
        String outputString = StringAlgorithms.urlify(testCharArray, size);
        System.out.println("===== 1.3 =====");
        System.out.println("Input:  \"" + inputString + "\"");
        System.out.println("Output: \"" + outputString + "\"");
        System.out.println();

        // 1.4
        System.out.println("===== 1.4 =====");
        inputString = "Tact Coa";
        boolean output = StringAlgorithms.palindromePermutation(inputString);
        System.out.println("Input:  \"" + inputString + "\"");
        System.out.println("Output: " + output);
        inputString = "Poop soup";
        output = StringAlgorithms.palindromePermutation(inputString);
        System.out.println("Input:  \"" + inputString + "\"");
        System.out.println("Output: " + output);
        System.out.println();

        // 1.5
        System.out.println("===== 1.5 =====");
        String inputString1 = "pale";
        String inputString2 = "ple";
        output = StringAlgorithms.oneAway(inputString1, inputString2);
        System.out.println(inputString1+", "+inputString2 + "\t-> " + output);
        inputString1 = "pales";
        inputString2 = "pale";
        output = StringAlgorithms.oneAway(inputString1, inputString2);
        System.out.println(inputString1+", "+inputString2 + "\t-> " + output);
        inputString1 = "pale";
        inputString2 = "bale";
        output = StringAlgorithms.oneAway(inputString1, inputString2);
        System.out.println(inputString1+", "+inputString2 + "\t-> " + output);
        inputString1 = "pale";
        inputString2 = "bake";
        output = StringAlgorithms.oneAway(inputString1, inputString2);
        System.out.println(inputString1+", "+inputString2 + "\t-> " + output);
        System.out.println();

        // 1.6
        System.out.println("===== 1.6 =====");
        inputString = "aabcccccaaa";
        outputString = StringAlgorithms.stringCompression(inputString);
        System.out.println("input: " + inputString);
        System.out.println("output: " + outputString);
        System.out.println();
       
        // 1.7
        System.out.println("===== 1.7 =====");
        int[][] inputMatrix = { { 20, 18, 22, 20 },
                                { 18, 20, 18, 21 },
                                { 16, 18, 16, 20 },
                                { 25, 24, 22, 24 },
                              };
        System.out.println("---- Input ----");
        for (int[] inputMatrix1 : inputMatrix) {
            for (int j = 0; j < inputMatrix1.length; j++) {
                System.out.print(inputMatrix1[j] + " ");
            }
            System.out.println( );
        }
        int[][] outputMatrix = ArrayAlgorithms.rotateMatrix(inputMatrix);
        System.out.println("--- Output ----");
        for (int[] outputMatrix1 : outputMatrix) {
            for (int j = 0; j < outputMatrix1.length; j++) {
                System.out.print(outputMatrix1[j] + " ");
            }
            System.out.println( );
        }
        System.out.println();
        
        // 1.8
        System.out.println("===== 1.8 =====");
        int[][] zeroMatrix = { { 0, 1, 1, 1, 0 },
                               { 1, 1, 1, 1, 1 },
                               { 1, 1, 1, 1, 1 },
                               { 0, 1, 1, 1, 0 } 
                             };
        System.out.println("---- Input ----");
        for (int[] inputMatrix1 : zeroMatrix) {
            for (int j = 0; j < inputMatrix1.length; j++) {
                System.out.print(inputMatrix1[j] + " ");
            }
            System.out.println( );
        }
        ArrayAlgorithms.zeroMatrix(zeroMatrix);
        System.out.println("---- Output ----");
        for (int[] inputMatrix1 : zeroMatrix) {
            for (int j = 0; j < inputMatrix1.length; j++) {
                System.out.print(inputMatrix1[j] + " ");
            }
            System.out.println( );
        }    
        System.out.println();
        
        // 1.9
        System.out.println("===== 1.9 =====");
        inputString1 = "waterbottle";
        inputString2 = "erbottlewat";
        output = StringAlgorithms.stringRotation(inputString1, inputString2);
        System.out.println("s1: " + inputString1);
        System.out.println("s2: " + inputString2);
        System.out.println("Is a rotation: " + output);
        System.out.println();

        // 2.1
        System.out.println("===== 2.1 =====");
        LinkedList inputLinkedList = new LinkedList();
        inputLinkedList.add(1);
        inputLinkedList.add(12);
        inputLinkedList.add(123);
        inputLinkedList.add(12);
        inputLinkedList.add(12);
        inputLinkedList.add(11);
        inputLinkedList.add(1);
        inputLinkedList.add(1234);
        inputLinkedList.add(14);
        inputLinkedList.add(123);
        LinkedListAlgorithms.removeDups(inputLinkedList);
        ListIterator iterator = inputLinkedList.listIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();

        inputLinkedList = new LinkedList();
        inputLinkedList.add(1);
        inputLinkedList.add(12);
        inputLinkedList.add(123);
        inputLinkedList.add(12);
        inputLinkedList.add(12);
        inputLinkedList.add(11);
        inputLinkedList.add(1);
        inputLinkedList.add(1234);
        inputLinkedList.add(14);
        inputLinkedList.add(123);
        LinkedListAlgorithms.removeDupsNoBuffer(inputLinkedList);
        iterator = inputLinkedList.listIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();
        System.out.println();
        
        // 2.2
        System.out.println("===== 2.2 =====");
        SinglyLinkedList inLink = new SinglyLinkedList();
        inLink.add(1);
        inLink.add(12);
        inLink.add(123);
        inLink.add(12);
        inLink.add(12);
        inLink.add(11);
        inLink.add(1);
        inLink.add(1234);
        inLink.add(14);
        inLink.add(123);        
        SinglyLinkedList.Node outNode = LinkedListAlgorithms.kToLast(inLink, 4);
        System.out.println(outNode.getData());
        System.out.println();
        
        // 2.3
        System.out.println("===== 2.3 =====");
        System.out.println(inLink.toString());
        
        System.out.println("Deleting node " + outNode.toString() + "...");
        LinkedListAlgorithms.deleteMiddleNode(inLink, outNode);
        System.out.println(inLink.toString());
        System.out.println();
        
        // 2.4
        System.out.println("===== 2.4 =====");
        System.out.println(inLink.toString());
        int partVal = 13;
        System.out.println("Partitioning list about " + partVal + "...");
        LinkedListAlgorithms.partition(inLink, partVal);
        System.out.println(inLink.toString());
        System.out.println();
        
        // 2.5
        SinglyLinkedList aLinkedNumber = new SinglyLinkedList();
        aLinkedNumber.add(7);
        aLinkedNumber.add(1);
        aLinkedNumber.add(6);
        SinglyLinkedList bLinkedNumber = new SinglyLinkedList();
        bLinkedNumber.add(5);
        bLinkedNumber.add(9);
        bLinkedNumber.add(2);
        bLinkedNumber.add(1);
        SinglyLinkedList linkSum = LinkedListAlgorithms.sumLists(aLinkedNumber,
                                                                 bLinkedNumber);
        System.out.println("  " + aLinkedNumber.toString());
        System.out.println("+ " + bLinkedNumber.toString());
        System.out.println("  ==============");
        System.out.println("  " + linkSum.toString());
        System.out.println();

        // 2.6
        System.out.println("===== 2.6 =====");
        SinglyLinkedList palindromeLink = new SinglyLinkedList();
        palindromeLink.add(5);
        palindromeLink.add(7);
        palindromeLink.add(8);
        palindromeLink.add(9);
        palindromeLink.add(8);
        palindromeLink.add(7);
        palindromeLink.add(5);
        output = LinkedListAlgorithms.palindrome(linkSum);
        System.out.println("Input: " + linkSum.toString());
        System.out.println("Palindrome: " + output);
        output = LinkedListAlgorithms.palindrome(palindromeLink);
        System.out.println("Input: " + palindromeLink.toString());
        System.out.println("Palindrome: " + output);
        System.out.println();

        // 2.7
        System.out.println("===== 2.7 =====");
        SinglyLinkedList.Node palindromeFirst = palindromeLink.first();
        SinglyLinkedList palindromeCopy = new SinglyLinkedList(palindromeFirst);

        palindromeLink.addFront(22);
        palindromeLink.addFront(53);
        palindromeCopy.addFront(23);
        SinglyLinkedList.Node outputNode = LinkedListAlgorithms.intersection(
                                                palindromeLink, palindromeCopy);
        System.out.println("Input: " + palindromeLink.toString());
        System.out.println("Input: " + palindromeCopy.toString());
        if(outputNode == null){
            System.out.println("Output: false");
        } else {
            System.out.println("Output: " + outputNode.toString());
        }     
        
        outputNode = LinkedListAlgorithms.intersection(palindromeLink, linkSum);
        System.out.println("Input: " + palindromeLink.toString());
        System.out.println("Input: " + linkSum.toString());
        if(outputNode == null){
            System.out.println("Output: false");
        } else {
            System.out.println("Output: " + outputNode.toString());
        }
        
        System.out.println();

        // 2.8
        System.out.println("===== 2.8 =====");
        SinglyLinkedList circularLinked = new SinglyLinkedList();
        circularLinked.add(2);
        circularLinked.add(4);
        circularLinked.add(6);
        circularLinked.add(8);
        circularLinked.add(10);
        circularLinked.add(12);
        circularLinked.add(14);
        SinglyLinkedList.Node current = circularLinked.first();
        current = current.getNext();
        current = current.getNext();
        SinglyLinkedList.Node last = circularLinked.last();
        last.setNext(current);
        
        outputNode = LinkedListAlgorithms.loopDetection(circularLinked);
        System.out.println("Circular Node: " + outputNode.toString());
        System.out.println();

        // 3.2
        StackMin minStack = new StackMin(100);
        minStack.push(11);
        minStack.push(16);
        minStack.push(9);
        minStack.push(99);
        minStack.push(42);
        minStack.push(3);
        minStack.push(22);
        int outVal = minStack.peek();
        System.out.println("Peeking... " + outVal);
        outVal = minStack.pop();
        System.out.println("Popping... " + outVal);
        outVal = minStack.min();
        System.out.println("Minimum: " + outVal);
        outVal = minStack.pop();
        System.out.println("Popping... " + outVal);
        outVal = minStack.min();
        System.out.println("Minimum: " + outVal);
        outVal = minStack.pop();
        System.out.println("Popping... " + outVal);
        outVal = minStack.min();
        System.out.println("Minimum: " + outVal);
        outVal = minStack.pop();
        System.out.println("Popping... " + outVal);
        outVal = minStack.min();
        System.out.println("Minimum: " + outVal);
        outVal = minStack.pop();
        System.out.println("Popping... " + outVal);
        outVal = minStack.min();
        System.out.println("Minimum: " + outVal);
        outVal = minStack.pop();
        System.out.println("Popping... " + outVal);
        outVal = minStack.min();
        System.out.println("Minimum: " + outVal);
        outVal = minStack.pop();
        System.out.println();
        
        // 3.3
        // 5 Stacks each of capacity 5
        System.out.println("===== 3.3 =====");
        SetOfStacks stackSet = new SetOfStacks(5, 5);
        stackSet.push(17);
        stackSet.push(16);
        stackSet.push(15);
        stackSet.push(14);
        stackSet.push(13);
        stackSet.push(12);
        stackSet.push(11);
        stackSet.push(10);
        stackSet.push(9);
        stackSet.push(8);        
        stackSet.push(7);
        stackSet.push(6);
        stackSet.push(5);
        stackSet.push(4);
        stackSet.push(3);        
        stackSet.push(2);
        stackSet.push(1);        
        System.out.println("Popped: " + stackSet.popAt(1));
        
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println("Popped: " + stackSet.pop());
        System.out.println();
        
        System.out.println("===== 3.4 =====");
        MyQueue queue = new MyQueue(100);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("Popped: " + queue.pop());
        System.out.println("Popped: " + queue.pop());
        System.out.println("Popped: " + queue.pop()); 
        System.out.println();

        System.out.println("===== 3.5 =====");
        Stack sortableStack = new Stack(100);
        sortableStack.push(12);
        sortableStack.push(21);
        sortableStack.push(4);
        sortableStack.push(16);
        sortableStack.push(17);
        sortableStack.push(8);
        sortableStack.push(10);
        sortableStack.push(15);
        sortableStack.push(54);
        sortableStack.push(12);        
        
        StackAlgorithms.sortStack(sortableStack);
        System.out.println("Popped: " + sortableStack.pop());
        System.out.println("Popped: " + sortableStack.pop());
        System.out.println("Popped: " + sortableStack.pop());
        System.out.println("Popped: " + sortableStack.pop());
        System.out.println("Popped: " + sortableStack.pop());
        System.out.println("Popped: " + sortableStack.pop());
        System.out.println("Popped: " + sortableStack.pop());
        System.out.println("Popped: " + sortableStack.pop());
        System.out.println("Popped: " + sortableStack.pop());
        System.out.println("Popped: " + sortableStack.pop());
        System.out.println();

        System.out.println("===== 3.6 =====");
        AnimalShelterQueue animalShelter = new AnimalShelterQueue();
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Cat());
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Cat());
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Cat());
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Cat());
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Cat());
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Cat());
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Cat());
        System.out.println(animalShelter.dequeueAny());
        System.out.println(animalShelter.dequeueAny());
        System.out.println(animalShelter.dequeueAny());
        System.out.println(animalShelter.dequeueAny());
        System.out.println(animalShelter.dequeueCat());
        System.out.println(animalShelter.dequeueCat());
        System.out.println(animalShelter.dequeueCat());
        System.out.println();
        
        System.out.println("===== 4.1 =====");
        DirectedGraph diGraph = new DirectedGraph();
        DirectedGraph.Node node1 = new DirectedGraph.Node(1);
        DirectedGraph.Node node2 = new DirectedGraph.Node(2);
        DirectedGraph.Node node3 = new DirectedGraph.Node(3);
        DirectedGraph.Node node4 = new DirectedGraph.Node(4);
        DirectedGraph.Node node5 = new DirectedGraph.Node(5);
        DirectedGraph.Node node6 = new DirectedGraph.Node(6);
        DirectedGraph.Node node7 = new DirectedGraph.Node(7);
        DirectedGraph.Node node8 = new DirectedGraph.Node(8);
        DirectedGraph.Node node9 = new DirectedGraph.Node(9);
        DirectedGraph.Node node10 = new DirectedGraph.Node(10);
        DirectedGraph.Node node11 = new DirectedGraph.Node(11);
        DirectedGraph.Node node12 = new DirectedGraph.Node(12);
        DirectedGraph.Node node13 = new DirectedGraph.Node(13);
        DirectedGraph.Node node14 = new DirectedGraph.Node(14);
        diGraph.addAdjacency(node1, node2);
        diGraph.addAdjacency(node2, node3, node4);
        diGraph.addAdjacency(node3, node5);
        diGraph.addAdjacency(node4, node6);
        diGraph.addAdjacency(node6, node7, node8, node9);
        diGraph.addAdjacency(node9, node10);
        diGraph.addAdjacency(node11, node12);
        diGraph.addAdjacency(node12, node13);
        diGraph.addAdjacency(node13, node14);
        diGraph.addAdjacency(node14, node7);

        System.out.println("Directed Graph: \n" + diGraph);
        output = diGraph.routeBetweenNodesExists(node1, node9);
        System.out.println("Route between " + node1 + " and " + node9 
                + " exists: " + output);
        output = diGraph.routeBetweenNodesExists(node11, node6);
        System.out.println("Route between " + node11 + " and " + node6 
                + " exists: " + output);
        System.out.println();

        System.out.println("===== 4.2 =====");
        int[] inputArray = {0,1,2,3,4,5,6,7,8,9,10,11,12};
        BinaryTree searchTreeOutput;
        searchTreeOutput = TreeAlgorithms.minimalTree(inputArray);
        System.out.println(searchTreeOutput);
        System.out.println();
        
        System.out.println("===== 4.3 =====");
        BinaryTree treeOutput;
        treeOutput = TreeAlgorithms.minimalTree(inputArray);
        List<LinkedList> outputList = treeOutput.linkedListsByDepth();
        System.out.println(outputList);
        System.out.println();
        
        System.out.println("===== 4.4 =====");
        BinaryTree.Node biNode0 = new BinaryTree.Node(0);
        BinaryTree.Node biNode1 = new BinaryTree.Node(1);
        BinaryTree.Node biNode2 = new BinaryTree.Node(2);
        BinaryTree.Node biNode3 = new BinaryTree.Node(3);
        BinaryTree.Node biNode4 = new BinaryTree.Node(4);
        BinaryTree.Node biNode5 = new BinaryTree.Node(5);
        BinaryTree.Node biNode6 = new BinaryTree.Node(6);
        BinaryTree.Node biNode7 = new BinaryTree.Node(7);
        BinaryTree.Node biNode8 = new BinaryTree.Node(8);
        BinaryTree.Node biNode9 = new BinaryTree.Node(9);
        BinaryTree.Node biNode10 = new BinaryTree.Node(10);
        BinaryTree.Node biNode11 = new BinaryTree.Node(11);
        biNode7.addLeftChild(biNode3);
        biNode3.addLeftChild(biNode1);
        biNode1.addLeftChild(biNode0);
        biNode1.addRightChild(biNode2);
        biNode3.addRightChild(biNode5);
        biNode5.addLeftChild(biNode4);
        biNode5.addRightChild(biNode6);
        biNode7.addRightChild(biNode10);
        biNode10.addLeftChild(biNode8);
        biNode8.addLeftChild(biNode9);
        
        output = treeOutput.isBalanced();
        System.out.println("              (7)             ");
        System.out.println("      (3)             (11)    ");
        System.out.println("  (1)     (5)     (9)     (12)");
        System.out.println("(0) (2) (4) (6) (8) (10)      ");
        System.out.println("Is balanced: " + output);
        System.out.println();
        
        BinaryTree unbalancedTree = new BinaryTree(biNode7);
        output = unbalancedTree.isBalanced();
        System.out.println("              (7)             ");
        System.out.println("      (3)             (10)    ");
        System.out.println("  (1)     (5)     (8)         ");
        System.out.println("(0) (2) (4) (6) (9)           ");
        System.out.println("Is balanced: " + output);
        System.out.println();

        System.out.println("===== 4.5 =====");
        output = treeOutput.isBinarySearchTree();
        System.out.println("              (7)             ");
        System.out.println("      (3)             (11)    ");
        System.out.println("  (1)     (5)     (9)     (12)");
        System.out.println("(0) (2) (4) (6) (8) (10)      ");
        System.out.println("Is BST: " + output);        
        System.out.println();
        output = unbalancedTree.isBinarySearchTree();
        System.out.println("              (7)             ");
        System.out.println("      (3)             (10)    ");
        System.out.println("  (1)     (5)     (8)         ");
        System.out.println("(0) (2) (4) (6) (9)           ");
        System.out.println("Is BST: " + output);        
        System.out.println();
        
        System.out.println("===== 4.6 =====");
        BinarySearchTree.Node bstNode0 = new BinarySearchTree.Node(0);
        BinarySearchTree.Node bstNode1 = new BinarySearchTree.Node(1);
        BinarySearchTree.Node bstNode2 = new BinarySearchTree.Node(2);        
        BinarySearchTree.Node bstNode3 = new BinarySearchTree.Node(3);        
        BinarySearchTree.Node bstNode4 = new BinarySearchTree.Node(4);        
        BinarySearchTree.Node bstNode5 = new BinarySearchTree.Node(5);
        BinarySearchTree.Node bstNode6 = new BinarySearchTree.Node(6);
        BinarySearchTree.Node bstNode7 = new BinarySearchTree.Node(7);
        BinarySearchTree.Node bstNode8 = new BinarySearchTree.Node(8);
        BinarySearchTree.Node bstNode9 = new BinarySearchTree.Node(9);
        BinarySearchTree.Node bstNode10 = new BinarySearchTree.Node(10);
        BinarySearchTree.Node bstNode11 = new BinarySearchTree.Node(11);
        
        bstNode1.addLeftChild(bstNode0);
        bstNode1.addRightChild(bstNode2);
        bstNode3.addLeftChild(bstNode1);
        bstNode3.addRightChild(bstNode5);
        bstNode5.addLeftChild(bstNode4);
        bstNode5.addRightChild(bstNode6);
        bstNode7.addLeftChild(bstNode3);
        bstNode7.addRightChild(bstNode11);
        bstNode11.addLeftChild(bstNode9);
        bstNode9.addLeftChild(bstNode8);        
        bstNode9.addRightChild(bstNode10);        
        
        System.out.println(bstNode0);
        System.out.println(bstNode0.getNext());
        System.out.println(bstNode1.getNext());
        System.out.println(bstNode2.getNext());
        System.out.println(bstNode3.getNext());
        System.out.println(bstNode4.getNext());
        System.out.println(bstNode5.getNext());
        System.out.println(bstNode6.getNext());
        System.out.println(bstNode7.getNext());
        System.out.println(bstNode8.getNext());
        System.out.println(bstNode9.getNext());
        System.out.println(bstNode10.getNext());
        System.out.println();
        
        System.out.println("===== 4.7 =====");
        // 4.7 Build Order: You are given a list of projects and a list of 
        // dependencies (which is a list of pairs of projects where the first 
        // project is dependent on the second project). All of a project's 
        // dependencies must be built before the project is. Find a build order
        // that will allow the projects to be built. If there is no valid build
        // order, return an error.
        // EXAMPLE: 
        // Input: 
        //      projects: a, b, c, d, e, f
        //      dependencies: (d, a), (b, f), (d, b), (a, f), (c, d)
        // Output: f, e, a, b, d, c
        List<Character> listOfProjects = new ArrayList<>();
        Character[] projectArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        listOfProjects.addAll(Arrays.asList(projectArray));
        
        List<Tuple<Character>> listOfDependencies = new ArrayList<>();
        listOfDependencies.add(new Tuple('d', 'a'));
        listOfDependencies.add(new Tuple('b', 'f'));
        listOfDependencies.add(new Tuple('d', 'b'));
        listOfDependencies.add(new Tuple('a', 'f'));
        listOfDependencies.add(new Tuple('c', 'd'));
        
        
    }
}