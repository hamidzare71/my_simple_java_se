import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;


public class FileWriting {
    Scanner sc = new Scanner(System.in);

    //    public void createFile() {
    public String createFile(String customerName) {
        System.out.print("Enter file name to create: ");
        String fileName = customerName + ".txt";
        File f = new File("C:\\java\\prj\\Hyper2", fileName);
        String absolutePath = f.getAbsolutePath();
        System.out.println("absoluteAddress: " + absolutePath);

        try {
            if (!f.exists()) {
                f.createNewFile();
                System.out.println("created");

            } else {
                f.setWritable(true);

                System.out.println("File already created");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return absolutePath;
    }

    public void fileWriter(String absolutePath, String customerName, String tableStr, long tPrice) {

        Calendar calendar = Calendar.getInstance();
        try {
            FileWriter fw = new FileWriter(absolutePath, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Date " + calendar.getTime() + "\n" + "Customer name:\t" + customerName + "\n" + tableStr + "\nTotal price: " + tPrice + " $");
            bw.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
