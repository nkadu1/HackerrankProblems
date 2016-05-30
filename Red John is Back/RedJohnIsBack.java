import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc  = new Scanner(System.in);
        int T =  sc.nextInt();
        sc.nextLine();
        for(int i=0;i<T;i++){
            int N  =  sc.nextInt();
            Calculate(N);
            if(sc.hasNextLine())
                sc.nextLine();
        }
    }
    static void Calculate(int N){
        int inhand[] = new int[]{1,4};
        int a[][] = new int[inhand.length][N+1];
        for(int i=0;i<a[0].length;i++){
            a[0][i] = 1;
        }
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(j < inhand[i])
                    a[i][j] = a[i-1][j];
                else{
                    a[i][j] =  a[i][j-1]  + a[i][j-inhand[i]];
                }
            }
        }
        //System.out.println("here "  +  a[inhand.length-1][a[0].length-1]);
        closestPrime(a[inhand.length-1][a[0].length-1]);
    }
    static void closestPrime(int N){
        boolean flag = false;
        int count=0;
        for(int i=N;i>=2;i--){
             int sqrt = (int) Math.sqrt(i) + 1;
            for(int j=2;j<sqrt;j++){
                    if(i%j==0){
                       flag = true;
                       break;
                    }
            }
            if(!flag && i !=4){
            //    System.out.println(" i " + i);
                count++;
            }
            flag = false;
        }
        System.out.println(count);
    }
}