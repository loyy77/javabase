package org.loyy.arithmetic.recursion;

class Fib {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    public static int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }
}
