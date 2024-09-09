
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author blon8
 */
public class test {

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Are You manager (Y/N) :");
        String ID = x.next();
        if("Y".equalsIgnoreCase(ID)){
        staff b =new manager_detail("","","");

        }else if("N".equalsIgnoreCase(ID)){
        staff a = new staff_detail("","","") ;
        }else{
            System.out.println("please enter again");
        }
    }

}
