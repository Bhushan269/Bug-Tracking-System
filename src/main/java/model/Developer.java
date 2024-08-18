package model;

public class Developer extends User {
    private String programmingLanguage; // Example attribute specific to Developer role

    // Constructors
    public Developer() {}

    public Developer(String userId, String name, String email, String role, String programmingLanguage) {
        super(userId, name, email, role);
        this.programmingLanguage = programmingLanguage;
    }

    // Getters and Setters
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
}
