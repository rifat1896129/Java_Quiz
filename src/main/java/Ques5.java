import java.util.HashMap;

public class Ques5 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        HashMap <Integer, Integer> hashMap = new HashMap();
        for(int num:numbers){
            hashMap.put(num,hashMap.getOrDefault(num, 0)+1);
        }

        System.out.println(hashMap);
    }
}
