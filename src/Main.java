import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StaffManagement staffManagement = new StaffManagement();
        int choice;

        do {
            System.out.print(
                    "                              _\n" +
                            "                     ___----~~~~~~----__\n" +
                            "                _-~~~____-----~~-----____~~~-\n" +
                            "             ..~.-~~--   ___------___   --~~-_~.\n" +
                            "           .'_.~.~~---~~~  __----__  ~~~---~` ~`.`\n" +
                            "         .'.~ .'.~~__---~~~        ~~~---__~`.`. `_`\n" +
                            "        ' .'.' /'/~          ,-._          ~-.'.`. `.~\n" +
                            "      /'/'/'/'/'/          _.-'  '--.         `.`.`. ~.`\n" +
                            "    .~.~.~.~.~.~         .'       _  -` _       `..`. .``.\n" +
                            "   .'.'.'.'.'.'         / .----. `_.'----'        .`.`.`.``\n" +
                            "  | | | | | |           ;/     `                   : .`.`.`.\n" +
                            "_|_|_|_|_|_|_         /_;                           : `.`.`.\n" +
                            "_.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-.\n\n" +
                            "          Welcome to ToyUMT Inventory Management System\n");
            System.out.println("1: Login");
            System.out.println("0: Exit");
            System.out.println("--------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Username: ");
                    String username = scanner.nextLine();

                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    if (username == "admin" && password == "admin1234") {
                        int option;

                        do {
                            menu();
                            option = scanner.nextInt();

                            switch (option) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    staffManagement.displayAll();
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Invalid option, please try again.");
                                    break;
                            }
                        } while (option != 0);
                    } else {
                        menu(username);
                    }
                    break;
                case 0:
                    System.out.println("Thank you for choosing us! Have a nice day!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }

    public static void menu(String username) {
        System.out.println("Welcome, " + username);
        System.out.println("1. Inventory Module");
        System.out.println("2. Edit Account");
        System.out.println("0. Logout");
        System.out.println("--------------------------");
        System.out.println("Enter your choice: ");
    }

    public static void menu() {
        System.out.println("Welcome, Admin");
        System.out.println("1. Report Module");
        System.out.println("2. Add new Staff");
        System.out.println("3. Display All Staff");
        System.out.println("0. Logout");
        System.out.println("--------------------------");
        System.out.println("Enter your choice: ");
    }
}
