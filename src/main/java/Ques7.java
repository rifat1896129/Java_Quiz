import java.util.LinkedHashSet;

public class Ques7 {
    public static void main(String[] args) {
        String myStr = "abcaabbcc";
        char[] chars = myStr.toCharArray();
        LinkedHashSet<Character> hashSet = new LinkedHashSet();

        for (char ch : chars) {
            hashSet.add(ch);
        }

        int count = 0;
        System.out.print("Unique Characters: ");


        for (char ch : hashSet) {
            System.out.print(ch);
            count++;
        }
        System.out.println();
        System.out.println("Total Unique Characters:" +count);
    }

}

