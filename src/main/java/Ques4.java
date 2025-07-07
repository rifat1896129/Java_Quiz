public class Ques4 {
    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 4, 5};
        int n = 5;

        int expectedSum = n * (n+1) / 2;
        int Sum = 0;

        for(int num:numbers){
            Sum += num;
        }
        int missingNum = expectedSum - Sum;
        System.out.println("the missing number is: "+missingNum);
    }
}
