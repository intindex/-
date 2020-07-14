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
import waimai.model.Beanyouhuiquan;
import waimai.start.yonghuUttil;
import waimai.util.BaseException;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Frmyouhuiquan extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmyouhuiquan frame = new Frmyouhuiquan();
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
	Beanyouhuiquan gg = new Beanyouhuiquan();
	List <Beanyouhuiquan> allyouhuiquan = null;
	private Object tblyouhuiquanData[][];
	DefaultTableModel tabyouhuiquanModel=new DefaultTableModel();
	private Object tblyouhuiquanTitle[]=Beanyouhuiquan.tblyouhuiquanTitle;
	private JTable datayouhuiquanPlan=new JTable(tabyouhuiquanModel);
	private final JLabel lblNewLabel = new JLabel("\u9886\u53D6\u4F18\u60E0\u5238");
	private final JButton button = new JButton("\u786E\u8BA4");
	private  void reloadyouhuiquanTable() {
		try {
			allyouhuiquan = yonghuUttil.youhuiquanManger.loadall();
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblyouhuiquanData =  new Object[allyouhuiquan.size()][Beanyouhuiquan.tblyouhuiquanTitle.length];
		for(int i=0;i<allyouhuiquan.size();i++){
			for(int j=0;j<Beanmanjian.tblmanjianTitle.length;j++)
				tblyouhuiquanData[i][j]=allyouhuiquan.get(i).getCell(j);
		}
		tabyouhuiquanModel.setDataVector(tblyouhuiquanData,tblyouhuiquanTitle);
		this.datayouhuiquanPlan.validate();
		this.datayouhuiquanPlan.repaint();
	}
	JButton button_1 = new JButton("\u8FD4\u56DE");
	public Frmyouhuiquan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(this.datayouhuiquanPlan);
		scrollPane.setBounds(0, 0, 367, 216);
	    this.getContentPane().add(scrollPane);
	    lblNewLabel.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
	    lblNewLabel.setBounds(390, 65, 158, 38);
	    
	    contentPane.add(lblNewLabel);
	    button.setBounds(390, 171, 97, 23);
	    
	    contentPane.add(button);
	    
	    
	    button_1.setBounds(390, 232, 97, 23);
	    contentPane.add(button_1);
	    this.reloadyouhuiquanTable();
	    this.button.addActionListener(this);
	    this.button_1.addActionListener(this);
	    this.datayouhuiquanPlan.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frmyouhuiquan.this.datayouhuiquanPlan.getSelectedRow();
				//int j=FrmUserlogin.this.datamanjianPlan.getSelectedRow();
				if(i<0) {
					return;
					
				}
				//else if(j<0)
					//return;
			gg = allyouhuiquan.get(i);
			}
	    	
	    });
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getSource()==this.button)
	{
		try {
			Beanyouhuiquan.currentLoginUser = yonghuUttil.youhuiquanManger.lingqu(gg);
		}catch (BaseException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "´íÎó",JOptionPane.ERROR_MESSAGE);
			return;
			
	}
        Frmyonghujiemian tt = new Frmyonghujiemian();
        tt.setVisible(true);
        this.setVisible(false);
	}
	else if(e.getSource()==this.button_1)
	{
        Frmyonghujiemian tt = new Frmyonghujiemian();
        tt.setVisible(true);
        this.setVisible(false);
	}

}
}
