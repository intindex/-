package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import waimai.model.Beanyouhuiquan;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Frmaddyouhuiquan extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmaddyouhuiquan frame = new Frmaddyouhuiquan();
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
	private JTextField textField_2;
	private JLabel label_3;
	private JTextField textField_3;
	public Frmaddyouhuiquan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4F18\u60E0\u91D1\u989D");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(105, 99, 97, 22);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u96C6\u5355\u8981\u6C42\u6570");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(105, 142, 97, 22);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("\u589E\u52A0\u4F18\u60E0\u5238\u754C\u9762");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(10, 10, 155, 35);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(304, 101, 145, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(304, 144, 145, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		button.setBounds(497, 251, 97, 23);
		contentPane.add(button);
		
		JLabel label_2 = new JLabel("\u53EF\u4F7F\u7528\u5546\u5BB6\u7F16\u53F7");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(105, 188, 145, 22);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(304, 191, 145, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		label_3 = new JLabel("\u4F18\u60E0\u5238\u6570\u91CF");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(105, 220, 145, 28);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(304, 222, 145, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
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
			try {
				Beanyouhuiquan.currentLoginUser = yonghuUttil.youhuiquanManger.addyouhuiquan(Double.valueOf(a1), Integer.valueOf(a2),Integer.valueOf(a3),Integer.valueOf(a4));
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			this.setVisible(false);
		}
	}
}
