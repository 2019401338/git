package vo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Impl.EmployeeInformation;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class ModifyStaffScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_5;
	private static ImageIcon image;
	private static JLabel label;

	/**
	 * Launch the application.
	 */
			public static void run() {
				try {
					ModifyStaffScreen frame = new ModifyStaffScreen();
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
	 * 修改员工信息界面
	 */
	public ModifyStaffScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\qingcheng\\Pictures\\Saved Pictures\\Af5.png"));
		setTitle("\u6839\u636E\u5458\u5DE5\u7F16\u53F7\u4FEE\u6539");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 537, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image=new ImageIcon("image/b5c97df8eaccc28953936bf48f68fa27.jpg");
		label=new JLabel(image);
		label.setSize(537, 422);
		label.setLocation(0,0);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//把背景图片添加到分层窗格的最底层作为背景
		((JPanel)this.getContentPane()).setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u7F16\u53F7");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 25, 95, 40);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();//编号
		textField.setBounds(113, 25, 213, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4FEE\u6539\u4EE5\u4E0B\u4FE1\u606F");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 72, 478, 30);
		lblNewLabel_1.setBorder(BorderFactory.createLineBorder(Color.gray));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 125, 95, 40);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();//姓名
		textField_1.setBounds(113, 125, 213, 37);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u90E8\u95E8\uFF1A");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 195, 95, 40);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();//部门
		textField_2.setBounds(113, 195, 213, 37);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u804C\u4F4D\uFF1A");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 265, 95, 40);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();//职位
		textField_3.setBounds(113, 265, 213, 37);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stanum=textField.getText();
				String name=textField_1.getText();
				String department=textField_2.getText();
				String job=textField_3.getText();
				String sql="update employeeimformation set staname='"+name+"',department='"+department+"',jobs='"+job+"' where stanum='"+stanum+"'";
				EmployeeInformation em=new EmployeeInformation();//员工信息修改
				em.modify(sql);
				String sql1="update department set mgname='"+name+"' where stanum='"+stanum+"'";//如果涉及到部门，就修改
				em.modify(sql1);
				lblNewLabel_5.setForeground(Color.red);
				lblNewLabel_5.setText("修改成功！");
			}
		});
		btnNewButton.setBounds(384, 25, 104, 37);
		contentPane.add(btnNewButton);
		
		lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(237, 327, 169, 34);
		contentPane.add(lblNewLabel_5);
	}
}
