package com.demo.BigDecimal;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class format {
    static double f = 111231.5585;
    public static void m1() {
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }
    /**
     * DecimalFormat转换最简便
     */
    public static void m2() {
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(f));
    }
    /**
     * String.format打印最简便
     */
    public static void m3() {
        System.out.println(String.format("%.2f", f));
    }
    public static void m4() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(f));
    }
    public static void main(String[] args) {
        format.m1();
        format.m2();
        format.m3();
        format.m4();
    }
}
