package src.com.jd.leetcode.textH;

public class FindMagicIndex {

    public int findMagicIndex(int[] nums) {
        for(int i=0;i<nums.length; ){
            if(nums[i]==i)
                return i;
            i=Math.max(nums[i],i+1);
        }
        return -1;
    }

}
