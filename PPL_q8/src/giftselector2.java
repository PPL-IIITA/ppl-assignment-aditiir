
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class giftselector2 {
    /**
     * Method implementing new gifting algorithm
     * @param brr array of objects of class boy
     * @param grr array of objects of class girl
     * @param n array of indexes of committed boys
     * @param f an integer
     * @param price array of prices of gifts
     * @param c array of objects of class couple
     * @throws IOException for errors
     */
    public void gifting(boy[] brr,girl[] grr,int[] n,int f,int[] price,couple[] c)throws IOException
    {
        int i=0,j=100,k=200;
        if(brr[n[f]].type=='m')
            {
            //    System.out.println("miser");
                c[f].gift_cost+=price[i++]+price[j++]+price[k++];
                while(c[f].gift_cost<grr[f].maint_cost)
                    c[f].gift_cost+=price[f];
            }
            else if(brr[n[f]].type=='g')
            {
             //   System.out.println("geeky");
                c[f].gift_cost+=price[i++]+price[j++]+price[k++];
                while(c[f].gift_cost<grr[f].maint_cost)
                    c[f].gift_cost+=price[f];
                if(brr[n[f]].budget>0&&brr[n[f]].budget>price[f])
                    c[f].gift_cost+=price[f];
            }
            else
            {
              //  System.out.println("generous");
                c[f].gift_cost+=price[i++]+price[j++]+price[k++];
                while(c[f].gift_cost<brr[n[f]].budget){
                    c[f].gift_cost+=price[f];
                    }
            }
    }
}
