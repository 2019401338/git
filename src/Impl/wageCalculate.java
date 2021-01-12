package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DAO.wageCalculateIM;
import proxy.ConnectionDemo01;
/**
 * 工资表
 * @author qingcheng
 *
 */
public class wageCalculate implements wageCalculateIM{

	private float pro=0.17f;
	public  void setFound(float pro) {//设置工资
		this.pro=pro;
	}
	
	public float getFound() {//获得工资
		return pro;
	}
	/**
	 * 计算工资
	 */
	public  void Calculate(String sql) throws SQLException {
		//String sql = "select * from wagecalculate";
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		Connection conn = dbcs.getConnection(); // 获取数据库接
		Statement state = conn.createStatement();
		ResultSet rs = state.executeQuery(sql);
		while (rs.next()) { // next（）获取里面的内容
			int bw = Integer.parseInt(rs.getString(3));// 获取第三个bw int
			float allo = Float.parseFloat(rs.getString(4));// 获取第四个allo float
			float whop = Float.parseFloat(rs.getString(5));// 获取第五个whop 代扣款项 float
			float pm = Float.parseFloat(rs.getString(6));// 获取第六个pm float
			float wage = bw + allo + whop + pm;
			float found=wage*getFound();
			float truewage=wage-found;
			String sql2="update wagecalculate set wage="+wage+",sfound="+found+",truewage="+truewage+"where stanum='"+rs.getString(2)+"'";
			Statement state2 = conn.createStatement();
			state2.executeUpdate(sql2);
		}
	}
	/**
	 * 设置基本工资：员工：3500，经理：4500
	 */
	public void setBw(String sql5) throws SQLException{
		//String sql5="select id from wagecalculate";
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		Connection conn = dbcs.getConnection(); // 获取数据库接
		Statement state = conn.createStatement();
			ResultSet rs2 = state.executeQuery(sql5);
			Statement state1 = conn.createStatement();
			while(rs2.next()){
				String sql1="select jobs from employeeimformation where stanum=(select stanum from wagecalculate where id='"+rs2.getString(1)+"')";
			ResultSet rs1=state1.executeQuery(sql1);
			if(rs1.next()) {
				if("经理".equals(rs1.getString(1))) {
					String sql2="update wagecalculate set bw=? where id = ?";
					PreparedStatement pst1=conn.prepareStatement(sql2);
					pst1.setInt(1, 4500);
					pst1.setInt(2, Integer.valueOf(rs2.getString(1)).intValue());
					pst1.executeUpdate();
				}else {
					String sql3="update wagecalculate set bw=? where id=?";
					PreparedStatement pst=conn.prepareStatement(sql3);
					pst.setInt(1, 3500);
					pst.setInt(2, Integer.valueOf(rs2.getString(1)).intValue());
					pst.executeUpdate();
				}
			}
			}
	}
	/**
	 * 查询工资信息
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public static Vector<Vector> checkWage(String sql) throws SQLException {
		Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		Connection conn = dbcs.getConnection(); // 获取数据库接
		Statement state = conn.createStatement();
			ResultSet rs=state.executeQuery(sql); 
			while(rs.next()){    //next（）获取里面的内容
				Vector row=new Vector();//定义行数据
				row.add(rs.getString(1));//获取第一个字段id
				row.add(rs.getString(2));//获取第二个stanum
				row.add(Integer.parseInt(rs.getString(3)));//获取第三个bw    int
				row.add(Float.parseFloat(rs.getString(4)));//获取第四个allo   float
				row.add(Float.parseFloat(rs.getString(5)));//获取第五个whop   代扣款项  float
				row.add(Float.parseFloat(rs.getString(6)));//获取第六个pm   float
				row.add(Float.parseFloat(rs.getString(7)));//获取第七个wage float
				row.add(Float.parseFloat(rs.getString(8)));
				row.add(Float.parseFloat(rs.getString(9)));
				rows.add(row);//将行数据添加到记录集合中
			    }
			conn.close();
		return rows;
	}
	/**
	 * 修改工资信息
	 */
	public void modyWg(String sql) throws SQLException {
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		Connection conn = dbcs.getConnection(); // 获取数据库接
		Statement state = conn.createStatement();
		ResultSet rs = state.executeQuery(sql);
		while (rs.next()) { // next（）获取里面的内容
			int bw = Integer.parseInt(rs.getString(3));// 获取第三个bw int
			float allo = Float.parseFloat(rs.getString(4));// 获取第四个allo float
			float whop = Float.parseFloat(rs.getString(5));// 获取第五个whop 代扣款项 float
			float pm = Float.parseFloat(rs.getString(6));// 获取第六个pm float
			float wage = bw + allo + whop + pm;
			float found=wage*getFound();
			float truewage=wage-found;
			String sql2="update wagecalculate set wage="+wage+",sfound="+found+",truewage="+truewage+"where stanum='"+rs.getString(2)+"'";
			Statement state2 = conn.createStatement();
			state2.executeUpdate(sql2);
		}
	}
//	public static void main(String[] args) throws SQLException {
//		//Calculate();
//	}

}
