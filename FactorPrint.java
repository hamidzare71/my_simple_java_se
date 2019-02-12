import com.bethecoder.ascii_table.ASCIITable;
import com.bethecoder.ascii_table.impl.CollectionASCIITableAware;
import com.bethecoder.ascii_table.spec.IASCIITableAware;
import com.itextpdf.text.DocumentException;

import java.io.File;
import java.io.IOException;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Scanner;

public class FactorPrint {
//    Buy b = new Buy();

    FileWriting fileWriting = new FileWriting();
    Scanner sc = new Scanner(System.in);

    public void factorPrint(ArrayList<Buy> factorList) {
        if (factorList.size() == 0) {
            System.out.println("factorPrint is empty");
            new Menu().showMenu();
        }
        String customerName;
        System.out.println("Enter customer name:");
        customerName = sc.next();

//        calculate total price
        long tPrice = 0;
        for (Buy fp : factorList) {
            tPrice = tPrice + (long) fp.getTotalprice();
        }

        IASCIITableAware iasciiTableAware = new CollectionASCIITableAware<Buy>(factorList, "barcode", "Category", "Name", "Count", "price", "totalprice");

//        printShow
        ASCIITable.getInstance().printTable(iasciiTableAware);

//        fileShow
        String tableStr = ASCIITable.getInstance().getTable(iasciiTableAware);

        tablemaker(tPrice);

        String absolutePath = fileWriting.createFile(customerName);
        fileWriting.fileWriter(absolutePath, customerName, tableStr, tPrice);

        new Menu().showMenu();
    }

    public void tablemaker(double tPrice) {
        String fstr = String.valueOf(tPrice);
        int len = fstr.length();

        System.out.print("+-------------------------------------------+------------+");
        System.out.print("\n| Total Price:");
        for (int i = 0; i < (39 - len); i++) {
            if (i == 30) System.out.print("|");
            System.out.print(" ");
        }
        System.out.print(tPrice + " $ |\n");
        System.out.println("+-------------------------------------------+------------+");

    }

    public static final String DEST = "C:\\java\\prj\\Hyper2\\Customer Factor.pdf";

    public void pdfmaker() {
        File file = new File(DEST);
        //file.getParentFile().mkdirs();
        try {
            new SimpleTable().createPdf(DEST);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
