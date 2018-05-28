import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JPanel;

public class login {

	private JFrame frame;
	private JTextField Account;
	private JPasswordField Password;
	private final JPanel panel = new JPanel();
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//��ȡ�û�������Ļ����
	Font AccFont = new Font("����",Font.ITALIC, 16);
	Font PassFont = new Font("����",Font.ITALIC, 16);
	Font AccEnFont=new Font("����",Font.PLAIN, 16);
	private DatabaseCon LoginCon;  //���ݿ����ӵ���д��һ����  ����getConn()������ȡConnection
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		//����BeautyEye���
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BeautyEyeLNFHelper.frameBorderStyle=BeautyEyeLNFHelper.frameBorderStyle.translucencySmallShadow;  //����ģʽ
		
		UIManager.put("RootPane.setupButtonVisible", false);   //ȡ�����ð�ť
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//�������ݿ�
		LoginCon=new DatabaseCon(); 
		
		//��������
		frame = new JFrame();
		frame.setBounds(screenSize.width/2-210, screenSize.height/2-160, 420, 320);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);     //��ֹ�ı��С
		frame.getContentPane().setLayout(null);    //ȡ�����ֽṹ
        ((JPanel)frame.getContentPane()).setOpaque(false);  //����ContentPane͸��
		frame.setTitle("Hotel Manage System");
        //���ñ���
        ImageIcon background = new ImageIcon("img/background.jpg");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(-25, -10, background.getIconWidth(),background.getIconHeight());
        frame.getLayeredPane().add(backgroundLabel, new Integer(Integer.MIN_VALUE));
        //���������frame
        frame.setFocusable(true);
        
        
		//�˺��ı���
		Account = new JTextField();
		Account.setBackground(Color.LIGHT_GRAY);
		Account.setBounds(164, 82, 140, 28);
		frame.getContentPane().add(Account);
		Account.setColumns(10);
		Account.setFont(AccFont);
		Account.setText("Account");
		Account.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
				//����������ʾAccount��ʾ
				if(Account.getText()==null||Account.getText().equals(""))
				{
					Account.setFont(AccFont);
					Account.setText("Account");
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(Account.getText().equals("Account"))
				Account.setText("");
				Account.setFont(AccEnFont);
			}
		});
		
		//�˺ű�ǩ��
		JLabel AccountLabel = new JLabel("Account");
		AccountLabel.setForeground(Color.BLACK);
		AccountLabel.setFont(new Font("����", Font.PLAIN, 18));
		AccountLabel.setBounds(86, 82, 68, 22);
		frame.getContentPane().add(AccountLabel);
		
		//�����ǩ��
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setForeground(Color.BLACK);
		PasswordLabel.setFont(new Font("����", Font.PLAIN, 18));
		PasswordLabel.setBounds(76, 120, 78, 22);
		frame.getContentPane().add(PasswordLabel);
		
		//��½��ť
		JButton Login = new JButton("Login");
		Login.setForeground(Color.BLACK);
		Login.setBackground(Color.LIGHT_GRAY);
		Login.setBounds(76, 172, 93, 23);
		frame.getContentPane().add(Login);
		Login.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
		Login.addActionListener(new ActionListener() {
			
			String passres;
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				/*
				//����˺����������Ƿ���ȷ
				try {
					
					PreparedStatement sql=LoginCon.getConn().prepareStatement("select password from logininf where account = ? ");
					sql.setString(1, Account.getText());
					ResultSet res=sql.executeQuery();
					while(res.next())
					{
						passres=res.getString("password");	
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				if(passres.equals(String.valueOf(Password.getPassword())))
				{
					MainPage my=new MainPage();
					frame.dispose();
					System.out.println("�˺�������֤��ȷ");
				}
				else
				{
					PasswordError PsError=new PasswordError();
					System.out.println("�������");
				}
				*/
				MainPage my=new MainPage();
				frame.dispose();
			}
		});
		
		//������
		Password = new JPasswordField();
		Password.setToolTipText("");
		Password.setForeground(Color.BLACK);
		Password.setBackground(Color.LIGHT_GRAY);
		Password.setEchoChar((char) 0);
		Password.setFont(PassFont);
		Password.setText("Password");
		Password.setBounds(164, 120, 140, 28);
		frame.getContentPane().add(Password);
		Password.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if(String.valueOf(Password.getPassword())==null||String.valueOf(Password.getPassword()).equals(""))
				{
					Password.setEchoChar((char) 0);
					Password.setFont(PassFont);
					Password.setText("Password");
					
				}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				Password.setEchoChar('*');
				Password.setFont(null);
				if(String.valueOf(Password.getPassword()).equals("Password"))
				{
					Password.setText("");
				}
			}
		});
		//�˳���ť
		JButton Exit = new JButton("Exit");
		Exit.setBackground(Color.LIGHT_GRAY);
		Exit.setForeground(Color.BLACK);
		Exit.setBounds(200, 172, 93, 23);
		Exit.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
		Exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		
		//����һ��panel��������������͸������
		frame.getContentPane().add(Exit);
		panel.setBounds(0, -11, 404, 291);
		panel.setOpaque(false);
		frame.getContentPane().add(panel);
		
	}
	
	
}
