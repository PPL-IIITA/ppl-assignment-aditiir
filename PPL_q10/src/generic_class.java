/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @see generic_class A generic class 
 * @param <t> type of object passed
 */

public class generic_class <t>{
    /**
     * Method to return best k values 
     * @param arr array of objects of type t
     * @param k an integer
     * @param s an array of integers
     */
    public void fnc(t[] arr,int k,int[] s)
    {
        int l=arr.length;
        t temp;
        for(int i=0; i < l; i++)
        {  
            for(int j=1; j < (l-i); j++)
                {  
                    if(s[j-1] >s[j])
                       {  
                                 //swap elements  
                          temp = arr[j-1];  
                          arr[j-1] = arr[j];  
                          arr[j] = temp;  
                         }  
                 } 
         }
        
    }
}
