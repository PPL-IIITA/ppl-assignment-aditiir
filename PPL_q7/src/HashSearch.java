/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class HashSearch extends Search{
    //final int size=12;
   // HashEntry[] hash_table;
    Entry[] table=new Entry[size];
    public HashSearch(){
        for(int i=0;i<size;i++){
            table[i]=null;
            
        }
    }
    /**
     * Hash function which returns the sum of ASCII
     * values of characters as key of given string
     * @param value string
     * @return key
     */
    int hash(String value){
        
            int length = value.length();

            int i, sum;
            for (sum=0, i=0; i < length; i++)
            sum += value.charAt(i);
            return sum;
      }
    /**
     * Method to store data in hash table
     * @param boy_name name of boy
     * @param girl_name name of girl
     */
    
    public void storeData(String boy_name,String girl_name){
        int h=hash(boy_name)%size;
        //table[h].init();
        while (table[h] != null)
                  h = (h + 1) % size;
            table[h] = new hashentry();
            table[h].bf_name=boy_name;
            table[h].gf_name=girl_name;
            
    }
    /**
     * Method to find the passed string in the hash
     * table
     * @param value passed string
     * @return hash value of string
     */
    public String search(String value){
        int h=hash(value)%size;
       for(int i=0;i<size;i++){
            h = (h + i) % size;
            if((table[h].bf_name).equals(value)==true)
                 
            //table[h] = new hashentry(value);
        
            return table[h].gf_name;
        }
       return null;
    }
}