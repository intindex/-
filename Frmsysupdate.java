package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import waimai.model.Beanguanliyuan;
import waimai.model.Beanyonghuxinxi;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Frmsysupdate extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmsysupdate frame = new Frmsysupdate();
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
	JButton btnQueren = new JButton("\u786E\u8BA4");
	public Frmsysupdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u539F\u59CB\u5BC6\u7801");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(44, 65, 89, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(44, 125, 89, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u65B0\u5BC6\u7801");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(44, 174, 100, 33);
		contentPane.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 65, 154, 21);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(198, 125, 154, 21);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(198, 189, 154, 21);
		contentPane.add(passwordField_2);
		
		
		btnQueren.setBounds(329, 230, 97, 23);
		contentPane.add(btnQueren);
		this.btnQueren.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnQueren)
		{
			String old = new String(this.passwordField.getPassword());
			String pwd = new String(this.passwordField_1.getPassword());
			String pwd1 = new String(this.passwordField_2.getPassword());
			 try {
			    	Beanguanliyuan.currentLoginUser = yonghuUttil.userManger.changePwd(old, pwd, pwd1);
			    }catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
					return;
					}
			 this.setVisible(false);
		}
	}
}
