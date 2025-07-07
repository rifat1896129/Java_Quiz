import java.util.LinkedHashSet;

public class Ques3 {
    public static void main(String[] args) {
        int[] numbers = {11, 7, 7, 11, 2, 15, 6, 6};
        LinkedHashSet <Integer> hashSet = new LinkedHashSet();
        for(int num:numbers){
            hashSet.add(num);
        }
        System.out.println("The Unique value are: "+ hashSet);

        int sum = 0;
        for(int num:hashSet){
            sum += num;
        }
        System.out.println("Sum of the Unique Value "+ sum);
    }
}
