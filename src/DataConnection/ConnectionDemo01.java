package DataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * ���ݿ�����
 * @author qingcheng
 *
 */
public class ConnectionDemo01 {
	private static final String DBDRIVER="org.gjt.mm.mysql.Driver";//�������ݿ���������
	private static final String DBURL="jdbc:mysql://localhost:3306/manageemployee?useSSL=false";//����MySQL���ݿ�����ӵ�ַ
	private static final String DBUSER="root";//���ݿ�������û���
	private static final String DBPASS="123456";//���ݿ����������
	private Connection conn=null;
	public ConnectionDemo01(){//���췽���������ݿ�
		try {
			Class.forName(DBDRIVER);
			this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		} catch (Exception e) {e.printStackTrace();}
	}
	public Connection getConnection() {//�������ݿ����Ӷ���
		return this.conn;
	}
	public void close() {//�ر���������
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
