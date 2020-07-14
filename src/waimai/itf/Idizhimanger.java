package waimai.itf;

import java.util.List;

import waimai.model.Beandizhi;
import waimai.util.BaseException;

public interface Idizhimanger {
	public List<Beandizhi> loadall() throws BaseException;
	public Beandizhi insertdizhi(int n,int m)throws BaseException;
	public Beandizhi adddizhi(String a1,String a2,String a3,String a4,String a5,String a6)throws BaseException;
	public Beandizhi deletedizhi(Beandizhi jkl)throws BaseException;
}
