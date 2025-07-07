public class Ques15 {
    public static void main(String[] args) {
        for (int x = 0; x <= 15; x++) { // x = number of 5-mark questions
            int y = 15 - x; // y = number of 10-mark questions

            if (5 * x + 10 * y == 100) {
                System.out.println("5-mark questions: " + x);
                System.out.println("10-mark questions: " + y);
                break;
            }
        }
    }
}
