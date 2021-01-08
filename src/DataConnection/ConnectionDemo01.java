package DataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 数据库连接
 * @author qingcheng
 *
 */
public class ConnectionDemo01 {
	private static final String DBDRIVER="org.gjt.mm.mysql.Driver";//定义数据库驱动程序
	private static final String DBURL="jdbc:mysql://localhost:3306/manageemployee?useSSL=false";//定义MySQL数据库的连接地址
	private static final String DBUSER="root";//数据库的连接用户名
	private static final String DBPASS="123456";//数据库的连接密码
	private Connection conn=null;
	public ConnectionDemo01(){//构造方法连接数据库
		try {
			Class.forName(DBDRIVER);
			this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		} catch (Exception e) {e.printStackTrace();}
	}
	public Connection getConnection() {//返回数据库连接对象
		return this.conn;
	}
	public void close() {//关闭数据连接
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
