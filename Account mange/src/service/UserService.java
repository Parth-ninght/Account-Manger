package service;

import model.User;
import util.PasswordUtil;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public boolean register(String username, String password, String email) {
        if (users.containsKey(username)) {
            return false;
        }

        String salt = PasswordUtil.generateSalt();
        String passwordHash = PasswordUtil.hashPassword(password, salt);

        User user = new User(username, passwordHash, email, salt);
        users.put(username, user);
        return true;
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        if (user == null) {
            return false;
        }

        String hashedPassword = PasswordUtil.hashPassword(password, user.getSalt());
        return hashedPassword.equals(user.getPasswordHash());
    }

    public boolean resetPassword(String username, String email, String newPassword) {
        User user = users.get(username);
        if (user == null || !user.getEmail().equals(email)) {
            return false;
        }

        String salt = PasswordUtil.generateSalt();
        String passwordHash = PasswordUtil.hashPassword(newPassword, salt);

        user.setPasswordHash(passwordHash);
        user.setSalt(salt);
        return true;
    }
}