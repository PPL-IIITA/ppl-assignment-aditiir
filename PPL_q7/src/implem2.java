/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class which stores the committed boys in an 
 * sorted array
 */
public class implem2 {
    String[] arr=new String[50];
    int ind=-1;
    void insert2(String name)
    {
        arr[++ind]=name;
    }
    /**
     * Method to search the boy in sorted array using
     * binary search
     * @param g array of girls
     * @param c array of couple
     * @param b list of boys
     * @return string array
     */
    String[] search2(girl[] g,couple[] c,String[] b)
    {
        int len=b.length;
        String[] res1=new String[len];
        int[] res=new int[len];
        String[] sorted_name=new String[12];
        for(int i=0;i<12;i++)
        {
            sorted_name[i]=c[i].name_boy;
        }
        couple temp;
        for(int i=0; i<12; i++)
        {
            for(int j=1; j<12; j++)
            {
                if((c[j-1].name_boy).compareTo((c[j].name_boy))>0)
                {
                    temp=c[j-1];
                   c[j-1]=c[j];
                   c[j]=temp;
                }
            }
        }
        
        for(int i=0;i<len;i++)
        {
        int start = 0;
        int end =11,mid=-1;
        String key=b[i];
        while (start <= end) {
            mid = (start + end) / 2;
            if (key.equals(c[mid].name_boy)==true) {
                res[i]=mid;
                break;
            } 
            if (key.compareTo(c[mid].name_boy)<0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(start>end)
        res[i]=-1;
        else
            res[i]=mid;
}
        for(int i=0;i<len;i++)
        {
            if(res[i]==-1)
                res1[i]="no";
            else
                res1[i]=c[res[i]].name_girl;
        }
        return res1;
}
}
