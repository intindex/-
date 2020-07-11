package waimai.model;

public class Beanshangpinxiangqing {
	public static Beanshangpinxiangqing currentLoginUser=null;
	public static final String[] tblshangpinxiangqingTitle={"商品名称","价格"};
	public String getCell(int col){
		if(col==0) return ""+this.getShanpinname();
		else if(col==1) return ""+this.getJiage();	
		else return "";
	}
	private int sahngpinbianhao;
	private String fenleibianhao;
	private String shanpinname;
	private String jiage;
	private int shangjiabianhao;
	private int order_id;
	private int shuliang;
	public int getShuliang() {
		return shuliang;
	}
	public void setShuliang(int shuliang) {
		this.shuliang = shuliang;
	}
	public int getSahngpinbianhao() {
		return sahngpinbianhao;
	}
	public void setSahngpinbianhao(int sahngpinbianhao) {
		this.sahngpinbianhao = sahngpinbianhao;
	}
	public String getFenleibianhao() {
		return fenleibianhao;
	}
	public void setFenleibianhao(String fenleibianhao) {
		this.fenleibianhao = fenleibianhao;
	}
	public String getShanpinname() {
		return shanpinname;
	}
	public void setShanpinname(String shanpinname) {
		this.shanpinname = shanpinname;
	}
	public String getJiage() {
		return jiage;
	}
	public void setJiage(String jiage) {
		this.jiage = jiage;
	}
	public int getShangjiabianhao() {
		return shangjiabianhao;
	}
	public void setShangjiabianhao(int shangjiabianhao) {
		this.shangjiabianhao = shangjiabianhao;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public static String[] getTblshangpinxiangqingtitle() {
		return tblshangpinxiangqingTitle;
	}
}
