import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.print.DocFlavor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class SimpleTable {

    Scanner sc = new Scanner(System.in);


    /*public static final String DEST = "C:\\java\\prj\\Hyper2\\myFile.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new SimpleTable().createPdf(DEST);
    }*/

    public void createPdf(String dest) throws IOException, DocumentException {

        String customerName;
        System.out.println("Enter customer name:");
        customerName = sc.next();

        Calendar calendar = Calendar.getInstance();


        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(6);

        String[] header = {"Barcode", "Category", "Name", "Count", "Price", "TotalPrice"};

        int factorSize = Buy.buyArrayList.size();

//        header
        for (int i = 0; i < header.length; i++) {
            table.addCell(header[i]);
        }

//        data
//        for (int j = 0; j < factorSize; j++)
        for (Buy i : Buy.buyArrayList) {
            table.addCell(String.valueOf(i.getBarcode()));
            table.addCell(i.getCategory());
            table.addCell(i.getName());
            table.addCell(String.valueOf(i.getCount()));
            table.addCell(String.valueOf(i.getPrice()));
            table.addCell(String.valueOf(i.getTotalprice()) + " $");
        }


        /*for (int i = 0; i < data.length; i++) {
            for (String s : data[i]) {
                table.addCell(s);
            }
        }*/

        document.add(new Paragraph("Customer name: " + customerName + "\n Date: " + calendar.getTime()));
        document.add(new Paragraph("\n")); //separate table and first line
        document.add(table);

        long tPrice = 0;
        for (Buy fp : Buy.buyArrayList) {
            tPrice = tPrice + (long) fp.getTotalprice();
        }

        document.add(new Paragraph("total price: " + tPrice + " $"));


        System.out.println("\n**********************************************************\nPDF Created in " + dest + "\n**********************************************************\n" + "Customer name: " + customerName);

        document.close();
        new Menu().showMenu();
    }
}