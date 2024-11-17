package gui;

import service.UserService;

import javax.swing.*;
import java.awt.*;

public class RegisterDialog extends JDialog {
    private UserService userService;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;

    public RegisterDialog(Frame parent, UserService userService) {
        super(parent, "用户注册", true);
        this.userService = userService;
        initializeUI();
    }

    private void initializeUI() {
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

        // 邮箱输入
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("邮箱:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        emailField = new JTextField(15);
        add(emailField, gbc);

        // 注册按钮
        JButton registerButton = new JButton("确认注册");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(registerButton, gbc);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String email = emailField.getText();

            if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "所有字段都必须填写！", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (userService.register(username, password, email)) {
                JOptionPane.showMessageDialog(this, "注册成功！");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "用户名已存在！", "注册失败", JOptionPane.ERROR_MESSAGE);
            }
        });

        pack();
        setLocationRelativeTo(getParent());
        setVisible(true);
    }
}