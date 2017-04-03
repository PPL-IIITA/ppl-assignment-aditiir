

import java.io.*;
import static java.lang.Math.*;
import java.util.Random;
import java.util.Arrays;
import java.util.Date;
/**
 * @see couple This class stores the attributes of couple
 * and creates the gift basket
 */
public class couple {
    String name_girl;
    String name_boy;
    int happiness_g;
    int happiness_b;
    int happiness;
    int price_g,value_g;
    int gift_cost;
    int compatibility;
    /**
     * This method creates the gift basket according to 
     * the type of boy
     * @param brr array of objects of class boy
     * @param grr array of objects of class boy
     * @param n integer array
     * @param f integer
     * @throws IOException handles error in IO
     */
    public void gifting(boy[] brr,girl[] grr,int[] n,int f)throws IOException
    {
        Date date=new Date(); 
        essential_gift[] e=new essential_gift[100];
        luxury_gift[] l=new luxury_gift[100];
        utility_gift[] u=new utility_gift[100];
        for(int i=0;i<100;i++)
          {
              l[i]=new luxury_gift();
              u[i]=new utility_gift();
              e[i]=new essential_gift();
          }
    
        FileWriter out=null;
        FileWriter out1=null;
        FileWriter out2=null;
        FileWriter out3=null;
        out1=new FileWriter("lux_gifts.txt");
        out=new FileWriter("essen_gifts.txt");
        out2=new FileWriter("util_gifts.txt");
        out3=new FileWriter("couple.txt");
        Random randomGenerator = new Random();
        for(int i=0;i<100;i++)
        {
            e[i].price= randomGenerator.nextInt(500);
            e[i].value= randomGenerator.nextInt(20);
            out.write(String.valueOf(e[i].price)+" ");
            out.write(String.valueOf(e[i].value)+"\n");
        }
        out.close();
        for(int i=0;i<100;i++)
        {
            u[i].price= randomGenerator.nextInt(800)+400;
            u[i].value= randomGenerator.nextInt(50)+20;
            out2.write(String.valueOf(u[i].price+" "));
            out2.write(String.valueOf(u[i].value+"\n"));
        }
        out2.close();
        for(int i=0;i<100;i++)
        {
            l[i].price= randomGenerator.nextInt(1200)+800;
            l[i].value= randomGenerator.nextInt(80)+50;
            out1.write(String.valueOf(l[i].price+" "));
            out1.write(String.valueOf(l[i].value+"\n"));
        }
        out1.close();
 /*       final String alphabet = "mgj";
        final int N = alphabet.length();
        Random r = new Random();
        for(int z=0;z<12;z++)
          {
             brr[z].type=alphabet.charAt(r.nextInt(N));
          }*/
        int[] price=new int[300];
        for(int i=0;i<100;i++)
        {
            price[i]=e[i].price;
        }
        int j=0;
        for(int i=100;i<200;i++)
        {
            price[i]=u[j].price;
            j++;
        }
        int k=0;
        for(int i=200;i<300;i++)
        {
            price[i]=l[k].price;
            k++;
        }
        Arrays.sort(price);
  //      int[] n=new int[12];
    /*    for(int i=0;i<12;i++)
        {
            n[i]=search(brr,grr[i].name_b);
        }*/
        int h=299;
    //    for(int i=0;i<12;i++)
      //  {
            if(brr[n[f]].type=='m')
            {
                while(gift_cost<grr[f].maint_cost)
                    gift_cost+=price[f];
            }
            else if(brr[n[f]].type=='g')
            {
                while(gift_cost<grr[f].maint_cost)
                    gift_cost+=price[f];
                if(brr[n[f]].budget>0&&brr[n[f]].budget>price[h])
                    gift_cost+=price[h];
            }
            else
            {
                while(gift_cost<brr[n[f]].budget){
                    gift_cost+=price[h];
                    h--;}
            }
 
            out3.write(name_girl+" "+name_boy+" "+gift_cost+"\n");
     
         out3.close();   

    }
    /**
     * This method calculates the k most happy couples 
     * @param h array that stores happiness of each couple 
     * in sorted order
     * @param k integer that specify k
     * @param b array of objects of class boy
     * @param g array of objects of class boy
     * @param n integer array
     */
    public void happy(int[] h,int k,int[] n,girl[] g,boy[] b)
    {
     //   System.out.println("The "+k+" Most happy couples are");
        int j=0;
        for(int i=11;i>11-k;i--)
        {
           j=0;
           while(h[i]!=happiness)
                j++;
            System.out.println(g[n[j]].name+" "+b[n[j]].name+" "+h[i]);
         }
    //    System.out.println("\n");
    }
    /**
     * This method computes the k most compatible couples
     * @param co array that stores the compatibility of 
     * couples in sorted order
     * @param k  integer to specify k
     * @param c  array of objects of class couple
     */
    public void compatible(int[] co,int k,couple[] c)
    {
        int j=0;
        System.out.println("The "+k+" Most compatible couples are");
        for(int i=11;i>11-k;i--)
        {
           j=0;
           while(co[i]!=c[j].compatibility)
                j++;
            System.out.println(c[j].name_boy+" "+c[j].name_girl+" "+co[i]);
         }
        System.out.println("\n");
    }
    /**
     * This method finds the index of committed 
     * boy in array of objects of class boy 
     * @param arr array of objects of class boy
     * @param s name of boy to be found
     * @return returns the index of boy of given name
     */
    public static int search(boy[] arr,String s)
        {
            int i;
            for(i=0;i<58;i++)
            {
                if(s==arr[i].name)
                    break;
            }
            return i;
        }
    /**
     * This method calculates happiness for each couple 
     * according to the given constraints
     * @param g array of objects of class girl 
     * @param b array of objects of class boy
     * @param i an integer
     * @param n array that stores the indexes of committed
     * boys
     */
    public void happiness(girl[] g,boy[] b,int [] n,int i)
    {
        
            if(g[i].type=='c')
            {
                happiness_g=abs((int)log(gift_cost)-g[i].maint_cost);
            }
            else if(g[i].type=='n')
                happiness_g=gift_cost;
            else
                happiness_g=(int) exp(gift_cost)-g[i].maint_cost;
        //for(int i=0;i<12;i++)
        //{
            if(b[n[i]].type=='m')
                happiness_b=b[n[i]].budget-gift_cost;
            else if(b[n[i]].type=='g')
                happiness_b=g[i].intelligence_level;
            else
                happiness_b=happiness_g;
        //for(int i=0;i<12;i++)
        //{
            compatibility=abs(b[n[i]].budget-g[i].maint_cost)+abs(b[n[i]].intelligence_level-g[i].intelligence_level)+abs(b[n[i]].attractiveness-g[i].attractiveness);
        //}
        //for(int i=0;i<12;i++)
            happiness=abs(happiness_g+happiness_b);
//}
}
}


