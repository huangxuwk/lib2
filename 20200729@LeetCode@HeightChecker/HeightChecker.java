package src.com.jd.leetcode.textG;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        int[] sign = new int[101];
        for (int h : heights) {
            sign[h]++;
        }
        int count = 0;
        int[] temp = new int[len];
        for (int i = 1, j = 0; i < 101 && j < len; i++) {
            while (sign[i] > 0) {
                temp[j++] = i;
                sign[i]--;
            }
        }
        for (int i = 0; i < len; i++) {
            if (temp[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

}
