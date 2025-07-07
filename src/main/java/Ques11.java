public class Ques11 {
    public static void main(String[] args) {
        String myStr = "I am a SQA Engineer";

        String msg = myStr.replaceAll("[aeiouAEIOU]", "");

        System.out.println("After Removing Vowels: " + msg);
    }
}
