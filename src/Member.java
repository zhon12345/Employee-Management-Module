/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Member extends Customer {

    private MemberCard card;

    public Member(String nm, String usernm, String passwd) {
        super(nm, usernm, passwd);
        setCard(new MemberCard());
    }

    public void setCard(MemberCard cd) {
        card = cd;
    }

    public MemberCard getCard() {
        return card;
    }

}
