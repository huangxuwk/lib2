package src.com.jd.leetcode.textJ;

public class MyAtoi {

    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        new StringBuilder().deleteCharAt()
        char[] cs = str.toCharArray();
        long num = 0;
        boolean sign = false;
        long si = 1;
        for (char c : cs) {
            if (!sign) {
                if (c == ' ') {
                    continue;
                } else if (c == '-') {
                    si *= -1;
                    sign = true;
                } else if (c == '+') {
                    sign = true;
                } else if (c >= '0' && c <= '9') {
                    num = c - '0';
                    sign = true;
                } else {
                    return 0;
                }
            } else {
                if (c >= '0' && c <= '9') {
                    num = num * 10 + c - '0';
                    if (num * si > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    if (num * si < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    break;
                }
            }
        }
        num *= si;
        return (int)num;
    }

}
