
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class MainMenu {

    public static void main(String[] args) {
        int choice = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("               * *                                                                                      \n");
            System.out.print("            *    *  *                                                                                   \n");
            System.out.print("       *  *    *     *  *                                      __                                       \n");
            System.out.print("      *     *    * *     *                            ___----~~~~~~----___                              \n");
            System.out.print("  * *   *    *    *    *   *                     _-~~~____-----~~-----____~~~-_                         \n");
            System.out.print("  *     *  *    * * .#  *   *                 ..~.-~~--   ___------___   --~~-_~..                      \n");
            System.out.print("  *   *     * #.  .# *   *                  .'_.~.~~---~~~  __----__  ~~~---~` ~`.`.                    \n");
            System.out.print("   *     '#.  #; #' * *    *              .'.~ .'.~~__---~~~        ~~~---__~`.`. `_`.                  \n");
            System.out.print("  *   * * '#. ##'       *                ' .'.' /'/~          ,-._          ~-.'.`. `.~.                \n");
            System.out.print("    *       '###                       /'/'/'/'/'/          _.-'  '--.         `.`.`. ~.`.              \n");
            System.out.print("              '##                    .~.~.~.~.~.~         .'       _  -` _       `..`. .``.`            \n");
            System.out.print("               ##.                  .'.'.'.'.'.'         / .----. `_.'----'        .`.`.`.``.           \n");
            System.out.print("               .##;                | | | | | |           ;/     `                   : .`.`.`.`          \n");
            System.out.print("               ;###              _|_|_|_|_|_|_         /_;                           : `.`.`.`          \n");
            System.out.print("               ;###                                WELCOME TO ToyUMT                       \n");
            System.out.print("              ,####.        ._      ._      ._      ._      ._      ._      ._      ._      ._          \n");
            System.out.print("             .######.____.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-.    \n");
            System.out.println("");
            System.out.println("== Main Menu ==");
            System.out.println("1: Staff");
            System.out.println("2: Sales");
            System.out.println("3: Report");
            System.out.println("4: Inventory");
            System.out.println("0: Exit program");
            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    test.main(args);
                    break;
                case 2:
                    SalesDriver.main(args);
                    break;
                case 3:
                    testReport1.main(args);
                    break;
                case 4:
                    CRUDMethod.main(args);
                    break;
                case 0:
                    System.out.println("Thank you for choosing us! Have a nice day!");
                    break;
                default:
                    System.out.println("Not a valid choice.");
                    break;
            }
        } while (choice != 0);
    }
}
