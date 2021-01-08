package Interface1;

public interface EmployeeInformationIM {
	 public static final String firstName = "";
	 public static final String girl = "";
	 public static final String boy = "";
	 /**
      * 随机返回返回指定范围间的整数
  */
	 public int getNum(int start,int end);
	 /**
	   * 随机返回编号
	   */
	 public StringBuilder getStuno();
	 /**
	     * 随机生成性别
	     */
	 public int getSex();
	 /**
	   * 随机返回中文姓名 
	   */
	 public String getChineseName(int sex);
	 /**
	   * 随机生成事哪个部门
	   */
	 public String getDepartment();
	 public String getJobs();
	 /**
	   *  随机生成成员信息
	   */
	 public void addPeople();
	 /**
		 * 增加员工信息
		 */
	 public void addStaff(String num,String xm,int sex,String department,String jobs);
	 /**
		 * 删除成员信息
		 */
	 public void delete(String sql);
	 /**
		 * 修改成员信息
		 */
	 public void modify(String sql);
}
