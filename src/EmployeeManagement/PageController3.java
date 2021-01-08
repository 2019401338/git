package EmployeeManagement;

import java.sql.SQLException;
import java.util.Vector;

/**
 * ��ҳ��ʾԱ�����ʱ�������
 * @author qingcheng
 *
 */
public class PageController3 {
	
	private static Vector<Vector> bigList;// �󼯺ϣ�������ȡ����
	private Vector<Vector> smallList=new Vector<Vector>(); // С���ϣ����ظ�����������
	private static int curentPageIndex = 1; // ��ǰҳ��
	private static int  countPerpage = 10; // ÿҳ��ʾ����
	private int pageCount; // ��ҳ��
	private int recordCount; // �ܼ�¼����
	{// ��ʼ�������
		if (PageController3.bigList == null) {
			try {
				PageController3.bigList = wageCalculate.checkWage("select * from wagecalculate");// ���ò�ѯ���ݿ�ķ������������е���
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ��ȡ��ҳ��
		if (bigList.size() % countPerpage == 0) {
			pageCount = bigList.size() / countPerpage;
		} else {
			pageCount = bigList.size() / countPerpage + 1;
		}
	}
	public PageController3() {}//�޲ι��췽��
	public PageController3(int curentPageIndex) {//���췽�����õ�ǰҳ
		this.curentPageIndex = curentPageIndex;
	}
	public void setCountPerpage(int countPerpage) {//����ÿҳ��ʾ�ļ�¼��
		this.countPerpage=countPerpage;
	}
	public Vector<Vector> getPaegData() {// ���ݵ�ǰҳ����ɸѡ��¼
		recordCount = bigList.size();//�����¼��Ϊ���ݿ��б�������������
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