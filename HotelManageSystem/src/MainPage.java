import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.UIManager;
import java.awt.Color;

public class MainPage{

	
	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//��ȡ�û�������Ļ����
	private RoomQueryFrame myroomqueryframe;
	private ReserveQueryFrame myreservequeryframe;
	private CustomerQueryFrame mycustomerqueryframe;
	boolean frontdeskmenuflag=false;
	boolean reservemenuflag=false;
	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Hotel Manage System");
		frame.setFocusable(true);
		
		
		//�˵���
		JMenuBar menuBar=new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setLocation(0, 0);
		frame.getContentPane().add(menuBar);
		menuBar.setSize(1920, 135);
		
		//ǰ̨�˵�
		JMenu frontdeskMenu=new JMenu("ǰ̨ ��");
		frontdeskMenu.setBackground(Color.LIGHT_GRAY);
		
		frontdeskMenu.setIcon(new ImageIcon("img/frontdesk.png"));
		
		frontdeskMenu.setVerticalTextPosition(SwingConstants.BOTTOM);      
		frontdeskMenu.setHorizontalTextPosition(SwingConstants.CENTER);    //����������ͼƬ�·�
		
		frontdeskMenu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				frontdeskMenu.setText("ǰ̨ ��");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				frontdeskMenu.setText("ǰ̨ ��");
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuItem frontdeskMenuitem1=new JMenuItem("������ס����");
		JMenuItem frontdeskMenuitem2=new JMenuItem("����������");
		JMenuItem frontdeskMenuitem3=new JMenuItem("����Ԥ������");
		frontdeskMenu.add(frontdeskMenuitem1);
		frontdeskMenu.add(frontdeskMenuitem2);
		frontdeskMenu.add(frontdeskMenuitem3);
		menuBar.add(frontdeskMenu);
		
		//�Ӵ��϶
		JMenu blank1=new JMenu("  ");
		blank1.setBackground(Color.LIGHT_GRAY);
		menuBar.add(blank1);
		
		//Ԥ���˵�
		JMenu reserveMenu=new JMenu("Ԥ�� ��");
		reserveMenu.setBackground(Color.LIGHT_GRAY);
		reserveMenu.setIcon(new ImageIcon("img/reserve.png"));
		
		reserveMenu.setVerticalTextPosition(SwingConstants.BOTTOM);      
		reserveMenu.setHorizontalTextPosition(SwingConstants.CENTER);    //����������ͼƬ�·�
		
		reserveMenu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				reserveMenu.setText("Ԥ�� ��");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				reserveMenu.setText("Ԥ�� ��");
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuItem reserveMenuitem1=new JMenuItem("����Ԥ������");
		JMenuItem reserveMenuitem2=new JMenuItem("��ȷ��Ԥ��");
		JMenuItem reserveMenuitem3=new JMenuItem("������ȷ��Ԥ��");
		JMenuItem reserveMenuitem4=new JMenuItem("������ȡ��Ԥ��");
		
		reserveMenu.add(reserveMenuitem1);
		reserveMenu.add(reserveMenuitem2);
		reserveMenu.addSeparator();
		reserveMenu.add(reserveMenuitem3);
		reserveMenu.add(reserveMenuitem4);
		menuBar.add(reserveMenu);
		
		//�Ӵ��϶
		JMenu blank2=new JMenu("  ");
		blank2.setBackground(Color.LIGHT_GRAY);
		menuBar.add(blank2);
		
		//��Ա��Ϣ�˵�
		JMenu customerMenu=new JMenu("��Ա��Ϣ ��");
		customerMenu.setBackground(Color.LIGHT_GRAY);
		customerMenu.setIcon(new ImageIcon("img/customer.png"));
				
		customerMenu.setVerticalTextPosition(SwingConstants.BOTTOM);      
		customerMenu.setHorizontalTextPosition(SwingConstants.CENTER); 
		
		customerMenu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				customerMenu.setText("��Ա��Ϣ ��");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				customerMenu.setText("��Ա��Ϣ ��");
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuItem customerMenuitem1=new JMenuItem("��Ա��Ϣά��");
		JMenuItem customerMenuitem2=new JMenuItem("��Ա��Ϣ����");
		JMenuItem customerMenuitem3=new JMenuItem("��Ա�������");
		
		customerMenu.add(customerMenuitem1);
		customerMenu.addSeparator();
		customerMenu.add(customerMenuitem2);
		customerMenu.add(customerMenuitem3);
		menuBar.add(customerMenu);
		
		//�Ӵ��϶
		JMenu blank3=new JMenu("  ");
		blank3.setBackground(Color.LIGHT_GRAY);
		menuBar.add(blank3);
		
		
		//��ѯ�˵�
		JMenu queryMenu=new JMenu("��ѯ ��");
		queryMenu.setBackground(Color.LIGHT_GRAY);
		queryMenu.setIcon(new ImageIcon("img/query.png"));
				
		queryMenu.setVerticalTextPosition(SwingConstants.BOTTOM);      
		queryMenu.setHorizontalTextPosition(SwingConstants.CENTER); 
		
		
		queryMenu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				queryMenu.setText("��ѯ ��");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				queryMenu.setText("��ѯ ��");
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuItem queryMenuitem1=new JMenuItem("�ͷ���Ϣ��ѯ");
		JMenuItem queryMenuitem2=new JMenuItem("Ԥ����Ϣ��ѯ");
		JMenuItem queryMenuitem3=new JMenuItem("��Ա��Ϣ��ѯ");
		
		queryMenu.add(queryMenuitem1);
		queryMenu.add(queryMenuitem2);
		queryMenu.add(queryMenuitem3);
		menuBar.add(queryMenu);
		
		queryMenuitem1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myroomqueryframe=new RoomQueryFrame();
			}
		});
		
			queryMenuitem2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myreservequeryframe=new ReserveQueryFrame();
			}
		});

		queryMenuitem3.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mycustomerqueryframe=new CustomerQueryFrame();
			}
		});
		
		//����
		JMenu background=new JMenu();
		background.setIcon(new ImageIcon("img/menuback.png"));
		background.setBackground(Color.LIGHT_GRAY);
		menuBar.add(background);
		
		//
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, screenSize.width, screenSize.height);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//
		
		frame.setVisible(true);
	}
	
}
