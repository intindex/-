package waimai.model;

import java.sql.Date;

public class Beanyouhuiquan {
	public static Beanyouhuiquan currentLoginUser=null;
	public static final String[] tblyouhuiquanTitle={"优惠金额","集单要求数","起始日期","结束日期"};
	public String getCell(int col){
		if(col==0) return ""+this.getYouhuijine();
		else if(col==1) return ""+this.getJidanyaoqiushu();
		else if(col==2) return ""+this.getQishiriqi();
		else if(col==3) return ""+this.getJieshuriqi();
		else return "";
	}
       private int youhuiquanbianhao;
       private double youhuijine;
       private int jidanyaoqiushu;
       private Date qishiriqi;
       private Date jieshuriqi;
       
       private int youhuiquanshuliang;

	public int getYouhuiquanshuliang() {
		return youhuiquanshuliang;
	}
	public void setYouhuiquanshuliang(int youhuiquanshuliang) {
		this.youhuiquanshuliang = youhuiquanshuliang;
	}
	public int getYouhuiquanbianhao() {
		return youhuiquanbianhao;
	}
	public void setYouhuiquanbianhao(int youhuiquanbianhao) {
		this.youhuiquanbianhao = youhuiquanbianhao;
	}
	public double getYouhuijine() {
		return youhuijine;
	}
	public void setYouhuijine(double youhuijine) {
		this.youhuijine = youhuijine;
	}
	public int getJidanyaoqiushu() {
		return jidanyaoqiushu;
	}
	public void setJidanyaoqiushu(int jidanyaoqiushu) {
		this.jidanyaoqiushu = jidanyaoqiushu;
	}
	public Date getQishiriqi() {
		return qishiriqi;
	}
	public void setQishiriqi(Date qishiriqi) {
		this.qishiriqi = qishiriqi;
	}
	public Date getJieshuriqi() {
		return jieshuriqi;
	}
	public void setJieshuriqi(Date jieshuriqi) {
		this.jieshuriqi = jieshuriqi;
	}
}
