package factory;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proxy.ConnectionDemo01;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RegistrationScreen extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JTextField jobText;
	private JPasswordField passwordText;
	private static ImageIcon image;
	private static JLabel label;

	/**
	 * Launch the application.
	 */
			public static void run() {
				try {
					RegistrationScreen frame = new RegistrationScreen();
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
	 * 注册界面
	 */
	public RegistrationScreen(){
		setTitle("\u6B22\u8FCE\u6CE8\u518C\uFF01");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口时，程序也结束
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image=new ImageIcon("image/b5c97df8eaccc28953936bf48f68fa27.jpg");
		label=new JLabel(image);
		label.setSize(443, 271);
		label.setLocation(0, 0);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//把背景图片添加到分层窗格的最底层作为背景
		((JPanel)this.getContentPane()).setOpaque(false);//将panel不透明设置为false
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(34, 25, 85, 30);
		contentPane.add(lblNewLabel);
		
		usernameText = new JTextField();
		usernameText.setBounds(138, 25, 170, 30);
		contentPane.add(usernameText);
		usernameText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u804C\u4F4D\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(34, 75, 85, 30);
		contentPane.add(lblNewLabel_1);
		
		jobText = new JTextField();
		jobText.setBounds(138, 75, 170, 30);
		contentPane.add(jobText);
		jobText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(34, 125, 85, 30);
		contentPane.add(lblNewLabel_2);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(138, 125, 170, 30);
		contentPane.add(passwordText);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		JLabel label1=new JLabel();
		label1.setSize(232, 30);
		label1.setLocation(204, 185);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					String stanum=usernameText.getText();
					String job=jobText.getText();
					String password=passwordText.getText();
					ConnectionDemo01 dbcs=new ConnectionDemo01();
					String sql="insert into users(stanum,password,aut)"+"values(?,?,?)";
					String x=null;
					try(Connection conn=dbcs.getConnection()){//获取数据库接
							String sql1=String.format("Select COUNT(*) From %s where stanum = '%s'","employeeimformation",stanum);
							PreparedStatement pstmt1 = conn.prepareStatement(sql1);
							ResultSet result = pstmt1.executeQuery();
							if(result.next()) {
								x=result.getString(1);
							}
							if(!x.equals("0")) {
							    		PreparedStatement pstmt=conn.prepareStatement(sql);//实例化
							    		pstmt.setString(1, stanum);//定义第1个占位符的内容
							    		pstmt.setString(2, password);//定义第2个占位符的内容
							    		pstmt.setString(3, job);//定义第3个占位符的内容
							    		pstmt.executeUpdate();//执行插入语句
							    		label1.setForeground(Color.red);
							    		label1.setText("注册成功！"); 
							}
							else {
								label1.setForeground(Color.red);
								label1.setText("注册失败!");
							}
				    	}catch(SQLException a) {
				    		a.printStackTrace();
				    	}
					
					
				}
			}
		});
		btnNewButton.setBounds(90, 185, 95, 30);
		contentPane.add(label1);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("\u4F60\u7684\u5458\u5DE5\u7F16\u53F7");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(315, 25, 85, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7ECF\u7406or\u5458\u5DE5");
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(315, 75, 100, 30);
		contentPane.add(lblNewLabel_4);
	}
}
