public class Ques13 {
    public static void main(String[] args) {
        int laptopPrice = 85000;
        int mousePrice = 2500;

        int totalPrice = laptopPrice + mousePrice;
        double discount = 0.15; // 15%

        double discountAmount = totalPrice * discount;
        double finalPrice = totalPrice - discountAmount;

        System.out.println("Total Price before discount: " + totalPrice + " Tk");
        System.out.println("Discount amount (15%): " + discountAmount + " Tk");
        System.out.println("Final Price after discount: " + finalPrice + " Tk");
    }
}
