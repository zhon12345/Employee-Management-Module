/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Productlist {

    private String proid;
    private String proName;
    double proPrice;
    int quantitysales;

    public Productlist(String proid, String proName, double proPrice, int quantitysales) {
        this.proid = proid;
        this.proName = proName;
        this.proPrice = proPrice;
        this.quantitysales = quantitysales;

    }

    public String getProid() {
        return proid;
    }

    public String getProName() {
        return proName;
    }

    public double getProPrice() {
        return proPrice;
    }

    public void setProid(String proid) {
        this.proid = proid;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public void setProPrice(double proPrice) {
        this.proPrice = proPrice;
    }

    public int getQuantitysales() {
        return quantitysales;
    }

    public void setQuantitysales(int quantitysales) {
        this.quantitysales = quantitysales;
    }

    @Override
    public String toString() {
        return "Barcode :" + proid + " | Product Name :" + proName + " | Product Price :" + proPrice + "| Total QuantitySell :" + quantitysales;
    }

}
