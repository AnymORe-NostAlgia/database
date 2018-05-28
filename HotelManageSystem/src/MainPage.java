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
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取用户电脑屏幕数据
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
		
		
		//菜单栏
		JMenuBar menuBar=new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setLocation(0, 0);
		frame.getContentPane().add(menuBar);
		menuBar.setSize(1920, 135);
		
		//前台菜单
		JMenu frontdeskMenu=new JMenu("前台 ▼");
		frontdeskMenu.setBackground(Color.LIGHT_GRAY);
		
		frontdeskMenu.setIcon(new ImageIcon("img/frontdesk.png"));
		
		frontdeskMenu.setVerticalTextPosition(SwingConstants.BOTTOM);      
		frontdeskMenu.setHorizontalTextPosition(SwingConstants.CENTER);    //设置文字在图片下方
		
		frontdeskMenu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				frontdeskMenu.setText("前台 ▲");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				frontdeskMenu.setText("前台 ▼");
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuItem frontdeskMenuitem1=new JMenuItem("今日在住客人");
		JMenuItem frontdeskMenuitem2=new JMenuItem("今日离店客人");
		JMenuItem frontdeskMenuitem3=new JMenuItem("今日预离店客人");
		frontdeskMenu.add(frontdeskMenuitem1);
		frontdeskMenu.add(frontdeskMenuitem2);
		frontdeskMenu.add(frontdeskMenuitem3);
		menuBar.add(frontdeskMenu);
		
		//加大空隙
		JMenu blank1=new JMenu("  ");
		blank1.setBackground(Color.LIGHT_GRAY);
		menuBar.add(blank1);
		
		//预定菜单
		JMenu reserveMenu=new JMenu("预订 ▼");
		reserveMenu.setBackground(Color.LIGHT_GRAY);
		reserveMenu.setIcon(new ImageIcon("img/reserve.png"));
		
		reserveMenu.setVerticalTextPosition(SwingConstants.BOTTOM);      
		reserveMenu.setHorizontalTextPosition(SwingConstants.CENTER);    //设置文字在图片下方
		
		reserveMenu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				reserveMenu.setText("预订 ▲");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				reserveMenu.setText("预订 ▼");
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuItem reserveMenuitem1=new JMenuItem("网络预订汇总");
		JMenuItem reserveMenuitem2=new JMenuItem("待确认预定");
		JMenuItem reserveMenuitem3=new JMenuItem("今日已确定预定");
		JMenuItem reserveMenuitem4=new JMenuItem("今日已取消预定");
		
		reserveMenu.add(reserveMenuitem1);
		reserveMenu.add(reserveMenuitem2);
		reserveMenu.addSeparator();
		reserveMenu.add(reserveMenuitem3);
		reserveMenu.add(reserveMenuitem4);
		menuBar.add(reserveMenu);
		
		//加大空隙
		JMenu blank2=new JMenu("  ");
		blank2.setBackground(Color.LIGHT_GRAY);
		menuBar.add(blank2);
		
		//会员信息菜单
		JMenu customerMenu=new JMenu("会员信息 ▼");
		customerMenu.setBackground(Color.LIGHT_GRAY);
		customerMenu.setIcon(new ImageIcon("img/customer.png"));
				
		customerMenu.setVerticalTextPosition(SwingConstants.BOTTOM);      
		customerMenu.setHorizontalTextPosition(SwingConstants.CENTER); 
		
		customerMenu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				customerMenu.setText("会员信息 ▲");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				customerMenu.setText("会员信息 ▼");
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuItem customerMenuitem1=new JMenuItem("会员信息维护");
		JMenuItem customerMenuitem2=new JMenuItem("会员信息汇总");
		JMenuItem customerMenuitem3=new JMenuItem("会员升级情况");
		
		customerMenu.add(customerMenuitem1);
		customerMenu.addSeparator();
		customerMenu.add(customerMenuitem2);
		customerMenu.add(customerMenuitem3);
		menuBar.add(customerMenu);
		
		//加大空隙
		JMenu blank3=new JMenu("  ");
		blank3.setBackground(Color.LIGHT_GRAY);
		menuBar.add(blank3);
		
		
		//查询菜单
		JMenu queryMenu=new JMenu("查询 ▼");
		queryMenu.setBackground(Color.LIGHT_GRAY);
		queryMenu.setIcon(new ImageIcon("img/query.png"));
				
		queryMenu.setVerticalTextPosition(SwingConstants.BOTTOM);      
		queryMenu.setHorizontalTextPosition(SwingConstants.CENTER); 
		
		
		queryMenu.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				queryMenu.setText("查询 ▲");
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				queryMenu.setText("查询 ▼");
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuItem queryMenuitem1=new JMenuItem("客房信息查询");
		JMenuItem queryMenuitem2=new JMenuItem("预订信息查询");
		JMenuItem queryMenuitem3=new JMenuItem("会员信息查询");
		
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
		
		//背景
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
