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

import waimai.model.Beanshangjiaxinxi;
import waimai.model.Beanyonghuxinxi;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Frmyonghujiemian extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmyonghujiemian frame = new Frmyonghujiemian();
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
	
	List <Beanyonghuxinxi> allyonghu = null;
	private Object tblyonghuData[][];
	DefaultTableModel tabyonghuModel=new DefaultTableModel();
	private Object tblyonghuTitle[]=Beanyonghuxinxi.tblyonghuTitle;
	private JTable datayonghuPlan=new JTable(tabyonghuModel);
	private JLabel label;
	 
	
	private  void reloadyonghuTable() {
		try {
			allyonghu = yonghuUttil.yonghuManager.load();
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblyonghuData =  new Object[allyonghu.size()][Beanyonghuxinxi.tblyonghuTitle.length];
		for(int i=0;i<allyonghu.size();i++){
			for(int j=0;j<Beanyonghuxinxi.tblyonghuTitle.length;j++)
				tblyonghuData[i][j]=allyonghu.get(i).getCell(j);
		}
		tabyonghuModel.setDataVector(tblyonghuData,tblyonghuTitle);
		this.datayonghuPlan.validate();
		this.datayonghuPlan.repaint();
	}
	JButton btnNewButton = new JButton("\u5546\u5BB6\u4FE1\u606F");
	JButton button = new JButton("\u5BC6\u7801\u4FEE\u6539");
	JButton button_1 = new JButton("\u7F16\u8F91\u5730\u5740");
	private final JButton button_2 = new JButton("\u67E5\u770B\u8BA2\u5355");
	private final JButton btnNewButton_1 = new JButton("\u9886\u53D6\u4F18\u60E0\u5238");
	public Frmyonghujiemian() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(this.datayonghuPlan);
		scrollPane.setBounds(0, 40, 629, 192);
	    this.getContentPane().add(scrollPane);
	    
	    label = new JLabel("\u4E2A\u4EBA\u4FE1\u606F");
	    label.setBounds(10, 10, 58, 15);
	    contentPane.add(label);
	    
	    //btnNewButton = new JButton("\u5546\u5BB6\u4FE1\u606F");
	    btnNewButton.setBounds(712, 288, 97, 23);
	    contentPane.add(btnNewButton);
	    
	    
	    button.setBounds(605, 288, 97, 23);
	    contentPane.add(button);
	    
	    
	    button_1.setBounds(498, 288, 97, 23);
	    contentPane.add(button_1);
	    button_2.setBounds(391, 288, 97, 23);
	    
	    contentPane.add(button_2);
	    btnNewButton_1.setBounds(255, 288, 126, 23);
	    
	    contentPane.add(btnNewButton_1);
	    this.btnNewButton.addActionListener(this);
	    this.button.addActionListener(this);
	    this.button_1.addActionListener(this);
	    this.button_2.addActionListener(this);
	    this.btnNewButton_1.addActionListener(this);
	    this.datayonghuPlan.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frmyonghujiemian.this.datayonghuPlan.getSelectedRow();
				if(i<0) {
					return;
					
				}
			}
	    	
	    });
	    this.reloadyonghuTable();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnNewButton)
		{
			FrmUserlogin pFrmUserlogin  = new FrmUserlogin();
			pFrmUserlogin.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==this.button)
		{
			Frmupdatepwd dddFrmupdatepwd = new Frmupdatepwd();
			dddFrmupdatepwd.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==this.button_1)
		{
			Frmupdatedizhi dizhi = new Frmupdatedizhi();
			dizhi.setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==this.button_2)
		{
				Frmdingdan aa = new Frmdingdan();
				aa.setVisible(true);
				this.setVisible(false);
		}
		else if(e.getSource()==this.btnNewButton_1)
		{
			Frmyouhuiquan fy = new Frmyouhuiquan();
			fy.setVisible(true);
			this.setVisible(false);
		}
	}
}
