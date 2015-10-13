import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        BigInteger[] f = new BigInteger[2];
        f[0] = BigInteger.valueOf(A);
        f[1] = BigInteger.valueOf(B);
        for(int i = 2; i < N; i++){
            BigInteger mul = BigInteger.valueOf(1);
        	mul = mul.multiply(f[(i+1)%2]);
        	mul = mul.multiply(f[(i+1)%2]);
        	f[i%2] = f[i%2].add(mul);
        }
        System.out.print(f[(N-1)%2]);
    }
}
