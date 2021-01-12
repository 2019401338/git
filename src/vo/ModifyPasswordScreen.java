package vo;


import java.awt.Color;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Impl.EmployeeInformation;
import Impl.Users;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ModifyPasswordScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Vector<String> titles;
	private DefaultTableModel model;// 定义表格数据模型
	private JTable table;// 定义表格
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_3;
	private static ImageIcon image;
	private static JLabel label;

	/**
	 * Launch the application.
	 * 修改密码和查询密码界面
	 */
	
			public static void run() {
				try {
					ModifyPasswordScreen frame = new ModifyPasswordScreen();
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
	public ModifyPasswordScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\qingcheng\\Pictures\\Saved Pictures\\Af1.png"));
		setTitle("\u5BC6\u7801\u4FEE\u6539");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image=new ImageIcon("image/b5c97df8eaccc28953936bf48f68fa27.jpg");
		label=new JLabel(image);
		label.setSize(501, 615);
		label.setLocation(0,0);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//把背景图片添加到分层窗格的最底层作为背景
		((JPanel)this.getContentPane()).setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u5458\u5DE5\u7F16\u53F7\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 20, 115, 35);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();//员工编号
		textField.setBounds(145, 20, 225, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 65, 115, 35);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();//新密码
		textField_1.setBounds(145, 65, 225, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");//修改按钮
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stanum=textField.getText();
				String password=textField_1.getText();
				if(stanum.length()!=0&&password.length()!=0) {
				String sql="update users set password='"+password+" where stanum='"+stanum+"'";
				EmployeeInformation em=new EmployeeInformation();
				em.modify(sql);
				lblNewLabel_3.setForeground(Color.red);
				lblNewLabel_3.setText("修改成功！");
				}else {
					lblNewLabel_3.setForeground(Color.red);
					lblNewLabel_3.setText("不能为空！");
				}
			}
		});
		btnNewButton.setBounds(209, 117, 83, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u8F93\u5165\u5458\u5DE5\u7F16\u53F7\uFF1A");//
		lblNewLabel_2.setBounds(10, 185, 115, 35);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();//搜索所需的员工编码
		textField_2.setBounds(145, 185, 225, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u641C\u7D22");//搜索
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stanum=textField_2.getText();
				String sql="select * from users where stanum='"+stanum+"'";
				Users user=new Users();
				try {
					model = new DefaultTableModel(user.checkPassword(sql), titles);
				} catch (SQLException a) {
					// TODO Auto-generated catch block
					a.printStackTrace();
				}
				table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton_1.setBounds(335, 235, 80, 31);
		contentPane.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 275, 439, 236);
		contentPane.add(scrollPane);
		
		titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "id", "密码", "职位","员工编号");
		String sql = "select * from users ";
		Users user=new Users();
		try {
			model = new DefaultTableModel(user.checkPassword(sql), titles);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		scrollPane.setViewportView(table);
		
		lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(339, 122, 122, 35);
		contentPane.add(lblNewLabel_3);
	}

}
