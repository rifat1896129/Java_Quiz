public class Ques12 {
        public static void main(String[] args) {
            String input = "2001";

            if (isBinary(input)) {
                System.out.println("✅ true");
            } else {
                System.out.println("❌ false");
            }
        }

        public static boolean isBinary(String str) {

            return str.matches("[01]+");
        }
    }

