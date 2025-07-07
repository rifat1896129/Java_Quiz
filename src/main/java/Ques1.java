import java.util.Arrays;

public class Ques1 {
    public static void main(String[] args) {
       int[] numbers = {11, 7, 2, 15, 6};

        Arrays.sort(numbers);

        int max = numbers[numbers.length-1];
        int secondMax = numbers[numbers.length - 2];

        int diference = max - secondMax;

        System.out.println("The Maximum value is: "+max);
        System.out.println("The Second maximum value is: "+ secondMax);
        System.out.println("Difference is: "+diference);
    }
}