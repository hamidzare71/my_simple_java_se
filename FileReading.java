import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class FileReading {

    ArrayList<Products> storeArrayList = new ArrayList<>();

    public FileReading() {
        fileReading();
    }

    public void fileReading() {
        try {
            FileReader fr = new FileReader("C:\\java\\prj\\Hyper2\\dbs.txt");
            BufferedReader br = new BufferedReader(fr);
            String data = "";
            while ((data = br.readLine()) != null) {

//                split a row of file barcode,category,name,price
                String[] str = data.split(",", 5);
//                add to storeArrayList
                storeArrayList.add(new Products(Integer.parseInt(str[0]), str[1], str[2], Double.parseDouble(str[3]))); //productsArrayList is initiate from Products
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAllProducts(ArrayList<Products> storeArrayList) {
        for (Products p : storeArrayList) {
            System.out.println("barcode: " + p.getBarcode() + "\t category: " + p.getCategory() + "\t name: " + p.getName() + "\t price: " + p.getPrice());
        }
        System.out.println();
        new Menu().showMenu();
    }
}
