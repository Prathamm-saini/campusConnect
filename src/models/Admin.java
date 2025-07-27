package models;

public class Admin extends User {
    public Admin(String name, String email) {
        super(name, email);
    }

    @Override
    public void showDashboard() {
        System.out.println("Welcome Admin " + name);
    }
}
