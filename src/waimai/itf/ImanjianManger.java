package waimai.itf;

import java.util.List;

import waimai.model.Beanmanjian;
import waimai.model.Beanshangjiaxinxi;
import waimai.util.BaseException;

public interface ImanjianManger {
	public List<Beanmanjian> loadall() throws BaseException;
	public Beanmanjian addmanjian(double a1,double a2,String a3)throws BaseException;
	public Beanmanjian deletemanjian(Beanmanjian jkl)throws BaseException;
}
