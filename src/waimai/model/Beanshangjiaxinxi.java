package waimai.model;

public class Beanshangjiaxinxi {
	public static final String[] tblshangjiaTitle={"�̼ұ��","����","�Ǽ�","������"};
	/**
	 * �����и���javabean������޸ı��������룬col��ʾ�������е�����ţ�0��ʼ
	 */
	public String getCell(int col){
		if(col==0) return ""+this.getShangjiabianhao();
		else if(col==1) return ""+this.getShangjianame();
		else if(col==2) return ""+this.getShangjiaxingji();
		else if(col==3) return ""+this.getZongxiaoliang();		
		else return "";
	}
   public static Beanshangjiaxinxi currentLoginUser = null;
   private int shangjiabianhao;
   private String shangjianame;
   private String shangjiaxingji;
   private String renjunxiaofei;
   private String zongxiaoliang;
public int getShangjiabianhao() {
	return shangjiabianhao;
}
public void setShangjiabianhao(int i) {
	this.shangjiabianhao = i;
}
public String getShangjianame() {
	return shangjianame;
}
public void setShangjianame(String shangjianame) {
	this.shangjianame = shangjianame;
}
public String getShangjiaxingji() {
	return shangjiaxingji;
}
public void setShangjiaxingji(String shangjiaxingji) {
	this.shangjiaxingji = shangjiaxingji;
}
public String getRenjunxiaofei() {
	return renjunxiaofei;
}
public void setRenjunxiaofei(String renjunxiaofei) {
	this.renjunxiaofei = renjunxiaofei;
}
public String getZongxiaoliang() {
	return zongxiaoliang;
}
public void setZongxiaoliang(String zongxiaoliang) {
	this.zongxiaoliang = zongxiaoliang;
}
}
