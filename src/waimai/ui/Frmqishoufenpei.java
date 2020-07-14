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

import waimai.model.Beanmanjian;
import waimai.model.Beanqishouxinxi;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frmqishoufenpei extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmqishoufenpei frame = new Frmqishoufenpei();
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
	Beanqishouxinxi uu = new Beanqishouxinxi();
	List <Beanqishouxinxi> allqishou = null;
	private Object tblqishouData[][];
	DefaultTableModel tabqishouModel=new DefaultTableModel();
	private Object tblqishouTitle[]=Beanqishouxinxi.tblqishouTitle;
	private JTable dataqishouPlan=new JTable(tabqishouModel);
	private  void reloadqishouTable() {
		try {
			allqishou = yonghuUttil.qishouManger.loadall();
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblqishouData =  new Object[allqishou.size()][Beanqishouxinxi.tblqishouTitle.length];
		for(int i=0;i<allqishou.size();i++){
			for(int j=0;j<Beanqishouxinxi.tblqishouTitle.length;j++)
				tblqishouData[i][j]=allqishou.get(i).getCell(j);
		}
		tabqishouModel.setDataVector(tblqishouData,tblqishouTitle);
		this.dataqishouPlan.validate();
		this.dataqishouPlan.repaint();
	}
	JButton button = new JButton("\u786E\u8BA4");
	private final JButton button_1 = new JButton("\u8FD4\u56DE");
	public Frmqishoufenpei() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(this.dataqishouPlan);
		scrollPane.setBounds(10, 10, 512, 303);
	    this.getContentPane().add(scrollPane);
	    
	    JLabel label = new JLabel("\u9009\u62E9\u63A5\u5355\u7684\u9A91\u624B");
	    label.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
	    label.setBounds(371, 340, 134, 22);
	    contentPane.add(label);
	    
	    
	    button.setBounds(523, 341, 97, 23);
	    contentPane.add(button);
	    button_1.setBounds(523, 285, 97, 23);
	    
	    contentPane.add(button_1);
	    this.button.addActionListener(this);
	    this.button_1.addActionListener(this);
	    this.dataqishouPlan.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frmqishoufenpei.this.dataqishouPlan.getSelectedRow();
				//int j=FrmUserlogin.this.datamanjianPlan.getSelectedRow();
				if(i<0) {
					return;
					
				}
				//else if(j<0)
					//return;
				//FrmUserlogin.this.reloadPlanStepTabel(i);
				uu = allqishou.get(i);
			}
	    	
	    });
	    this.reloadqishouTable();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.button)
		{
			try {
				Beanqishouxinxi.currentLoginUser = yonghuUttil.qishouManger.jiedan(uu);
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
				return;
				
		}
			Frmshangjia dad = new Frmshangjia();
			dad.setVisible(true);
			this.setVisible(false);
	    }
		else if(e.getSource()==this.button_1)
		{
			Frmshangjia dad = new Frmshangjia();
			dad.setVisible(true);
			this.setVisible(false);
		}

}
}
