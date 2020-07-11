package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.TextField;
import javax.swing.JButton;

public class FrmMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain frame = new FrmMain();
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
	public FrmMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u7528\u6237\u4FE1\u606F");
		button.setBounds(24, 25, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u5546\u5BB6\u4FE1\u606F");
		button_1.setBounds(139, 25, 97, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u9A91\u624B\u4FE1\u606F");
		button_2.setBounds(247, 25, 97, 23);
		contentPane.add(button_2);
	}
}
