
import java.io.InputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class ReportSales extends Productlist {

    private int totalAmount;
    private int quantitiysell;

    public ReportSales(String proid, String proName, double proPrice,int quantitysales) {
        super(proid,proName,proPrice,quantitysales);
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;

    }

    public int getTotalAmount() {
       totalAmount = (int) (proPrice * quantitysales);
        return totalAmount;
    }
    

    
    public int getQuantitiysell() {
        
        return quantitiysell;
    }

    public void setQuantitiysell(int quantitiysell) {
        this.quantitiysell = quantitiysell;
    }



}
