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
	public Frmdizhi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	    contentPane.setLayout(null);
	    JScrollPane scrollPane2 = new JScrollPane(this.datadizhiPlan);
	    scrollPane2.setBounds(10, 10, 671,273 );
	    this.getContentPane().add(scrollPane2);
	    
	    JLabel label = new JLabel("\u8BF7\u8F93\u5165\u5730\u5740\u7F16\u53F7");
	    label.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
	    label.setBounds(10, 313, 140, 36);
	    contentPane.add(label);
	    
	    textField = new JTextField();
	    textField.setBounds(222, 323, 150, 21);
	    contentPane.add(textField);
	    textField.setColumns(10);
	    
	    
	    button.setBounds(705, 322, 97, 23);
	    contentPane.add(button);
	    this.reloaddizhiTable();
	    this.button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.button)
		{
			String string = this.textField.getText();
			try {
				Beandizhi.currentLoginUser = yonghuUttil.dizhiManger.insertdizhi(Integer.valueOf(string));
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
				}
			this.setVisible(false);
		}
		
	}
}
