package Impl;

import java.sql.SQLException;
import java.util.Vector;

/**
 * ��ҳ��ʾԱ����Ϣ�б������
 * @author qingcheng
 *
 */
public class PageController2 {

	private static  Vector<Vector> bigList ; // �󼯺ϣ�������ȡ����
	private Vector<Vector> smallList = new Vector<Vector>(); // С���ϣ����ظ�����������
	private static int curentPageIndex = 1; // ��ǰҳ��
	private static int  countPerpage = 5; // ÿҳ��ʾ����
	private int pageCount; // ��ҳ��
	private int recordCount; // �ܼ�¼����
	{// ��ʼ�������
		if(PageController2.bigList==null) {
			try {
				PageController2.bigList=EmployeeInformation.checkStaff("select * from employeeimformation");// ���ò�ѯ���ݿ�ķ������������е���
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��ȡ��ҳ��
		if(bigList.size()%countPerpage==0) {
			pageCount=bigList.size()/countPerpage;
		}else {
			pageCount=bigList.size()/countPerpage+1;
		}
	}
	//�޲ι��췽��
	public PageController2() {}
	/**
	 * ���췽�����õ�ǰҳ
	 * @param curentPageIndex
	 */
	public PageController2(int curentPageIndex) {
		this.curentPageIndex = curentPageIndex;
	}
	/**
	 * ����ÿҳ��ʾ�ļ�¼��
	 * @param countPerpage
	 */
	public void setCountPerpage(int countPerpage) {
		this.countPerpage=countPerpage;
	}
	/**
	 * ���ݵ�ǰҳ����ɸѡ��¼
	 * @return
	 */
	public Vector<Vector> getPaegData() {
		recordCount = bigList.size();//�����¼��Ϊ���ݿ��б������������
		for (int i = (curentPageIndex - 1) * countPerpage; i < curentPageIndex * countPerpage && i < recordCount; i++) {//ȡ�õ�ǰҳ���ļ�¼��curentPageIndex��ǰҳ����countPerpageÿҳ��ʾ�ļ�¼��
			smallList.add(bigList.get(i));//����¼���뵽С������
		}
		return smallList;//����С���ϣ���ǰҳ�����ݣ�
	}
	public Vector<Vector> nextPage(){//��һҳ
		if(curentPageIndex<pageCount) {
			curentPageIndex++;
		}else {
			curentPageIndex=1;
		}
		return getPaegData();//������һҳ������
	}
	public Vector<Vector> prePage(){//��һҳ
		if(curentPageIndex>1) {
			curentPageIndex--;
		}else {
			curentPageIndex=pageCount;
		}
		return getPaegData();//������һҳ������
	}

}
