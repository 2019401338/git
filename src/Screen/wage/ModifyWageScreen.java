package Screen.wage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EmployeeManagement.EmployeeInformation;
import EmployeeManagement.wageCalculate;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ModifyWageScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_8;
	private static ImageIcon image;
	private static JLabel label;

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					ModifyWageScreen frame = new ModifyWageScreen();
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
	 * 修改五险一金比例，修改工资界面
	 */
	public ModifyWageScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\qingcheng\\Pictures\\Saved Pictures\\Af5.png"));
		setTitle("\u5DE5\u8D44\u8868\u4FE1\u606F\u4FEE\u6539");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image=new ImageIcon("image/b5c97df8eaccc28953936bf48f68fa27.jpg");
		label=new JLabel(image);
		label.setSize(603, 485);
		label.setLocation(0,0);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//把背景图片添加到分层窗格的最底层作为背景
		((JPanel)this.getContentPane()).setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u4E94\u9669\u4E00\u91D1\u7684\u6BD4\u4F8B");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.green));
		lblNewLabel.setBounds(10, 10, 562, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u4E94\u9669\u4E00\u91D1\u7684\u6BD4\u4F8B\uFF08\u5C0F\u6570\uFF09\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(15, 46, 195, 35);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(240, 46, 160, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
				float found=Float.parseFloat(textField.getText());
				wageCalculate wa=new wageCalculate();
				wa.setFound(found);
				try {
					String sql = "select * from wagecalculate";
					wa.Calculate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblNewLabel_8.setForeground(Color.red);
				lblNewLabel_8.setText("五险一金比例修改成功！");
				}
			}
		});
		btnNewButton.setBounds(446, 46, 97, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("\u6839\u636E\u5458\u5DE5\u7F16\u53F7\u4FEE\u6539\u4E2A\u4EBA\u7684\u57FA\u672C\u5DE5\u8D44\uFF0C\u6D25\u8D34\uFF0C\u4EE3\u6263\u6B3E\u9879\uFF0C\u5956\u91D1");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBorder(BorderFactory.createLineBorder(Color.green));
		lblNewLabel_2.setBounds(17, 89, 562, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5458\u5DE5\u7F16\u53F7\uFF1A");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(25, 125, 95, 35);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();//员工编号
		textField_1.setBounds(135, 124, 263, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u57FA\u672C\u5DE5\u8D44\uFF1A");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(25, 180, 95, 35);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();//基本工资
		textField_2.setBounds(135, 180, 263, 36);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u6D25\u8D34\uFF1A");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(25, 235, 95, 35);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();//津贴
		textField_3.setBounds(135, 235, 263, 36);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u4EE3\u6263\u6B3E\u9879\uFF1A");//代扣款项
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(25, 290, 95,35);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u5956\u91D1\uFF1A");//奖金
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(25, 345, 95,35);
		contentPane.add(lblNewLabel_7);
		
		textField_4 = new JTextField();//代扣款项
		textField_4.setBounds(137, 290, 263, 36);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();//奖金
		textField_5.setBounds(136, 345, 263, 36);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");//修改按钮
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stanum=textField_1.getText();
				int bw=Integer.parseInt(textField_2.getText());
				float allo=Float.parseFloat(textField_3.getText());
				float whop=Float.parseFloat(textField_4.getText());
				float pm=Float.parseFloat(textField_5.getText());
				String sql="update wagecalculate set bw="+bw+",allo="+allo+",whop="+whop+",pm="+pm+" where stanum='"+stanum+"'";
				EmployeeInformation up=new EmployeeInformation();
				up.modify(sql);
				String sql1="select * from wagecalculate where stanum='"+stanum+"'";
				wageCalculate wa=new wageCalculate();
				try {
					wa.modyWg(sql1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblNewLabel_8.setForeground(Color.red);
				lblNewLabel_8.setText("修改成功！！");
			}
		});
		btnNewButton_1.setBounds(448, 124, 97, 33);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(277, 406, 200, 32);
		contentPane.add(lblNewLabel_8);
	}

}
