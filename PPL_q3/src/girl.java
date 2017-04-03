/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @see girl
 *This class stores the attributes of a girl
 */
public abstract class girl {
    String name;
    int attractiveness;
    int intelligence_level;
    int maint_cost;
    char criteria;
    boolean commit;
    String name_b;
    /**
     * A method for calculating the happiness
     * according to type of boy and girl
     * @param c an object of class couple
     * @param g an object of class girl
     */
    public abstract void happiness(girl g,couple c);
}
