package waimai.model;

import java.sql.Date;

public class Beanqishouxinxi {
   public static Beanqishouxinxi currentLoginUser = null;
	public static final String[] tblqishouTitle={"骑手编号","骑手姓名","入职日期","身份","以接单数量"};
	public String getCell(int col){
		if(col==0) return ""+this.getQishoubianahao();
		else if(col==1) return ""+this.getQishouname();
		else if(col==2) return ""+this.getRuzhiriqi();
		else if(col==3) return ""+this.getQishoushenfen();
		else if(col==4) return ""+this.getJiedanshuliang();
		else return "";
	}
   private int qishoubianahao;
   private String qishouname;
   private Date ruzhiriqi;
   private String qishoushenfen;
   private int jiedanshuliang;
public int getJiedanshuliang() {
	return jiedanshuliang;
}
public void setJiedanshuliang(int jiedanshuliang) {
	this.jiedanshuliang = jiedanshuliang;
}
public int getQishoubianahao() {
	return qishoubianahao;
}
public void setQishoubianahao(int qishoubianahao) {
	this.qishoubianahao = qishoubianahao;
}
public String getQishouname() {
	return qishouname;
}
public void setQishouname(String qishouname) {
	this.qishouname = qishouname;
}
public Date getRuzhiriqi() {
	return ruzhiriqi;
}
public void setRuzhiriqi(Date ruzhiriqi) {
	this.ruzhiriqi = ruzhiriqi;
}
public String getQishoushenfen() {
	return qishoushenfen;
}
public void setQishoushenfen(String qishoushenfen) {
	this.qishoushenfen = qishoushenfen;
}
}
