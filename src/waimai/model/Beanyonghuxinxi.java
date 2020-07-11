package waimai.model;

import java.sql.Date;

public class Beanyonghuxinxi {
	public static final String[] tblyonghuTitle={"姓名","性别","手机号","城市","是否会员"};
	public String getCell(int col){
		if(col==0) return ""+this.getName();
		else if(col==1) return ""+this.getSex();
		else if(col==2) return ""+this.getShoujihaoma();
		else if(col==3) return ""+this.getCity();
		else if(col==4) return ""+this.getHuiyuan();
		else return "";
	}
   public static Beanyonghuxinxi currentLoginUser=null;
   private int yonghubianhao;
   private String name;
   private String sex;
   private String mima;
   private String shoujihaoma;
   private String youxiang;
   private String city;
   private Date zhuceshijian;
   private Date huiyuanjiezhiriqi;
   private String huiyuan;
public String getHuiyuan() {
	return huiyuan;
}
public void setHuiyuan(String huiyuan) {
	this.huiyuan = huiyuan;
}
public int getYonghubianhao() {
	return yonghubianhao;
}
public void setYonghubianhao(int yonghubianhao) {
	this.yonghubianhao = yonghubianhao;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getMima() {
	return mima;
}
public void setMima(String mima) {
	this.mima = mima;
}
public String getShoujihaoma() {
	return shoujihaoma;
}
public void setShoujihaoma(String shoujihaoma) {
	this.shoujihaoma = shoujihaoma;
}
public String getYouxiang() {
	return youxiang;
}
public void setYouxiang(String youxiang) {
	this.youxiang = youxiang;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Date getZhuceshijian() {
	return zhuceshijian;
}
public void setZhuceshijian(Date zhuceshijian) {
	this.zhuceshijian = zhuceshijian;
}
public Date getHuiyuanjiezhiriqi() {
	return huiyuanjiezhiriqi;
}
public void setHuiyuanjiezhiriqi(Date huiyuanjiezhiriqi) {
	this.huiyuanjiezhiriqi = huiyuanjiezhiriqi;
}
}
