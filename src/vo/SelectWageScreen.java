package vo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Impl.PageController2;
import Impl.PageController3;
import Impl.wageCalculate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class SelectWageScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Vector<String> titles;
	private DefaultTableModel model;// ����������ģ��
	private JTable table;// ������
	private JScrollPane scrollPane ;
	private static ImageIcon image;
	private static JLabel label;

	/**
	 * Launch the application.
	 */
			public static void run() {
				try {
					SelectWageScreen frame = new SelectWageScreen();
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
	 * ��ѯ������Ϣ��
	 */
	public SelectWageScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\qingcheng\\Pictures\\Saved Pictures\\Af15.png"));
		setTitle("\u67E5\u8BE2\u5DE5\u8D44\u8868");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image=new ImageIcon("image/b5c97df8eaccc28953936bf48f68fa27.jpg");
		label=new JLabel(image);
		label.setSize(697, 608);
		label.setLocation(0,0);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//�ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		((JPanel)this.getContentPane()).setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u7F16\u53F7\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 35, 105, 40);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(140, 35, 190, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");//��ѯ��ť
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stanum=textField.getText();//
				String sql="select * from wagecalculate where stanum='"+stanum+"'";
				wageCalculate wa=new wageCalculate();
				try {
					Vector<Vector> in=wa.checkWage(sql);
					model = new DefaultTableModel(in, titles);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton.setBounds(381, 35, 90, 40);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 103, 643, 353);
		contentPane.add(scrollPane);
		
		titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "id", "Ա������", "��������","����","���ۿ���","����","����","����һ��","ʵ������");
		Vector<Vector> stuInfo = new PageController3().getPaegData();//��ȡ��һҳ������
		model = new DefaultTableModel(stuInfo, titles);// ʹ��DefaultTableModel����ģ��ʵ�������
		table = new JTable(model);
		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
		
		JButton btnPre = new JButton("��һҳ");
		btnPre.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController3().prePage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
			}
		});
		btnPre.setBounds(21, 484, 95, 35);
		contentPane.add(btnPre);

		JButton btnNext = new JButton("��һҳ");
		btnNext.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController3().nextPage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
			}
		});
		btnNext.setBounds(126, 484, 95, 35);
		contentPane.add(btnNext);
		
		JLabel lblMsg = new JLabel("ÿҳ��ʾ��");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setBounds(246, 486, 87, 35);
		contentPane.add(lblMsg);

		JComboBox comboBox = new JComboBox(new Integer[] {10,50,100,1000,2000,10000});
		comboBox.addItemListener(new ItemListener() {//ҳ��������ѡ��ı��¼�
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//��ȡ��������ѡ��ֵ
				PageController3 pcl=new PageController3();
				pcl.setCountPerpage(pageSize);//����ÿҳ��ʾ��¼����
				model=new DefaultTableModel(pcl.getPaegData(),titles);//��������ģ��
				table.setModel(model);//���ñ������ģ��
			}
		});
		comboBox.setSelectedIndex(1);//����������Ĭ��ֵ
		comboBox.setBounds(318, 484, 55, 35);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("\u5BFC\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelExporter exp=new ExcelExporter();
				File file=new File("e:/Ա������.xls");
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
		btnNewButton_1.setBounds(526, 70, 75, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
