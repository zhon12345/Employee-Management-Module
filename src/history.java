import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class history {

    private String name, ID, function, date;
    String line;

    public history() {
        this.name = "";
        this.ID = "";
        this.function = "";
        this.date = "";
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getFunction() {
        return function;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void checking(String name, String ID) {

        String function = "history";
        Date date = new Date();
        String i = String.valueOf(date);

        new history().saving(name, ID, function, i);

        Scanner c = new Scanner(System.in);

        try {
            c = new Scanner(new File("history.txt"));
            System.out.println("\nThis Is All The Record That Find Inside File ");
            System.out.println(
                    "----------------------------------------------------------------------------------------");
            System.out.println("History Login In \nID \t NAME \t\t Function \t\t  Date \t     Time  ");
            System.out.println(
                    "----------------------------------------------------------------------------------------");
            int num = 0;
            while (c.hasNext()) {
                String a = c.next();
                String b = c.next();
                String d = c.next();
                String e = c.nextLine();
                System.out.printf("%-5s\t %-10s \t %-20s\t %-40s\n", a, b, d, e);

            }
        } catch (Exception e) {
            System.out.print(e);
        }
        System.out.println("----------------------------------------------------------------------------------------");

    }

    public void saving(String name, String ID, String function, String date) {
        this.name = name;
        this.ID = ID;
        this.function = function;
        this.date = date;

        try {
            FileWriter fw = new FileWriter("history.txt", true);
            fw.append(toString());
            fw.append("\n");
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public String toString() {

        return "" + this.ID + " " + this.name + " " + this.function + " " + this.date + "";
    }

}
