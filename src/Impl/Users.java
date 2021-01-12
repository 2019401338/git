package Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import proxy.ConnectionDemo01;
/**
 * 用户信息登录密码设置
 * @author qingcheng
 *
 */
public class Users {

	public Vector<Vector> checkPassword(String sql) throws SQLException {//查询成员信息
		Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		Connection conn = dbcs.getConnection(); // 获取数据库接
		Statement state = conn.createStatement();
			ResultSet rs=state.executeQuery(sql); 
			while(rs.next()){    //next（）获取里面的内容
				Vector row=new Vector();//定义行数据
				row.add(rs.getString(1));//获取第一个 id
				row.add(rs.getString(2));//获取第二个 密码
				row.add(rs.getString(3));//获取第三个 职位
				row.add(rs.getString(4));//获取第四个 员工编码
				rows.add(row);//将行数据添加到记录集合中
			    }
		return rows;
	}
}
