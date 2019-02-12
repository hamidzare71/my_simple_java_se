import java.util.ArrayList;

import com.bethecoder.ascii_table.ASCIITable;
import com.bethecoder.ascii_table.impl.CollectionASCIITableAware;
import com.bethecoder.ascii_table.spec.IASCIITableAware;

public class Buy {
    private int barcode;
    private String category;
    private String name;
    private int count;
    private double price;
    private double totalprice;

//    private String rawInfo;

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public Buy() {
    }

    public Buy(int barcode, String category, String name, int count, /*double totalPrice,*/ double price) {
        this.barcode = barcode;
        this.category = category;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalprice = price * count;

    }

    FileReading fr = new FileReading();

    public static ArrayList<Buy> buyArrayList = new ArrayList<>();


//    Buy b;

    public void buy(int inputBarcode, int inputCount, int i) {


//        int i = searchInProducts(inputBarcode); //index of food
        setBarcode(fr.storeArrayList.get(i).getBarcode());
        setCategory(fr.storeArrayList.get(i).getCategory());
        setName(fr.storeArrayList.get(i).getName());
        setCount(inputCount);
//        setResult();
        setPrice(fr.storeArrayList.get(i).getPrice());

        buyArrayList.add(new Buy(this.barcode, this.category, this.name, this.count, this.price));
        /*b = new Buy();
        b.setBarcode(fr.storeArrayList.get(i).getBarcode());
        b.setCategory(fr.storeArrayList.get(i).getCategory());
        b.setName(fr.storeArrayList.get(i).getName());
        b.setPrice(fr.storeArrayList.get(i).getPrice());
        result = (int) (inputCount * fr.storeArrayList.get(i).getPrice());
        b.setCount(inputCount);
        b.setTotalPrice(200);

        buyArrayList.add(b);*/

//        new FactorPrint().factorPrint(Buy.buyArrayList);
        new Menu().showMenu();


//        splittingRawInfo(i, inputCount);        //this method get (index ,count) --> additionalArrList<> add(expDte,type,totalPrice)

    }


    //    search index of barcode in storeArrayList<>
    public int searchInProducts(int inputBarcode) {
        int ret = -1;
        int i = 0;

        while (i != fr.storeArrayList.size()) {
            int tmpBarcode = fr.storeArrayList.get(i).getBarcode();
            if (tmpBarcode == inputBarcode) {
                return i;
            }
            i++;
        }
        return ret;
    }
}
