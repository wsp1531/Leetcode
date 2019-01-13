package com.csii.leetcode;

public class Leetcode_9 {
    /**
     * equals的作用：用于判断两个变量是否是对同一个对象的引用，即堆中的内容是否相同，返回值为布尔类型
     *==的作用：判断引用是否指向堆内存的同一块地址。用于基本数据类型的比较
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        String str=String.valueOf(x);
       String  str1=new StringBuffer(str).reverse().toString();
       if(str.equals(str1))return true;//如果这里写str==str1  返回错误
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_9().isPalindrome(-121));
    }
}
