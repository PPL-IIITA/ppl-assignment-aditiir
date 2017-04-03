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
    public abstract void calc_cost(girl g,couple c,int[] price);
    public abstract void happiness(couple c,girl g);
}
