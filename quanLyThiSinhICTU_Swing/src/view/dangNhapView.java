package view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class dangNhapView extends Frame {
	private TextField usernamField;
	private TextField passwordField;

	public void loginView() {
		setTitle("Đăng nhập");
		setSize(300, 150);
		setLayout(new GridLayout(3, 2));

		Label usernamLabel = new Label("Tài khoản");
		usernamField = new TextField();
		Label passwordLabel = new Label("Mật khẩu");
		passwordField = new TextField();
		passwordField.setEchoChar('*');

		Button loginButton = new Button("Đăng nhập");
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				performLogin();

			}
		});
		Button cancelButton = new Button("Hủy");
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		add(usernamLabel);
		add(usernamField);
		add(passwordLabel);
		add(passwordField);
		add(loginButton);
		add(cancelButton);

		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}

	private void performLogin() {
		String usernameString = usernamField.getText();
		String passwordString = passwordField.getText();
		if (usernameString.equals("huynguyen03") && passwordString.equals("17112003")) {
			// Hiển thị thông báo đăng nhập thành công
			JOptionPane.showMessageDialog(this, "Đăng nhập thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

			// Chuyển sang trang QL_ThiSinhView
			new QL_ThiSinhView();

			// Đóng cửa sổ đăng nhập
			this.dispose();
		} else {
			// Hiển thị thông báo đăng nhập không thành công
			JOptionPane.showMessageDialog(this, "Đăng nhập không thành công", "Thông báo", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void performCancel() {
		// Xử lý logic cancel ở đây
		usernamField.setText("");
		passwordField.setText("");
		System.out.println("Đã hủy bỏ");
	}

	public static void main(String[] args) {

		dangNhapView myFramDangNhap = new dangNhapView();
		myFramDangNhap.setTitle("Login Interface");
		myFramDangNhap.setSize(300, 150);
		myFramDangNhap.setLayout(new GridLayout(3, 2));
		myFramDangNhap.setVisible(true);
		myFramDangNhap.loginView();
	}
}
