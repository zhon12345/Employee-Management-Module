/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */

import java.util.*;
import java.io.*;

public class SalesDriver {

    public static String filename = "inventory.txt";

    File file = new File("inventory.txt");

    public static void main(String[] args) {
        new Customer("Guest", "Admin", "Admin");
        new Member("Jin kai", "jink", "5678");
        new Member("ZhengHong", "zh", "1234");
        createObjects();
        Menu.welcomeMessage();
        Customer customer = null;
        while (customer == null) {
            String[] credentials = Menu.getCredentials();
            customer = Menu.checkCredentials(credentials[0], credentials[1]);
            if (customer == null) {
                System.out.println("Wrong Combination. Try again.");
            }
        }
        System.out.printf("Welcome *%s*\n\n", customer.getName());
        if (customer instanceof Member) {
            Member cust = (Member) customer;
            while (true) {
                Menu.getMemberMenu(cust);
                break;
            }
        } else {
            while (true) {
                Menu.getCustomerMenu(customer);
                break;
            }
        }
    }

    public static void createObjects() {

        File file = new File("inventory.txt");

        try {

            BufferedReader br = new BufferedReader(new FileReader("inventory.txt"));

            Scanner x = new Scanner(br);
            new FileReader("inventory.txt");

            while (x.hasNext()) {
                String a = x.next();
                String b = x.next();

                String c = x.next();
                int s = Integer.valueOf(c);

                String d = x.next();
                double z = Double.valueOf(d);
                
                String e = x.next();
                double y = Double.valueOf(e);

                new Product(a, b, z, s, y);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
