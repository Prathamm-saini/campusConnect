package models;

public class Professor extends User {
    public Professor(String name, String email) {
        super(name, email);
    }

    @Override
    public void showDashboard() {
        System.out.println("Welcome Professor " + name);
    }
}
