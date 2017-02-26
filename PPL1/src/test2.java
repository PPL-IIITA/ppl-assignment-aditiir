
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * @see test2
 *This class calls the methods of class couple to store the 
 * gifting details
 */
public class test2 {
    public void gen_couple()throws IOException
    {
       girl[] g=new girl[12];
       boy[] b=new boy[58];
       for ( int i=0; i<g.length; i++) {
           g[i]=new girl();
}
       for ( int i=0; i<b.length; i++) {
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
      int i=0;
      BufferedReader br=new BufferedReader(new FileReader("data_g.txt"));
      BufferedReader br1=new BufferedReader(new FileReader("data_b.txt"));
      while((line=br.readLine())!=null)
      {
          String [] arr=line.split(",");
          g[i].attractiveness=Integer.parseInt(arr[0]);
          g[i].intelligence_level=Integer.parseInt(arr[1]);
          g[i].maint_cost=Integer.parseInt(arr[2]);
          i++;
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
    int[] rich=new int[58];
    int[] attract=new int[58];
    int[] intelligent=new int[58];
    for(int z=0;z<58;z++)
    {
        rich[z]=b[z].budget;
        attract[z]=b[z].attractiveness;
        intelligent[z]=b[z].intelligence_level;
    }
    Arrays.sort(rich);
    Arrays.sort(attract);
    Arrays.sort(intelligent);
    final String alphabet = "rai";
    final int N = alphabet.length();
    Random r = new Random();
    for(int z=0;z<12;z++)
    {
    g[z].criteria=alphabet.charAt(r.nextInt(N));
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
    out2.close();
    couple c=new couple();
    c.gifting(b,g);
    }
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
}

