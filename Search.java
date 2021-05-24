import java.io.*;
import java.util.Scanner;

public class Search {

    public static void main(String[] args) {

        try {

            System.out.println("Enter the Dept name for searching: ");
            Scanner sca = new Scanner(System.in);
            String dept=sca.nextLine();

            FileReader fr = new FileReader("File.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fc = new FileWriter("Search.txt", false);
            fc.close();
            FileWriter fw = new FileWriter("Search.txt", true);
            String s;
            while ((s = br.readLine()) != null) { // read a line
               String data[]=new String[3];
                data=s.split(",");
                //System.out.println(data[2]);
                if(dept.equals(data[2])){
                fw.write(s);// write to output file
                //fw.flush();
                fw.write("\n");
            }
            }
            br.close();
            fw.close();
            System.out.println("file copied");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
