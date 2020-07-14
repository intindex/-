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
import waimai.model.Beanmanjian;
import waimai.model.Beanshangjiaxinxi;
import waimai.model.Beanshangpinxiangqing;
import waimai.start.yonghuUttil;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class FrmUserlogin extends JFrame implements ActionListener{

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
			JOptionPane.showMessageDialog(null, e.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showMessageDialog(null, e.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
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
	 JButton btnNewButton = new JButton("\u786E\u8BA4");
	 JButton button = new JButton("\u4E2A\u4EBA\u4E2D\u5FC3");
	 private final JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u8D2D\u4E70\u7684\u5546\u54C1\u6570\u91CF");
	 private final JTextField textField = new JTextField();
	 private final JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u6EE1\u51CF\u7F16\u53F7");
	 private final JLabel label_3 = new JLabel("\u6EE1\u51CF\u65B9\u6848");
	 private final JTextField textField_2 = new JTextField();
	public FrmUserlogin() {
		textField_2.setBounds(495, 293, 134, 21);
		textField_2.setColumns(10);
		textField.setBounds(21, 293, 149, 21);
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(this.datashangjiaPlan);
		scrollPane.setBounds(0, 40, 629, 206);
	    this.getContentPane().add(scrollPane);
	    JScrollPane scrollPane1 = new JScrollPane(this.datashangpinStep);
	    scrollPane1.setBounds(634, 40, 122, 192);
	    this.getContentPane().add(scrollPane1);
	    JScrollPane scrollPane2 = new JScrollPane(this.datamanjianPlan);
	    scrollPane2.setBounds(220, 295, 218,131 );
	    this.getContentPane().add(scrollPane2);
	    //JButton btnNewButton = new JButton("\u9009\u62E9\u5546\u54C1\u4E0B\u5355");
	    btnNewButton.setBounds(608, 408, 138, 41);
	    contentPane.add(btnNewButton);
	    
	    
	    button.setBounds(10, 7, 97, 23);
	    contentPane.add(button);
	    label.setBounds(21, 256, 194, 15);
	    
	    contentPane.add(label);
	    
	    contentPane.add(textField);
	    label_2.setBounds(495, 256, 143, 15);
	    
	    contentPane.add(label_2);
	    label_3.setBounds(220, 256, 58, 15);
	    
	    contentPane.add(label_3);
	    
	    contentPane.add(textField_2);
	    this.btnNewButton.addActionListener(this);
	    this.button.addActionListener(this);
	    this.datashangjiaPlan.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=FrmUserlogin.this.datashangjiaPlan.getSelectedRow();
				//int j=FrmUserlogin.this.datamanjianPlan.getSelectedRow();
				if(i<0) {
					return;
					
				}
				//else if(j<0)
					//return;
				FrmUserlogin.this.reloadPlanStepTabel(i);
			}
	    	
	    });
	    this.reloadshangjiaTable();
	    this.reloadmanjianTable();
		
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnNewButton)
		{
			
			//String nString = this.textField.getText();
			int mString =0;
			int nString=0;
			try {
				mString=Integer.parseInt(this.textField_2.getText());
				nString =Integer.parseInt(this.textField.getText());
			}catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Êý×Ö²»ÄÜÎª¿Õ", "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			//FrmUserlogin rFrmUserlogin = new FrmUserlogin();
			//rFrmUserlogin.setVisible(true);
			int i=FrmUserlogin.this.datashangpinStep.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null, "ÇëÑ¡Ôñ²½Öè", "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				yonghuUttil.shangpinManger.xiadan(this.planSteps.get(i),nString,mString);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
			}
			Frmdizhi dd = new Frmdizhi();
			dd.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==this.button)
		{
			Frmyonghujiemian sFrmyonghujiemian = new Frmyonghujiemian();
			sFrmyonghujiemian.setVisible(true);
		}
		
	}
}
