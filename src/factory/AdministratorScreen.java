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
 * ����Ա����
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
	 * ����Ա����
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
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//�ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		((JPanel)this.getContentPane()).setOpaque(false);
		
		JMenuBar menuBar = new JMenuBar();
		//contentPane.add(menuBar,BorderLayout.NORTH);
		JMenu menuStaff=new JMenu("Ա����Ϣ����");
		menuStaff.setIcon(null);
		JMenu menuWage=new JMenu("���ʹ���");
		JMenu menuDepartment=new JMenu("���Ź���");
		
		JMenu menuPassword=new JMenu("�����޸�");
		JMenuItem miCM=new JMenuItem("������޸ĺͲ鿴");
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
		JMenuItem micheck=new JMenuItem("�鿴������Ϣ");
		micheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckDepartmentScreen checkdp=new CheckDepartmentScreen();
				checkdp.run();
			}
		});
		menuDepartment.add(micheck);
		JMenuItem miAdd=new JMenuItem("����Ա��");
		miAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStaff ad=new AddStaff();
				ad.run();
			}
		});
		JMenuItem miModify=new JMenuItem("�޸�Ա����Ϣ");
		miModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyStaffScreen mody=new ModifyStaffScreen();
				mody.run();
			}
		});
		JMenuItem miDelete=new JMenuItem("ɾ��Ա��");
		miDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStaffScreen del=new DeleteStaffScreen();
				del.run();
			}
		});
		JMenuItem miQuery=new JMenuItem("��ѯԱ����Ϣ");
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
		JMenuItem menuItem_1 = new JMenuItem("�޸Ĺ���");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyWageScreen mody=new ModifyWageScreen();
				mody.run();
			}
		});
		menuWage.add(menuItem_1);
		JMenuItem menuItem = new JMenuItem("��ѯ���ʱ�");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectWageScreen check=new SelectWageScreen();
				check.run();
			}
		});
		menuWage.add(menuItem);
		
	}
}
