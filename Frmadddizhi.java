package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import waimai.model.Beandizhi;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Frmadddizhi extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmadddizhi frame = new Frmadddizhi();
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
	public Frmadddizhi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7701");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(34, 45, 58, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u589E\u52A0\u5730\u5740\u754C\u9762");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(10, 10, 123, 25);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(202, 43, 123, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5E02");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(34, 70, 58, 31);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(202, 76, 123, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u533A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(34, 114, 58, 25);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(202, 117, 123, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5177\u4F53\u5730\u5740");
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setBounds(34, 156, 82, 25);
		contentPane.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(202, 159, 123, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_5 = new JLabel("\u8054\u7CFB\u4EBA");
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		label_5.setBounds(34, 191, 58, 25);
		contentPane.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(202, 194, 123, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_6 = new JLabel("\u7535\u8BDD");
		label_6.setFont(new Font("宋体", Font.PLAIN, 16));
		label_6.setBounds(34, 226, 58, 15);
		contentPane.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(202, 225, 123, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		
		button.setBounds(390, 280, 97, 23);
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
			String a4 = this.textField_3.getText();
			String a5 = this.textField_4.getText();
			String a6 = this.textField_5.getText();
			try {
				Beandizhi.currentLoginUser = yonghuUttil.dizhiManger.adddizhi(a1, a2, a3, a4, a5, a6);
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
				}
			this.setVisible(false);
		}
	}
}
