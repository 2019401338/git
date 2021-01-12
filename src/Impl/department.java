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
 * 部门类
 * @author qingcheng
 *
 */
public class department implements departmentIM{

	/**
	 * 计算各部门人数
	 */
	public void getStaffNum() {
		String[] sql=new String[10];
		String[] sql0=new String[10];	
		 sql[1]="select count(*) FROM employeeimformation where department = '开发部'";
		 sql[2]="select count(*) FROM employeeimformation where department = '人事部'";
		 sql[3]="select count(*) FROM employeeimformation where department = '物控部'";
		 sql[4]="select count(*) FROM employeeimformation where department = '生产部'";
		 sql[5]="select count(*) FROM employeeimformation where department = '综合办'";
		 sql[6]="select count(*) FROM employeeimformation where department = '设备部'";
		 sql[7]="select count(*) FROM employeeimformation where department = '财务部'";
		 sql[8]="select count(*) FROM employeeimformation where department = '销售部'";
		for(int i=1;i<9;i++) {
			ConnectionDemo01 dbcs=new ConnectionDemo01();//使用1中定义的连接数据库的类
			Connection conn = dbcs.getConnection();
			PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql[i]);
			ResultSet y=pstmt.executeQuery();
			if(y.next()) {
				String x=y.getString(1);
				sql0[i]="update department set empnumber='"+x+"' where depnum='"+i+"'";
				pstmt = conn.prepareStatement(sql0[i]);
				pstmt.executeUpdate();//执行插入语句
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	/**
	 * 查询部门信息表
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public Vector<Vector> checkdepart(String sql) throws SQLException {
		Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		Connection conn = dbcs.getConnection(); // 获取数据库接
		Statement state = conn.createStatement();
			ResultSet rs=state.executeQuery(sql); 
			while(rs.next()){    //next（）获取里面的内容
				Vector row=new Vector();//定义行数据
				row.add(rs.getString(1));//获取第一个 字段id
				row.add(rs.getString(2));//获取第二个 部门
				row.add(rs.getString(3));//获取第三个 经理编号
				row.add(rs.getString(4));//获取第四个 经理名字
				row.add(rs.getString(5));//获取第五个 department人数
				rows.add(row);//将行数据添加到记录集合中
			    }
			conn.close();
		return rows;
	}
//	public static void main(String[] args) {
//		getStaffNum();
//	}

}
