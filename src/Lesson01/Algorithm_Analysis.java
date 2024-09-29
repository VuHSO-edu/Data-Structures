package Lesson01;


import java.util.Arrays;

public class Algorithm_Analysis {
    public int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        Arrays.sort(nums);
        boolean[] check = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++){
            check[i] = true;
        }

        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i + 1]){
                check[i] = false;
                check[i + 1] = false;
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (check[i] == true)
                return nums[i];
        }
        return 0;
    }
}
