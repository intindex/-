package waimai.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import waimai.util.BaseException;
import waimai.util.BusinessException;
import waimai.util.DBUtil;
import waimai.util.DbException;
import waimai.itf.IyonghuManger;
import waimai.model.Beanyonghuxinxi;

public class yonghuManger implements IyonghuManger {

    public Beanyonghuxinxi login(String userid,String pwd) throws BusinessException, DbException
    {
    	Connection conn=null;
 Beanyonghuxinxi u = null;
	    try {
	    	conn=DBUtil.getConnection();
	    	String sql = "select * from yonghuxinxi where name = ? ";
	    	java.sql.PreparedStatement pst=conn.prepareStatement(sql);
	    	pst.setString(1,userid);
	    	java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("��½�˺Ų� ����");
			u=new Beanyonghuxinxi();
			u.setYonghubianhao(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setMima(rs.getString(4));
			if(!pwd.equals(u.getMima()))
				throw new BusinessException("�������");
			pst.close();
			rs.close();
			
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
	return u;
	}

	@Override
	public Beanyonghuxinxi reg(String userid, String xingbie,String shouji,String city,String pwd, String pwd2) throws BaseException {
		if(userid.equals(""))
			throw new BusinessException("�˻�������Ϊ��");
		if(pwd.equals("")||pwd.equals(""))
			throw new BusinessException("mima����Ϊ��");
		if(!pwd.equals(pwd2))
				throw new BusinessException("�����������벻һ��");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from yonghuxinxi where name=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("�û����ظ�");
			 sql = "insert into yonghuxinxi(name,sex,mima,shoujihaoma,city) values(?,?,?,?,?)";
		     pst=conn.prepareStatement(sql);
		    
			pst.setString(1,userid);
			pst.setString(2,xingbie);
			pst.setString(3, pwd);
			pst.setString(4, shouji);
			pst.setString(5, city);
			//pst.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Beanyonghuxinxi changePwd(String user, String oldPwd, String newPwd, String newPwd2) throws BaseException {
		if(oldPwd==null) throw new BusinessException("ԭʼ���벻��Ϊ��");
		if(newPwd==null || "".equals(newPwd) || newPwd.length()>16) throw new BusinessException("����Ϊ1-16���ַ�");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select mima from yonghuxinxi where name=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,user);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("��½�˺Ų� ����");
			if(!oldPwd.equals(rs.getString(1))) throw new BusinessException("ԭʼ�������");
			rs.close();
			pst.close();
			sql = "update yonghuxinxi set mima = ? where name= ?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setString(2, user);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Beanyonghuxinxi> load() throws BaseException {
		List<Beanyonghuxinxi> o = new ArrayList<Beanyonghuxinxi>();
		Beanyonghuxinxi p = new Beanyonghuxinxi();
		// TODO Auto-generated method stub
		Connection conn=null;
		
		try {
			
			conn=DBUtil.getConnection();
			String sql = "select * from yonghuxinxi where name = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,Beanyonghuxinxi.currentLoginUser.getName());
			java.sql.ResultSet rs = pst.executeQuery();
			if(!rs.next())
			{
				throw new BusinessException("���û�������");
			}
		    p.setName(rs.getString(2));
            p.setSex(rs.getString(3));
            p.setShoujihaoma(rs.getString(5));
            p.setCity(rs.getString(7));
            p.setHuiyuan(rs.getString(10));
            o.add(p);
		return o;
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
	}

	

	
    }

