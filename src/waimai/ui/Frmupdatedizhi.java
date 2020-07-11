package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import waimai.model.Beandizhi;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;

import javax.swing.JButton;

public class Frmupdatedizhi extends JFrame implements ActionListener{

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
					Frmupdatedizhi frame = new Frmupdatedizhi();
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
	JButton button = new JButton("\u589E\u52A0\u5730\u5740");
	JButton button_1 = new JButton("\u5220\u9664\u5730\u5740");
	Beandizhi uu = new Beandizhi();
	List<Beandizhi> ff = new ArrayList<Beandizhi>(); 
	public Frmupdatedizhi() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		button.setBounds(699, 55, 97, 23);
		contentPane.add(button);
		
		
		button_1.setBounds(699, 202, 97, 23);
		contentPane.add(button_1);
	    JScrollPane scrollPane2 = new JScrollPane(this.datadizhiPlan);
	    scrollPane2.setBounds(10, 10, 671,273 );
	    this.getContentPane().add(scrollPane2);
		this.reloaddizhiTable();
		this.button.addActionListener(this);
		this.button_1.addActionListener(this);
	    this.datadizhiPlan.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frmupdatedizhi.this.datadizhiPlan.getSelectedRow();
				//int j=FrmUserlogin.this.datamanjianPlan.getSelectedRow();
				if(i<0) {
					return;
					
				}
				//else if(j<0)
					//return;
				//FrmUserlogin.this.reloadPlanStepTabel(i);
				uu = alldizhi.get(i);
			}
	    	
	    });
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.button)
		{
			Frmadddizhi adddizhi = new Frmadddizhi();
			adddizhi.setVisible(true);
		}
		else if(e.getSource() == this.button_1)
		{
			try {
				Beandizhi.currentLoginUser = yonghuUttil.dizhiManger.deletedizhi(uu);
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
				}
			this.setVisible(false);
		}
		
	}

}
