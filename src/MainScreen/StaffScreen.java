package MainScreen;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Screen.Staff.Mod_Del_SecScreen;
import Screen.departmentAndpassword.CheckDepartmentScreen;
import Screen.wage.SelectWageScreen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class StaffScreen extends JFrame {

	private JPanel contentPane;
	private static ImageIcon image;
	private static JLabel label;

	/**
	 * Launch the application.
	 * Ա�������run����
	 */
			public static void run() {
				try {
					StaffScreen frame = new StaffScreen();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			/**
			 * ���ڲ���
			 * @param args
			 */
			public static void main(String[] args) {
				run();
			}

	/**
	 * Create the frame.
	 * Ա������
	 */
	public StaffScreen() {
		setTitle("\u6B22\u8FCE\u8FDB\u5165\u5458\u5DE5\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		image=new ImageIcon("image/���ʹ�����ͼ.jpg");
		label=new JLabel(image);
		label.setSize(443, 271);
		label.setLocation(0, 0);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//�ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		((JPanel)this.getContentPane()).setOpaque(false);//��panel��͸������Ϊfalse
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ա����Ϣ��ѯ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mod_Del_SecScreen check=new Mod_Del_SecScreen();
				check.run();
			}
		});
		btnNewButton.setBounds(139, 52, 125, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("���ʲ�ѯ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectWageScreen checkW=new SelectWageScreen();
				checkW.run();
			}
		});
		btnNewButton_1.setBounds(139, 122, 125, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("���Ų鿴");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckDepartmentScreen checkD=new CheckDepartmentScreen();
				checkD.run();
			}
		});
		btnNewButton_2.setBounds(139, 192, 125, 40);
		contentPane.add(btnNewButton_2);
		
	}

}
