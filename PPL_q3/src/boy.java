/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @see boy
 *This class stores the attributes for boys
 */
public abstract class boy {
    String name;
    int attractiveness;
    int intelligence_level;
    int budget;
    int min_attraction;
    boolean commit;
    /**
     * An abstract method for calculating the cost of gift
     * given by boy to girl according to type of boy
     * @param g an object of class girl
     * @param c an object of class couple
     * @param price an array which stores the prices of 
     * all gifts
     */
    public abstract void calc_cost(girl g,couple c,int[] price);
    /**
     * An abstract method for calculating the happiness
     * according to type of boy and girl
     * @param c an object of class couple
     * @param g an object of class girl
     */
    public abstract void happiness(couple c,girl g);
}
