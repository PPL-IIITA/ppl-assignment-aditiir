/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @see Search An abstract class which is inherited 
 * by the 3 classes which implement 3 different 
 * methods to store committed boys
 */


public abstract class Search {
    final int size=12;
    Entry[] table=new Entry[size];
    public abstract void storeData(String a, String b);
     public abstract String search(String a);
}
