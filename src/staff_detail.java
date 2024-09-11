import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class staff_detail extends staff {

    private String staffName, staffID, staffword;

    Scanner c = new Scanner(System.in);

    Date date = new Date();
    String SID = "", SName = "";

    ArrayList<String> al = new ArrayList<String>();
    BufferedReader br = null;
    String line;

    public staff_detail() {
        super("", "", "", "", "", "", "", 0, 0, 0d, 0d);
    }

    public staff_detail(String username, String userID, String word) {
        super();
    }

    public String getStaffName() {
        return staffName;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getStaffword() {
        return staffword;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setStaffWord(String staffword) {
        this.staffword = staffword;
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
                    this.staffword = "";
                    this.staffName = "Your Name : " + name;
                    this.staffID = "Your ID : " + ID;
                    SID = ID;
                    SName = name;
                    super.washRecord(ID);
                    count++;
                }

            }
            if (count == 0) {
                this.staffword = "New Employee Nice To Meet You";
                this.staffName = "";
                this.staffID = "";
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

            System.out.println("\n" + this.staffword + "" + this.staffName + "\t  " + this.staffID);
            System.out.println("\n1.View Incidents Pass");
            System.out.println("2.Modify ");
            System.out.println("3.Attend Record ");
            System.out.println("4.Staff Module");
            System.out.print("Enter The Number You Want :");
            num = c.nextInt();

            switch (num) {
                case 1:
                    incidentPass(SName, SID);
                    break;
                case 2:
                    modify(SName, SID);
                    break;
                case 3:
                    attendRecord(SName, SID);
                    break;

            }

        } while (num != 4);
    }
    // --------------------------------------------------

    public void incidentPass(String name, String ID) {
        String function = "incidentPass";

        String i = String.valueOf(date);
        new history().saving(name, ID, function, i);
        try {
            BufferedReader br = new BufferedReader(new FileReader("incident.txt"));

            int count = 0;
            System.out.println("\n---------------------------------------------------------------------------");
            System.out.println("This Is The Record That Find Inside This File.\n");
            while ((line = br.readLine()) != null) {
                if (line.contains(ID)) {

                    System.out.println(line);

                    count++;
                }

            }
            System.out.println("--------------------------------------------------------------------------");
            if (count == 0) {
                System.out.println("----------------------------------------");
                System.out.println("You Not Have Any Record Inside The File.");
                System.out.println("----------------------------------------");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // --------------------------------------------------
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
            System.out.printf("Staff Name : %s  Staff ID : %s\n", name, ID);
            System.out.println("This Is Your Total Working Hours : " + totalworkTime);
            System.out.println("This Is Your Total Salary : " + salary);
            System.out.println("----------------------------------------");
        }
    }
    // -------------------------------------------------------------------------

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
                    System.out.print("Enter the value that you want to change (Quantity/Price/Product Name) : ");
                    String oldValue = c.next();
                    System.out.print("Do You Want To Change Your Record [" + oldValue + "] (Y/N): ");
                    String choice = c.next();
                    char com = choice.charAt(0);

                    if (com == 'Y' || com == 'y') {
                        System.out.println("If Some Value need to use space, it must use underscore replace space");
                        System.out.print("Enter the new value that can replace the old value [" + oldValue + "] : ");
                        newValue = c.next();
                        al.add(line.replace(oldValue, newValue));

                        System.out.println("---------------------------------------");
                        System.out.println("Your Are Successful Modify The Record!!");
                        System.out.println("---------------------------------------");

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

            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("----------------------------------------");
        super.washRecord(id);
        System.out.println("----------------------------------------");

    }

}
