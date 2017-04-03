
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;


public class test3 {
    /**
     * initialize objects of girl,boy,couple
     * For calculating the happiness, appropriate 
     * functions of classes are called due to polymorphism 
     * @throws FileNotFoundException handles file errors
     * @throws IOException handles IO errors
     */
    public void fnc() throws FileNotFoundException, IOException
    {
        girl[] g = new girl[12];
        boy[] b=new boy[58];
        char[] type_g=new char[12];
        char[] type_b=new char[58];
        final String alphabet3 = "cnd";
        final int N3 = alphabet3.length();
        Random r3 = new Random();
        for(int z=0;z<12;z++)
          {
             type_g[z]=alphabet3.charAt(r3.nextInt(N3));
          }
        final String alphabet2 = "mgj";
        final int N2 = alphabet2.length();
        Random r2 = new Random();
        for(int z=0;z<58;z++)
          {
             type_b[z]=alphabet2.charAt(r2.nextInt(N2));
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
      String line;
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
      int m=0,k=0;
        for(int i=0;i<12;i++)
        {
            if(type_g[i]=='c')
            {
                g[i]=new choosy_girl();
      
      BufferedReader br=new BufferedReader(new FileReader("data_g.txt"));
      line=br.readLine();
      
          String [] arr=line.split(",");
          g[m].attractiveness=Integer.parseInt(arr[0]);
          g[m].intelligence_level=Integer.parseInt(arr[1]);
          g[m].maint_cost=Integer.parseInt(arr[2]);
          m++;
         
            }
            else if(type_g[i]=='n')
            {
                g[i]=new normal_girl();
                
              BufferedReader br=new BufferedReader(new FileReader("data_g.txt"));
              line=br.readLine();
      
          String [] arr=line.split(",");
          g[m].attractiveness=Integer.parseInt(arr[0]);
          g[m].intelligence_level=Integer.parseInt(arr[1]);
          g[m].maint_cost=Integer.parseInt(arr[2]);
          m++;
         
            }
            else
            {
                g[i]=new desperate_girl();
      
      BufferedReader br=new BufferedReader(new FileReader("data_g.txt"));
      line=br.readLine();
      {
          String [] arr=line.split(",");
          g[m].attractiveness=Integer.parseInt(arr[0]);
          g[m].intelligence_level=Integer.parseInt(arr[1]);
          g[m].maint_cost=Integer.parseInt(arr[2]);
          m++;
         }
            }
        }
        BufferedReader br1=new BufferedReader(new FileReader("data_b.txt"));
        for(int i=0;i<58;i++)
        {
            if(type_b[i]=='m')
            {
                b[i]=new miser_boy();
                
          line=br1.readLine();
          
              String [] brr=line.split(",");
              b[k].attractiveness=Integer.parseInt(brr[0]);
              b[k].intelligence_level=Integer.parseInt(brr[1]);
              b[k].budget=Integer.parseInt(brr[2]);
              b[k].min_attraction=Integer.parseInt(brr[3]);
              k++;
      
            }
            else if(type_b[i]=='g')
            {
                b[i]=new geeky_boy();
                line=br1.readLine();
          
              String [] brr=line.split(",");
              b[k].attractiveness=Integer.parseInt(brr[0]);
              b[k].intelligence_level=Integer.parseInt(brr[1]);
              b[k].budget=Integer.parseInt(brr[2]);
              b[k].min_attraction=Integer.parseInt(brr[3]);
              k++;
      
            }
            else
            {
                b[i]=new generous_boy();
                line=br1.readLine();
          
              String [] brr=line.split(",");
              b[k].attractiveness=Integer.parseInt(brr[0]);
              b[k].intelligence_level=Integer.parseInt(brr[1]);
              b[k].budget=Integer.parseInt(brr[2]);
              b[k].min_attraction=Integer.parseInt(brr[3]);
              k++;
      
            }
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
   gen_criteria(g);
   int ind;
   for(int z=0;z<58;z++)
        b[z].commit=false;
   int[] ind_b=new int[58];
   for(int i=0;i<58;i++)
       ind_b[i]=-1;
   int[] ind_g=new int[12];
   for(int z=0;z<12;z++)
    {
        if(g[z].criteria=='r')
        {
            ind=linearSearch(b,'r');
                b[ind].commit=true;
                ind_b[z]=ind;
                g[z].name_b=b[ind].name;
        }
        else if(g[z].criteria=='i')
        {
            ind=linearSearch(b,'i');
                b[ind].commit=true;
                ind_b[z]=ind;
                g[z].name_b=b[ind].name;
        }
       else if(g[z].criteria=='a')
        {
               ind=linearSearch(b,'a');
                b[ind].commit=true;
                ind_b[z]=ind;
                g[z].name_b=b[ind].name;
        }
    }
   FileWriter out2 = null;
    out2 = new FileWriter("couple.txt");
    for(int z=0;z<12;z++)
    {
        out2.write(g[z].name+" "+g[z].name_b);
    }
    out2.close();
    couple[] c=new couple[12];
       for (int i=0; i<c.length; i++) {
           c[i]=new couple();
             }
       for (int i=0; i<c.length; i++) {
           c[i].gift_cost=0;
             }  
       for(int i=0;i<12;i++)
          {
             c[i].name_girl=g[i].name;
             c[i].name_boy=g[i].name_b;
          }
       print(g,b);
       int[] n=new int[12];
       for(int i=0;i<12;i++)
        {
            n[i]=search(b,g[i].name_b);
        }
  //     System.out.println("before gifting");
       for(int v=0;v<12;v++)
       {
           c[v].gifting(b,g,n,v,type_g,type_b);
           c[v].happinesss(g,b,n,v,type_g,type_b);
       }
  //     System.out.println("after gifting");
       int[] happy=new int[12];
       int[] co=new int[12];
       for(int i=0;i<12;i++)
       {
       happy[i]=c[i].happiness;
       co[i]=c[i].compatibility;
       }
    /*   System.out.println("couple array");
       for(int i=0;i<12;i++)
           System.out.println(c[i].happiness);*/
       
       int ki=4;
       Arrays.sort(happy);
       Arrays.sort(co);
   /*    System.out.println("hppiness arr");
       for(int i=0;i<12;i++)
           System.out.println(happy[i]);*/
       System.out.println("The "+4+" Most happy couples are");
       for(int i=11;i>11-ki;i--)
       {
           int j=0;
           j=0;
           while(happy[i]!=c[j].happiness)
                j++;
         //  System.out.println(n[j]);
            System.out.println(c[j].name_girl+" "+c[j].name_boy+" "+happy[i]);
       }
       System.out.println("The "+4+" Most compatible couples are");
       for(int i=11;i>11-ki;i--)
       {
           int j=0;
           j=0;
           while(co[i]!=c[j].compatibility)
                j++;
            System.out.println(c[j].name_girl+" "+c[j].name_boy);
       }
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
    /**
     * This method generate criteria of each girl 
     * for selecting the boyfriend randomly
     * and stores it into the object of class girl
     * @param g array of object of class girl
     */
    public void gen_criteria(girl[] g)
    {
        final String alphabet = "rai";
        final int N = alphabet.length();
        Random r = new Random();
        for(int z=0;z<12;z++)
          {
            g[z].criteria=alphabet.charAt(r.nextInt(N));
           }
    }
    /**
     * Method to find the correct boy according
     * to given name
     * @param arr array of objects of boys
     * @param s name
     * @return index of boy with name s
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
    }

