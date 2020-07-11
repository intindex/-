package waimai.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import waimai.itf.Idizhimanger;
import waimai.model.Beandizhi;
import waimai.model.Beanmanjian;
import waimai.model.Beanyonghuxinxi;
import waimai.util.BaseException;
import waimai.util.BusinessException;
import waimai.util.DBUtil;
import waimai.util.DbException;

public class dizhiManger implements Idizhimanger{

	@Override
	public List<Beandizhi> loadall() throws BaseException {
		List<Beandizhi> result=new ArrayList<Beandizhi>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select dizhibianhao,sheng,shi,qu,dizhi,lianxiren,dianhua from peisongdizhibiao where yonghubianhao=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, Beanyonghuxinxi.currentLoginUser.getYonghubianhao());
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Beandizhi p=new Beandizhi();
                p.setDizhibianhao(rs.getInt(1));
                p.setSheng(rs.getString(2));
                p.setShi(rs.getString(3));
                p.setQu(rs.getString(4));
                p.setDizhi(rs.getString(5));
                p.setLianxiren(rs.getString(6));
                p.setDianhua(rs.getString(7));
                
				result.add(p);
			}
			
			rs.close();
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
		return result;
	}

	@Override
	public Beandizhi insertdizhi(int n) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select * from peisongdizhibiao where yonghubianhao=?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, Beanyonghuxinxi.currentLoginUser.getYonghubianhao());
			java.sql.ResultSet rs = pst.executeQuery();
			if(!rs.next())
				throw new BusinessException("该地址不存在");
			sql = "select max(dingdanbianhao)\r\n" + 
					"from shangpindingdan";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			int m = 0;
			if(rs.next())
			m=rs.getInt(1);
			sql = "update shangpindingdan set dizhibianhao=? where dingdanbianhao = ?";
			 pst = conn.prepareStatement(sql);
			 pst.setInt(1, n);
			 pst.setInt(2, m);
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

	@Override
	public Beandizhi adddizhi(String a1, String a2, String a3, String a4, String a5, String a6) throws BaseException {
		Connection conn=null;
		int n=0;
		try {
			conn=DBUtil.getConnection();
			String sql = "insert into peisongdizhibiao(yonghubianhao,sheng,shi,qu,dizhi,lianxiren,dianhua) values(?,?,?,?,?,?,?)";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1,Beanyonghuxinxi.currentLoginUser.getYonghubianhao());
            pst.setString(2, a1);
            pst.setString(3, a2);
            pst.setString(4, a3);
            pst.setString(5, a4);
            pst.setString(6, a5);
            pst.setString(7, a6);
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

	@Override
	public Beandizhi deletedizhi(Beandizhi jkl) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "delete from peisongdizhibiao where dizhibianhao = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, jkl.getDizhibianhao());
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
