
import static java.lang.Math.abs;
import static java.lang.Math.log;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class choosy_girl extends girl{
    /**
     * An abstract method for calculating the happiness
     * according to type of boy and girl
     * @param c an object of class couple
     * @param g an object of class girl
     */
    public void happiness(girl g,couple c)
    {
        c.happiness_g=abs((int)log(c.gift_cost)-g.maint_cost);
    }
}
