package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import waimai.model.Beandizhi;
import waimai.model.Beanshangjiaxinxi;
import waimai.model.Beanyonghuyouhui;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Frmdizhi extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	List <Beandizhi> alldizhi = null;
	private Object tbldizhiData[][];
	DefaultTableModel tabdizhiModel=new DefaultTableModel();
	private Object tbldizhiTitle[]=Beandizhi.tbldizhiTitle;
	private JTable datadizhiPlan=new JTable(tabdizhiModel);
	private JTextField textField;
	private  void reloaddizhiTable() {
		try {
			alldizhi = yonghuUttil.dizhiManger.loadall();
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tbldizhiData =  new Object[alldizhi.size()][Beandizhi.tbldizhiTitle.length];
		for(int i=0;i<alldizhi.size();i++){
			for(int j=0;j<Beandizhi.tbldizhiTitle.length;j++)
				tbldizhiData[i][j]=alldizhi.get(i).getCell(j);
		}
		tabdizhiModel.setDataVector(tbldizhiData,tbldizhiTitle);
		this.datadizhiPlan.validate();
		this.datadizhiPlan.repaint();
	}
	List <Beanyonghuyouhui> allyonghuyouhui = null;
	private Object tblyonghuyouhuiData[][];
	DefaultTableModel tabyonghuyouhuiModel=new DefaultTableModel();
	private Object tblyonghuyouhuiTitle[]=Beanyonghuyouhui.tblyonghuyouhuiTitle;
	private JTable datayonghuyouhuiPlan=new JTable(tabyonghuyouhuiModel);
	//private JTextField textField;
	private  void reloadyonghuyouhuiTable() {
		try {
			allyonghuyouhui = yonghuUttil.yonghuyouhuiManger.loadall();
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblyonghuyouhuiData =  new Object[allyonghuyouhui.size()][Beanyonghuyouhui.tblyonghuyouhuiTitle.length];
		for(int i=0;i<allyonghuyouhui.size();i++){
			for(int j=0;j<Beanyonghuyouhui.tblyonghuyouhuiTitle.length;j++)
				tblyonghuyouhuiData[i][j]=allyonghuyouhui.get(i).getCell(j);
		}
		tabyonghuyouhuiModel.setDataVector(tblyonghuyouhuiData,tblyonghuyouhuiTitle);
		this.datayonghuyouhuiPlan.validate();
		this.datayonghuyouhuiPlan.repaint();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmdizhi frame = new Frmdizhi();
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
	private final JLabel label_1 = new JLabel("\u8BF7\u9009\u62E9\u4F7F\u7528\u7684\u4F18\u60E0\u5238");
	private final JTextField textField_1 = new JTextField();
	private final JButton button_1 = new JButton("\u8FD4\u56DE");
	public Frmdizhi() {
		textField_1.setBounds(221, 449, 150, 21);
		textField_1.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	    contentPane.setLayout(null);
	    JScrollPane scrollPane2 = new JScrollPane(this.datadizhiPlan);
	    scrollPane2.setBounds(10, 10, 671,273 );
	    this.getContentPane().add(scrollPane2);
	    JScrollPane scrollPane = new JScrollPane(this.datayonghuyouhuiPlan);
	    scrollPane.setBounds(10, 293, 671,120 );
	    this.getContentPane().add(scrollPane);
	    JLabel label = new JLabel("\u8BF7\u8F93\u5165\u5730\u5740\u7F16\u53F7");
	    label.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
	    label.setBounds(10, 481, 140, 36);
	    contentPane.add(label);
	    
	    textField = new JTextField();
	    textField.setBounds(221, 491, 150, 21);
	    contentPane.add(textField);
	    textField.setColumns(10);
	    
	    
	    button.setBounds(706, 490, 97, 23);
	    contentPane.add(button);
	    label_1.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
	    label_1.setBounds(10, 446, 188, 23);
	    
	    contentPane.add(label_1);
	    
	    contentPane.add(textField_1);
	    button_1.setBounds(584, 490, 97, 23);
	    
	    contentPane.add(button_1);
	    this.reloaddizhiTable();
	    this.reloadyonghuyouhuiTable();
	    this.button.addActionListener(this);
	    this.button_1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.button)
		{
			String string = this.textField.getText();
			String ff = this.textField_1.getText();
			try {
				Beandizhi.currentLoginUser = yonghuUttil.dizhiManger.insertdizhi(Integer.valueOf(string),Integer.valueOf(ff));
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
				}
			this.setVisible(false);
		}
		else if(e.getSource()==this.button_1)
		{
			FrmUserlogin uu = new FrmUserlogin();
			uu.setVisible(true);
			this.setVisible(false);
		}
		
	}
}
