public class Ques10 {
    public static void main(String[] args) {
        String message = "s@atur!day";

        String cleaned = message.replaceAll("[^a-zA-Z0-9]", "");

        System.out.println("Cleaned string: " + cleaned);
    }
}
