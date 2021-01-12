package vo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Impl.EmployeeInformation;
import Impl.PageController2;
import proxy.ConnectionDemo01;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Toolkit;

public class Mod_Del_SecScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Vector<String> titles;
	/**
	 *  ����������ģ��
	 */
	private DefaultTableModel model;
	private JTable table;// ������
	private JScrollPane scrollPane ;
	private static ImageIcon image;
	private static JLabel label;

	/**
	 * Launch the application.
	 */
			public static void run() {
				try {
					Mod_Del_SecScreen frame = new Mod_Del_SecScreen();
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
	 * ��ѯԱ����Ϣ����
	 */
	public Mod_Del_SecScreen() {
		setTitle("\u67E5\u8BE2\u5458\u5DE5\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\qingcheng\\Pictures\\Saved Pictures\\Af15.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���ʱ������Ҳ����
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image=new ImageIcon("image/b5c97df8eaccc28953936bf48f68fa27.jpg");
		label=new JLabel(image);
		label.setSize(700, 600);
		label.setLocation(0,0);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//�ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		((JPanel)this.getContentPane()).setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u7F16\u7801");//Ա�����
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 95, 35);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();//Ա�����
		textField.setBounds(110, 10, 165, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");//����
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 80, 95, 35);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();//����
		textField_1.setBounds(110, 80, 165, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		/**
		 * ��ѯ
		 */
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==btnNewButton_1) {
					String stanum=textField.getText();
					String sql="select * from employeeimformation where stanum='"+stanum+"'";//Ա����Ų�ѯ
					if(stanum.length()!=0) {
						try {
							model = new DefaultTableModel(new EmployeeInformation().checkStaff(sql), titles) ;
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
						scrollPane.setViewportView(table);
					}else {
						JOptionPane.showMessageDialog(null, "����Ϊ�գ�");
					}
				}
			}
		});
		btnNewButton_1.setBounds(422, 10, 95, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");//������ѯ
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField_1.getText();
				String sql1="select* from employeeimformation where staname='"+name+"'";//������ѯ
				if(name.length()!=0) {
					try {
						model = new DefaultTableModel(new EmployeeInformation().checkStaff(sql1), titles) ;
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
					scrollPane.setViewportView(table);
				}else {
					JOptionPane.showMessageDialog(null, "����Ϊ�գ�");
				}
			}
		});
		btnNewButton.setBounds(422, 80, 97, 35);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 155, 643, 301);
		contentPane.add(scrollPane);
		/**
		 * ���嶯̬�����ʾ������
		 */
		titles = new Vector<String>();
		Collections.addAll(titles, "id", "Ա������", "����","�Ա�","����","ְλ");
		Vector<Vector> stuInfo = new PageController2().getPaegData();//��ȡ��һҳ������
		model = new DefaultTableModel(stuInfo, titles);
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
		
		JButton btnPre = new JButton("��һҳ");
		btnPre.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController2().prePage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
			}
		});
		btnPre.setBounds(21, 484, 95, 35);
		contentPane.add(btnPre);

		JButton btnNext = new JButton("��һҳ");
		btnNext.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController2().nextPage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
			}
		});
		btnNext.setBounds(126, 484, 95, 35);
		contentPane.add(btnNext);
		
		JLabel lblMsg = new JLabel("ÿҳ��ʾ��");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setBounds(246, 486, 87, 35);
		contentPane.add(lblMsg);

		JComboBox comboBox = new JComboBox(new Integer[] {10,50,100,1000,2000});
		comboBox.addItemListener(new ItemListener() {//ҳ��������ѡ��ı��¼�
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//��ȡ��������ѡ��ֵ
				PageController2 pcl=new PageController2();
				pcl.setCountPerpage(pageSize);//����ÿҳ��ʾ��¼����
				model=new DefaultTableModel(pcl.getPaegData(),titles);//��������ģ��
				table.setModel(model);//���ñ������ģ��
			}
		});
		comboBox.setSelectedIndex(1);//����������Ĭ��ֵ
		comboBox.setBounds(318, 484, 55, 35);
		contentPane.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("\u5BFC\u51FA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelExporter exp=new ExcelExporter();
				File file=new File("e:/Ա����Ϣ��.xls");
				if(!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				try {
					exp.exportTable(table, file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "�����ɹ���");
			}
		});
		btnNewButton_2.setBounds(550, 110, 97, 35);
		contentPane.add(btnNewButton_2);

	}
}
