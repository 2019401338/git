package Screen.Staff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DataConnection.ConnectionDemo01;
import EmployeeManagement.EmployeeInformation;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DeleteStaffScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private static ImageIcon image;
	private static JLabel label;

	/**
	 * Launch the application.
	 * 删除员工信息界面
	 */
			public static void run() {
				try {
					DeleteStaffScreen frame = new DeleteStaffScreen();
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
	public DeleteStaffScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\qingcheng\\Pictures\\Saved Pictures\\Af11.png"));
		setTitle("\u6839\u636E\u5458\u5DE5\u7F16\u53F7\u5220\u9664");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image=new ImageIcon("image/工资管理背景图.jpg");
		label=new JLabel(image);
		label.setSize(450, 300);
		label.setLocation(0,0);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//把背景图片添加到分层窗格的最底层作为背景
		((JPanel)this.getContentPane()).setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u7F16\u53F7\uFF1A");//员工编号
		lblNewLabel.setIcon(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 74, 87, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();//员工编号编辑栏
		textField.setBounds(140, 74, 190, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stanum=textField.getText();
				String sql2="select count(*) from employeeimformation where stanum='"+stanum+"'";//判断是否存在
				ConnectionDemo01 dbcs = new ConnectionDemo01();
				Connection conn = dbcs.getConnection(); // 获取数据库接
				Statement state;
				String str=null;
				try {
					state = conn.createStatement();
					ResultSet rs=state.executeQuery(sql2);
					if(rs.next()) {
						str=rs.getString(1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if((Integer.parseInt(str)!=0)) {
				String sql="delete from employeeimformation where stanum='"+stanum+"'";
				EmployeeInformation em=new EmployeeInformation();
				em.delete(sql);//删除员工信息，同时部门表人数发生改变
				String sql1="delete from wagecalculate where stanum='"+stanum+"'";//同时删除工资表里的信息
				em.delete(sql1);
				lblNewLabel_1.setForeground(Color.red);
				lblNewLabel_1.setText("删除成功");
				}else {
					lblNewLabel_1.setForeground(Color.red);
					lblNewLabel_1.setText("没有该员工");
				}
			}
		});
		btnNewButton.setBounds(87, 159, 113, 40);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel();//提醒语句
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(240, 188, 147, 39);
		contentPane.add(lblNewLabel_1);
	}

}
