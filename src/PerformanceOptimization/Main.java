package PerformanceOptimization;


public class Main {
    public static void main(String[] args) {
        LazyNumberDetails lazyNumberDetails = new LazyNumberDetails(13);
        lazyNumberDetails.updateNumber(11);
        lazyNumberDetails.updateNumber(18);
        System.out.println(lazyNumberDetails.isPrime());
        lazyNumberDetails.updateNumber(26);
        lazyNumberDetails.updateNumber(6);
        System.out.println(lazyNumberDetails.isPerfect());
        lazyNumberDetails.updateNumber(14);
        System.out.println(lazyNumberDetails.isMagic());
    }
}