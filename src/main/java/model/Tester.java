package model;

public class Tester extends User {
    private int maxProjects; // Example attribute specific to Tester role

    // Constructors
    public Tester() {}

    public Tester(String userId, String name, String email, String role, int maxProjects) {
        super(userId, name, email, role);
        this.maxProjects = maxProjects;
    }

    // Getters and Setters
    public int getMaxProjects() {
        return maxProjects;
    }

    public void setMaxProjects(int maxProjects) {
        this.maxProjects = maxProjects;
    }
}
