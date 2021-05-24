import java.io.*;
import java.util.Scanner;

public class StudentData {

    public static void main(String[] args) {
        StudentData st = new StudentData();
        st.insert();
        st.display();
    }
    public void display(){
            try{
            BufferedReader br = new BufferedReader(new FileReader("File.txt"));
            String s= "";
            while((s=br.readLine())!=null){
                String data[]=new String[3];
                data=s.split(",");
                for(int i=0;i<3;i++){
                    System.out.print(data[i]+" ");
                }
                System.out.println();
            }
    }
            catch(Exception e){

            }}
    public void insert(){
        Student st = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Roll: ");
        String roll = sc.nextLine();
        st.setRoll(roll);
        System.out.println("Enter student's name: ");
        String name = sc.nextLine();
        st.setName(name);
        System.out.println("Enter dept: ");
        String dept = sc.nextLine();
        st.setDept(dept);
        //System.out.println(st.getDept());
        System.out.println("Student Info: ");
        //System.out.println(f.getAbsolutePath());
        try{
            File f = new File("File.txt");
            PrintWriter write = new PrintWriter(new FileOutputStream(f, true));
            write.append(st.getRoll()+ ","+st.getName()+","+st.getDept()+"\n");
            write.close();


        }catch(IOException e){
            System.out.println("An error occured");
        }

    }
}