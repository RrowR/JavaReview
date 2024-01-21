package com.study;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

/**
 * @author: Rrow
 * @date: 2024/1/21 23:36
 * Description: Hutool 的驼峰转下划线之间的转换
 */
public class Testhutool下划线转驼峰之间的互转 {

    @Test
    public void testCamel() {
        String str = "netCost";
        String underlineCase = StrUtil.toUnderlineCase(str);
        System.out.println("underlineCase = " + underlineCase);
    }

}
