package src.com.jd.leetcode.textJ;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] sc = s.toCharArray();
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < sc.length; i++) {
            if (map.containsKey(sc[i])) {
                maxLen = Math.max(maxLen, i - start);
                start = Math.max(start, map.get(sc[i]) + 1);
            }
            map.put(sc[i], i);
        }
        maxLen = Math.max(maxLen, sc.length - start);
        return maxLen;
    }

}
