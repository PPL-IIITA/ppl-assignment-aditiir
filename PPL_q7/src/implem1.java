/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class which stores the committed boys in an array
 */
public class implem1 {
    String[] arr=new String[50];
    int ind=-1;
    void insert(String name)
    {
        arr[++ind]=name;
    }
    /**
     * Method to search the boy in array using linear search
     * @param g array of girls
     * @param c array of couple
     * @param b list of boys
     * @return string array
     */
    String[] search(girl[] g,couple[] c,String[] b)
    {
        int len=b.length;
        String[] res=new String[len];
        
        for(int i=0;i<len;i++)
        {
            int flag=1;
            int j=0;
            while(b[i].equals(c[j].name_boy)!=true)
            {
                j++;
                if(j==12)
                {
                   flag=0;
                   break;
                }
            }
        
            if(flag==0)
                res[i]="no";
            else 
                res[i]=c[j].name_girl;
        }   
    return res;
}
}
