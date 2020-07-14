package waimai.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import waimai.itf.IdingdanManger;
import waimai.model.Beandingdan;
import waimai.model.Beanshangjiaxinxi;
import waimai.model.Beanyonghuxinxi;
import waimai.util.BaseException;
import waimai.util.DBUtil;
import waimai.util.DbException;

public class dingdanManger implements IdingdanManger{

	@Override
	public List<Beandingdan> loadall() throws BaseException {
		// TODO Auto-generated method stub
		List<Beandingdan> result=new ArrayList<Beandingdan>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select dingdanbianhao,shangjiabianhao,yonghubianhao,qishoubianhao,yuanshijine,jiesuanjine,manjianbianhao,youhuiquanbianhao,xiadanshijian,songdashijian,dizhibianhao,dingdanzhuangtai from shangpindingdan where yonghubianhao = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, Beanyonghuxinxi.currentLoginUser.getYonghubianhao());
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Beandingdan p=new Beandingdan();
				p.setDingdanbianhao(rs.getInt(1));
				p.setShangjiabianhao(rs.getInt(2));
                p.setQishoubianhao(rs.getInt(4));
                p.setYuanshijine(rs.getDouble(5));
                p.setJiesuanjine(rs.getDouble(6));
                p.setSongdashijian(rs.getTimestamp(10));
                p.setDingdanzhuangtai(rs.getString(12));
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

}
