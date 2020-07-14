package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import waimai.model.Beandingdan;
import waimai.model.Beanshangjiaxinxi;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class Frmdingdan extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmdingdan frame = new Frmdingdan();
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
	List <Beandingdan> alldingdan = null;
	private Object tbldingdanData[][];
	DefaultTableModel tabdingdanModel=new DefaultTableModel();
	private Object tbldingdanTitle[]=Beandingdan.tbldingdanTitle;
	private JTable datadingdanPlan=new JTable(tabdingdanModel);
	private  void reloaddingdanTable() {
		try {
			alldingdan = yonghuUttil.dingdanManger.loadall();
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tbldingdanData =  new Object[alldingdan.size()][Beandingdan.tbldingdanTitle.length];
		for(int i=0;i<alldingdan.size();i++){
			for(int j=0;j<Beandingdan.tbldingdanTitle.length;j++)
				tbldingdanData[i][j]=alldingdan.get(i).getCell(j);
		}
		tabdingdanModel.setDataVector(tbldingdanData,tbldingdanTitle);
		this.datadingdanPlan.validate();
		this.datadingdanPlan.repaint();
	}
	JButton button = new JButton("\u8FD4\u56DE");
	JButton button_1 = new JButton("\u7528\u6237\u8BC4\u4EF7");
	Beandingdan uu = new Beandingdan();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public Frmdingdan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		button.setBounds(542, 436, 97, 23);
		contentPane.add(button);
		JScrollPane scrollPane = new JScrollPane(this.datadingdanPlan);
		scrollPane.setBounds(10, 10, 629, 206);
	    this.getContentPane().add(scrollPane);
	    
	    
	    button_1.setBounds(648, 436, 97, 23);
	    contentPane.add(button_1);
	    
	    JLabel label = new JLabel("");
	    label.setBounds(650, 11, 58, 15);
	    contentPane.add(label);
	    
	    JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u8BC4\u4EF7\u5185\u5BB9");
	    label_1.setBounds(59, 302, 172, 15);
	    contentPane.add(label_1);
	    
	    JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u8BC4\u4EF7\u5185\u5BB9");
	    label_2.setBounds(59, 302, 58, 15);
	    contentPane.add(label_2);
	    
	    JLabel label_3 = new JLabel("\u8BF7\u8F93\u5165\u661F\u7EA7");
	    label_3.setBounds(59, 357, 141, 15);
	    contentPane.add(label_3);
	    
	    textField = new JTextField();
	    textField.setBounds(207, 299, 141, 21);
	    contentPane.add(textField);
	    textField.setColumns(10);
	    
	    textField_1 = new JTextField();
	    textField_1.setBounds(207, 354, 141, 21);
	    contentPane.add(textField_1);
	    textField_1.setColumns(10);
	    
	    JLabel label_4 = new JLabel("\u8BF7\u9009\u62E9\u8BA2\u5355\u8FDB\u884C\u8BC4\u4EF7");
	    label_4.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
	    label_4.setBounds(10, 240, 172, 23);
	    contentPane.add(label_4);
	    
	    JLabel label_5 = new JLabel("\u5BF9\u9A91\u624B\u7684\u661F\u7EA7\u8BC4\u4EF7");
	    label_5.setBounds(59, 404, 104, 15);
	    contentPane.add(label_5);
	    
	    textField_2 = new JTextField();
	    textField_2.setBounds(207, 401, 141, 21);
	    contentPane.add(textField_2);
	    textField_2.setColumns(10);
	    this.button.addActionListener(this);
	    this.button_1.addActionListener(this);
	    this.datadingdanPlan.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frmdingdan.this.datadingdanPlan.getSelectedRow();
				//int j=FrmUserlogin.this.datamanjianPlan.getSelectedRow();
				if(i<0) {
					return;
					
				}
				//else if(j<0)
					//return;
				//FrmUserlogin.this.reloadPlanStepTabel(i);
				uu = alldingdan.get(i);
			}
	    	
	    });
	    
	    this.reloaddingdanTable();
	}
	   
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.button)
		{
			Frmyonghujiemian frm  = new Frmyonghujiemian();
			frm.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==this.button_1)
		{
			String a1 = this.textField.getText();
			String a2 = this.textField_1.getText();
			String a3 = this.textField_2.getText();
			try {
				yonghuUttil.shangpinManger.pingjia(uu,a1,a2,a3);
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
		}
			Frmyonghujiemian frm1  = new Frmyonghujiemian();
			frm1.setVisible(true);
			this.setVisible(false);
	    }
}
}