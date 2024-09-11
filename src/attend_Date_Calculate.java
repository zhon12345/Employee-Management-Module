import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class attend_Date_Calculate {

    calculate c = new calculate();
    Scanner s = new Scanner(System.in);

    public void Recording(String name, String ID) {
        String function = "attendent";
        Date date = new Date();
        String i = String.valueOf(date);
        new history().saving(name, ID, function, i);
        int timeIn;
        do {
            System.out.print("\nEnter Your Time In For Working (International Time [xxxx]): ");
            timeIn = s.nextInt();
        } while (timeIn <= 0 && timeIn >= 2359);

        int timeOut;
        do {
            System.out.print("Enter Your Time Out For Working (International Time [xxxx]): ");
            timeOut = s.nextInt();
        } while (timeOut <= 0 && timeOut >= 2359);

        int num = calculate(timeIn, timeOut);
        c.display(num, ID, timeIn, timeOut);

        try {
            FileWriter fw = new FileWriter("attend.txt", true);
            fw.append(c.toString());
            fw.append("\n");
            fw.close();
            System.out.println("\n----------------------------------------------------");
            System.out.println("The Attend Record Is Added succesfully In The System.");
            System.out.println("-----------------------------------------------------");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public int calculate(int timeIn, int timeOut) {
        return timeOut - timeIn;
    }

    @Override
    public String toString() {
        return "\n[Working Time] \n" + "Staff ID : " + c.getID()
                + "\nYour Working (Time In) : " + c.getTimeIn() + "       (Time out) :" + c.getTimeOut()
                + "\nTotal Working Time Is : " + c.getTotalWorkingTime() + " hours    Total Overtime : RM"
                + (c.getOverTime())
                + "\nDaily Salary : RM" + c.getDailySalary();
    }

}
