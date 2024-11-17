import gui.LoginFrame;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        // 使用SwingUtilities确保在EDT线程中创建和显示GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame(userService);
            loginFrame.setVisible(true);
        });
    }
} 