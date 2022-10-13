import java.util.Scanner;
import java.text.DecimalFormat;

public class App {
    private int selectedItem = 0;
    private int selectedDiscount = 0;
    private int totalBill = 0;
    private int[] priceList = { 34490, 44990, 52490 };
    private double[] discountList = { 0, 0.1, 0.2, 0.3 };
    private String displayOptions = 
        "\n1) iPhone 11 - 34,490" + 
        "\n2) iPhone 12 - 44,990" +
        "\n3) iPhone 13 - 52,490\n" +
        "\n1) DSC00 - 0%" +
        "\n2) DSC01 - 10%" +
        "\n3) DSC02 - 20%" +
        "\n4) DSC03 - 30%\n";
    
    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.displayOptions);
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter item [1-3]: ");
            app.selectedItem = in.nextInt();

            System.out.print("Enter discount code: ");
            app.selectedDiscount = in.nextInt();

            app.setTotalBill(app.selectedItem, app.selectedDiscount);
            System.out.print("Your total bill is: " + app.getTotalBill());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void setTotalBill(int selectedItem, int selectedDiscount) {
        this.totalBill = priceList[selectedItem-1] - (int) (priceList[selectedItem-1] * discountList[selectedDiscount-1]);
    }

    private String getTotalBill() {
        DecimalFormat moneyFormat = new DecimalFormat("##,###");
        return "₱" + moneyFormat.format(this.totalBill);
    }
}