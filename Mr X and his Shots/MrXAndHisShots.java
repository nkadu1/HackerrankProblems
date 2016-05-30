import java.io.*;
import java.util.*;
public class Solution {

   static  TreeMap<Integer,ArrayList<Integer>>  mapn  = new TreeMap<Integer,ArrayList<Integer>>();
   static TreeMap<Integer,ArrayList<Integer>>  mapm  = new TreeMap<Integer,ArrayList<Integer>>();
   
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
         for(int i=0;i<n;i++){
           addValuesn(sc.nextInt(),sc.nextInt());
        }
            for(int i=0;i<m;i++){
                addValuesm(sc.nextInt(),sc.nextInt());
         }
        
        for(ArrayList<Integer> list : mapm.values()){
            Collections.sort(list);
        }   
        
        for(ArrayList<Integer> list : mapn.values()){
            Collections.sort(list);
        }
            
        
        ArrayList<Integer> lastvalueN  =  mapn.get(mapn.lastKey());
        if(lastvalueN.get(lastvalueN.size()-1) < mapm.firstKey()){
            System.out.print(0);
            return;
        }

        ArrayList<Integer> lastvalueM  =  mapm.get(mapm.lastKey());
        if(lastvalueM.get(lastvalueM.size()-1) < mapn.firstKey())
        {
            System.out.print(0);
            return;
        }
         
        
        int count  = 0;
          for(Map.Entry<Integer,ArrayList<Integer>> entry : mapm.entrySet()){
            int from  = entry.getKey();
            ArrayList<Integer> mlist =  entry.getValue();
            
              for(int to : mlist){
                
                for(Map.Entry<Integer,ArrayList<Integer>> entryn: mapn.entrySet()){
                  int nkey =  entryn.getKey();
                   if(nkey > to) break;
                    
                   if((nkey == from)) {
                        count = count + mapn.get(from).size();
//                      System.out.println("up " + count);
                        continue;
                  }
                      
                   ArrayList<Integer> nlist =  entryn.getValue();   
                   if(nlist.get(nlist.size()-1) < from )
                       continue;
                   int i=0;
                   for(int nvalue : nlist){
                       if(!(nvalue < from)){
                           count   = count  +   nlist.size() - i;
                              break;
                       }
                       i++;
                
               }
               }
              }
            }
         
        System.out.print(count);
    }
    
    
    static boolean check(int from , int to, int nkey, int nvalue){
        if((nkey <= to && nkey >= from) || (nkey <= from && nvalue >= from))
            return true;
        else 
            return false;
    }
    
    static void addValuesn(Integer key, Integer value) {
           ArrayList<Integer> tempList = null;
           if (mapn.containsKey(key)) {
              tempList = mapn.get(key);
              tempList.add(value);  
           } else {
              tempList = new ArrayList();
              tempList.add(value);               
           }
           mapn.put(key,tempList);
        
        
    }
    
    static void addValuesm(Integer key, Integer value) {
           ArrayList<Integer> tempList = null;
           if (mapm.containsKey(key)) {
              tempList = mapm.get(key);
              tempList.add(value);  
           } else {
              tempList = new ArrayList();
              tempList.add(value);               
           }
           mapm.put(key,tempList);
    }
    
}