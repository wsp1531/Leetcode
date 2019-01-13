package com.csii.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_259 {
    public List<List<Integer>> threeSum_best(int[] nums,int target){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (nums[i] > 0) break;//nums[i]是最小的，如果nums[i]>0肯定是要退出循环的
            if (i > 0 && nums[i] == nums[i - 1])
                continue;//为了保证不加入重复的 list,因为是有序的，所以如果和前一个元素相同，只需要继续后移就可以
            while (left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if (sum<target) {
                    result.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));//找到这样的三元组
                    while (left < right && nums[left] == nums[left + 1])
                        left++; // 去掉重复的左点
                    while (left < right && nums[right] == nums[right - 1])
                        right--; // 去掉重复的右点
                    right--; // 进入下一组左右点判断
                } else {
                    left++; // 同理，需要变大，移动左指针
                }

            }


        }



        return  result;
    }

    public static void main(String[] args) {
        int nums[]=new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(new Leetcode_259().threeSum_best(nums,2));
    }
}
