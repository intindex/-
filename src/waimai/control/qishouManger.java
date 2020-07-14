package waimai.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import waimai.itf.IqishouManger;
import waimai.model.Beanqishouxinxi;
import waimai.model.Beanshangjiaxinxi;
import waimai.util.BaseException;
import waimai.util.BusinessException;
import waimai.util.DBUtil;
import waimai.util.DbException;

public class qishouManger implements IqishouManger{
	public Beanqishouxinxi addqishou(String name,String ID)throws BaseException
	{
		if(name==null || "".equals(name))
			throw new BusinessException("商家姓名不能为空");
		// TODO Auto-generated method stub
		Connection conn=null;
		int n=0;
		try {
			
			conn=DBUtil.getConnection();
			String sql = "select 1 from qishouxinxi1 where dingshouxingming= ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,name);
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				rs.close();
				pst.close();
				throw new BusinessException("同名骑手已存在");
			}
			sql = "insert into qishouxinxi1(dingshouxingming,ruzhiriqi,qishoushengfen) values(?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1,name);
            pst.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
            pst.setString(3, ID);
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
	public Beanqishouxinxi deleteqishou(String name) throws BaseException {
		// TODO Auto-generated method stub
		if(name==null || "".equals(name))
			throw new BusinessException("骑手姓名不能为空");
		// TODO Auto-generated method stub
		Connection conn=null;
		
		try {
			
			conn=DBUtil.getConnection();
			String sql = "select * from qishouxinxi1 where dingshouxingming = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,name);
			java.sql.ResultSet rs = pst.executeQuery();
			if(!rs.next())
			{
				rs.close();
				pst.close();
				throw new BusinessException("该骑手不存在，无法删除");
			}
			sql = "delete from qishouxinxi1 where dingshouxingming = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,name);
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
	public List<Beanqishouxinxi> loadall()throws BaseException
	{
		List<Beanqishouxinxi> result=new ArrayList<Beanqishouxinxi>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select qishoubianhao,dingshouxingming,ruzhiriqi,qishoushengfen,songdanshuliang from qishouxinxi1";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			//pst.setString(1, BeanUser.currentLoginUser.getUser_id());
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Beanqishouxinxi p=new Beanqishouxinxi();
                p.setQishoubianahao(rs.getInt(1));
                p.setQishouname(rs.getString(2));
                p.setRuzhiriqi(rs.getDate(3));
                p.setQishoushenfen(rs.getString(4));
                p.setJiedanshuliang(rs.getInt(5));
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
	public Beanqishouxinxi jiedan(Beanqishouxinxi jkl) throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
				String sql = "select COUNT(dingdanbianhao)\r\n" + 
						"from shangpindingdan\r\n" + 
						"where dingdanzhuangtai = '未接单'";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs = pst.executeQuery();
			int n = 0;
			if(rs.next())
			{
				n = rs.getInt(1);
			}
			sql = "update shangpindingdan set qishoubianhao = ? , dingdanzhuangtai = '配送中' where dingdanzhuangtai = '未接单'";
			pst = conn.prepareStatement(sql);
			System.out.print(jkl.getQishoubianahao());
			pst.setInt(1, jkl.getQishoubianahao());
			pst.execute();
			pst.close();
			sql = "update qishouxinxi1 set songdanshuliang=songdanshuliang + ? where qishoubianhao = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, n);
			pst.setInt(2, jkl.getQishoubianahao());
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
