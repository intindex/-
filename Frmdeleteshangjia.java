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

public class Frmdeleteshangjia extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField = new JTextField(20);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmdeleteshangjia frame = new Frmdeleteshangjia();
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
	public Frmdeleteshangjia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u5546\u5BB6\u59D3\u540D");
		label.setBounds(76, 45, 157, 41);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(76, 128, 214, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		button.setBounds(329, 230, 97, 23);
		contentPane.add(button);
		this.button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.button)
		{
			String name = this.textField.getText();
			try {
				Beanshangjiaxinxi.currentLoginUser = yonghuUttil.shangjiaManger.deleteshangjia(name);
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
				}
			this.setVisible(false);
		}
	}

}
