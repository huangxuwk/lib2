package src.com.jd.leetcode.test;

public class QuickSelect {
    private int index;

    public int quickSelect(int array[], int k) {
        quick(array, 0, array.length - 1, k);
        return index;
    }

    private void quick(int array[], int left, int right, int k) {
        if (left >= right) {
            this.index = left;
            return;
        }
        int mid = left + (right - left) / 2;
        int tar = array[mid];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && array[j] < tar) {
                j--;
            }
            if (i < j) {
                array[i++] = array[j];
            }
            while (i < j && array[i] > tar) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[mid] = tar;
        System.out.println("mid: " + mid);
        if (mid == k - 1) {
            this.index = mid;
        } else if (mid > k - 1) {
            quick(array, left, mid - 1, k);
        } else {
            quick(array, mid + 1, right, k);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {4, 2, 3, 1, 5, 7};
        int index = new QuickSelect().quickSelect(array, 2);
        System.out.println(index);
        for (int i = 0; i <= index; i++) {
            System.out.println(array[i]);
        }
    }

}
