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
 * ���ʱ�
 * @author qingcheng
 *
 */
public class wageCalculate implements wageCalculateIM{

	private float pro=0.17f;
	public  void setFound(float pro) {//���ù���
		this.pro=pro;
	}
	
	public float getFound() {//��ù���
		return pro;
	}
	/**
	 * ���㹤��
	 */
	public  void Calculate(String sql) throws SQLException {
		//String sql = "select * from wagecalculate";
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
		Statement state = conn.createStatement();
		ResultSet rs = state.executeQuery(sql);
		while (rs.next()) { // next������ȡ���������
			int bw = Integer.parseInt(rs.getString(3));// ��ȡ������bw int
			float allo = Float.parseFloat(rs.getString(4));// ��ȡ���ĸ�allo float
			float whop = Float.parseFloat(rs.getString(5));// ��ȡ�����whop ���ۿ��� float
			float pm = Float.parseFloat(rs.getString(6));// ��ȡ������pm float
			float wage = bw + allo + whop + pm;
			float found=wage*getFound();
			float truewage=wage-found;
			String sql2="update wagecalculate set wage="+wage+",sfound="+found+",truewage="+truewage+"where stanum='"+rs.getString(2)+"'";
			Statement state2 = conn.createStatement();
			state2.executeUpdate(sql2);
		}
	}
	/**
	 * ���û������ʣ�Ա����3500������4500
	 */
	public void setBw(String sql5) throws SQLException{
		//String sql5="select id from wagecalculate";
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
		Statement state = conn.createStatement();
			ResultSet rs2 = state.executeQuery(sql5);
			Statement state1 = conn.createStatement();
			while(rs2.next()){
				String sql1="select jobs from employeeimformation where stanum=(select stanum from wagecalculate where id='"+rs2.getString(1)+"')";
			ResultSet rs1=state1.executeQuery(sql1);
			if(rs1.next()) {
				if("����".equals(rs1.getString(1))) {
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
	 * ��ѯ������Ϣ
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public static Vector<Vector> checkWage(String sql) throws SQLException {
		Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
		Statement state = conn.createStatement();
			ResultSet rs=state.executeQuery(sql); 
			while(rs.next()){    //next������ȡ���������
				Vector row=new Vector();//����������
				row.add(rs.getString(1));//��ȡ��һ���ֶ�id
				row.add(rs.getString(2));//��ȡ�ڶ���stanum
				row.add(Integer.parseInt(rs.getString(3)));//��ȡ������bw    int
				row.add(Float.parseFloat(rs.getString(4)));//��ȡ���ĸ�allo   float
				row.add(Float.parseFloat(rs.getString(5)));//��ȡ�����whop   ���ۿ���  float
				row.add(Float.parseFloat(rs.getString(6)));//��ȡ������pm   float
				row.add(Float.parseFloat(rs.getString(7)));//��ȡ���߸�wage float
				row.add(Float.parseFloat(rs.getString(8)));
				row.add(Float.parseFloat(rs.getString(9)));
				rows.add(row);//����������ӵ���¼������
			    }
			conn.close();
		return rows;
	}
	/**
	 * �޸Ĺ�����Ϣ
	 */
	public void modyWg(String sql) throws SQLException {
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
		Statement state = conn.createStatement();
		ResultSet rs = state.executeQuery(sql);
		while (rs.next()) { // next������ȡ���������
			int bw = Integer.parseInt(rs.getString(3));// ��ȡ������bw int
			float allo = Float.parseFloat(rs.getString(4));// ��ȡ���ĸ�allo float
			float whop = Float.parseFloat(rs.getString(5));// ��ȡ�����whop ���ۿ��� float
			float pm = Float.parseFloat(rs.getString(6));// ��ȡ������pm float
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
