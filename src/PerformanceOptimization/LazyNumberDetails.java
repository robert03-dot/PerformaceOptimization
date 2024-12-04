package PerformanceOptimization;

public class LazyNumberDetails {
    private int number;
    private boolean firstOutputIsPrime; //stocarea rezultatului initial
    private boolean firstOutputIsPerfect; //pentru stocarea rezultatului initial
    private boolean firstOutputIsMagic; //pentru stocarea rezultatului initial
    private boolean hasResultIsPrime,hasResultIsPerfect,hasResultIsMagic; //rezultatul a fost deja calculat

    public LazyNumberDetails(int number) {
        this.number = number;
    }

    public void updateNumber(int number) {
        if (this.number != number) {
            this.number = number;
            hasResultIsPrime = false;
            hasResultIsPerfect = false;
            hasResultIsMagic = false;
        }
    }
    public boolean isPrime(){
        updateNumber(number);
        if(hasResultIsPrime){
            System.out.println("===cached===");
            return firstOutputIsPrime;
        } else{
            hasResultIsPrime = true;
            System.out.println(" !!! se calculeaza !!!");
            return isPrimeAlgorithm(number);
        }
    }
    public boolean isPrimeAlgorithm(int number) {
            firstOutputIsPrime = true;
            if (number < 2) {
                firstOutputIsPrime = false;
                return false;
            }
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
//                System.out.println(number + " nu este numar prim");
                    firstOutputIsPrime = false;
                    return false;
            }
        }
        System.out.println(this.number + " is prime number!");
        return firstOutputIsPrime;
    }
    public boolean isPerfect(){
        updateNumber(number);
        if(hasResultIsPerfect){
            System.out.println("===cached===");
            return firstOutputIsPerfect;
        } else{
            hasResultIsPerfect = true;
            System.out.println(" !!! se calculeaza !!!");
            return isPerfectAlgorithm(number);
        }
    }
    public boolean isPerfectAlgorithm(int number) {
        int sum=0;
        firstOutputIsPerfect = true;
        if(number<2){
            firstOutputIsPerfect = false;
            return false;
        }
        for(int i=1;i<number;i++){
            if(number%i==0){
                sum+=i;
                if(sum==number){
                    return true;
                }
            }
        }
        return firstOutputIsPerfect;
    }
    private static int digitSum(int number){
        int sum=0;
        while (number>0){
            sum+=number%10;
            number/=10;
        }
        return sum;
    }
    private static int reduceNumber(int number){
        while (number>9){
            number = digitSum(number);
        }
        return number;
    }
    public boolean isMagic(){
        updateNumber(number);
        if(hasResultIsMagic){
            System.out.println("===cached===");
            return firstOutputIsMagic;
        } else{
            hasResultIsMagic = true;
            System.out.println(" !!! se calculeaza !!!");
            return isMagicAlgorithm(number);
        }
    }
    public boolean isMagicAlgorithm(int number) {
        if(this.number!=number){
            int reducedNumber = reduceNumber(number);
            firstOutputIsMagic = (reducedNumber == 3 || reducedNumber == 7 || reducedNumber == 9);
            return firstOutputIsMagic;
        }else{
            return firstOutputIsMagic;
        }
    }
}