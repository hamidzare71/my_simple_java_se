import com.itextpdf.text.DocumentException;

import java.io.File;
import java.io.IOException;

public class Runner {

    public static void main(String[] args) {
//        new Menu().showMenu();
        Menu menu = new Menu();
        menu.showMenu();

        /*File file = new File(DEST);
        file.getParentFile().mkdirs();
        new SimpleTable().createPdf(DEST);*/
    }
}
