
    import java.io.*;
import java.util.*;
   public class UpdateInfo
    {
        public static void main(String ar[])
        {
            UpdateInfo uf=new UpdateInfo();
            uf.update();
            StudentData st = new StudentData();
            st.display();
        }
        public void update()
        {
            /////////phase 1
            System.out.println("Enter the roll no that you want to update.....");
            Scanner sc=new Scanner(System.in);
            int  roll_to_change=sc.nextInt();
            String to_change_column_names[]={"Name:","Dept:"};
            int yes_no[]=new int[2];
            String to_update[]=new String[2];

            System.out.println("Select the columns that you want to update (0: No/1: Yes)");
            for(int i=0;i<2;i++)
            {
                System.out.println(to_change_column_names[i]+"");
                int temp=sc.nextInt();
                yes_no[i]=temp;
            }

            ////////////////phase2
            System.out.println("_______________________________________________________");
            System.out.println("Add new values to the columns");
            for(int i=0;i<2;i++)
            {
                System.out.println(to_change_column_names[i]+"");
                if(yes_no[i]==1)
                {
                    Scanner sc1=new Scanner(System.in);
                    String temp_val=sc1.nextLine();
                    to_update[i]=temp_val;
                    System.out.println();
                }
                else
                {
                    System.out.println("Cannot be changed");
                }
            }

            //////////////////phase 3
            StringBuffer sb=new StringBuffer();
            try
            {
                BufferedReader br=new BufferedReader(new FileReader("File.txt"));
                String s="";
                while((s=br.readLine())!=null)
                {
                    String data[]=new String[3];
                    data=s.split(",");
                    if(roll_to_change==Integer.parseInt(data[0]))
                    {
                        String row=data[0]+",";
                        for(int i=0;i<2;i++)
                        {
                            if(yes_no[i]==1)
                            {
                                row=row+to_update[i];
                                if(i==0)row=row+",";
                            }
                            else
                            {
                                row=row+data[i+1];
                                if(i==0)row=row+",";
                            }

                        }
                        sb.append(row);
                        sb.append("\n");
                    }
                    else
                    {
                        sb.append(s);
                        sb.append("\n");
                    }
                }
                //System.out.println(sb.toString());

                ////////////////// phase 4
                File f=new File("File.txt");
                PrintWriter pw=new PrintWriter(new FileOutputStream(f,false));
                pw.print(sb.toString());
                pw.close();
            }
            catch(Exception e)
            {

            }
        }


        }


