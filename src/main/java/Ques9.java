import java.util.Random;

public class Ques9 {
    public static void main(String[] args) {
        String Password = generateRandomPassword();
        System.out.println(Password);

    }

    public static String generateRandomPassword(){
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&";
        char[] chars = letters.toCharArray();
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<8; i++){
            int randomIndex = random.nextInt(chars.length);
            sb.append(letters.charAt(randomIndex));
        }
        return sb.toString();
    }
}
