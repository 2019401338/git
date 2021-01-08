package Screen.Staff;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EmployeeManagement.EmployeeInformation;
import EmployeeManagement.department;
import EmployeeManagement.wageCalculate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AddStaff extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JRadioButton button_1;
	private JRadioButton button;
	private JComboBox jcb;
	private JLabel label_5;
	private static ImageIcon image;
	private static JLabel label;

	/**
	 * Launch the application.
	 */
			public static void run() {
				try {
					AddStaff frame = new AddStaff();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�رմ���ʱ������Ҳ����
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
	 * ����Ա������
	 */
	public AddStaff() {
		setTitle("\u589E\u52A0\u5458\u5DE5\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\qingcheng\\Pictures\\Saved Pictures\\Af1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		image=new ImageIcon("image/���ʹ�����ͼ.jpg");
		label=new JLabel(image);
		label.setSize(500, 350);
		label.setLocation(0,0);
		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));//�ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		((JPanel)this.getContentPane()).setOpaque(false);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u7F16\u53F7");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 75, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 70, 75, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u90E8\u95E8");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 130, 75, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u804C\u4F4D");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 190, 75, 33);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();//Ա�����
		textField.setBounds(112, 10, 182, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();//����
		textField_1.setBounds(112, 70, 182, 33);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		String[] dep= {"������","���²�","��ز�","������","�ۺϰ�","�豸��","����","���۲�"};
		jcb=new JComboBox(dep);
		jcb.setBounds(112, 130, 182, 33);
		contentPane.add(jcb);
		
		textField_3 = new JTextField();//ְλ
		textField_3.setBounds(112, 190, 182, 33);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		ButtonGroup group=new ButtonGroup();//�Ա���ѡ��ť����
		button = new JRadioButton("\u7537");
		button.setSelected(true);
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setBounds(379, 100, 39, 20);
		group.add(button);
		button_1 = new JRadioButton("\u5973");
		button_1.setHorizontalAlignment(SwingConstants.CENTER);
		button_1.setBounds(381, 135, 39, 24);
		group.add(button_1);
		contentPane.add(button_1);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					int sex;
					 if(button_1.isSelected()) {
						 sex=0;
					 }else sex=1;
					String stanum=textField.getText();
					String name=textField_1.getText();
					String department=jcb.getSelectedItem().toString();
					String jobs=textField_3.getText();
					if(stanum.length()!=0&&name.length()!=0&&jobs.length()!=0) {
					EmployeeInformation emp=new EmployeeInformation();
					emp.addStaff(stanum, name, sex, department, jobs);
					department de=new department();
					de.getStaffNum();
					wageCalculate wag=new wageCalculate();
					try {
						String sql="select * from wagecalculate where stanum='"+stanum+"'";
						wag.setBw(sql);//ͬʱ���û�������
					    wag.Calculate(sql);//������˹���
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					label_5.setForeground(Color.red);
					label_5.setText("��ӳ�Ա�ɹ���");
					//JOptionPane.showMessageDialog(null, "sucess");
					}else {
						label_5.setForeground(Color.red);
						label_5.setText("���ʧ�ܣ�����Ϊ�գ�");
					}
				}
			}
		});
		btnNewButton.setBounds(82, 263, 106, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("\u6027\u522B");//�Ա�
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(340, 53, 114, 33);
		contentPane.add(lblNewLabel_4);
		
		label_5 = new JLabel();
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(226, 263, 152, 40);
		contentPane.add(label_5);
		
	}
}
