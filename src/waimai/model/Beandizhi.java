package waimai.model;

public class Beandizhi {
	public static Beandizhi currentLoginUser=null;
	public static final String[] tbldizhiTitle={"地址编号","省","市","区","具体地址","联系人","电话"};
	public String getCell(int col){
		if(col==0) return ""+this.getDizhibianhao();
		else if(col==1) return ""+this.getSheng();
		else if(col==2) return ""+this.getShi();
		else if(col==3) return ""+this.getQu();
		else if(col==4) return ""+this.getDizhi();
		else if(col==5) return ""+this.getLianxiren();
		else if(col==6) return ""+this.getDianhua();
		else return "";
	}
       private int dizhibianhao;
       private int yonghubianhao;
       private String sheng;
       private String shi;
       private String qu;
       public String getQu() {
		return qu;
	}
	public void setQu(String qu) {
		this.qu = qu;
	}
	  private String dizhi;
       private String lianxiren;
       private String dianhua;
	public int getDizhibianhao() {
		return dizhibianhao;
	}
	public void setDizhibianhao(int dizhibianhao) {
		this.dizhibianhao = dizhibianhao;
	}
	public int getYonghubianhao() {
		return yonghubianhao;
	}
	public void setYonghubianhao(int yonghubianhao) {
		this.yonghubianhao = yonghubianhao;
	}
	public String getSheng() {
		return sheng;
	}
	public void setSheng(String sheng) {
		this.sheng = sheng;
	}
	public String getShi() {
		return shi;
	}
	public void setShi(String shi) {
		this.shi = shi;
	}
	public String getDizhi() {
		return dizhi;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public String getLianxiren() {
		return lianxiren;
	}
	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}
	public String getDianhua() {
		return dianhua;
	}
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	} 
}
