package EmployeeManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import DataConnection.ConnectionDemo01;
import Interface1.EmployeeInformationIM;
/**
 * Ա����Ϣ��
 * @author qingcheng
 *
 */
public class EmployeeInformation implements EmployeeInformationIM{
	private static String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	//����Ů������
	private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	//������������
    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
   /**
        * ������ط���ָ����Χ�������
    */
    public int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);//Math.random()�������0.0��1.0֮�����
    }
  /**
   * ������ر��
   */
    public StringBuilder getStuno() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder num=new StringBuilder("2019401");//Ա����ǰ7λ��ͬ
    	StringBuilder num1=new StringBuilder(String.valueOf(getNum(1,9999)));//���ȡ��4λ
    	if(num1.length()==1) {
    		num1=num1.insert(0, "000");//�����1λ����ǰ������2��0
    		num=num.append(num1);//ǰ6λ���4λƴ�ӳ�ѧ��
    	}else if(num1.length()==2) {
    		num1=num1.insert(0, "00");//�����2λ����ǰ������2��0
    		num=num.append(num1);
    	}else if(num1.length()==3) {
    		num1=num1.insert(0, "0");//�����3λ����ǰ������1��0
    		num=num.append(num1);
    	}else {
    		num=num.append(num1);
    	}
    	return num;
    }
    /**
     * ��������Ա�
     */
    public int getSex() {
    	int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
    	return sex;
    }
  /**
   * ��������������� 
   */
    public String getChineseName(int sex) {
        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
        String str=boy;//��������Ϊ�����ַ���
        int length=boy.length();//��ȡ�����ַ����ĳ���
        if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
        String second=str.substring(index, index+1);//��ȡ��λ���е�����
        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
        String third="";//Ĭ��û�е�������
        if(hasThird==1){//��������ȡΪ1�����е�������
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//��������
    }
  /**
   * ����������ĸ�����
   */
    public String getDepartment() {
    	int x=getNum(1,8);
    	String s = null;
    	String s1="������";
    	String s2="���²�";
    	String s3="�ۺϰ�";
    	String s4="���۲�";
    	String s5="��ز�";
    	String s6="������";
    	String s7="�豸��";
    	String s8="����";
    	switch(x) {
    	case 1:s= s1;break;
    	case 2:s= s2;break;
    	case 3:s= s3;break;
    	case 4:s= s4;break;
    	case 5:s= s5;break;
    	case 6:s= s6;break;
    	case 7:s= s7;break;
    	case 8:s= s8;break;
    	default:s="��ȡ����";break;
    	}
    	return s;
    }
    public String getJobs() {
    	return "Ա��";
    }
  /**
   *  ������ɳ�Ա��Ϣ
   */
	public void addPeople() {
		ConnectionDemo01 dbcs = new ConnectionDemo01();// ʹ��1�ж�����������ݿ����
		String sql = "insert into employeeimformation(stanum,staname,stasex,department,jobs) values(?,?,?,?,?)";// ʹ��ռλ������������
		String sql1="insert into wagecalculate(stanum) values(?)";
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql);) {// ʵ����
			ArrayList<String> alist = new ArrayList<String>();// ���弯��
			for (int i = 1; i <= 1;) {
				String num = getStuno().toString();// �����ȡԱ����
				if (!alist.contains(num)) {// �ж�Ա�����Ƿ�Ψһ
					alist.add(num);// ��Ա���ż��뼯��
					int sex = getSex();// �����ȡ�Ա�
					String xm = getChineseName(sex);// �����ȡ����
					String department = getDepartment();// ������ɲ���
					String jobs = getJobs();
					pstmt.setString(1, num);// �����1��ռλ��������
					pstmt.setString(2, xm);// �����2��ռλ��������
					pstmt.setInt(3, sex);// �����3��ռλ��������
					pstmt.setString(4, department);// �����4��ռλ��������
					pstmt.setString(5, jobs);// �����5��ռλ��������
					pstmt.addBatch();// ����������ȴ�ִ��
					i++;
					
					PreparedStatement pstmt1=conn.prepareStatement(sql1);//���ʼ����ͬʱ����
					pstmt1.setString(1, num);
					pstmt1.executeUpdate();
				}
			}
			pstmt.executeBatch();// ����ִ�в������
			JOptionPane.showMessageDialog(null, "sucess");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		department d=new department();//������Ϣͬʱ����
		d.getStaffNum();
	}
	/**
	 * ����Ա����Ϣ
	 */
	public void addStaff(String num,String xm,int sex,String department,String jobs) {
		ConnectionDemo01 dbcs = new ConnectionDemo01();// ʹ��1�ж�����������ݿ����
		String sql = "insert into employeeimformation(stanum,staname,stasex,department,jobs) values(?,?,?,?,?)";// ʹ��ռλ������������
		String sql1="insert into wagecalculate(stanum) values(?)";
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql);) {// ʵ����
					pstmt.setString(1, num);// �����1��ռλ��������
					pstmt.setString(2, xm);// �����2��ռλ��������
					pstmt.setInt(3, sex);// �����3��ռλ��������
					pstmt.setString(4, department);// �����4��ռλ��������
					pstmt.setString(5, jobs);// �����5��ռλ��������
			pstmt.executeUpdate();
			
			PreparedStatement pstmt1=conn.prepareStatement(sql1);//���ʼ����ͬʱ����
			pstmt1.setString(1, num);
			pstmt1.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		department d=new department();//������Ϣͬʱ����
		d.getStaffNum();
	}
	/**
	 * ɾ����Ա��Ϣ
	 */
	public void delete(String sql) {
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		try(Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
		Statement state = conn.createStatement();){
			state.executeUpdate(sql);
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		department d=new department();//������Ϣͬʱ����
		d.getStaffNum();
	}
	/**
	 * �޸ĳ�Ա��Ϣ
	 */
	public void modify(String sql) {
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		try(Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
		Statement state = conn.createStatement();){
			state.executeUpdate(sql);
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ѯ��Ա��Ϣ
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public static Vector<Vector> checkStaff(String sql) throws SQLException {
		Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
		ConnectionDemo01 dbcs = new ConnectionDemo01();
		Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
		Statement state = conn.createStatement();
			ResultSet rs=state.executeQuery(sql); 
			while(rs.next()){    //next������ȡ���������
				Vector row=new Vector();//����������
				row.add(rs.getString(1));//��ȡ��һ���ֶ�id
				row.add(rs.getString(2));//��ȡ�ڶ���stanum
				row.add(rs.getString(3));//��ȡ������staname
				if("1".equals(rs.getString(4))){//��ȡ���ĸ�stasex
					row.add("��");
				}else row.add("Ů");
				row.add(rs.getString(5));//��ȡ�����department
				row.add(rs.getString(6));//��ȡ������jobs
				rows.add(row);//����������ӵ���¼������
			    }
			conn.close();
		return rows;
	}
//    public static void main(String[] args) throws SQLException {
//    	String sql="select * from employeeimformation where stanum='20194013380'";
//    	System.out.println(checkStaff(sql));
//	}
}
 
