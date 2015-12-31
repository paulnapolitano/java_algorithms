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

// 3.6 Animal Shelter: An animal shelter, which holds only dogs and cats, 
// operates on a strictly "first in, first out" basics. People must adopt either
// the "oldest" (based on arrival time) of all animals at the shelter or they 
// can select whether they would prefer a dog or a cat (and will receive the
// oldest animal of that type). They cannot select which specific animal they 
// would like. Create the data structures to maintain this system and implement
// operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may
// use the built-in LinkedList data structure.
public class AnimalShelterQueue {
    private final Queue<Dog> dogQueue;
    private final Queue<Cat> catQueue;
    private static int animalsQueued;
    
    public AnimalShelterQueue(){
        dogQueue = new Queue<>();
        catQueue = new Queue<>();
        animalsQueued = 0;
    }
    
    public void enqueue(Animal newAnimal) {
        newAnimal.setID(animalsQueued);
        animalsQueued++;
        
        if(newAnimal instanceof Dog){
            dogQueue.enqueue((Dog) newAnimal);
        } else {
            catQueue.enqueue((Cat) newAnimal);
        }
        
    };
    
    public Animal dequeueAny() {
        if(dogQueue.peek().getID() < catQueue.peek().getID()){
            return dogQueue.dequeue();
        } else {
            return catQueue.dequeue();
        }
    }
    
    public Dog dequeueDog() { return dogQueue.dequeue(); } 
    public Cat dequeueCat() { return catQueue.dequeue(); }
}
