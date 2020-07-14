package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

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
	private final JButton button_2 = new JButton("\u589E\u52A0\u9A91\u624B");
	private final JButton button_3 = new JButton("\u5220\u9664\u9A91\u624B");
	private final JLabel label = new JLabel("\u7BA1\u7406\u5458\u64CD\u4F5C\u754C\u9762");
	private final JLabel label_1 = new JLabel("\u5546\u5BB6\u64CD\u4F5C");
	private final JLabel label_2 = new JLabel("\u9A91\u624B\u64CD\u4F5C");
	private final JButton button_4 = new JButton("\u4FEE\u6539\u5BC6\u7801");
	private final JButton btnNewButton = new JButton("\u6DFB\u52A0\u6EE1\u51CF\u65B9\u6848");
	private final JLabel label_3 = new JLabel("\u6EE1\u51CF\u65B9\u6848\u64CD\u4F5C");
	private final JButton button_5 = new JButton("\u5220\u9664\u6EE1\u51CF\u65B9\u6848");
	private final JButton btnNewButton_1 = new JButton("\u5206\u914D\u9A91\u624B");
	JButton btnNewButton_2 = new JButton("\u589E\u52A0\u4F18\u60E0\u5238");
	public Frmshangjia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		button.setBounds(49, 99, 146, 40);
		contentPane.add(button);
		
		
		button_1.setBounds(49, 181, 146, 40);
		contentPane.add(button_1);
		button_2.setBounds(434, 99, 146, 40);
		
		contentPane.add(button_2);
		button_3.setBounds(434, 181, 146, 40);
		
		contentPane.add(button_3);
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(10, 0, 180, 35);
		
		contentPane.add(label);
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(49, 45, 98, 24);
		
		contentPane.add(label_1);
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(434, 29, 85, 40);
		
		contentPane.add(label_2);
		button_4.setBounds(221, 10, 97, 23);
		
		contentPane.add(button_4);
		btnNewButton.setBounds(245, 99, 146, 40);
		
		contentPane.add(btnNewButton);
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(231, 45, 146, 22);
		
		contentPane.add(label_3);
		button_5.setBounds(249, 181, 142, 40);
		
		contentPane.add(button_5);
		btnNewButton_1.setBounds(49, 268, 146, 40);
		
		contentPane.add(btnNewButton_1);
		
		
		btnNewButton_2.setBounds(245, 268, 146, 40);
		contentPane.add(btnNewButton_2);
		this.button.addActionListener(this);
		this.button_1.addActionListener(this);
		this.button_2.addActionListener(this);
		this.button_3.addActionListener(this);
		this.button_4.addActionListener(this);
		this.button_5.addActionListener(this);
		this.btnNewButton.addActionListener(this);
		this.btnNewButton_1.addActionListener(this);
		this.btnNewButton_2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.button)
		{
			Frmaddshangjia aFrmaddshangjia  = new Frmaddshangjia();
			aFrmaddshangjia.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==this.button_1)
		{
			Frmdeleteshangjia jFrmdeleteshangjia = new Frmdeleteshangjia();
			jFrmdeleteshangjia .setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==this.button_2)
		{
			Frmaddqishou q = new Frmaddqishou();
			q.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==this.button_3)
		{
			Frmdeleteqishou f = new Frmdeleteqishou();
			f.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==this.button_4)
		{
			Frmsysupdate jkl = new Frmsysupdate();
			jkl.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==this.btnNewButton)
		{
			Frmaddmanjian addmanjian = new Frmaddmanjian();
			addmanjian.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==this.button_5)
		{
			Frmdeletemanjian dmanjian = new Frmdeletemanjian();
			dmanjian.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==this.btnNewButton_1)
		{
			Frmqishoufenpei qq = new Frmqishoufenpei();
			qq.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==this.btnNewButton_2)
		{
			Frmaddyouhuiquan aq = new Frmaddyouhuiquan();
			aq.setVisible(true);
			this.setVisible(false);
		}
	}
}
