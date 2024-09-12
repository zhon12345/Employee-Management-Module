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
