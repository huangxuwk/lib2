package src.com.jd.leetcode.textH;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet();
        generate(set, "", n, n);
        // System.out.println(set.size());
        return new ArrayList<String>(set);
    }

    private void generate(Set<String> set, String s, int l, int r) {
        // System.out.println(s);
        if (l == 0 && r == 0) {
            set.add(s);
            return;
        }
        if (l <= 0) {
            String sr = s + ")";
            generate(set, sr, l, r - 1);
            return;
        }
        if (r <= 0) {
            String sl = s + "(";
            generate(set, sl, l - 1, r);
            return;
        }
        if (l >= r) {
            String sl = s + "(";
            generate(set, sl, l - 1, r);
        } else {
            String sl = s + "(";
            generate(set, sl, l - 1, r);
            String sr = s + ")";
            generate(set, sr, l, r - 1);
        }
    }

}
