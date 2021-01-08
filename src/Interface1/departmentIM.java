package Interface1;

import java.sql.SQLException;
import java.util.Vector;
/**
 * 部门接口
 * @author qingcheng
 *
 */
public interface departmentIM {
	/**
	 * 计算各部门人数
	 */
	public void getStaffNum();
	/**
	 * 查询部门信息表
	 */
	public Vector<Vector> checkdepart(String sql) throws SQLException;
}
