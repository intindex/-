package waimai.itf;

import waimai.model.Beanguanliyuan;
import waimai.model.Beanyonghuxinxi;
import waimai.util.BaseException;

public interface IuserManger {
	public Beanguanliyuan login(String userid,String pwd)throws BaseException;
	public Beanguanliyuan changePwd(String oldPwd, String newPwd, String newPwd2) throws BaseException;
}
