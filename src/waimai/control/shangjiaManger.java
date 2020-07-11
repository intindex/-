package waimai.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import waimai.util.BusinessException;
import waimai.itf.IshangjiaManger;
import waimai.model.Beanshangjiaxinxi;

import waimai.util.DBUtil;
import waimai.util.DbException;
import waimai.model.Beanshangjiaxinxi;
import waimai.util.BaseException;

public class shangjiaManger implements IshangjiaManger{
	public List<Beanshangjiaxinxi> loadall() throws BaseException
	{
		List<Beanshangjiaxinxi> result=new ArrayList<Beanshangjiaxinxi>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select shangjiabianhao,shangjianame,shangjiaxingji,renjunxiaofei,zongxiaoliang from shangjiaxinxibiao";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			//pst.setString(1, BeanUser.currentLoginUser.getUser_id());
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Beanshangjiaxinxi p=new Beanshangjiaxinxi();
                p.setShangjiabianhao(rs.getInt(1));
                p.setShangjianame(rs.getString(2));
                p.setShangjiaxingji(rs.getString(3));
                p.setRenjunxiaofei(rs.getString(4));
                p.setZongxiaoliang(rs.getString(5));
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
	public Beanshangjiaxinxi addshangjia(String name,String xingji,String xiaofei,String xiaoliang) throws BaseException {
		// TODO Auto-generated method stub
		if(name==null || "".equals(name))
			throw new BusinessException("商家姓名不能为空");
		// TODO Auto-generated method stub
		Connection conn=null;
		int n=0;
		try {
			
			conn=DBUtil.getConnection();
			String sql = "select 1 from shangjiaxinxibiao where shangjianame = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,name);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				rs.close();
				pst.close();
				throw new BusinessException("同名商家已存在");
			}
			sql = "insert into shangjiaxinxibiao(shangjianame,shangjiaxingji,renjunxiaofei,zongxiaoliang) values(?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1,name);
            pst.setString(2, xingji);
            pst.setString(3, xiaofei);
            pst.setString(4, xiaoliang);
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
	public Beanshangjiaxinxi deleteshangjia(String name) throws BaseException {
		if(name==null || "".equals(name))
			throw new BusinessException("商家姓名不能为空");
		// TODO Auto-generated method stub
		Connection conn=null;
		
		try {
			
			conn=DBUtil.getConnection();
			String sql = "select * from shangjiaxinxibiao where shangjianame = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,name);
			java.sql.ResultSet rs = pst.executeQuery();
			int n = 0;
			if(!rs.next())
			{
				throw new BusinessException("该商家不存在，无法删除");
			}
			n = rs.getInt(1);
			rs.close();
			pst.close();
			sql = "delete from shangjiaxinxibiao where shangjianame = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,name);
			pst.execute();
			pst.close();
			sql = "delete from shangpinxiangqing where shangjiabianhao = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1,n);
			pst.execute();
			pst.close();
		return null;
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
