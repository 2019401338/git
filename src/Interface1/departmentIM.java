package Interface1;

import java.sql.SQLException;
import java.util.Vector;
/**
 * ���Žӿ�
 * @author qingcheng
 *
 */
public interface departmentIM {
	/**
	 * �������������
	 */
	public void getStaffNum();
	/**
	 * ��ѯ������Ϣ��
	 */
	public Vector<Vector> checkdepart(String sql) throws SQLException;
}
