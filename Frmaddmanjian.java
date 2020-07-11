package waimai.ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import waimai.model.Beanmanjian;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Frmaddmanjian extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmaddmanjian frame = new Frmaddmanjian();
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
	JButton button = new JButton("\u786E\u8BA4");
	public Frmaddmanjian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u589E\u52A0\u6EE1\u51CF\u65B9\u6848");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(44, 36, 126, 24);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6EE1\u51CF\u91D1\u989D");
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setBounds(44, 85, 82, 24);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u4F18\u60E0\u91D1\u989D");
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setBounds(44, 141, 82, 31);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(201, 87, 106, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(201, 146, 106, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u662F\u5426\u53EF\u53E0\u52A0");
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setBounds(44, 188, 82, 24);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(201, 190, 106, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		button.setBounds(329, 219, 97, 23);
		contentPane.add(button);
		this.button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.button)
		{
			String a1 = this.textField.getText();
			String a2 = this.textField_1.getText();
			String a3 = this.textField_2.getText();
			try {
				Beanmanjian.currentLoginUser = yonghuUttil.manjianManger.addmanjian(Double.valueOf(a1), Double.valueOf(a2), a3);
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
				}
			this.setVisible(false);
		}
	}

}
