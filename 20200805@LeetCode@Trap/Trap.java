package src.com.jd.leetcode.textI;

public class Trap {

    public int trap(int[] height) {
        int len = height.length;
        if (len == 0) {
            return 0;
        }
        int sum = 0;
        int lMax = -1;
        int lIdx = -1;
        int rMax = -1;
        int rIdx = len;
        for (int i = 0; i < len; i++) {
            if (height[i] > lMax) {
                lMax = height[i];
                lIdx = i;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (height[i] > rMax) {
                rMax = height[i];
                rIdx = i;
            }
        }
        // 算出最大值中间的体积
        if (rIdx != lIdx) {
            sum += (rIdx - lIdx - 1) * lMax;
            for (int i = lIdx + 1; i < rIdx; i++) {
                sum -= height[i];
            }
        }
        // System.out.println(sum);
        // 算出最大值左边的体积
        int pre = height[0];
        int preI = 0;
        for (int i = 1; i <= lIdx; i++) {
            if (height[i] >= pre) {
                sum += (i - preI - 1) * pre;
                // System.out.println(sum + " " + preI + " " + pre + " " + i);
                for (int j = preI + 1; j < i; j++) {
                    sum -= height[j];
                }
                pre = height[i];
                preI = i;
            }
        }
        // System.out.println(sum);
        // 算出最大值右边的体积
        int last = height[len - 1];
        int lastI = len - 1;
        for (int i = len - 2; i >= rIdx; i--) {
            if (height[i] >= last) {
                sum += (lastI - i - 1) * last;
                // System.out.println(sum + " " + lastI + " " + last + " " + i);
                for (int j = i + 1; j < lastI; j++) {
                    sum -= height[j];
                }
                last = height[i];
                lastI = i;
            }
        }
        return sum;
    }

}
