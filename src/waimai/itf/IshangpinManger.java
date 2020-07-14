package waimai.itf;

import java.util.List;

import waimai.model.Beandingdan;
import waimai.model.Beanshangjiaxinxi;
import waimai.model.Beanshangpinxiangqing;
import waimai.util.BaseException;

public interface IshangpinManger {
	public List<Beanshangpinxiangqing> loadall(Beanshangjiaxinxi p)throws BaseException;
	public void xiadan(Beanshangpinxiangqing p,int n,int m)throws BaseException;
	public void pingjia(Beandingdan uu,String a1,String a2,String a3)throws BaseException;
}

