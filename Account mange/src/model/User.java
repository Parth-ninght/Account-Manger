package model;

public class User {
    private String username;
    private String passwordHash;
    private String email;
    private String salt;

    public User(String username, String passwordHash, String email, String salt) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.salt = salt;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}