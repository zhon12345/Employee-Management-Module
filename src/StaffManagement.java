import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class StaffManagement {
    private ArrayList<Staff> management = new ArrayList<>();
    private String filename = "../Staff.txt";
    private String adminUser = "admin";
    private String adminPass = "admin1234";

    public StaffManagement() {
        loadFromFile();
    }

    public void login(Scanner scanner, String username, String password) {
        if (username.equals(adminUser) && password.equals(adminPass)) {
            adminMenu(scanner);
        } else {
            Staff staff = matchCredentials(username, password);

            if (staff != null) {
                staffMenu(scanner, staff);
            } else {
                System.out.println("\nInvalid username or password\n");
            }
        }
    }

    // Admin Methods
    private void adminMenu(Scanner scanner) {
        int option;
        do {
            System.out.println("\nWelcome Admin, what do you like to do?");
            System.out.println("1. Report Module");
            System.out.println("2. Display All Staff");
            System.out.println("3. Manage Staff");
            System.out.println("0. Logout");
            System.out.println("-------------------------------------------");
            System.out.print("Enter your choice: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    manageStaff(scanner);
                    break;
                case 0:
                    System.out.println("\nLogged out successfully!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } while (option != 0);
    }

    private void displayAll() {
        System.out.println("\nFull-time Staff");
        System.out.printf("\n%-3s %-20s %-15s %-15s %-20s %-15s %-8s %-8s %-12s %s\n", "ID", "Name", "IC Number", "Phone Number", "Email", "Password", "Bonus", "Fines", "Base Salary", "Salary");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        for (Staff staff : management) {
            if (staff instanceof FulltimeStaff) {
                System.out.print(staff.toString(true));
            }
        }

        System.out.println("\nPart-time Staff");
        System.out.printf("\n%-3s %-20s %-15s %-15s %-20s %-15s %-12s %s\n", "ID", "Name", "IC Number", "Phone Number", "Email", "Password", "Work Hours", "Salary");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        for (Staff staff : management) {
            if (staff instanceof ParttimeStaff) {
                System.out.print(staff.toString(true));
            }
        }
    }

    private void manageStaff(Scanner scanner) {
        int choice;

        do {
            displayAll();

            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add Staff");
            System.out.println("2. Update Staff");
            System.out.println("3. Delete Staff");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addStaff(scanner);
                    break;
                case 2:
                    updateStaff(scanner);
                    break;
                case 3:
                    deleteStaff(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } while (choice != 0);
    }

    private void addStaff(Scanner scanner) {
        int id = management.size() + 1;

        System.out.print("\nEnter staff name: ");
        String name = scanner.nextLine();

        System.out.print("Enter staff IC: ");
        String ICNum = scanner.nextLine();

        System.out.print("Enter staff phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter staff email: ");
        String email = scanner.nextLine();

        System.out.print("Enter staff password: ");
        String password = scanner.nextLine();

        boolean invalid = true;

        do {
            System.out.print("Enter staff position (FULLTIME/PARTTIME): ");
            String position = scanner.nextLine();

            if (position.equalsIgnoreCase("Fulltime")) {
                invalid = false;

                System.out.print("Enter staff salary: ");
                double salary = Double.parseDouble(scanner.nextLine());

                FulltimeStaff staff = new FulltimeStaff(id, name, ICNum, phone, email, password, 0, 0, salary);
                management.add(staff);
                saveToFile(staff);

                System.out.println("-----------------------------");
                System.out.println("Staff successfully added!");
                System.out.println("-----------------------------");

            } else if (position.equalsIgnoreCase("Parttime")) {
                invalid = false;

                System.out.print("Enter staff working hours: ");
                int workHours = Integer.parseInt(scanner.nextLine());

                ParttimeStaff staff = new ParttimeStaff(id, name, ICNum, phone, email, password, workHours);
                management.add(staff);
                saveToFile(staff);

                System.out.println("-----------------------------");
                System.out.println("Staff successfully added!");
                System.out.println("-----------------------------");
            }
        } while (invalid);
    }

    private void updateStaff(Scanner scanner) {
        System.out.print("\nEnter staff ID to update (0 to cancel): ");
        int id = Integer.parseInt(scanner.nextLine());

        if (id != 0) {
            Staff toUpdate = null;
            for (Staff staff : management) {
                if (staff.getStaffCode() == id) {
                    toUpdate = staff;
                    break;
                }
            }

            if (toUpdate != null) {
                toUpdate.updateDetails(scanner);

                updateFile();

                System.out.println("-----------------------------");
                System.out.println("Staff successfully updated!");
                System.out.println("-----------------------------");
            } else {
                System.out.println("Staff with ID " + id + " not found.");
            }
        } else {
            System.out.println("-------------------------");
            System.out.println("Staff update cancelled!");
            System.out.println("-------------------------");
        }
    }

    private void deleteStaff(Scanner scanner) {
        System.out.print("\nEnter staff ID to delete (0 to cancel): ");
        int id = Integer.parseInt(scanner.nextLine());

        if (id != 0) {
            Staff toRemove = null;
            for (Staff staff : management) {
                if (staff.getStaffCode() == id) {
                    toRemove = staff;
                    break;
                }
            }

            if (toRemove != null) {
                System.out.print("Are you sure? (Y/N): ");
                char confirm = Character.toLowerCase(scanner.next().charAt(0));
                scanner.nextLine();

                if (confirm == 'y') {
                    management.remove(toRemove);
                    updateFile();

                    System.out.println("----------------------------");
                    System.out.println("Staff successfully deleted!");
                    System.out.println("----------------------------");
                } else {
                    System.out.println("---------------------------");
                    System.out.println("Staff deletion cancelled!");
                    System.out.println("---------------------------");
                }
            } else {
                System.out.println("Staff with ID " + id + " not found.");
            }
        } else {
            System.out.println("---------------------------");
            System.out.println("Staff deletion cancelled!");
            System.out.println("---------------------------");
        }
    }

    // Staff Methods
    private Staff matchCredentials(String username, String password) {
        for (Staff staff : management) {
            if (staff.getEmail().equals(username) && staff.getPassword().equals(password)) {
                return staff;
            }
        }
        return null;
    }

    private void staffMenu(Scanner scanner, Staff staff) {
        int option;
        do {
            System.out.println("\nWelcome " + staff.getName() + ", what do you like to do?");
            System.out.println("1. Inventory Module");
            System.out.println("2. View Salary");
            System.out.println("3. Edit Account");
            System.out.println("0. Logout");
            System.out.println("-------------------------------------------");
            System.out.print("Enter your choice: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    break;
                case 2:
                    viewSalary(staff);
                    break;
                case 3:
                    updateStaff(scanner, staff);
                    break;
                case 0:
                    System.out.println("\nLogged out successfully!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } while (option != 0);
    }

    private void viewSalary(Staff staff) {
        staff.viewSalary();
    }

    private void updateStaff(Scanner scanner, Staff staff) {
        staff.updateDetails(scanner, staff);

        updateFile();
        System.out.println("-----------------------------");
        System.out.println("Account successfully updated!");
        System.out.println("-----------------------------");
    }

    // Misc Methods
    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] staffData = line.split("\\|");
                int id = Integer.parseInt(staffData[0]);
                String name = staffData[1];
                String ICNum = staffData[2];
                String phone = staffData[3];
                String email = staffData[4];
                String password = staffData[5];

                if (staffData.length == 9) {
                    double bonus = Double.parseDouble(staffData[6]);
                    double fine = Double.parseDouble(staffData[7]);
                    double salary = Double.parseDouble(staffData[8]);

                    FulltimeStaff staff = new FulltimeStaff(id, name, ICNum, phone, email, password, bonus, fine, salary);
                    management.add(staff);
                } else if (staffData.length == 7) {
                    int workHours = Integer.parseInt(staffData[6]);

                    ParttimeStaff staff = new ParttimeStaff(id, name, ICNum, phone, email, password, workHours);
                    management.add(staff);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from Staff.txt");
            e.printStackTrace();
        }
    }

    private void saveToFile(Staff staff) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(staff.toString(false));
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred write writing to Staff.txt");
            e.printStackTrace();
        }
    }

    private void updateFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Staff staff : management) {
                writer.write(staff.toString(false));
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("An error occurred write writing to Staff.txt");
            e.printStackTrace();
        }
    }
}
