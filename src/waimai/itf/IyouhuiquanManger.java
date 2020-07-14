package waimai.itf;

import java.util.List;

import waimai.model.Beanyouhuiquan;
import waimai.util.BaseException;

public interface IyouhuiquanManger {
       public List<Beanyouhuiquan> loadall()throws BaseException;
       public Beanyouhuiquan addyouhuiquan(double a1,int a2,int a3,int a4)throws BaseException;
       public Beanyouhuiquan lingqu(Beanyouhuiquan jkl)throws BaseException;
}  
