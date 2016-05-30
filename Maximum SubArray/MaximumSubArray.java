import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc  =  new Scanner(System.in);
        int cases  =   sc.nextInt();
        sc.nextLine();
        for(int i=0;i<cases ;i++){
            int n  =  sc.nextInt();
            sc.nextLine();
            int [] a =  new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            int conti =  findConti(a);
            int nonconti = findNonConti(a);
            System.out.println(conti + " " + nonconti );
        }
        
        /*

2 
4 
1 2 3 4
6
2 -1 2 3 4 -5

*/
    }
    
    static int findConti(int[] a){
        int sumarray[] = new int[a.length]; 
        sumarray[0] =  a[0];
        for(int i=1;i<sumarray.length;i++){
           // System.out.println(sumarray[i-1] + a[i]);
            if(sumarray[i-1] + a[i]  > a[i]){
                sumarray[i] = sumarray[i-1] + a[i];  
            }      
            else{
                sumarray[i] = a[i];  
            }
        }
        Arrays.sort(sumarray);
        return sumarray[sumarray.length-1];
        
    }
    
    static int findNonConti(int [] a){
        Arrays.sort(a);
        if(a[a.length-1] <= 0 )
            return a[a.length-1];
        int sum = 0;
        for(int i =a.length-1;i>=0;i--){
            if(a[i]>0)
            sum =  sum + a[i];
        }
        return sum;
    }
    
    
    
    
    
    
}