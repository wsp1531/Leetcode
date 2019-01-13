package com.csii.leetcode;



/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class Leetcode_1 {
    public int[] twoSum(int[] nums, int target) {
        int res[]=new int[2];//这样定义java数组
        for (int i = 0; i <nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
