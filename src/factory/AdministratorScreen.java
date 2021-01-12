package factory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import vo.AddStaff;
import vo.CheckDepartmentScreen;
import vo.DeleteStaffScreen;
import vo.Mod_Del_SecScreen;
import vo.ModifyPasswordScreen;
import vo.ModifyStaffScreen;
import vo.ModifyWageScreen;
import vo.SelectWageScreen;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
/**
 * 管理员界面
 * @author qingcheng
 *
 */
public class AdministratorScreen extends JFrame {

	private JPanel contentPane;
	private static ImageIcon image;
	private static JLabel label;

	/**
	 * Launch the application.
	 */
			public static void run() {
				try {
					AdministratorScreen frame = new AdministratorScreen();
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
	 * 管理员界面
	 */
	public AdministratorScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\qingcheng\\Pictures\\Saved Pictures\\Af5.png"));
		setTitle("\u5458\u5DE5\u5DE5\u8D44\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image=new ImageIcon("image/616pic.jpg");
		label=new JLabel(image);
		label.setSize(536, 404);
		label.setLocation(0, 0);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//把背景图片添加到分层窗格的最底层作为背景
		((JPanel)this.getContentPane()).setOpaque(false);
		
		JMenuBar menuBar = new JMenuBar();
		//contentPane.add(menuBar,BorderLayout.NORTH);
		JMenu menuStaff=new JMenu("员工信息管理");
		menuStaff.setIcon(null);
		JMenu menuWage=new JMenu("工资管理");
		JMenu menuDepartment=new JMenu("部门管理");
		
		JMenu menuPassword=new JMenu("密码修改");
		JMenuItem miCM=new JMenuItem("密码的修改和查看");
		miCM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyPasswordScreen pass=new ModifyPasswordScreen();
				pass.run();
			}
		});
		menuPassword.add(miCM);
			
		this.setJMenuBar(menuBar);
		menuBar.add(menuStaff);
		menuBar.add(menuWage);
		menuBar.add(menuDepartment);
		menuBar.add(menuPassword);
		JMenuItem micheck=new JMenuItem("查看部门信息");
		micheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckDepartmentScreen checkdp=new CheckDepartmentScreen();
				checkdp.run();
			}
		});
		menuDepartment.add(micheck);
		JMenuItem miAdd=new JMenuItem("增加员工");
		miAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStaff ad=new AddStaff();
				ad.run();
			}
		});
		JMenuItem miModify=new JMenuItem("修改员工信息");
		miModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyStaffScreen mody=new ModifyStaffScreen();
				mody.run();
			}
		});
		JMenuItem miDelete=new JMenuItem("删除员工");
		miDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStaffScreen del=new DeleteStaffScreen();
				del.run();
			}
		});
		JMenuItem miQuery=new JMenuItem("查询员工信息");
		miQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mod_Del_SecScreen chk=new Mod_Del_SecScreen();
				chk.run();
			}
		});
		menuStaff.add(miAdd);
		menuStaff.add(miModify);
		menuStaff.add(miDelete);
		menuStaff.add(miQuery);
		JMenuItem menuItem_1 = new JMenuItem("修改工资");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyWageScreen mody=new ModifyWageScreen();
				mody.run();
			}
		});
		menuWage.add(menuItem_1);
		JMenuItem menuItem = new JMenuItem("查询工资表");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectWageScreen check=new SelectWageScreen();
				check.run();
			}
		});
		menuWage.add(menuItem);
		
	}
}
