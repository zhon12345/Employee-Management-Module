/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class MemberCard {

    private int points;

    public void setPoints(int pts) {
        points = pts;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int pts) {
        points += pts;
    }

    public int pointsWon(double cost) {
        return (int) cost / 3;
    }

}
