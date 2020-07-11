package waimai.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import waimai.itf.IshangjiaManger;
import waimai.itf.IshangpinManger;
import waimai.model.Beanshangjiaxinxi;
import waimai.model.Beanshangpinxiangqing;
import waimai.model.Beanyonghuxinxi;
import waimai.util.BaseException;
import waimai.util.BusinessException;
import waimai.util.DBUtil;
import waimai.util.DbException;

public class shangpinManger implements IshangpinManger{

	@Override
	public List<Beanshangpinxiangqing> loadall(Beanshangjiaxinxi d) throws BaseException {
		List<Beanshangpinxiangqing> result=new ArrayList<Beanshangpinxiangqing>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select sahngpinbianhao,fenleibianhao,shangpinname,jiage,shangjiabianhao,order_id,shuliang from shangpinxiangqing where shangjiabianhao = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
	     	pst.setInt(1, d.getShangjiabianhao());
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Beanshangpinxiangqing p=new Beanshangpinxiangqing();
                p.setSahngpinbianhao(rs.getInt(1));
                p.setFenleibianhao(rs.getString(2));
                p.setShanpinname(rs.getString(3));
                p.setJiage(rs.getString(4));
                p.setShangjiabianhao(rs.getInt(5));
                p.setOrder_id(rs.getInt(6));
                p.setShuliang(rs.getInt(7));
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
	public void xiadan(Beanshangpinxiangqing p,int n,int m)throws BaseException
	{
		if(n>p.getShuliang())
			throw new BusinessException("商品数量不足");
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select * from manjianfangan where manjianbianhao = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, m);
			java.sql.ResultSet rs = pst.executeQuery();
			if(!rs.next())
				throw new BusinessException("不存在该满减方案");
			if(n*(Double.valueOf(p.getJiage()))<rs.getDouble(2))
				throw new BusinessException("未达到满减要求");
			double g = rs.getDouble(3);
		    sql = "insert into dingdanxiangqing(shangpinbianhao,shuliang,jiage,danpinyouhuijine) values(?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, p.getSahngpinbianhao());
			pst.setInt(2, n);
			pst.setDouble(3, n*(Double.valueOf(p.getJiage())) );
			pst.setDouble(4, g/n);
			pst.execute();
			pst.close();
			sql = "insert into shangpindingdan(shangjiabianhao,yonghubianhao,yuanshijine,jiesuanjine,xiadanshijian,songdashijian,dingdanzhuangtai,manjianbianhao) values(?,?,?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1,p.getShangjiabianhao());
			pst.setInt(2, Beanyonghuxinxi.currentLoginUser.getYonghubianhao());
			pst.setDouble(3, n*(Double.valueOf(p.getJiage())));
			pst.setDouble(4, n*(Double.valueOf(p.getJiage()))-g);
			pst.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis()));
			pst.setTimestamp(6,  new java.sql.Timestamp(System.currentTimeMillis() + 1800000L));
			pst.setString(7, "未接单 ");
			pst.setInt(8, m);			
			pst.execute();
			pst.close();
			sql = "update shangpinxiangqing set shuliang = shuliang - ? where sahngpinbianhao = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, n);
			pst.setInt(2, p.getSahngpinbianhao());
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
	}
}
