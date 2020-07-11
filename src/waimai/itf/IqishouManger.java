package waimai.itf;

import java.util.List;

import waimai.model.Beanqishouxinxi;
import waimai.model.Beanshangjiaxinxi;
import waimai.util.BaseException;

public interface IqishouManger {
       public Beanqishouxinxi addqishou(String name,String ID)throws BaseException;
       public Beanqishouxinxi deleteqishou(String name)throws BaseException;
       public List<Beanqishouxinxi> loadall()throws BaseException;
       public Beanqishouxinxi jiedan(Beanqishouxinxi jkl)throws BaseException;
}
