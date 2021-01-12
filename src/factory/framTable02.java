package factory;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import proxy.ConnectionDemo01;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
/**
 * 登陆界面(员工登录，管理员登陆，注册)
 * @author qingcheng
 *
 */
public class framTable02 extends JFrame {
	private JPanel contentPane;
	private static JLabel label;
	private static ImageIcon image;
	private JTextField textField;
	private JPasswordField textField_1;
	/**
	 * Launch the application.
	 * 登陆界面(员工登录，管理员登陆，注册)的主方法
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					framTable02 frame = new framTable02();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口时，程序也结束
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 登陆界面(员工登录，管理员登陆，注册)
	 */
	public framTable02() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\qingcheng\\Pictures\\Saved Pictures\\d972054217f92e29390bb0516035ed94.jpg"));
		setForeground(Color.CYAN);
		setTitle("\u6B22\u8FCE\u4F7F\u7528\u516C\u53F8\u5DE5\u8D44\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		image=new ImageIcon("image/2e30ac784d4569f0da70a107b25dbe89.jpg");
		label=new JLabel(image);
		label.setSize(443, 271);
		label.setLocation(0, 0);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//把背景图片添加到分层窗格的最底层作为背景
		((JPanel)this.getContentPane()).setOpaque(false);//将panel不透明设置为false
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");//用户名标签
		lblNewLabel.setBounds(33, 16, 81, 26);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");//密码标签
		lblNewLabel_1.setBounds(33, 87, 75, 26);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();//用户名编写
		textField.setBounds(124, 11, 208, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();//密码编写
		textField_1.setBounds(124, 82, 208, 37);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u5458\u5DE5\u767B\u5F55");//员工登录按钮
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button) {
					String stanum=textField.getText();
					String sql1="select aut from users where stanum='"+stanum+"'";
					String password=textField_1.getText();
						String sql="select * from users where stanum='"+stanum+"' and password='"+password+"'";
						if(matching(sql)) {
								StaffScreen staff=new StaffScreen();
								staff.run();
						}	
				}
			}
		});
		button.setBounds(33, 177, 91, 30);
		button.setToolTipText("");
		contentPane.add(button);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");//注册按钮
		btnNewButton_1.setBounds(326, 177, 91, 30);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationScreen a =new RegistrationScreen();
				a.run();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton button2 = new JButton("\u7BA1\u7406\u5458\u767B\u9646");//管理员登陆按钮
		JLabel label_3 = new JLabel();
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(83, 230, 283, 31);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button2) {
					String stanum=textField.getText();
					String sql1="select aut from users where stanum='"+stanum+"'";
					String password=textField_1.getText();
						String sql="select * from users where stanum='"+stanum+"' and password='"+password+"'";
						if(matching(sql)) {
							if("经理".equals(matching1(sql1))) {
								AdministratorScreen adm=new AdministratorScreen();
								adm.run();
							}
						}
						else {
							label_3.setForeground(Color.red);
							label_3.setText("你不是管理员或密码输入错误，无法进入");
						}
				}
			}
		});
		button2.setBounds(176, 177, 105, 30);
		contentPane.add(button2);
		contentPane.add(label_3);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F60\u7684\u5458\u5DE5\u7F16\u53F7");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(342, 16, 101, 26);
		contentPane.add(lblNewLabel_2);
		
	}
	/**
	 * 密码匹配方法
	 * @param sql
	 * @return
	 */
	public boolean matching(String sql) {
		ConnectionDemo01 dbcs=new ConnectionDemo01();
		try(Connection conn=dbcs.getConnection()){//获取数据库接
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			ResultSet result = pstmt1.executeQuery();
			if(result.next()) {
				return true;
			}
    	}catch(SQLException a) {
    		a.printStackTrace();
    	}
		return false;
	}
	/**
	 * 身份匹配方法
	 * @param sql
	 * @return
	 */
	public String matching1(String sql) {
		ConnectionDemo01 dbcs=new ConnectionDemo01();
		try(Connection conn=dbcs.getConnection()){//获取数据库接
			PreparedStatement pstmt1 = conn.prepareStatement(sql);
			ResultSet result = pstmt1.executeQuery();
			if(result.next()) {
				return result.getString(1);
			}
    	}catch(SQLException a) {
    		a.printStackTrace();
    	}
		return "无";
	}
}
