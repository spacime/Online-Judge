import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        char[] num = in.next().toCharArray();
        boolean[] change = new boolean[n];

        for (int i = 0; i < n / 2; i++) {
            if (num[i] != num[n - 1 - i]) {
                num[i] = num[n - 1 - i] = (char) Math.max(num[i], num[n - 1 - i]);
                change[i] = true;
                k--;
            }
        }

        if (k < 0) {
            System.out.println("-1");
            return;
        }

        for (int i = 0; i < n / 2; i++) {
            if (num[i] != '9') {
                if (change[i] && k > 0) {
                    num[i] = num[n - 1 - i] = '9';
                    k--;
                }

                if (!change[i] && k > 1) {
                    num[i] = num[n - 1 - i] = '9';
                    k -= 2;
                }
            }
        }

        if (n % 2 == 1 && k > 0) {
            num[n / 2] = '9';
        }

        System.out.println(new String(num));
    }
}
