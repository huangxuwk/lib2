package src.com.jd.leetcode.textH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    private static Map<Character, String> map;
    static {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> list = new ArrayList<>();
        if (len == 0) {
            return list;
        }
        char[] sc = digits.toCharArray();
        combinations(list, sc, new StringBuilder(), len, 0);
        return list;
    }

    private void combinations(List<String> list, char[] sc, StringBuilder sb, int len,int index) {
        if (index == len) {
            list.add(sb.toString());
            return;
        }
        char[] vc = map.get(sc[index]).toCharArray();
        for (char c : vc) {
            StringBuilder s = new StringBuilder(sb.toString());
            s.append(c);
            combinations(list, sc, s, len, index + 1);
        }
    }
}
