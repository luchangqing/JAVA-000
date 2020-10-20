package com.luchangqing.question01;

public class MyHello {
    public static void main(String[] args) {

        int 变量_a = 10;
        int 变量_b = 20;
        int 变量_c = 0;

        // 1 加法操作
        变量_c = 变量_a + 变量_c;
        // 2 减法操作
        变量_c = 变量_b - 变量_a;
        // 3 乘法操作
        变量_c = 变量_a * 变量_b;
        // 4 除法操作
        变量_c = 变量_b / 变量_a;

        for (int i = 0; i < 变量_b; i++) {
            if (i == 变量_a) {
                System.out.println("Hello Java!");
            }
        }
    }
}
