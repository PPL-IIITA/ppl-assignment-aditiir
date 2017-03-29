
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class random_k <t> {
    /**
     * Method to return best of the n items
     * @return integer
     */
    public int fnc()
    {
        Random randomGenerator = new Random();
        int n=randomGenerator.nextInt(10);
        return n;
    }
    
}
