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

public class FrmUserReg extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField = new JTextField(20);
	private JPasswordField passwordField = new JPasswordField(20);
	private JPasswordField passwordField_1 = new JPasswordField(20);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUserReg frame = new FrmUserReg();
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
	JButton button = new JButton("\u70B9\u51FB\u6CE8\u518C");
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public FrmUserReg() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(32, 75, 58, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(32, 134, 58, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_2.setBounds(32, 159, 58, 15);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(180, 72, 141, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 134, 141, 21);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(180, 165, 141, 21);
		contentPane.add(passwordField_1);
		
		
		button.setBounds(501, 289, 97, 23);
		contentPane.add(button);
		
		JLabel label_3 = new JLabel("\u6027\u522B");
		label_3.setBounds(32, 106, 58, 15);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 103, 138, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_4 = new JLabel("\u624B\u673A\u53F7\u7801");
		label_4.setBounds(32, 193, 58, 15);
		contentPane.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(180, 196, 141, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_5 = new JLabel("\u6240\u5728\u57CE\u5E02");
		label_5.setBounds(32, 232, 58, 15);
		contentPane.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 229, 141, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		this.button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.button)
		{
			String userid = this.textField.getText();
			String xingbie = this.textField_1.getText();
			String shouji = this.textField_2.getText();
			String city = this.textField_3.getText();
		    String pwd = new String(this.passwordField.getPassword());
		    String pwd2 = new String(this.passwordField_1.getPassword());
		    try {
		    	Beanyonghuxinxi.currentLoginUser=yonghuUttil.yonghuManager.reg(userid, xingbie, shouji, city, pwd, pwd2);
		    	 
		    }catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
				}
		    this.setVisible(false);
		}
	}
}
