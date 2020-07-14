package waimai.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Beandingdan {
	public static Beandingdan currentLoginUser=null;
	public static final String[] tbldingdanTitle={"骑手编号","原始金额","结算金额","送达时间","订单状态"};
	public String getCell(int col){
		if(col==0) return ""+this.getQishoubianhao();
		else if(col==1) return ""+this.getYuanshijine();
		else if(col==2) return ""+this.getJiesuanjine();
		else if(col==3) return ""+this.getSongdashijian();
		else if(col==4) return ""+this.getDingdanzhuangtai();
		else return "";
	}
	private int dingdanbianhao;
	private int shangjiabianhao;
	private int yonghubianhao;
	
	public int getShangjiabianhao() {
		return shangjiabianhao;
	}
	public void setShangjiabianhao(int shangjiabianhao) {
		this.shangjiabianhao = shangjiabianhao;
	}
	public int getYonghubianhao() {
		return yonghubianhao;
	}
	public void setYonghubianhao(int yonghubianhao) {
		this.yonghubianhao = yonghubianhao;
	}
	public static String[] getTbldingdantitle() {
		return tbldingdanTitle;
	}
	public int getDingdanbianhao() {
		return dingdanbianhao;
	}
	public void setDingdanbianhao(int dingdanbianhao) {
		this.dingdanbianhao = dingdanbianhao;
	}
	private int qishoubianhao;
	private double yuanshijine;
	private double jiesuanjine;
	private Timestamp songdashijian;
	private String dingdanzhuangtai;
	public int getQishoubianhao() {
		return qishoubianhao;
	}
	public void setQishoubianhao(int qishoubianhao) {
		this.qishoubianhao = qishoubianhao;
	}
	public double getYuanshijine() {
		return yuanshijine;
	}
	public void setYuanshijine(double yuanshijine) {
		this.yuanshijine = yuanshijine;
	}
	public double getJiesuanjine() {
		return jiesuanjine;
	}
	public void setJiesuanjine(double jiesuanjine) {
		this.jiesuanjine = jiesuanjine;
	}
	public Timestamp getSongdashijian() {
		return songdashijian;
	}
	public void setSongdashijian(Timestamp songdashijian) {
		this.songdashijian = songdashijian;
	}
	public String getDingdanzhuangtai() {
		return dingdanzhuangtai;
	}
	public void setDingdanzhuangtai(String dingdanzhuangtai) {
		this.dingdanzhuangtai = dingdanzhuangtai;
	}
}
