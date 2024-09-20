import java.util.Scanner;

public class ParttimeStaff extends Staff {
    private int workHours;

    public ParttimeStaff(int staffCode, String name, String ICNum, String phone, String email, String password, int workHours) {
        super(staffCode, name, ICNum, phone, email, password);
        this.workHours = workHours;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public double getSalary() {
        return workHours * 100;
    }

    public void viewSalary() {
        System.out.printf("\n%-15s: RM%8.2f\n", "Base Salary", 100.0);
        System.out.printf("%-15s: %6d Hrs\n", "Work Hours", getWorkHours());
        System.out.printf("%-15s: RM%8.2f\n", "Total Salary", getSalary());
    }

    public void updateDetails(Scanner scanner) {
        boolean invalid = true;

        do {
            System.out.println(this.toString());

            System.out.print("\nEnter field to update, done to confirm: ");
            String field = scanner.nextLine();

            switch (field) {
                case "name":
                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();
                    setName(name);
                    break;
                case "ic number":
                    System.out.print("Enter new IC Number: ");
                    String icNum = scanner.nextLine();
                    setICNum(icNum);
                    break;
                case "phone number":
                    System.out.print("Enter new phone number: ");
                    String phone = scanner.nextLine();
                    setPhone(phone);
                    break;
                case "email":
                    System.out.print("Enter new email: ");
                    String email = scanner.nextLine();
                    setEmail(email);
                    break;
                case "password":
                    System.out.print("Enter new password: ");
                    String password = scanner.nextLine();
                    setPassword(password);
                    break;
                case "work hours":
                    System.out.print("Enter new work hours: ");
                    int workHours = Integer.parseInt(scanner.nextLine());
                    setWorkHours(workHours);
                    break;
                case "done":
                    invalid = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }

        } while (invalid);
    }

    public String toString(boolean format) {
        if (format) {
            return super.toString(true) + String.format(" %-12d %.2f\n", this.workHours, this.getSalary());
        } else {
            return super.toString(false) + String.format("|%d", this.workHours);
        }
    }

    public String toString() {
        return super.toString() + String.format("Work Hours: %d\n", getWorkHours());
    }
}
