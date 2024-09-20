import java.util.Scanner;

public class FulltimeStaff extends Staff {
    private double bonus;
    private double fine;
    private double baseSalary;

    public FulltimeStaff(int staffCode, String name, String ICNum, String phone, String email, String password, double bonus, double fine, double baseSalary) {
        super(staffCode, name, ICNum, phone, email, password);
        this.bonus = bonus;
        this.fine = fine;
        this.baseSalary = baseSalary;
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getFine() {
        return this.fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getSalary() {
        return baseSalary + bonus - fine;
    }

    public void viewSalary() {
        System.out.printf("\n%-15s: RM%8.2f\n", "Base Salary", getBaseSalary());
        System.out.printf("%-15s: RM%8.2f\n", "Bonus", getBonus());
        System.out.printf("%-15s: RM%8.2f\n", "Fines", getFine());
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
                case "bonus":
                    System.out.print("Enter new bonus amount: ");
                    double bonus = Double.parseDouble(scanner.nextLine());
                    setBonus(bonus);
                    break;
                case "fines":
                    System.out.print("Enter new fines amount: ");
                    double fines = Double.parseDouble(scanner.nextLine());
                    setFine(fines);
                    break;
                case "base salary":
                    System.out.print("Enter new base salary: ");
                    double salary = Double.parseDouble(scanner.nextLine());
                    setBaseSalary(salary);
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
            return super.toString(true) + String.format(" %-8.2f %-8.2f %-12.2f %.2f\n", this.bonus, this.fine, this.baseSalary, this.getSalary());
        } else {
            return super.toString(false) + String.format("|%.2f|%.2f|%.2f", this.bonus, this.fine, this.baseSalary);
        }
    }

    public String toString() {
        return super.toString() + String.format("Bonus: %.2f\nFines: %.2f\nBase Salary %.2f\n", getBonus(), getFine(), getBaseSalary());
    }
}