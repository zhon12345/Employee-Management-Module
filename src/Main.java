import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
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
                    "   .'.'.'.'.'.'         / .----. `_.'----'        .`.`.`.``\n"+ 
                    "  | | | | | |           ;/     `                   : .`.`.`.\n"+ 
                    "_|_|_|_|_|_|_         /_;                           : `.`.`.\n"+ 
                    "_.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-.\n\n"+
                    "          Welcome to ToyUMT Inventory Management System\n");
            System.out.println("1: View Products");
            System.out.println("2: Login");
            System.out.println("0: Exit");
            System.out.print("Enter your choice : ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    test.main(args);
                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("Thank you for choosing us! Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }
}
