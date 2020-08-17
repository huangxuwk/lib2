package src.com.jd.leetcode.test;

/**
 * 归并排序，仅次于快排
 * 时间复杂度 : O(nlogn)
 * 空间复杂度 : O(n)
 * 稳定排序
 */
public class MergeSort {
    //自顶向下的归并
    public void upToDownMergeSort(int[] array) {
        int len = array.length;
        if (len < 2) {
            return;
        }
        int[] temp = new int[len];
        sort(array, temp, 0, len - 1);
    }

    private void sort(int[] array, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        // 分割数组
        int mid = left + (right - left) / 2;
        sort(array, temp, left, mid);
        sort(array, temp, mid + 1, right);
        merge(array, temp, left, mid, right);
    }

    // 自底向上的归并排序
    public void downToUpMergeSort(int[] array) {
        int len = array.length;
        int[] temp = new int[len];
        // 从1个元素开始归并，每次翻倍
        for (int size = 1; size < len; size *= 2) {
            // 将数组分为多个子数组，依次归并这些小数组，步长为2*size
            for (int left = 0; left < len - size; left += 2 * size) {
                // 因为归并时包含mid和right，所以要减1，若数组长为奇数，那么可能会越界，所以要取小
                merge(array, temp, left, left + size - 1, Math.min(left + 2*size - 1, len - 1));
            }
        }
    }

    private void merge(int[] array, int[] temp, int left, int mid, int right) {
        // 合并排序
        int k = left;
        int idx1 = left;
        int idx2 = mid + 1;
        while (idx1 <= mid && idx2 <= right) {
            if (array[idx1] <= array[idx2]) {
                temp[k++] = array[idx1++];
            } else {
                temp[k++] = array[idx2++];
            }
        }
        while (idx1 <= mid) {
            temp[k++] = array[idx1++];
        }
        while (idx2 <= right) {
            temp[k++] = array[idx2++];
        }
        k = left;
        while (k <= right) {
            array[k] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 1, 5, 3, 4, 5, 7};
        new MergeSort().downToUpMergeSort(array);
        for (int n : array) {
            System.out.println(n);
        }
    }
}
