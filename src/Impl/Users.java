package Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import proxy.ConnectionDemo01;
/**
 * �û���Ϣ��¼��������
 * @author qingcheng
 *
 */
public class Users {

	public Vector<Vector> checkPassword(String sql) throws SQLException {//��ѯ��Ա��Ϣ
		Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
		Statement state = conn.createStatement();
			ResultSet rs=state.executeQuery(sql); 
			while(rs.next()){    //next������ȡ���������
				Vector row=new Vector();//����������
				row.add(rs.getString(1));//��ȡ��һ�� id
				row.add(rs.getString(2));//��ȡ�ڶ��� ����
				row.add(rs.getString(3));//��ȡ������ ְλ
				row.add(rs.getString(4));//��ȡ���ĸ� Ա������
				rows.add(row);//����������ӵ���¼������
			    }
		return rows;
	}
}
