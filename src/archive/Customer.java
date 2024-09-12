import java.util.ArrayList;

public class Customer {

  private static int counter = 0;
  private static ArrayList<Customer> customers = new ArrayList<Customer>();
  private int id;
  private String name;
  private String username;
  private String password;

  public Customer(String nm, String usernm, String passwd) {
    customers.add(this);
    counter++;
    setId(counter);
    setName(nm);
    setUsername(usernm);
    setPassword(passwd);
  }

  public int getCounter() {
    return counter;
  }

  public static ArrayList<Customer> getCustomers() {
    return customers;
  }

  public void setId(int iden) {
    id = iden;
  }

  public int getId() {
    return id;
  }

  public void setName(String nm) {
    name = nm;
  }

  public String getName() {
    return name;
  }

  public void setUsername(String usernm) {
    username = usernm;
  }

  public String getUsername() {
    return username;
  }

  public void setPassword(String passwd) {
    password = passwd;
  }

  public String getPassword() {
    return password;
  }

  public void changePassword(String pass1, String pass2) {
    if (pass1.equals(pass2)) {
      setPassword(pass1);
      System.out.println("Password has been changed");
    } else {
      System.out.println("Password don't match");
    }
  }

}
