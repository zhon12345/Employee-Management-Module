/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author blon8
 */
public class calculate extends calculateFunction {

    private String ID;
    private int totalWorkingTime, workingTime, timeIn, timeOut;
    private double dailySalary = 0d, overTime = 0d;
    private static double hoursSalary = 10.0;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public int getTotalWorkingTime() {
        return totalWorkingTime;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public double getDailySalary() {
        return dailySalary;
    }

    public double getOverTime() {
        return overTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }

    public void setTotalWorkingTime(int totalWorkingTime) {
        this.totalWorkingTime = totalWorkingTime;
    }

    public void setTimeIn(int timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public void setDailySalary(double dailySalary) {
        this.dailySalary = dailySalary;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }

    @Override
    public void display(int num, String ID, int timeIn, int timeOut) {
        this.ID = ID;
        this.timeIn = timeIn;
        this.timeOut = timeOut;

        if (num <= 800) {
            setDailySalary((num * this.hoursSalary) / 100);
            setTotalWorkingTime(num/100);
            setOverTime(0d);
            this.workingTime = num;
            
        } else if (num > 800) {
            setDailySalary((num * this.hoursSalary) / 100);
            setOverTime(getDailySalary() * 0.5);
            setTotalWorkingTime(num/100);
            this.workingTime = num;
            
        } else if (num <= 0) {
            setDailySalary((num * this.hoursSalary) / 100);
            setOverTime(0d);
            setDailySalary(-5d);
            this.workingTime = num;
            
        }
    }

    @Override
    public String toString() {

        return "" + this.ID + " " + this.timeIn + " " + this.timeOut + " " + this.totalWorkingTime + " " + this.dailySalary + " " + this.overTime;
    }

}
