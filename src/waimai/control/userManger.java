package waimai.control;

import java.sql.Connection;
import java.sql.SQLException;

import waimai.itf.IuserManger;
import waimai.itf.IyonghuManger;
import waimai.model.Beanguanliyuan;
import waimai.util.BusinessException;
import waimai.util.DBUtil;
import waimai.util.DbException;
import waimai.model.Beanguanliyuan;
import waimai.util.BaseException;

public class userManger implements IuserManger{
	public Beanguanliyuan login(String userid,String pwd)throws BaseException
	{
		Connection conn=null;
	    try {
	    	conn=DBUtil.getConnection();
	    	String sql = "select * from guanliyuan where yuangongxingming = ? ";
	    	java.sql.PreparedStatement pst=conn.prepareStatement(sql);
	    	pst.setString(1,userid);
	    	
	    	java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("登陆账号不存在");
			Beanguanliyuan u=new Beanguanliyuan();
			u.setYuangongxingming(rs.getString(2));
			u.setDenglumima(rs.getString(3));
			if(!pwd.equals(u.getDenglumima()))
				throw new BusinessException("密码错误");
			pst.close();
			rs.close();
			return u;
	    }catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		// TODO Auto-generated method stub
	
}

	@Override
	public Beanguanliyuan changePwd(String oldPwd, String newPwd, String newPwd2) throws BaseException {
		// TODO Auto-generated method stub
		if(oldPwd==null) throw new BusinessException("原始密码不能为空");
		if(newPwd==null || "".equals(newPwd) || newPwd.length()>16) throw new BusinessException("必须为1-16个字符");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select denglumima from guanliyuan where yuangongxingming=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,Beanguanliyuan.currentLoginUser.getYuangongxingming());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("登陆账号不 存在");
			if(!oldPwd.equals(rs.getString(1))) throw new BusinessException("原始密码错误");
			rs.close();
			pst.close();
			sql = "update guanliyuan set denglumima = ? where yuangongxingming= ?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setString(2, Beanguanliyuan.currentLoginUser.getYuangongxingming());
			pst.execute();
			pst.close();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}
}
