package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import waimai.model.Beanguanliyuan;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class FrmMangerlogin extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField = new JTextField(20);
	private JPasswordField passwordField = new JPasswordField(20);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMangerlogin frame = new FrmMangerlogin();
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
	JButton button = new JButton("\u767B\u5F55");
	public FrmMangerlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7BA1\u7406\u5458\u8D26\u53F7");
		label.setBounds(58, 77, 91, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(185, 74, 136, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801");
		lblNewLabel.setBounds(58, 156, 91, 15);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(185, 153, 136, 21);
		contentPane.add(passwordField);
		
		
		button.setBounds(275, 230, 97, 23);
		contentPane.add(button);
		this.button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if((e.getSource() == this.button))
		{
			String userid = this.textField.getText();
		    String pwd = new String(this.passwordField.getPassword());
		    try {
		    	Beanguanliyuan.currentLoginUser = yonghuUttil.userManger.login(userid, pwd);
		    }catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
				}
		    Frmshangjia dd = new Frmshangjia();
		    dd.setVisible(true);
		    this.setVisible(false);
		}
	}
}
