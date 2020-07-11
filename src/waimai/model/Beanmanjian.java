package waimai.model;

public class Beanmanjian {
	public static Beanmanjian currentLoginUser=null;
	public static final String[] tblmanjianTitle={"Âú¼õ±àºÅ","Âú¼õ½ð¶î","ÓÅ»Ý½ð¶î","ÊÇ·ñ¿Éµþ¼Ó"};
	public String getCell(int col){
		if(col==0) return ""+this.getManjianbiaohao();
		else if(col==1) return ""+this.getManjianjine();
		else if(col==2) return ""+this.getYouhuijine();
		else if(col==3) return ""+this.getShifoudiejiaString();
		else return "";
	}
       private int manjianbiaohao;
       private double manjianjine;
       private double youhuijine;
       private String shifoudiejiaString;
	public int getManjianbiaohao() {
		return manjianbiaohao;
	}
	public void setManjianbiaohao(int manjianbiaohao) {
		this.manjianbiaohao = manjianbiaohao;
	}
	public double getManjianjine() {
		return manjianjine;
	}
	public void setManjianjine(double manjianjine) {
		this.manjianjine = manjianjine;
	}
	public double getYouhuijine() {
		return youhuijine;
	}
	public void setYouhuijine(double youhuijine) {
		this.youhuijine = youhuijine;
	}
	public String getShifoudiejiaString() {
		return shifoudiejiaString;
	}
	public void setShifoudiejiaString(String shifoudiejiaString) {
		this.shifoudiejiaString = shifoudiejiaString;
	}
       
}
