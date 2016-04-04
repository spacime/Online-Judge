import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        for(int i = 0; i < len; i++) {
            int lenArr = sc.nextInt();
            int[] arr = new int[lenArr];
            for(int j = 0; j < lenArr; j++) {
                arr[j] = sc.nextInt();
            }
            //System.out.print(Arrays.toString(arr));
            boolean isSorted = isSortedByRotate(arr);
            if(isSorted) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isSortedByRotate(int[] arr) {
        int countR = 0;
        for (int i = 0; i + 1 < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    countR++;
                }
            }
        }

        return (countR & 1) != 1;
    }
}
