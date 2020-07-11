package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import waimai.model.Beanshangjiaxinxi;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Frmaddshangjia extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField = new JTextField(20);
	private JTextField textField_1 = new JTextField(20);
	private JTextField textField_2 = new JTextField(20);
	private JTextField textField_3 = new JTextField(20);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmaddshangjia frame = new Frmaddshangjia();
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
	public Frmaddshangjia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5546\u5BB6\u59D3\u540D");
		label.setBounds(34, 44, 58, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5546\u5BB6\u661F\u7EA7");
		label_1.setBounds(34, 97, 58, 15);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("\u4EBA\u5747\u6D88\u8D39");
		lblNewLabel.setBounds(34, 143, 58, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u603B\u9500\u91CF");
		lblNewLabel_1.setBounds(34, 202, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(168, 41, 163, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 94, 163, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(168, 140, 163, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(168, 199, 163, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		button.setBounds(313, 230, 97, 23);
		contentPane.add(button);
		this.button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.button)
		{
			String name = this.textField.getText();
			String xingji = this.textField_1.getText();
			String xiaofei = this.textField_2.getText();
			String xiaoliang = this.textField_3.getText();
			try {
				Beanshangjiaxinxi.currentLoginUser = yonghuUttil.shangjiaManger.addshangjia(name, xingji, xiaofei, xiaoliang);
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
				}
			this.setVisible(false);
		}
	}
}
