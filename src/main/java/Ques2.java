public class Ques2 {
    public static void main(String[] args) {
        int[] numbers = {11, 7, 2, 15, 6};
        int sum = 0;
        for(int num:numbers){
            if (isPrime(num)){
                sum += num;
            }
        }
        System.out.println("Sum of the prime number is "+ sum);
    }
    public static boolean isPrime(int n){
        for (int i = 2; i < n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
