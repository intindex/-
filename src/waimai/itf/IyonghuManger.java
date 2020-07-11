package waimai.itf;


import java.util.List;

import waimai.model.Beanyonghuxinxi;
import waimai.util.BaseException;

public interface IyonghuManger {
	public Beanyonghuxinxi login(String userid,String pwd)throws BaseException;
	public Beanyonghuxinxi reg(String userid, String xingbie,String shouji,String city,String pwd, String pwd2) throws BaseException;
	public Beanyonghuxinxi changePwd(String user, String oldPwd,String newPwd, String newPwd2)throws BaseException;
	public List<Beanyonghuxinxi> load() throws BaseException;
}
