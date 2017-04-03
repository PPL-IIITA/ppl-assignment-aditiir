
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * @see test5
 *Class forms the couples as per given conditions
 * Performs the gifting
 */
public class test5 {
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
/*    int[] rich=new int[58];
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
    Arrays.sort(intelligent);*/
    girl t;
    boy s;
    int p;
    for(i=0;i<11;i++)
    {
        p=0;
        for(int j=0;j<11-i;j++)
        {
            if(g[j].maint_cost>g[j+1].maint_cost)
            {
                   t=g[j];
                   g[j]=g[j+1];
                   g[j+1]=t;
                   p=1;
            }
        }
        if(p==0)
            break;
    }
    for(i=0;i<57;i++)
    {
        p=0;
        for(int j=0;j<57-i;j++)
        {
            if(b[j].attractiveness>b[j+1].attractiveness)
            {
                   s=b[j];
                   b[j]=b[j+1];
                   b[j+1]=s;
                   p=1;
            }
        }
        if(p==0)
            break;
    }
    final String alphabet = "rai";
    final int N = alphabet.length();
    Random r = new Random();
    for(int z=0;z<12;z++)
    {
    g[z].criteria=alphabet.charAt(r.nextInt(N));
    }
    int ri,inn=0,at=0,ind;
    int len=b.length;
    for(int z=0;z<len;z++)
        b[z].commit=false;
    for(int z=0;z<12;z++)
        g[z].commit=false;
  //  System.out.println("hi");
    for(int z=0;z<12;z++)
    {
     //   System.out.println("Girl chooses boy");
        if(z%2==0)
        {
            at=0;
            while(g[at].commit!=false)
            {
                at++;
                if(at==11)
                    at=0;
            }
            
        if(g[at].criteria=='r')
        {
            ind=linearSearch(b,'r');
         //   System.out.println(ind);
            if(b[ind].commit==false)
            {
                b[ind].commit=true;
                g[at].commit=true;
                g[at].name_b=b[ind].name;
                b[ind].name_g=g[at].name;
            }
            else
            {
                while(b[ind].commit!=false)
                {
             //       System.out.println("while1");
                    ind++;
                    if(ind==57)
                        ind=0;
                }
           //      System.out.println(ind);   
                b[ind].commit=true;
                g[at].commit=true;
                g[at].name_b=b[ind].name;
                b[ind].name_g=g[at].name;
            }
        }
        else if(g[at].criteria=='i')
        {
            ind=linearSearch(b,'i');
        //    System.out.println(ind);
                if(b[ind].commit==false)
            {
                b[ind].commit=true;
                g[at].commit=true;
                g[at].name_b=b[ind].name;
                b[ind].name_g=g[at].name;
            }
                else
            {
                while(b[ind].commit!=false)
                {
        //            System.out.println("while2");
                    ind++;
                    if(ind==57)
                        ind=0;
                }
       //         System.out.println(ind);
                b[ind].commit=true;
                g[at].commit=true;
                g[at].name_b=b[ind].name;
                b[ind].name_g=g[at].name;
            }
        }
       else if(g[at].criteria=='a')
        {
               ind=linearSearch(b,'a');
         //      System.out.println(ind);
                if(b[ind].commit==false)
            {
                b[ind].commit=true;
                g[at].commit=true;
                g[at].name_b=b[ind].name;
                b[ind].name_g=g[at].name;
            }
                else
            {
                while(b[inn].commit!=false)
                {
           //         System.out.println("while3");
                    inn++;
                    if(inn==57)
                        inn=0;
                }
             //   System.out.println(inn);
                b[inn].commit=true;
                g[at].commit=true;
                g[at].name_b=b[ind].name;
                b[inn].name_g=g[at].name;
            }
        }
        }
        else
        {
            int maxi;
            inn=0;
            while(b[inn].commit!=false)
            {
                inn++;
               // System.out.println(" inn is "+inn);
                if(inn==57)
                    inn=0;
            //    System.out.println("while4");
            }
                
            maxi=search_g(g);
       //     System.out.println("maxi is "+maxi);
            if(g[maxi].commit==false)
            {
                b[inn].commit=true;
                g[maxi].commit=true;
                g[maxi].name_b=b[inn].name;
                b[inn].name_g=g[maxi].name;
            }
            else
            {
                int ni=maxi;
                if(maxi==11)
                    maxi=0;
         //       System.out.println("else part");
                
                while(g[maxi].commit!=false&&maxi!=ni-1)
                {
                    maxi++;
                    if(maxi==11)
                        maxi=0;
                    
           //         System.out.println("while5");
                }
                b[inn].commit=true;
                g[maxi].commit=true;
                g[maxi].name_b=b[inn].name;
                b[inn].name_g=g[maxi].name;
            }
        }
    }
    for(int ti=0;ti<12;ti++)
    {
        int ho=0;
        if(g[ti].name_b==null)
        {
            while(b[ho].commit!=false)
                ho++;
            b[ho].commit=true;
            g[ti].commit=true;
            g[ti].name_b=b[ho].name;
            b[ho].name_g=g[ti].name;
        }
    }
    FileWriter out2 = null;
    out2 = new FileWriter("couple.txt");
    for(int z=0;z<12;z++)
    {
        out2.write(g[z].name+" "+g[z].name_b);
    }
    out2.close();
    print(g,b);
  //  breakup c=new breakup();
  //  c.gifting(b,g);
    couple c=new couple();
    c.gifting(b,g);
    }
    public static int search_g(girl[] g)
    {
        int maxi=0;
            int maxa=g[0].attractiveness;
            for(int l=1;l<12;l++)
            {
                if(g[l].attractiveness>maxa)
                {
                    maxa=g[l].attractiveness;
                    maxi=l;
                }
            }
            return maxi;
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
    public void print(girl[] g,boy[] b)
    {
        System.out.println("The couples formed are");
        for(int z=0;z<12;z++)
    {
        System.out.println(g[z].name+" "+g[z].name_b);
    }
    }
}

