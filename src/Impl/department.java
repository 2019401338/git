package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import DAO.departmentIM;
import proxy.ConnectionDemo01;

/**
 * ������
 * @author qingcheng
 *
 */
public class department implements departmentIM{

	/**
	 * �������������
	 */
	public void getStaffNum() {
		String[] sql=new String[10];
		String[] sql0=new String[10];	
		 sql[1]="select count(*) FROM employeeimformation where department = '������'";
		 sql[2]="select count(*) FROM employeeimformation where department = '���²�'";
		 sql[3]="select count(*) FROM employeeimformation where department = '��ز�'";
		 sql[4]="select count(*) FROM employeeimformation where department = '������'";
		 sql[5]="select count(*) FROM employeeimformation where department = '�ۺϰ�'";
		 sql[6]="select count(*) FROM employeeimformation where department = '�豸��'";
		 sql[7]="select count(*) FROM employeeimformation where department = '����'";
		 sql[8]="select count(*) FROM employeeimformation where department = '���۲�'";
		for(int i=1;i<9;i++) {
			ConnectionDemo01 dbcs=new ConnectionDemo01();//ʹ��1�ж�����������ݿ����
			Connection conn = dbcs.getConnection();
			PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql[i]);
			ResultSet y=pstmt.executeQuery();
			if(y.next()) {
				String x=y.getString(1);
				sql0[i]="update department set empnumber='"+x+"' where depnum='"+i+"'";
				pstmt = conn.prepareStatement(sql0[i]);
				pstmt.executeUpdate();//ִ�в������
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	/**
	 * ��ѯ������Ϣ��
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public Vector<Vector> checkdepart(String sql) throws SQLException {
		Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
		Statement state = conn.createStatement();
			ResultSet rs=state.executeQuery(sql); 
			while(rs.next()){    //next������ȡ���������
				Vector row=new Vector();//����������
				row.add(rs.getString(1));//��ȡ��һ�� �ֶ�id
				row.add(rs.getString(2));//��ȡ�ڶ��� ����
				row.add(rs.getString(3));//��ȡ������ ������
				row.add(rs.getString(4));//��ȡ���ĸ� ��������
				row.add(rs.getString(5));//��ȡ����� department����
				rows.add(row);//����������ӵ���¼������
			    }
			conn.close();
		return rows;
	}
//	public static void main(String[] args) {
//		getStaffNum();
//	}

}
