package waimai.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import waimai.itf.IyouhuiquanManger;
import waimai.model.Beanshangjiaxinxi;
import waimai.model.Beanyonghuxinxi;
import waimai.model.Beanyouhuiquan;
import waimai.util.BaseException;
import waimai.util.BusinessException;
import waimai.util.DBUtil;
import waimai.util.DbException;

public class youhuiquanManger implements IyouhuiquanManger{

	@Override
	public List<Beanyouhuiquan> loadall() throws BaseException {
		List<Beanyouhuiquan> result=new ArrayList<Beanyouhuiquan>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select youhuiquanbianhao,youhuijine,jidanyaoqiushu,qishiriqi,jieshuriqi,youhuiquanshuliang from youhuiquanxinxibiao";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			//pst.setString(1, BeanUser.currentLoginUser.getUser_id());
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Beanyouhuiquan p=new Beanyouhuiquan();
                p.setYouhuiquanbianhao(rs.getInt(1));
                p.setYouhuijine(rs.getDouble(2));
                p.setJidanyaoqiushu(rs.getInt(3));
                p.setQishiriqi(rs.getDate(4));
                p.setJieshuriqi(rs.getDate(5));
             
                p.setYouhuiquanshuliang(rs.getInt(6));
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
	public Beanyouhuiquan addyouhuiquan(double a1, int a2,int a3,int a4) throws BaseException {
		Connection conn=null;
		int n=0;
		try {
			
			conn=DBUtil.getConnection();
			String sql = "insert into youhuiquanxinxibiao(youhuijine,jidanyaoqiushu,qishiriqi,jieshuriqi,shangjiabianhao,youhuiquanshuliang) values(?,?,?,?,?,?)";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setDouble(1,a1);
            pst.setInt(2, a2);
            pst.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
            pst.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()+180000000L));
            pst.setInt(5,a3);
            pst.setInt(6, a4);
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
	public Beanyouhuiquan lingqu(Beanyouhuiquan jkl) throws BaseException {
		// TODO Auto-generated method stub
		if(jkl.getYouhuiquanshuliang()<=0)
			throw new BusinessException("数量不足");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "insert into jidansongquanbiao(yonghubianhao,youhuiquanbianhao,jidanyaoqiushu,dingdanshu) values(?,?,?,?)";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, Beanyonghuxinxi.currentLoginUser.getYonghubianhao());
			pst.setInt(2, jkl.getYouhuiquanbianhao());
			pst.setInt(3, jkl.getJidanyaoqiushu());
			pst.setInt(4, Beanyonghuxinxi.currentLoginUser.getGoumaidingdanshuliang());
			pst.execute();
			pst.close();
			if(Beanyonghuxinxi.currentLoginUser.getGoumaidingdanshuliang()<jkl.getJidanyaoqiushu())
				throw new BusinessException("未达到集单要求数");
			sql = "select * from youhuiquanchuyoubiao where yonghubianhao = ? and youhuiquanbianhao=? ";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Beanyonghuxinxi.currentLoginUser.getYonghubianhao());
			pst.setInt(2, jkl.getYouhuiquanbianhao());
			java.sql.ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				sql =  "update youhuiquanchuyoubiao set shuliang = shuliang + 1 where yonghubianhao = ? and youhuiquanbianhao=?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, Beanyonghuxinxi.currentLoginUser.getYonghubianhao());
				pst.setInt(2, jkl.getYouhuiquanbianhao());
				pst.execute();
				pst.close();
			}
			else 
			{
			    sql = "insert into youhuiquanchuyoubiao(yonghubianhao,youhuiquanbianhao,youhuijine,shuliang,jiezhiriqi) values(?,?,?,?,?)";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, Beanyonghuxinxi.currentLoginUser.getYonghubianhao());
				pst.setInt(2, jkl.getYouhuiquanbianhao());
				
				pst.setDouble(3, jkl.getYouhuijine());
				pst.setInt(4, 1);
				pst.setDate(5, jkl.getJieshuriqi());
				pst.execute();
				pst.close();
			}

			sql = "update youhuiquanxinxibiao set youhuiquanshuliang = youhuiquanshuliang - 1 where youhuiquanbianhao = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, jkl.getYouhuiquanbianhao());
			pst.execute();
			pst.close();
			sql = "update yonghuxinxi set goumaidingdanshuliang = goumaidingdanshuliang - ? where  yonghubianhao = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, jkl.getJidanyaoqiushu());
			pst.setInt(2, Beanyonghuxinxi.currentLoginUser.getYonghubianhao());
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
