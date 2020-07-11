package waimai.itf;

import java.util.List;

import waimai.model.Beanshangjiaxinxi;
import waimai.model.Beanshangpinxiangqing;
import waimai.util.BaseException;

public interface IshangpinManger {
	public List<Beanshangpinxiangqing> loadall(Beanshangjiaxinxi p)throws BaseException;
	public void xiadan(Beanshangpinxiangqing p,int n,int m)throws BaseException;
}
