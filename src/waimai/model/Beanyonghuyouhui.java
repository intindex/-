package waimai.model;

import java.sql.Date;

public class Beanyonghuyouhui {
	public static final String[] tblyonghuyouhuiTitle={"优惠券编号","优惠金额","截止日期"};
	public String getCell(int col){
		if(col==0) return ""+this.getYouhuiquanbianhao();
		else if(col==1) return ""+this.getYouhuijine();
		else if(col==2) return ""+this.getJiezhiriqiDate();
		else return "";
	}
    private int yonghubianhao;
    private int youhuiquanbianhao;
    //private int shangjiabianhao;
    private double youhuijine;
    private int shuliang;
    private Date jiezhiriqiDate;
	public int getYonghubianhao() {
		return yonghubianhao;
	}
	public void setYonghubianhao(int yonghubianhao) {
		this.yonghubianhao = yonghubianhao;
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
	public int getShuliang() {
		return shuliang;
	}
	public void setShuliang(int shuliang) {
		this.shuliang = shuliang;
	}
	public Date getJiezhiriqiDate() {
		return jiezhiriqiDate;
	}
	public void setJiezhiriqiDate(Date jiezhiriqiDate) {
		this.jiezhiriqiDate = jiezhiriqiDate;
	}
    
}
