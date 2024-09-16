import java.util.ArrayList;

public class StaffManagement {
    private ArrayList<Staff> management = new ArrayList<>();

    public void addNewStaff(Staff staff) {
        management.add(staff);
    }

    public void displayAll() {
        for (Staff staff : management) {
            System.out.println(staff.toString());
        }
    }
}
