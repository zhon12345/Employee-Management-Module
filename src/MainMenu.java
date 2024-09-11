import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        int choice = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("               * *\r\n" + //
                    "            *    *  *\r\n" + //
                    "       *  *    *     *  *                                      __\r\n" + //
                    "      *     *    * *     *                            ___----~~~~~~----___\r\n" + //
                    "  * *   *    *    *    *   *                     _-~~~____-----~~-----____~~~-_\r\n" + //
                    "  *     *  *    * * .#  *   *                 ..~.-~~--   ___------___   --~~-_~..\r\n" + //
                    "  *   *     * #.  .# *   *                  .'_.~.~~---~~~  __----__  ~~~---~` ~`.`.\r\n" + //
                    "   *     '#.  #; #' * *    *              .'.~ .'.~~__---~~~        ~~~---__~`.`. `_`.\r\n" + //
                    "  *   * * '#. ##'       *                ' .'.' /'/~          ,-._          ~-.'.`. `.~.\r\n" + //
                    "    *       '###                       /'/'/'/'/'/          _.-'  '--.         `.`.`. ~.`.\r\n" + //
                    "              '##                    .~.~.~.~.~.~         .'       _  -` _       `..`. .``.`\r\n" + //
                    "               ##.                  .'.'.'.'.'.'         / .----. `_.'----'        .`.`.`.``.\r\n"
                    + //
                    "               .##;                | | | | | |           ;/     `                   : .`.`.`.`\r\n"
                    + //
                    "               ;###              _|_|_|_|_|_|_         /_;                           : `.`.`.`\r\n"
                    + //
                    "               ;###                                WELCOME TO ToyUMT\r\n" + //
                    "              ,####.        ._      ._      ._      ._      ._      ._      ._      ._      ._\r\n"
                    + //
                    "             .######.____.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-._)` _.-.");
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
