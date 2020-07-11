package waimai.itf;


import java.util.List;

import waimai.model.Beanshangjiaxinxi;
import waimai.util.BaseException;

public interface IshangjiaManger {
       public List<Beanshangjiaxinxi> loadall() throws BaseException;
       public Beanshangjiaxinxi addshangjia(String name,String xingji,String xiaofei,String xiaoliang) throws BaseException;
       public Beanshangjiaxinxi deleteshangjia(String name) throws BaseException;
}
