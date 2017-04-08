
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 * @see test8
 *This class calls the methods of different giftselector
 * classes for different implementations
 */
public class test8 {
    /**
     * Method that generates couples
     * Initialize the objects of all gifts
     * Initialize the objects of class girl,boy,couple
     * @throws IOException Handling IO errors
     */
    public void gen_couple()throws IOException
    {
        int i;
       girl[] g=new girl[12];
       boy[] b=new boy[58];
       for (i=0; i<g.length; i++) {
           g[i]=new girl();
}
       for (i=0; i<b.length; i++) {
           b[i]=new boy();
}
      FileReader in = null;
      FileReader inx = null;
      FileWriter out = null;
      FileWriter out1 = null;
      in = new FileReader("data_g.txt");
      inx= new FileReader("data_b.txt");
      out = new FileWriter("data_g.txt");
      out1 = new FileWriter("data_b.txt");
      Random randomGenerator = new Random();
      for (int idx = 1; idx <= 12; ++idx){
      int att = randomGenerator.nextInt(10)+10;
      int intell=randomGenerator.nextInt(10);
      int cost=randomGenerator.nextInt(1000);
      
      out.write(String.valueOf(att)+",");
      out.write(String.valueOf(intell)+",");
      out.write(String.valueOf(cost)+"\n");   
     
      }
      out.close();
      for (int idx = 1; idx <= 58; ++idx){
      int att_b = randomGenerator.nextInt(10);
      int intell_b=randomGenerator.nextInt(10);
      int low=1000;
      int high=3000;
      int budget=randomGenerator.nextInt(high-low)+low;
      int min_attr=randomGenerator.nextInt(5);
      out1.write(String.valueOf(att_b)+",");
      out1.write(String.valueOf(intell_b)+",");
      out1.write(String.valueOf(budget)+",");  
      out1.write(String.valueOf(min_attr)+"\n"); 
      }
      out1.close();
      String line;
      int m=0;
      BufferedReader br=new BufferedReader(new FileReader("data_g.txt"));
      BufferedReader br1=new BufferedReader(new FileReader("data_b.txt"));
      while((line=br.readLine())!=null)
      {
          String [] arr=line.split(",");
          g[m].attractiveness=Integer.parseInt(arr[0]);
          g[m].intelligence_level=Integer.parseInt(arr[1]);
          g[m].maint_cost=Integer.parseInt(arr[2]);
          m++;
         }
         int k=0;
          while((line=br1.readLine())!=null)
          {
              String [] brr=line.split(",");
              b[k].attractiveness=Integer.parseInt(brr[0]);
              b[k].intelligence_level=Integer.parseInt(brr[1]);
              b[k].budget=Integer.parseInt(brr[2]);
              b[k].min_attraction=Integer.parseInt(brr[3]);
              k++;
      }
      String line1;
      int x=0,y=0;
      BufferedReader gr=new BufferedReader(new FileReader("name_g.txt"));
      BufferedReader gr1=new BufferedReader(new FileReader("name_b.txt"));
      StringBuilder sb = new StringBuilder();
      while((line1=gr.readLine())!=null)
      {
          g[x].name=line1;
          x++;
      }
      in.close();
      while((line1=gr1.readLine())!=null)
      {
          b[y].name=line1;
          y++;
      }
   inx.close();
 
    final String alphabet = "rai";
    final int N = alphabet.length();
    Random r = new Random();
    for(int z=0;z<12;z++)
    {
    g[z].criteria=alphabet.charAt(r.nextInt(N));
    }
    final String alphabet2 = "mgj";
        final int N2 = alphabet2.length();
        Random r2 = new Random();
        for(int z=0;z<12;z++)
          {
             b[z].type=alphabet2.charAt(r2.nextInt(N2));
          }
        final String alphabet3 = "cnd";
        final int N3 = alphabet3.length();
        Random r3 = new Random();
        for(int z=0;z<12;z++)
          {
             g[z].type=alphabet3.charAt(r3.nextInt(N3));
          }
    int ri,inn,at,ind;
    int len=b.length;
    for(int z=0;z<len;z++)
        b[z].commit=false;
    for(int z=0;z<12;z++)
    {
        if(g[z].criteria=='r')
        {
            ind=linearSearch(b,'r');
                b[ind].commit=true;
                g[z].name_b=b[ind].name;
        }
        else if(g[z].criteria=='i')
        {
            ind=linearSearch(b,'i');
                b[ind].commit=true;
                g[z].name_b=b[ind].name;
        }
       else if(g[z].criteria=='a')
        {
               ind=linearSearch(b,'a');
                b[ind].commit=true;
                g[z].name_b=b[ind].name;
        }
    }
    FileWriter out2 = null;
    out2 = new FileWriter("couple.txt");
    for(int z=0;z<12;z++)
    {
        out2.write(g[z].name+" "+g[z].name_b);
    }
  //  out2.close();
    couple[] c=new couple[12];
       for (i=0; i<c.length; i++) {
           c[i]=new couple();
             }
       for (i=0; i<c.length; i++) {
           c[i].gift_cost=0;
             }  
       for(i=0;i<12;i++)
          {
             c[i].name_girl=g[i].name;
             c[i].name_boy=g[i].name_b;
          }
       
       print(g,b);
       essential_gift[] e=new essential_gift[100];
        luxury_gift[] l=new luxury_gift[100];
        utility_gift[] u=new utility_gift[100];
        for(int p=0;p<100;p++)
          {
              l[p]=new luxury_gift();
              u[p]=new utility_gift();
              e[p]=new essential_gift();
          }
        FileWriter out3=null;
        FileWriter out4=null;
        FileWriter out5=null;
        FileWriter out6=null;
        out3=new FileWriter("lux_gifts.txt");
        out4=new FileWriter("essen_gifts.txt");
        out5=new FileWriter("util_gifts.txt");
    //    out6=new FileWriter("couple.txt");
        Random randomGenerator1 = new Random();
        for(int p=0;p<100;p++)
        {
            e[p].price= randomGenerator1.nextInt(500);
            e[p].value= randomGenerator1.nextInt(20);
            out4.write(String.valueOf(e[p].price)+" ");
            out4.write(String.valueOf(e[p].value)+"\n");
        }
        out4.close();
        for(int p=0;p<100;p++)
        {
            u[p].price= randomGenerator.nextInt(800)+400;
            u[p].value= randomGenerator.nextInt(50)+20;
            out5.write(String.valueOf(u[p].price+" "));
            out5.write(String.valueOf(u[p].value+"\n"));
        }
        out5.close();
        for(int p=0;p<100;p++)
        {
            l[p].price= randomGenerator.nextInt(1200)+800;
            l[p].value= randomGenerator.nextInt(80)+50;
            out3.write(String.valueOf(l[p].price+" "));
            out3.write(String.valueOf(l[p].value+"\n"));
        }
        out3.close();
        int[] price=new int[300];
        for(int p=0;p<100;p++)
        {
            price[p]=e[p].price;
        }
        int j=0;
        for(int p=100;p<200;p++)
        {
            price[p]=u[j].price;
            j++;
        }
        int pi=0;
        for(int p=200;p<300;p++)
        {
            price[p]=l[pi].price;
            pi++;
        }
       int[] n=new int[12];
       for(i=0;i<12;i++)
        {
            n[i]=search(b,g[i].name_b);
        }
      /* int d;
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in1=new BufferedReader(read);
        System.out.println("Enter ur choice");
        System.out.println("Enter 0 for the primitive gift selection algorithm");
        System.out.println("Enter 1 for the new gift selection algorithm");
        d=Integer.parseInt(in1.readLine*/
        Random d = new Random();
        int dr = d.nextInt(2);
    //    System.out.println(dr);
        if(dr==0)
        {
            System.out.println("primitive gifting algorithm implemented");
            giftselector1 gf=new giftselector1();
            for(int v=0;v<12;v++)
       {
           gf.gifting(b,g,n,v,price,c);
       }
        }
        else if(dr==1)
        {
            System.out.println("new gifting algorithm implemented");
       giftselector2 gf=new giftselector2();
       for(int v=0;v<12;v++)
       {
           gf.gifting(b,g,n,v,price,c);
       }
        }
        
        else
        {
            System.out.println("Default method of gifting used");
            giftselector1 gf=new giftselector1();
            for(int v=0;v<12;v++)
       {
           gf.gifting(b,g,n,v,price,c);
        }
        }
       for(int v=0;v<12;v++)
       {
           c[v].happiness(g,b,n,v);
       }
           
       
       for(int v=0;v<12;v++)
       {
           out2.write(c[v].name_girl+" "+c[v].name_boy+" "+c[v].gift_cost+"\n");
       }
       out2.close();
       for(int v=0;v<12;v++)
       {
           System.out.println(c[v].name_boy+" gifted "+c[v].name_girl+" gifts worth Rs"+c[v].gift_cost);
       }
    int happy[]=new int[12];
    for(int p=0;p<12;p++)
        happy[p]=c[p].happiness;
    Arrays.sort(happy);
    int ki=4;
    }
    public static boolean search_ex(int[] ar,int n)
    {
        int flag=0;
        for(int m=0;m<4;m++)
        {
            if(n==ar[m])
                flag=1;
        }
        if(flag==1)
            return true;
        else
            return false;
    }
    /**
     * This method searches the most rich or most
     * intelligent or most attractive boy according to
     * the criteria of the girl
     * @param arr array of objects of class boy
     * @param c criteria of girl
     * @return returns the index of appropriate boy
     */
    public static int linearSearch(boy[] arr,char c) {
        int size = arr.length; 
        int max=0;
        int m=-1;
        if(c=='r')
        {
        for(int i=0;i<size;i++)
        { 
            if(arr[i].budget>max&&arr[i].commit==false)
            { 
                max=arr[i].budget;
                m=i;
            } 
        } 
        return m;
        }
        else if(c=='a')
        {
            for(int i=0;i<size;i++)
        { 
            if(arr[i].attractiveness>max&&arr[i].commit==false)
            { 
                max=arr[i].attractiveness;
                m=i;
            } 
        } 
        return m;
        }
        else
        {
            for(int i=0;i<size;i++)
        { 
            if(arr[i].intelligence_level>max&&arr[i].commit==false)
            { 
                max=arr[i].intelligence_level;
                m=i;
            }
        } 
        return m;
        }
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
     * Method to find the correct girl according
     * to given name
     * @param arr array of objects of girls
     * @param s name
     * @return index of girl with name s
     */
    public static int search_g(girl[] arr,String s)
        {
            int i;
            for(i=0;i<12;i++)
            {
                if(s==arr[i].name)
                    break;
            }
            return i;
        }
    /**
     * This method prints the formed couples
     * @param g array of objects of class girl
     * @param b array of objects of class boy
     */
    public void print(girl[] g,boy[] b)
    {
        System.out.println("The couples formed are");
        for(int z=0;z<12;z++)
    {
        System.out.println(g[z].name+" "+g[z].name_b);
    }
    }
}

