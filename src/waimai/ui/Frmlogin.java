package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/*import sun.tools.tree.ThisExpression;*/
import waimai.util.BaseException;
import waimai.model.Beanyonghuxinxi;
import waimai.start.yonghuUttil;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dialog.ModalExclusionType;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Frmlogin extends JFrame implements ActionListener{
	
	//private JButton btnNewButton = new JButton("\u7528\u6237\u767B\u5F55");
	private JPanel contentPane;
	private JTextField textField= new JTextField(20);
	private JPasswordField passwordField= new JPasswordField(20);
	JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
	JButton btnNewButton = new JButton("\u7528\u6237\u767B\u5F55");
   // textField = new JTextField(20);
    //passwordField = new JPasswordField(20);
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 * 
	 */
	JButton btnNewButton_1 = new JButton("\u7BA1\u7406\u5458\u767B\u5F55");
	JButton button = new JButton("\u7528\u6237\u6CE8\u518C");
	
	ButtonGroup group=new ButtonGroup();
	public Frmlogin() {
		super();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setBounds(57, 92, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(57, 133, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(125, 89, 178, 21);
		contentPane.add(textField);
		textField.setColumns(30);
		
		JLabel label = new JLabel("\u7528\u6237\uFF0C\u7BA1\u7406\u5458\u767B\u5F55");
		label.setBounds(156, 27, 147, 15);
		contentPane.add(label);
		
		
	
		button.setBounds(18, 212, 97, 23);
		contentPane.add(button);
		ButtonGroup group=new ButtonGroup();
		
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(163, 212, 97, 23);
		contentPane.add(btnNewButton);
		
		
		btnNewButton_1.setBounds(302, 212, 108, 23);
		contentPane.add(btnNewButton_1);
		
		
		rdbtnNewRadioButton.setBounds(43, 170, 127, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(125, 130, 178, 21);
		contentPane.add(passwordField);
		this.btnNewButton.addActionListener(this);
		this.btnNewButton_1.addActionListener(this);
		this.button.addActionListener(this);
	}
	@Override
   public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnNewButton)
		{
			String userid = this.textField.getText();
		    String pwd = new String(this.passwordField.getPassword());
		    try {
		    	Beanyonghuxinxi.currentLoginUser=yonghuUttil.yonghuManager.login(userid, pwd);
		    }catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
				}
		    Frmyonghujiemian userlogin = new Frmyonghujiemian();
		    userlogin.setVisible(true);
		    this.setVisible(false);
		}
		else if(e.getSource() == this.button)
		{
			FrmUserReg reg = new FrmUserReg();  
			reg.setVisible(true);
			//reg.setVisible(false);
		}
		else if(e.getSource()==this.btnNewButton_1)
		{
			FrmMangerlogin d = new FrmMangerlogin();
			d.setVisible(true);
			this.setVisible(false);
		}
			
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmlogin frame = new Frmlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
