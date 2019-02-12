import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private int inputCount;
    private int inputBarcode;

    Scanner input = new Scanner(System.in);

    //    FileReading fr;
    Buy b = new Buy();
    FactorPrint fp = new FactorPrint();


    /*public Menu() {
        fr = new FileReading();
//        b = new Buy();
    }*/

    public void showMenu() {

        System.out.print("\t\tMenu\n********************\nSelect an option:\n" + "1) Add Product\n" + "2) Show Factor\n" + "3) Show Store\n" + "4) exit\n>>");
        while (true) {
            int num = input.nextInt();
            switch (num) {
                case 1: {
                    System.out.println("*****Add Product*****");
                    System.out.print("input barCode >>");
                    inputBarcode = input.nextInt();

                    int i = new Buy().searchInProducts(inputBarcode);
                    if (i != -1) {

                        System.out.print("input count >>");
                        inputCount = input.nextInt();
                        b.buy(inputBarcode, inputCount, i);
                        break;
                    } else {
                        System.out.println("********************\nSorry...barcode Not found ): \n");
                        new Menu().showMenu();
                        break;
                    }
                }
                case 2:
                    System.out.println("*****Show factor*****");
                    String fileType;
                    int i;
                    while (true) {
                        System.out.print("\"pdf\" or \"txt\" >>");
                        fileType = input.next();
                        if (fileType.equals("pdf")) {
                            i = 1;      //go to pdf
                            break;
                        } else if (fileType.equals("txt")) {
                            i = 2;      //go to txt
                            break;
                        }else System.out.print("Wrong Enter again...");
                    }

                    if (i == 1) {
                        fp.pdfmaker();
                    } else if (i == 2) {
                        fp.factorPrint(Buy.buyArrayList);
                    }

                    break;
                case 3:
                    System.out.println("*****Show Store*****");
                    new FileReading().showAllProducts(new FileReading().storeArrayList);

                    break;
                case 4:
                    System.out.println("Are you sure? y / n");
                    String response = input.next();
                    if (response.equals("y")) {
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Enter again...");
                    break;

            }

        }
    }

}
