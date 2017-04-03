
public class miser_boy extends boy{
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
        while(c.gift_cost<g.maint_cost){
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
        c.happiness_b=budget-c.gift_cost;
    }
}
