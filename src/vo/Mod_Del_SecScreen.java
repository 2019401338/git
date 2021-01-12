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
	 *  定义表格数据模型
	 */
	private DefaultTableModel model;
	private JTable table;// 定义表格
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
	 * 查询员工信息界面
	 */
	public Mod_Del_SecScreen() {
		setTitle("\u67E5\u8BE2\u5458\u5DE5\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\qingcheng\\Pictures\\Saved Pictures\\Af15.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口时，程序也结束
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image=new ImageIcon("image/b5c97df8eaccc28953936bf48f68fa27.jpg");
		label=new JLabel(image);
		label.setSize(700, 600);
		label.setLocation(0,0);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//把背景图片添加到分层窗格的最底层作为背景
		((JPanel)this.getContentPane()).setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u7F16\u7801");//员工编号
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 95, 35);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();//员工编号
		textField.setBounds(110, 10, 165, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");//姓名
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 80, 95, 35);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();//姓名
		textField_1.setBounds(110, 80, 165, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		/**
		 * 查询
		 */
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==btnNewButton_1) {
					String stanum=textField.getText();
					String sql="select * from employeeimformation where stanum='"+stanum+"'";//员工编号查询
					if(stanum.length()!=0) {
						try {
							model = new DefaultTableModel(new EmployeeInformation().checkStaff(sql), titles) ;
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
						scrollPane.setViewportView(table);
					}else {
						JOptionPane.showMessageDialog(null, "不能为空！");
					}
				}
			}
		});
		btnNewButton_1.setBounds(422, 10, 95, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");//姓名查询
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField_1.getText();
				String sql1="select* from employeeimformation where staname='"+name+"'";//姓名查询
				if(name.length()!=0) {
					try {
						model = new DefaultTableModel(new EmployeeInformation().checkStaff(sql1), titles) ;
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
					scrollPane.setViewportView(table);
				}else {
					JOptionPane.showMessageDialog(null, "不能为空！");
				}
			}
		});
		btnNewButton.setBounds(422, 80, 97, 35);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 155, 643, 301);
		contentPane.add(scrollPane);
		/**
		 * 定义动态数组表示表格标题
		 */
		titles = new Vector<String>();
		Collections.addAll(titles, "id", "员工编码", "姓名","性别","部门","职位");
		Vector<Vector> stuInfo = new PageController2().getPaegData();//获取第一页的数据
		model = new DefaultTableModel(stuInfo, titles);
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
		
		JButton btnPre = new JButton("上一页");
		btnPre.addActionListener(new ActionListener() {//上一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController2().prePage(),titles);//设置数据模型中的数据为上一页内容
				table.setModel(model);//设置表格的数据模型
			}
		});
		btnPre.setBounds(21, 484, 95, 35);
		contentPane.add(btnPre);

		JButton btnNext = new JButton("下一页");
		btnNext.addActionListener(new ActionListener() {//下一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController2().nextPage(),titles);//设置数据模型中的数据为下一页内容
				table.setModel(model);//设置表格的数据模型
			}
		});
		btnNext.setBounds(126, 484, 95, 35);
		contentPane.add(btnNext);
		
		JLabel lblMsg = new JLabel("每页显示：");
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg.setBounds(246, 486, 87, 35);
		contentPane.add(lblMsg);

		JComboBox comboBox = new JComboBox(new Integer[] {10,50,100,1000,2000});
		comboBox.addItemListener(new ItemListener() {//页数下拉框选择改变事件
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//获取下拉框所选的值
				PageController2 pcl=new PageController2();
				pcl.setCountPerpage(pageSize);//设置每页显示记录条数
				model=new DefaultTableModel(pcl.getPaegData(),titles);//设置数据模型
				table.setModel(model);//设置表格数据模型
			}
		});
		comboBox.setSelectedIndex(1);//设置下拉框默认值
		comboBox.setBounds(318, 484, 55, 35);
		contentPane.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("\u5BFC\u51FA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelExporter exp=new ExcelExporter();
				File file=new File("e:/员工信息表.xls");
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
				JOptionPane.showMessageDialog(null, "导出成功！");
			}
		});
		btnNewButton_2.setBounds(550, 110, 97, 35);
		contentPane.add(btnNewButton_2);

	}
}
