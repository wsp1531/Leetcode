package com.csii.leetcode;

public class Leetcode_7 {
    public int reverse(int x) {
        long  t=0;//java中的long类型等价于c++中的long long
        if(x==-2147483648)return 0;
        boolean bl=true;
        if(x<0)bl=false;
        x=Math.abs(x);//取绝对值
        String str=String.valueOf(x);
        str=new StringBuffer(str).reverse().toString();
        t=Long.valueOf(str);
        if(t>Integer.MAX_VALUE||t<Integer.MIN_VALUE)//获取int的最大值和最小值
            return 0;
        if(!bl) t=-t;
        return (int)t;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_7().reverse_best(-123467899));
    }

    /**
     * 最优算法
     * @param x
     * @return
     */
    public int reverse_best(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
