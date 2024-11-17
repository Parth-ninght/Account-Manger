package gui;

import service.UserService;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private UserService userService;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginFrame(UserService userService) {
        this.userService = userService;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("用户登录系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // 用户名输入
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("用户名:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usernameField = new JTextField(15);
        add(usernameField, gbc);

        // 密码输入
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("密码:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        passwordField = new JPasswordField(15);
        add(passwordField, gbc);

        // 按钮面板
        JPanel buttonPanel = new JPanel();
        loginButton = new JButton("登录");
        registerButton = new JButton("注册");
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);

        // 添加登录按钮事件
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (userService.login(username, password)) {
                JOptionPane.showMessageDialog(this, "登录成功！");
                // TODO: 这里可以打开主系统界面
            } else {
                JOptionPane.showMessageDialog(this, "用户名或密码错误！", "登录失败", JOptionPane.ERROR_MESSAGE);
            }
        });

        // 添加注册按钮事件
        registerButton.addActionListener(e -> {
            new RegisterDialog(this, userService);
        });
    }
}