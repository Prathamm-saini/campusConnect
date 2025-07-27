package models;

public abstract class User {
    protected String name;
    protected String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public abstract void showDashboard();

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
