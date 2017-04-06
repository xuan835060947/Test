package com.xuan.gsonapt.testapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by chenxiaoxuan1 on 17/3/20.
 */

public class LeetCode12 {

    @Test
    public void test() {
        Assert.assertEquals("IV", intToRoman(4));
        Assert.assertEquals("VIII", intToRoman(8));
        Assert.assertEquals("IX", intToRoman(9));
        Assert.assertEquals("X", intToRoman(10));
        Assert.assertEquals("XIX", intToRoman(19));
        Assert.assertEquals("XX", intToRoman(20));
        Assert.assertEquals("XCIX", intToRoman(99));
    }

    /**
     * http://www.cnblogs.com/springfor/p/3886459.html
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        String str = "";
        String [] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int [] value = {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};
        for(int i=0;num!=0;i++){
            while(num >= value[i]){
                num -= value[i];
                str += symbol[i];
            }
        }
        return str;
    }
}
