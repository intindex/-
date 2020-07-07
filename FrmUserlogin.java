package waimai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import waimai.util.BaseException;
import waimai.model.Beanshangjiaxinxi;
import waimai.model.Beanshangpinxiangqing;
import waimai.start.yonghuUttil;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmUserlogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	List <Beanshangjiaxinxi> allshangjia = null;
	private Object tblshangjiaData[][];
	DefaultTableModel tabshangjiaModel=new DefaultTableModel();
	private Object tblshangjiaTitle[]=Beanshangjiaxinxi.tblshangjiaTitle;
	private JTable datashangjiaPlan=new JTable(tabshangjiaModel);
	private  void reloadshangjiaTable() {
		try {
			allshangjia = yonghuUttil.shangjiaManger.loadall();
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblshangjiaData =  new Object[allshangjia.size()][Beanshangjiaxinxi.tblshangjiaTitle.length];
		for(int i=0;i<allshangjia.size();i++){
			for(int j=0;j<Beanshangjiaxinxi.tblshangjiaTitle.length;j++)
				tblshangjiaData[i][j]=allshangjia.get(i).getCell(j);
		}
		tabshangjiaModel.setDataVector(tblshangjiaData,tblshangjiaTitle);
		this.datashangjiaPlan.validate();
		this.datashangjiaPlan.repaint();
	}
	/**
	 * Create the frame.
	 */
	private Object tblshangpinTitle[]=Beanshangpinxiangqing.tblshangpinxiangqingTitle;
	private Object tblshangpinData[][];
    private Beanshangjiaxinxi curPlan=null;
	List<Beanshangpinxiangqing> planSteps=null;
	DefaultTableModel tabshangpinModel=new DefaultTableModel();
	private JTable datashangpinStep=new JTable(tabshangpinModel);
	private void reloadPlanStepTabel(int planIdx){
		if(planIdx<0) return;
		curPlan= allshangjia.get(planIdx);
		try {
			planSteps=yonghuUttil.shangpinManger.loadall(curPlan);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblshangpinData =new Object[planSteps.size()][Beanshangpinxiangqing.tblshangpinxiangqingTitle.length];
		for(int i=0;i<planSteps.size();i++){
			for(int j=0;j<Beanshangpinxiangqing.tblshangpinxiangqingTitle.length;j++)
				tblshangpinData[i][j]=planSteps.get(i).getCell(j);
		}
		
		tabshangpinModel.setDataVector(tblshangpinData,tblshangpinTitle);
		this.datashangpinStep.validate();
		this.datashangpinStep.repaint();
	}
	public FrmUserlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/*table = new JTable();
		table.setBounds(84, 76, 258, 100);
		contentPane.add(table);*/
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(this.datashangjiaPlan);
		scrollPane.setBounds(0, 40, 629, 192);
	    this.getContentPane().add(scrollPane);
	    JScrollPane scrollPane1 = new JScrollPane(this.datashangpinStep);
	    scrollPane1.setBounds(634, 40, 122, 192);
	    this.getContentPane().add(scrollPane1);
	    JLabel label = new JLabel("\u70B9\u5355");
	    label.setBounds(10, 10, 58, 15);
	    contentPane.add(label);
	    this.datashangjiaPlan.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=FrmUserlogin.this.datashangjiaPlan.getSelectedRow();
				if(i<0) {
					return;
					
				}
				FrmUserlogin.this.reloadPlanStepTabel(i);
			}
	    	
	    });
	    this.reloadshangjiaTable();
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUserlogin frame = new FrmUserlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
}
