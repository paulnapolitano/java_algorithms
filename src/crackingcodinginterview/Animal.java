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
public abstract class Animal {
    private int id;

    public Animal(){
        id = 0;
    }

    public int getID(){ return id; }
    public void setID(int newID){
        id = newID;
    }

}

