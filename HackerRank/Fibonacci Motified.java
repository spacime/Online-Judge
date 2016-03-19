import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int len = sc.nextInt();
        BigInteger nthElement = nthFabo(num1, num2, len);
        System.out.println(nthElement);
    }

    private static BigInteger nthFabo(int num1, int num2, int len) {
        BigInteger[] dp = new BigInteger[len];
        for(int i = 0; i < len; i++) {
            dp[i] = BigInteger.valueOf(0);
        }
        dp[0] = BigInteger.valueOf(num1);
        dp[1] = BigInteger.valueOf(num2);

        for(int i = 2; i < len; i++) {
            dp[i] = dp[i - 1].multiply(dp[i - 1]).add(dp[i - 2]);
        }

        return dp[len - 1];
    }
}
