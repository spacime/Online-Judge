import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for(int i = 0; i < tests; i++) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            char[][] chs = new char[R][C];
            sc.nextLine();
            for(int j = 0; j < R; j++) {
                String s = sc.nextLine();
                chs[j] = s.toCharArray();
            }
            
            int r = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine();
            char[][] chs_find = new char[r][c];
            for(int j = 0; j < r; j++) {
                String s = sc.nextLine();
                chs_find[j] = s.toCharArray();
            }
            
            if(isFound(chs, chs_find)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            
            
        } 
    }
    
    private static boolean isFound(char[][] grid, char[][] pattern) {
        int R = grid.length;
        int C = grid[0].length;
        
        int r = pattern.length;
        int c = pattern[0].length;
        
        for(int i = 0; i + r <= R; i++) {
            for(int j = 0; j + c <= C; j++) {
                if(isequal(grid, pattern, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean isequal(char[][] grid, char[][] pattern, int i, int j) {
        for(int m = 0; m < pattern.length; m++) {
            for(int n = 0; n < pattern[0].length; n++) {
                if(pattern[m][n] != grid[i + m][j + n]) {
                    return false;
                }
            }
        }
        return true;
    }
}