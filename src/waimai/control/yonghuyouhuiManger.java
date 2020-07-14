package waimai.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import waimai.itf.IyonghuyouhuiManger;
import waimai.model.Beanyonghuxinxi;
import waimai.model.Beanyonghuyouhui;
import waimai.util.BaseException;
import waimai.util.DBUtil;
import waimai.util.DbException;

public class yonghuyouhuiManger implements IyonghuyouhuiManger{

	@Override
	public List<Beanyonghuyouhui> loadall() throws BaseException {
		
		List<Beanyonghuyouhui> result=new ArrayList<Beanyonghuyouhui>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql = "select yonghubianhao,youhuiquanbianhao,youhuijine,shuliang,jiezhiriqi from youhuiquanchuyoubiao where yonghubianhao = ?";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, Beanyonghuxinxi.currentLoginUser.getYonghubianhao());
			java.sql.ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Beanyonghuyouhui p=new Beanyonghuyouhui();
				p.setYonghubianhao(rs.getInt(1));
                p.setYouhuiquanbianhao(rs.getInt(2));
                
                p.setYouhuijine(rs.getDouble(3));
                p.setShuliang(rs.getInt(4));
                p.setJiezhiriqiDate(rs.getDate(5));
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
