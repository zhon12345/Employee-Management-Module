import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class manager_detail extends staff {

    private String managerName, managerID, managerword;

    Scanner c = new Scanner(System.in);

    Date date = new Date();
    String SID = "", SName = "";

    ArrayList<String> al = new ArrayList<String>();
    BufferedReader br = null;
    String line;

    public manager_detail() {
        super("", "", "", "", "", "", "", 0, 0, 0d, 0d);

    }

    public manager_detail(String username, String userID, String word) {
        super();
    }

    public String getmanagerName() {
        return managerName;
    }

    public String getmanagerID() {
        return managerID;
    }

    public String getManagerword() {
        return managerword;
    }

    public void setUserName(String managerName) {
        this.managerName = managerName;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public void setmanagerword(String managerword) {
        this.managerword = managerword;
    }
    // --------------------------------------------------

    public void value(String name, String ID) {
        ArrayList<String> al = new ArrayList<String>();
        Scanner c = new Scanner(System.in);
        BufferedReader br = null;
        String line;

        try {
            br = new BufferedReader(new FileReader("staffdetail.txt"));
            int count = 0;

            while ((line = br.readLine()) != null) {
                if (line.contains(ID)) {
                    this.managerword = "";
                    this.managerName = "Your Name : " + name;
                    this.managerID = "Your ID : " + ID;
                    SID = ID;
                    SName = name;
                    super.washRecord(ID);
                    count++;
                }

            }
            if (count == 0) {
                this.managerword = "New Employee Nice To Meet You";
                this.managerName = "";
                this.managerID = "";
                SID = ID;
                SID = name;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    // --------------------------------------------------

    public void CRUD() {
        int num = 0;
        do {

            System.out.println("\n" + this.managerword + "" + this.managerName + "\t  " + this.managerID);
            System.out.println("1.Add ");
            System.out.println("2.Modify ");
            System.out.println("3.Delete ");
            System.out.println("4.attend Record");
            System.out.println("5.Staff Module");
            System.out.print("Enter The Number You Want :");
            num = c.nextInt();

            switch (num) {
                case 1:
                    add(SName, SID);
                    break;
                case 2:
                    modify(SName, SID);
                    break;
                case 3:
                    delete(SName, SID);
                    break;
                case 4:
                    attendRecord(SName, SID);
                    break;
                case 5:
                    break;
            }

        } while (num != 5);
    }
    // --------------------------------------------------

    public void add(String name, String ID) {
        String function = "addstaff";

        String i = String.valueOf(date);
        new history().saving(name, ID, function, i);

        Scanner c = new Scanner(System.in);
        System.out.print("\nPersonal Detail#n");
        System.out.println("================");
        System.out.print("Enter The New Staff ID (Exxx/Mxxx) :");
        super.setID(c.nextLine());

        System.out.print("Enter The New Staff Name (must use underscore replace space) :");
        String a = c.nextLine();
        super.setName(a);

        System.out.print("Enter Your Password :");
        super.setPassword(c.nextLine());

        System.out.print("Enter The New Staff Address (must use underscore replace space) :");
        String b = c.nextLine();
        super.setAddress(b);

        System.out.print("Enter The New Staff Email (xxxx@gmail.com) :");
        super.setEmail(c.nextLine());

        System.out.print("Enter The New Staff Mobile Phone (0123xxxxxxx) :");
        super.setMphone(c.nextLine());

        System.out.print("Enter The New Staff Bank Account Name (must use underscore replace space) :");
        String d = c.nextLine();
        super.setBname(d);

        System.out.print("Enter The New Staff Identity Card (1234xxxxx) :");
        super.setIC(c.nextInt());

        System.out.print("Enter The New Staff Bank Account Number (456xxxxxx) :");
        super.setAccounubmer(c.nextInt());

        System.out.print("Enter The New Staff Salary (xxxx.x):");
        super.setSalary(c.nextDouble());

        System.out.print("Enter The New Staff Hour rate (xx.x):");
        super.setHsalary(c.nextDouble());

        try {
            FileWriter fw = new FileWriter("staffdetail.txt", true);
            fw.append(super.word());
            fw.append("\n");
            fw.close();
            System.out.println("----------------------------------");
            System.out.println("The product is added succesfully!!");
            System.out.println("----------------------------------");
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println(super.toString());
    }
    // --------------------------------------------------

    public void delete(String name, String ID) {
        String function = "deletestaff";

        String i = String.valueOf(date);
        new history().saving(name, ID, function, i);
        System.out.print("\nEnter The Staff ID That You Want To Delete (Exxx/Mxxx): ");
        String DID = c.next();

        System.out.println("");
        super.washRecord(DID);

        System.out.print("\nDo You Comfirm To Delete The Staff Record ? (Y/N) : ");
        String comfirm = c.next();
        char choose = comfirm.charAt(0);

        if (choose == 'Y' || choose == 'y') {
            try {
                br = new BufferedReader(new FileReader("staffdetail.txt"));
                while ((line = br.readLine()) != null) {
                    if (line.contains(DID)) {
                        System.out.println(
                                "----------------------------------------------------------------------------------------");
                        System.out.println("This record has been deleted!!\n");
                        System.out.println(line);
                        continue;
                    } else {
                        al.add(line);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // --------------------------------------------------
            try {
                FileWriter fw = new FileWriter("staffdetail.txt");
                for (int t = 0; t < al.size(); t++) {
                    fw.append(al.get(t));
                    fw.append("\n");
                }

                fw.close();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                System.out.println(
                        "----------------------------------------------------------------------------------------");
            }
        }
    }
    // -------------------------------------------------------------------------

    @Override
    public void attendRecord(String name, String ID) {
        String function = "attendRecord";

        String i = String.valueOf(date);
        new history().saving(name, ID, function, i);
        int num = 0;
        int totalworkTime = 0;
        double salary = 0d;
        System.out.println("\n----------------------------------------");
        try {

            BufferedReader br = new BufferedReader(new FileReader("attend.txt"));

            Scanner x = new Scanner(br);

            while (x.hasNext()) {
                String a = x.next();
                String b = x.next();
                int y = Integer.valueOf(b);

                String c = x.next();
                int s = Integer.valueOf(c);

                String d = x.next();
                int z = Integer.valueOf(d);

                String e = x.next();
                double q = Double.valueOf(e);

                String f = x.next();
                double r = Double.valueOf(f);
                if (a.equals(ID)) {
                    totalworkTime += z;
                    salary += (q + r);
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.printf("Staff Name : %s  (Staff ID : %s)\n", name, ID);
            System.out.println("This Is Your Total Working Hours : " + totalworkTime);
            System.out.println("This Is Your Total Salary : " + salary);
            System.out.println("----------------------------------------");
        }
    }

    @Override
    public void modify(String name, String ID) {
        String line;
        String function = "changingstaff";
        String i = String.valueOf(date);
        new history().saving(name, ID, function, i);
        System.out.print("\nEnter id number to modify your record (Exxx): ");
        String id = c.next();

        super.washRecord(id);
        System.out.println("You only can change your record as shown as above");

        try {
            br = new BufferedReader(new FileReader("staffdetail.txt"));

            while ((line = br.readLine()) != null) {

                if (line.contains(id)) {
                    String newValue = "";
                    System.out.println("Enter the old value that you want to change (Name/Phone Number/Bank Name) : ");
                    System.out.print("Such As (anson/1234567/Public Bank) : ");
                    String oldValue = c.next();

                    System.out.print("Do You Want To Change Your Old Record [" + oldValue + "] (Y/N): ");
                    String choice = c.next();
                    char com = choice.charAt(0);

                    if (com == 'Y' || com == 'y') {
                        System.out.println("If Some Value need to use space, it must use underscore replace space");
                        System.out.print("Enter the new value that can replace the old value [" + oldValue + "] : ");
                        newValue = c.next();
                        al.add(line.replace(oldValue, newValue));

                    } else if (com == 'N' || com == 'n') {
                        System.out.println("Your record has not been changed");
                    }

                } else {
                    al.add(line);

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            FileWriter fw = new FileWriter("staffdetail.txt");

            for (int l = 0; l < al.size(); l++) {
                fw.append(al.get(l));
                fw.append("\n");
            }
            fw.append("\n");
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("---------------------------------------");
            System.out.println("Your Are Successful Modify The Record!!");
            System.out.println("---------------------------------------");
        }

        super.washRecord(id);
        System.out.println("----------------------------------------");

    }
}
