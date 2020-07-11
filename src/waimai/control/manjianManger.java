package waimai.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.source.tree.ParameterizedTypeTree;

import waimai.itf.ImanjianManger;
import waimai.model.Beanmanjian;
import waimai.model.Beanshangjiaxinxi;
import waimai.util.BaseException;
import waimai.util.DBUtil;
import waimai.util.DbException;

public class manjianManger implements ImanjianManger{

	@Override
	public List<Beanmanjian> loadall() throws BaseException {
		List<Beanmanjian> result=new ArrayList<Beanmanjian>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select manjianbianhao,manjianjine,youhuijine,shifoudiejia from manjianfangan";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			//pst.setString(1, BeanUser.currentLoginUser.getUser_id());
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Beanmanjian p=new Beanmanjian();
                p.setManjianbiaohao(rs.getInt(1));
                p.setManjianjine(rs.getDouble(2));
                p.setYouhuijine(rs.getDouble(3));
                p.setShifoudiejiaString(rs.getString(4));;
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
	public Beanmanjian addmanjian(double a1, double a2, String a3) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "insert into manjianfangan(manjianjine,youhuijine,shifoudiejia) values(?,?,?)";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setDouble(1, a1);
			pst.setDouble(2, a2);
			pst.setString(3, a3);
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
	public Beanmanjian deletemanjian(Beanmanjian jkl) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "delete from manjianfangan where manjianbianhao = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, jkl.getManjianbiaohao());
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
