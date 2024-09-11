import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class staff {

    private String name, ID, address, email, Mphone, Bname, password;
    private int IC, Accounumber;
    private double Hsalary, salary;

    public staff(String name, String ID, String address, String email, String Mphone, String Bname, String password,
            int IC, int Accounumber, double Hsalary, double salary) {
        this.name = name;
        this.ID = ID;
        this.address = address;
        this.email = email;
        this.Mphone = Mphone;
        this.Bname = Bname;
        this.password = password;
        this.IC = IC;
        this.Accounumber = Accounumber;
        this.Hsalary = Hsalary;
        this.salary = salary;
    }

    public abstract void modify(String name, String ID);

    public abstract void attendRecord(String name, String ID);

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMphone() {
        return Mphone;
    }

    public String getBname() {
        return Bname;
    }

    public int getIC() {
        return IC;
    }

    public int getAccounubmer() {
        return Accounumber;
    }

    public double getHsalary() {
        return Hsalary;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMphone(String Mphone) {
        this.Mphone = Mphone;
    }

    public void setBname(String Bname) {
        this.Bname = Bname;
    }

    public void setIC(int IC) {
        this.IC = IC;
    }

    public void setAccounubmer(int Accounumber) {
        this.Accounumber = Accounumber;
    }

    public void setHsalary(double Hsalary) {
        this.Hsalary = Hsalary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public staff() {

        menu();
    }

    public void menu() {
        String CID = "", CPassword = "";
        Scanner x;

        int count = 0, number = 1, num1 = 0;
        do {
            Scanner S = new Scanner(System.in);
            System.out.println("\n====Welcome come to employee module====");

            System.out.print("Enter You Name : ");
            String Name = S.nextLine();

            if (Name.equalsIgnoreCase("N")) {
                break;
            }

            System.out.print("Enter You Staff ID : ");
            String Id = S.nextLine();

            System.out.print("Enter You Password : ");
            String Password = S.nextLine();

            if ("M005".equalsIgnoreCase(Id) && "jki011".equalsIgnoreCase(Password)) {
                number++;
            }
            int num = 1;
            if (number == 1) {
                try {
                    x = new Scanner(new File("staffdetail.txt"));
                    while (x.hasNext()) {
                        CID = x.next();
                        String name = x.next();
                        CPassword = x.next();

                        String a = x.nextLine();

                        if (Id.equals(CID) && Password.equals(CPassword) && (!"M005".equalsIgnoreCase(CID))) {

                            do {
                                System.out.println("\n==============================");
                                System.out.println("\nWelcome To The Staff Page : ");
                                System.out.println("1. Staff Detail");
                                System.out.println("2. Record Working Time");
                                System.out.println("3. Report Incidents");
                                System.out.println("4. Main Page");
                                System.out.print("Enter The Page That You Need (1-4) :");
                                num = S.nextInt();

                                switch (num) {
                                    case 1:

                                        staff_detail f = new staff_detail();
                                        f.value(Name, Id);
                                        f.CRUD();
                                        break;
                                    case 2:
                                        attend_Date_Calculate b = new attend_Date_Calculate();
                                        b.Recording(Name, Id);
                                        System.out.println(b.toString());
                                        break;
                                    case 3:
                                        report_incidents c = new report_incidents();
                                        c.report(Name, Id);
                                        break;
                                    case 4:
                                        num = 4;
                                        count = 4;
                                        break;
                                    default:
                                        System.out.println("Please Enter Again");
                                }
                            } while (num != 4);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(staff.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (num == 4) {
                break;
            }

            if (number == 2) {
                do {
                    System.out.print("\n================================");
                    System.out.println("\nWelcome To The manager Page : ");
                    System.out.println("1. Staff Detail");
                    System.out.println("2. Record Working Time");
                    System.out.println("3. Report Incidents");
                    System.out.println("4. Check Login History");
                    System.out.println("5. Main Page");
                    System.out.print("Enter The Page That You Need (1-5) :");
                    num = S.nextInt();

                    switch (num) {
                        case 1:
                            manager_detail a = new manager_detail();
                            a.value(Name, Id);
                            a.CRUD();
                            break;
                        case 2:
                            attend_Date_Calculate b = new attend_Date_Calculate();
                            b.Recording(Name, Id);
                            System.out.println(b.toString());
                            break;
                        case 3:
                            report_incidents c = new report_incidents();
                            c.report(Name, Id);
                            break;
                        case 4:
                            history f = new history();
                            f.checking(Name, Id);
                            break;
                        case 5:
                            num = 5;
                            count = 5;

                            break;
                        default:
                            System.out.println("Please Enter Again");
                    }

                } while (num != 5);
            }

        } while (count != 5);
    }

    public void washRecord(String ID) {
        Scanner c = new Scanner(System.in);

        try {
            c = new Scanner(new File("staffdetail.txt"));
            int num = 0;
            while (c.hasNext()) {
                this.ID = c.next();
                this.name = c.next();
                this.password = c.next();
                this.address = c.next();
                this.Mphone = c.next();
                this.email = c.next();
                String a = c.next();
                this.IC = Integer.valueOf(a);
                this.Bname = c.next();
                String b = c.next();
                this.Accounumber = Integer.valueOf(b);
                String d = c.next();
                this.salary = Double.valueOf(d);
                String e = c.next();
                this.Hsalary = Double.valueOf(e);
                if (this.ID.equals(ID)) {
                    break;
                }

            }
        } catch (Exception e) {
            System.out.print(e);
        }

        System.out.println(toString());
    }

    public String word() {

        return "" + this.getID() + " " + this.getName() + " " + this.getPassword() + " " + this.getAddress() + " "
                + this.getMphone() + " "
                + this.getEmail() + " " + this.getIC() + " " + this.getBname() + " " + this.getAccounubmer() + " "
                + this.getSalary() + " " + this.getHsalary();
    }

    @Override
    public String toString() {

        return "\n[Personal Detail] \n"
                + "Name : " + this.getName() + "(" + this.getID() + ")" + "          Address : " + this.getAddress()
                + "\nPhone Number : " + this.getMphone() + "     Email : " + this.getEmail()
                + "\nIdentity Card : " + this.getIC()
                + "\n\n[Payment Detail] "
                + "\nBank Name : " + this.getBname() + "      Account Number : " + this.getAccounubmer()
                + "\nTotal Salary : " + this.getSalary() + "        Hours rate : " + this.getHsalary()
                + "\n";

    }
}
