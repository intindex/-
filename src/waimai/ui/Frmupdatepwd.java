package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import waimai.model.Beanyonghuxinxi;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Frmupdatepwd extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField = new JTextField(20);
	private JPasswordField passwordField = new JPasswordField(20);
	private JPasswordField passwordField_1 = new JPasswordField(20);
	private JPasswordField passwordField_2 = new JPasswordField(20);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmupdatepwd frame = new Frmupdatepwd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
	public Frmupdatepwd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(63, 42, 58, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u65E7\u5BC6\u7801");
		label_1.setBounds(63, 87, 58, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u65B0\u5BC6\u7801");
		label_2.setBounds(63, 131, 58, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_3.setBounds(63, 181, 58, 15);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(184, 39, 136, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(184, 84, 136, 21);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(184, 128, 136, 21);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(184, 178, 136, 21);
		contentPane.add(passwordField_2);
		
		
		btnNewButton.setBounds(339, 230, 97, 23);
		contentPane.add(btnNewButton);
		this.btnNewButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnNewButton)
		{
			String user = this.textField.getText();
			String oldPwd = new String(this.passwordField.getPassword());
			String newPwd = new String(this.passwordField_1.getPassword());
			String newPwd2 = new String(this.passwordField_2.getPassword());
			try {
				Beanyonghuxinxi.currentLoginUser=yonghuUttil.yonghuManager.changePwd(user, oldPwd, newPwd, newPwd2);
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
				}
			this.setVisible(false);
		}
	}

}
