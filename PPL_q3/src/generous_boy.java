/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class generous_boy extends boy{
    /**
     * An abstract method for calculating the cost of gift
     * given by boy to girl according to type of boy
     * @param g an object of class girl
     * @param c an object of class couple
     * @param price an array which stores the prices of 
     * all gifts
     */
    public void calc_cost(girl g,couple c,int[] price)
    {
        int j=0;
        while(c.gift_cost<budget){
                    c.gift_cost+=price[j];
                    j++;
        }
    }
    /**
     * An abstract method for calculating the happiness
     * according to type of boy and girl
     * @param c an object of class couple
     * @param g an object of class girl
     */
    public void happiness(couple c,girl g)
    {
        c.happiness_b=c.happiness_g;
    }
}
