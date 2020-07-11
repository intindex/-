package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import waimai.model.Beanmanjian;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;

public class Frmdeletemanjian extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmdeletemanjian frame = new Frmdeletemanjian();
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
	List <Beanmanjian> allmanjian = null;
	private Object tblmanjianData[][];
	DefaultTableModel tabmanjianModel=new DefaultTableModel();
	private Object tblmanjianTitle[]=Beanmanjian.tblmanjianTitle;
	private JTable datamanjianPlan=new JTable(tabmanjianModel);
	private  void reloadmanjianTable() {
		try {
			allmanjian = yonghuUttil.manjianManger.loadall();
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblmanjianData =  new Object[allmanjian.size()][Beanmanjian.tblmanjianTitle.length];
		for(int i=0;i<allmanjian.size();i++){
			for(int j=0;j<Beanmanjian.tblmanjianTitle.length;j++)
				tblmanjianData[i][j]=allmanjian.get(i).getCell(j);
		}
		tabmanjianModel.setDataVector(tblmanjianData,tblmanjianTitle);
		this.datamanjianPlan.validate();
		this.datamanjianPlan.repaint();
	}
	Beanmanjian uu = new Beanmanjian(); 
	JButton button = new JButton("\u786E\u8BA4");
	public Frmdeletemanjian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6EE1\u51CF\u65B9\u6848\u5220\u9664\u754C\u9762");
		label.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		label.setBounds(28, 10, 184, 32);
		contentPane.add(label);
	    JScrollPane scrollPane2 = new JScrollPane(this.datamanjianPlan);
	    scrollPane2.setBounds(10, 78, 671,273 );
	    this.getContentPane().add(scrollPane2);
	    
	    JLabel label_1 = new JLabel("\u8BF7\u9009\u62E9\u4E00\u6761\u65B9\u6848\u5220\u9664");
	    label_1.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
	    label_1.setBounds(400, 387, 206, 32);
	    contentPane.add(label_1);
	    
	    
	    button.setBounds(675, 432, 97, 23);
	    contentPane.add(button);
	    this.button.addActionListener(this);
	    this.reloadmanjianTable();
	    this.datamanjianPlan.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frmdeletemanjian.this.datamanjianPlan.getSelectedRow();
				//int j=FrmUserlogin.this.datamanjianPlan.getSelectedRow();
				if(i<0) {
					return;
					
				}
				//else if(j<0)
					//return;
				//FrmUserlogin.this.reloadPlanStepTabel(i);
				uu = allmanjian.get(i);
			}
	    	
	    });
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getSource()==this.button)
	{
		try {
			Beanmanjian.currentLoginUser = yonghuUttil.manjianManger.deletemanjian(uu);
		}catch (BaseException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
			return;
			}
		this.setVisible(false);
	}
	}
	}


