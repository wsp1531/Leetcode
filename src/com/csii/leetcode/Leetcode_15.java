package com.csii.leetcode;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 */
public class Leetcode_15 {
    /**
     * 暴力解决,最后一个测试用例无法通过[0,0,0,0,0,0,0,0,0,0...]
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer>tmp;
        Arrays.sort(nums);
        Set<List<Integer>> res=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length; j++) {
                for (int k = j+1; k <nums.length ; k++) {
                    if(nums[i]+nums[j]+nums[k]==0&&!(i==j&&i==k)){
                        tmp=new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        res.add(tmp);//set无法插入重复元素
                    }
                }
            }
        }


        return new ArrayList<>(res) ;//将hashset转成arraylist
    }

    /**
     * 双指针
     * 必须先对数组进行排序(不排序的话，就不能利用双指针的思想了，所以说对数组进行排序是个大前提)，
     * 每次固定i的位置，并利用两个指针j和k，分别指向数组的i+1位置和数组的尾元素，
     * 通过判断num[j]+num[k]与-num[i]的大小，来决定如何移动指针j和k
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_best(int[] nums){
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
                if (sum == 0) {
                    result.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));//找到这样的三元组
                    while (left < right && nums[left] == nums[left + 1])
                        left++; // 去掉重复的左点
                    while (left < right && nums[right] == nums[right - 1])
                        right--; // 去掉重复的右点
                    right--; // 进入下一组左右点判断
                    left++;//必须保证left>i
                } else if (sum > 0) {
                    right--; // sum>0 ,说明和过大了，需要变小，所以移动右边指针
                } else {
                    left++; // 同理，需要变大，移动左指针
                }

            }


        }



        return  result;
    }
    public static void main(String[] args) {
        int nums[]=new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(new Leetcode_15().threeSum_best(nums));
        /*
        List<Integer>tmp1=new ArrayList<>();
        tmp1.add(1);
        tmp1.add(2);
        tmp1.add(3);
        Collections.sort(tmp1);
        List<Integer>tmp2=new ArrayList<>();
        tmp1.add(3);
        tmp1.add(2);
        tmp1.add(1);
        Collections.sort(tmp2);
        System.out.println(tmp1==tmp2);
        结果是false
        */
    }
}
