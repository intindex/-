package waimai.start;


import waimai.control.yonghuManger;
import waimai.itf.IdingdanManger;
import waimai.itf.Idizhimanger;
import waimai.itf.ImanjianManger;
import waimai.itf.IqishouManger;
import waimai.itf.IshangjiaManger;
import waimai.itf.IshangpinManger;
import waimai.itf.IuserManger;
import waimai.itf.IyonghuManger;
import waimai.itf.IyonghuyouhuiManger;
import waimai.itf.IyouhuiquanManger;
import waimai.control.userManger;
import waimai.control.qishouManger;
import waimai.control.shangjiaManger;
import waimai.control.shangpinManger;
import waimai.control.manjianManger;
import waimai.control.dizhiManger;
import waimai.control.dingdanManger;
import waimai.control.youhuiquanManger;
import waimai.control.yonghuyouhuiManger;
public class yonghuUttil {
	public static IyonghuManger yonghuManager=new yonghuManger();
	public static IuserManger userManger = new userManger();
	public static IshangjiaManger shangjiaManger =  new shangjiaManger();
	public static IshangpinManger shangpinManger =   new shangpinManger();
	public static IqishouManger qishouManger = new qishouManger();
	public static ImanjianManger manjianManger = new manjianManger();
	public static Idizhimanger dizhiManger = new dizhiManger();
	public static IdingdanManger dingdanManger = new dingdanManger();
	public static IyouhuiquanManger youhuiquanManger = new youhuiquanManger();
	public static IyonghuyouhuiManger yonghuyouhuiManger =  new yonghuyouhuiManger(); 
}
