package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;

public class Frmshangjia extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmshangjia frame = new Frmshangjia();
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
	JButton button = new JButton("\u6DFB\u52A0\u5546\u5BB6");
	JButton button_1 = new JButton("\u5220\u9664\u5546\u5BB6");
	public Frmshangjia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		button.setBounds(41, 54, 146, 40);
		contentPane.add(button);
		
		
		button_1.setBounds(41, 181, 146, 40);
		contentPane.add(button_1);
		this.button.addActionListener(this);
		this.button_1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.button)
		{
			Frmaddshangjia aFrmaddshangjia  = new Frmaddshangjia();
			aFrmaddshangjia.setVisible(true);
		}
		else if(e.getSource()==this.button_1)
		{
			Frmdeleteshangjia jFrmdeleteshangjia = new Frmdeleteshangjia();
			jFrmdeleteshangjia .setVisible(true);
		}
	}

}
