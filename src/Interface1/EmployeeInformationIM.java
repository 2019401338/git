package Interface1;

public interface EmployeeInformationIM {
	 public static final String firstName = "";
	 public static final String girl = "";
	 public static final String boy = "";
	 /**
      * ������ط���ָ����Χ�������
  */
	 public int getNum(int start,int end);
	 /**
	   * ������ر��
	   */
	 public StringBuilder getStuno();
	 /**
	     * ��������Ա�
	     */
	 public int getSex();
	 /**
	   * ��������������� 
	   */
	 public String getChineseName(int sex);
	 /**
	   * ����������ĸ�����
	   */
	 public String getDepartment();
	 public String getJobs();
	 /**
	   *  ������ɳ�Ա��Ϣ
	   */
	 public void addPeople();
	 /**
		 * ����Ա����Ϣ
		 */
	 public void addStaff(String num,String xm,int sex,String department,String jobs);
	 /**
		 * ɾ����Ա��Ϣ
		 */
	 public void delete(String sql);
	 /**
		 * �޸ĳ�Ա��Ϣ
		 */
	 public void modify(String sql);
}
