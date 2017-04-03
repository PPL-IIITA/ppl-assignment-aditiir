
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * @see test6
 * Class forms the couples
 * Performs the gifting for t days
 * Calculates k least happy couples
 * Perform breakup of couples who have 
 * happiness less than t and form new couples
 */
public class test6 {
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
    out2.close();
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
       int[] n=new int[12];
       for(i=0;i<12;i++)
        {
            n[i]=search(b,g[i].name_b);
        }
       for(int v=0;v<12;v++)
       {
           c[v].gifting(b,g,n,v);
           c[v].happiness(g,b,n,v);
       }
    int happy[]=new int[12];
    for(int l=0;l<12;l++)
        happy[l]=c[l].happiness;
    Arrays.sort(happy);
    int ki=4;
 /*   for(int v=0;v<12;v++)
    {
        System.out.println(happy[v]);
    }*/
    int[] mi=new int[ki];
    int[] ex_girl=new int[k];
    int[] ex_boy=new int[k];
    int t_day=20;
    int[] t_happy=new int[ki];
    for(int gi=0;gi<t_day;gi++)
    {
    System.out.println("The "+ki+" Least happy couples are");
    for(int v=0;v<ki;v++)
    {
    //    System.out.println("hi");
        int j=0;
        while(happy[v]!=c[j].happiness)
            j++;
        mi[v]=j;
        t_happy[v]=c[j].happiness;
        System.out.println(c[j].name_girl+" "+c[j].name_boy+" "+happy[v]);
    }
    int flag=0;
  //  for(int p=0;p<t_day;p++)
    //{
    for(int hi=0;hi<ki;hi++)
    {
        if(t_happy[hi]<t_day)
        {
            flag=1;
            int n1=0,n2;
            for(int v=0;v<ki;v++)
             {
               ex_boy[v]=search(b,c[mi[v]].name_boy);
               ex_girl[v]=search_g(g,c[mi[v]].name_girl);
             }
            for(int v=0;v<ki;v++)
    {
      g[ex_girl[v]].commit=false;
      b[ex_boy[v]].commit=false;
      g[ex_girl[v]].name_b=null;
      c[mi[v]].name_boy=null;
    }
    boolean rx;
    System.out.println("Newly formed pairs are");
    for(int v=0;v<ki;v++)
    {
        g[ex_girl[v]].commit=true;
        while(b[n1].commit!=false)
            n1++;
        rx=search_ex(ex_boy,n1);
        if(rx==false)
        {
        g[ex_girl[v]].name_b=b[n1].name;
        b[n1].commit=true;
        c[mi[v]].name_boy=b[n1].name;
        c[mi[v]].name_girl=g[ex_girl[v]].name;
        System.out.println(g[ex_girl[v]].name+" "+b[n1].name);
        }
        else
        {
            while(b[n1].commit!=false)
            {
                n1++;
                if(n1==57)
                    break;
            }
        g[ex_girl[v]].name_b=b[n1].name;
        b[n1].commit=true;
        c[mi[v]].name_boy=b[n1].name;
        c[mi[v]].name_girl=g[ex_girl[v]].name;
        System.out.println(g[ex_girl[v]].name+" "+b[n1].name);
        }
    }
            
        }
    }
        if(flag==0)
        {
            System.out.println("No couple has happiness less than "+t_day);
        }
    }
    
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
    public void print(girl[] g,boy[] b)
    {
        System.out.println("The couples formed are");
        for(int z=0;z<12;z++)
    {
        System.out.println(g[z].name+" "+g[z].name_b);
    }
    }
}

