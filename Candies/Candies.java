import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc =  new Scanner(System.in);
        int N =  sc.nextInt();
        long a[] = new long[N];
        long ratings[]   = new long[N];
        for(int i=0;i<N;i++){
            ratings[i] =  sc.nextInt();
            if(sc.hasNextLine())
            sc.nextLine();
        }
        int minchoc  = 1;
        long ind=0;
        a[0] = 1;
        for(int i=1;i<N;i++){
           if(ratings[i] > ratings[i-1]){
               //System.out.println(ratings[i] + " " + a[i] + " " + a[i-1]);
               a[i] =  a[i-1] + 1;
               //System.out.println("  " + a[i]);
               ind  =  i;
           }
           else if(ratings[i] == ratings[i-1] ){
                    a[i]  = 1;
                    ind = i;
           }
           else{
               //System.out.println("i " + i);
               if(a[i-1] == 1){
                   int temp =  i-1;
                   while(temp>=ind){
                       a[temp]++;
                       temp--;
                        //System.out.print(temp + " ");
                        if(temp>0){
	                        if(a[temp] > a[temp+1])
	                           break;
                        }
                      
                   }
                   a[i] =  a[i-1]-1;
               }
               else{
                   a[i] = 1;
               }
           }
        }
        for(int i=0;i<N;i++){
         //   System.out.print(a[i] + " ");
        }
           //System.out.println();
        long sum  =  0;
        for(int i=0;i<N;i++){
            sum =  sum + a[i];
        }
        System.out.print(sum);
    }
}