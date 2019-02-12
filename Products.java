public class Products {
    private int barcode;
    private String name;
    private String category;
    private double price;
//    private String rawInfo;       //reserved for future use

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public String getRawInfo() {
//        return rawInfo;
//    }

//    public void setRawInfo(String rawInfo) {
//        this.rawInfo = rawInfo;
//    }

    public Products(int barcode, String name, String category, double price/*, String rawInfo*/) {
        this.barcode = barcode;
        this.name = name;
        this.category = category;
        this.price = price;
//        this.rawInfo = rawInfo;   //reserved for future use
    }
}
