package Screen.departmentAndpassword;


import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import EmployeeManagement.department;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;

public class CheckDepartmentScreen extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private Vector<String> titles;
	private DefaultTableModel model;
	private JTable table;// ������
	private static ImageIcon image;
	private static JLabel label;

	/**
	 * Launch the application.
	 * ������Ϣ�鿴����
	 */

			public static void run() {
				try {
					CheckDepartmentScreen frame = new CheckDepartmentScreen();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public static void main(String[] args) {
				run();
			}

	/**
	 * Create the frame.
	 */
	public CheckDepartmentScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\qingcheng\\Pictures\\Saved Pictures\\Af15.png"));
		setTitle("\u90E8\u95E8\u4FE1\u606F\u5C55\u793A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image=new ImageIcon("image/b5c97df8eaccc28953936bf48f68fa27.jpg");
		label=new JLabel(image);
		label.setSize(504, 375);
		label.setLocation(0,0);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//�ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		((JPanel)this.getContentPane()).setOpaque(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 33, 436, 276);
		contentPane.add(scrollPane);
		
		titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "id", "����", "����Ա�����","��������","��������");
		String sql="select * from department ";
		department check=new department();
		try {
			model = new DefaultTableModel(check.checkdepart(sql), titles);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table=new JTable(model);
		scrollPane.setViewportView(table);
	}
}
