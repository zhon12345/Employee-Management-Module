import java.util.Scanner;

public abstract class Staff {
    private int staffCode;
    private String name;
    private String ICNum;
    private String phone;
    private String email;
    private String password;

    public Staff(int staffCode, String name, String ICNum, String phone, String email, String password) {
        this.staffCode = staffCode;
        this.name = name;
        this.ICNum = ICNum;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public int getStaffCode() {
        return this.staffCode;
    }

    public void setStaffCode(int staffCode) {
        this.staffCode = staffCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getICNum() {
        return this.ICNum;
    }

    public void setICNum(String ICNum) {
        this.ICNum = ICNum;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.phone = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return 0;
    }

    public abstract void viewSalary();

    public abstract void updateDetails(Scanner scanner);

    public void updateDetails(Scanner scanner, Staff staff) {
        boolean invalid = true;
        do {
            System.out.printf("\nCurrent details:\n\nName: %s\nIC Number: %s\nPhone Number: %s\nEmail: %s\nPassword: %s\n", getName(), getICNum(), getPhone(), getEmail(), getPassword());

            System.out.print("\nEnter field to update, done to confirm: ");
            String field = scanner.nextLine();

            switch (field.toLowerCase()) {
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
            return String.format("%-3d %-20s %-15s %-15s %-20s %-15s", this.staffCode, this.name, this.ICNum, this.phone, this.email, this.password);
        } else {
            return String.format("%d|%s|%s|%s|%s|%s", this.staffCode, this.name, this.ICNum, this.phone, this.email, this.password);
        }
    }

    public String toString() {
        return String.format("\nCurrent details:\n\nName: %s\nIC Number: %s\nPhone Number: %s\nEmail: %s\nPassword: %s\n", getName(), getICNum(), getPhone(), getEmail(), getPassword());
    }
}