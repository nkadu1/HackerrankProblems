import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M  = sc.nextInt();
        int coins[]  = new int[M];
        sc.nextLine();
        for(int i=0;i<M;i++){
            coins[i] =  sc.nextInt();
        }
        Arrays.sort(coins);
        //int amount[] =  new int[N+1];
        long res[][] =  new long[M][N+1];
        for(int i=0;i<=N;i++){
            if(i%coins[0] == 0)
                res[0][i] = 1;
            else 
                res[0][i] = 0;
        }
        for(int i=0;i<M;i++){
                res[i][0] = 1;
        }
        
        for(int i=1;i<M;i++){
            for(int j=0;j<=N;j++){
                if(j < coins[i])
                    res[i][j] = res[i-1][j];
                else{
                    res[i][j] =  res[i-1][j] + res[i][j- coins[i]];
                }
            }
        }
        System.out.print(res[M-1][N]);
    }
}