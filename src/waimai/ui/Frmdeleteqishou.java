package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import waimai.model.Beanqishouxinxi;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Frmdeleteqishou extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmdeleteqishou frame = new Frmdeleteqishou();
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
	JButton button_1 = new JButton("\u9000\u51FA");
	JButton button = new JButton("\u786E\u8BA4");
	public Frmdeleteqishou() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8F93\u5165\u8981\u5220\u9664\u9A91\u624B\u7684\u59D3\u540D");
		label.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		label.setBounds(53, 54, 259, 36);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(53, 157, 203, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
		button.setBounds(299, 230, 97, 23);
		contentPane.add(button);
		
		
		button_1.setBounds(187, 230, 97, 23);
		contentPane.add(button_1);
		this.button_1.addActionListener(this);
		this.button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.button)
		{
			String name = this.textField.getText();
			try {
				Beanqishouxinxi.currentLoginUser = yonghuUttil.qishouManger.deleteqishou(name);
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
				}
			this.setVisible(false);
		}
	}

}
