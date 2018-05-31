import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.UIManager;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;

public class MainPage{

	
	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取用户电脑屏幕数据
	private RoomQueryFrame myroomqueryframe;
	private ReserveQueryFrame myreservequeryframe;
	private CustomerQueryFrame mycustomerqueryframe;
	boolean frontdeskmenuflag=false;
	boolean reservemenuflag=false;
	
	int flag=0;
	
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
		
		//桌面面板
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setForeground(Color.WHITE);
		ImageIcon icon=new ImageIcon("img/logo.jpg");
		JLabel backlabel=new JLabel(icon);
		backlabel.setBounds(screenSize.width/2-icon.getIconWidth()/2, screenSize.height/2-icon.getIconHeight()/2-100, icon.getIconWidth(), icon.getIconHeight());
		desktopPane.setBounds(0, 134, screenSize.width, screenSize.height-menuBar.getHeight());
		frame.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);
		desktopPane.add(backlabel);
		
		//内部面板
			
			
		
			JInternalFrame iframe1_1=new JInternalFrame("今日在住客人");
			iframe1_1.setVisible(true);
			iframe1_1.setResizable(false);
			
			JInternalFrame iframe1_2=new JInternalFrame("今日离店客人");
			iframe1_2.setVisible(true);
			iframe1_2.setResizable(false);
			
			JInternalFrame iframe1_3=new JInternalFrame("今日预离店客人");
			iframe1_3.setVisible(true);
			iframe1_3.setResizable(false);
			
			JInternalFrame iframe2_1=new JInternalFrame("网络预订汇总");
			iframe2_1.setVisible(true);
			iframe2_1.setResizable(false);
			
			JInternalFrame iframe2_2=new JInternalFrame("待确认预订");
			iframe2_2.setVisible(true);
			iframe2_2.setResizable(false);
			
			JInternalFrame iframe2_3=new JInternalFrame("今日已确定预订");
			iframe2_3.setVisible(true);
			iframe2_3.setResizable(false);
			
			JInternalFrame iframe2_4=new JInternalFrame("今日已取消预订");
			iframe2_4.setVisible(true);
			iframe2_4.setResizable(false);
			
			JInternalFrame iframe3_1=new JInternalFrame("会员信息维护");
			iframe3_1.setVisible(true);
			iframe3_1.setResizable(false);
			
			JInternalFrame iframe3_2=new JInternalFrame("会员信息汇总");
			iframe3_2.setVisible(true);
			iframe3_2.setResizable(false);
			
			JInternalFrame iframe3_3=new JInternalFrame("会员升级情况");
			iframe3_3.setVisible(true);
			iframe3_3.setResizable(false);
			
			JInternalFrame iframe4_4=new JInternalFrame("房间汇总");
			iframe4_4.setVisible(true);
			iframe4_4.setResizable(false);
				
			//iframe4_4界面
				iframe4_4.setLayout(null);
				JButton[] room=new JButton[25];
				String[] roomid= {"3001","3002","3003","3004","3005","3006","3007",
								  "4001","4002","4003","4004","4005","4006","4007",
								  "5001","5002","5003","5004","5005","5006","5007",
								  "6001","6002","6003","6004"};
				
				int roomWidth=(screenSize.width-70)/7;
				int roomHeight=(screenSize.height-menuBar.getHeight()-200)/4;
				int widthDis=roomWidth+5;
				int heightDis=roomHeight+5;
				Font roomFont=new Font("宋体",Font.PLAIN, 16);
				int i=0;
				for(i=0;i<25;i++)
				{
					room[i]=new JButton(roomid[i]);
					room[i].setFont(roomFont);
					if(i<7)
					room[i].setBounds(10+widthDis*i, 10, roomWidth, roomHeight);
					else if (i<14)
						room[i].setBounds(10+widthDis*(i-7), 10+heightDis, roomWidth, roomHeight);
					else if (i<21)
						room[i].setBounds(10+widthDis*(i-14), 10+heightDis*2, roomWidth, roomHeight);
					else 
						room[i].setBounds(10+widthDis*(i-21), 10+heightDis*3, roomWidth, roomHeight);
					
					room[i].setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
					
					iframe4_4.add(room[i]);
					
				}
				
		
		
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
		
		frontdeskMenuitem1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(flag)
				{
				case 0:
					break;
				case 1:
					desktopPane.remove(iframe1_1);
				case 2:
					desktopPane.remove(iframe1_2);
				case 3:
					desktopPane.remove(iframe1_3);
				case 4:
					desktopPane.remove(iframe2_1);
				case 5:
					desktopPane.remove(iframe2_2);
				case 6:
					desktopPane.remove(iframe2_3);
				case 7:
					desktopPane.remove(iframe2_4);
				case 8:
					desktopPane.remove(iframe3_1);
				case 9:
					desktopPane.remove(iframe3_2);
				case 10:
					desktopPane.remove(iframe3_3);
				case 11:
					desktopPane.remove(iframe4_4);
				}
					
				desktopPane.repaint();
				iframe1_1.setBounds(0, 0, screenSize.width, screenSize.height-menuBar.getHeight());
				desktopPane.add(iframe1_1);
				
				try {
					iframe1_1.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag=1;
			}
		});
		
		frontdeskMenuitem2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(flag)
				{
				case 0:
					break;
				case 1:
					desktopPane.remove(iframe1_1);
				case 2:
					desktopPane.remove(iframe1_2);
				case 3:
					desktopPane.remove(iframe1_3);
				case 4:
					desktopPane.remove(iframe2_1);
				case 5:
					desktopPane.remove(iframe2_2);
				case 6:
					desktopPane.remove(iframe2_3);
				case 7:
					desktopPane.remove(iframe2_4);
				case 8:
					desktopPane.remove(iframe3_1);
				case 9:
					desktopPane.remove(iframe3_2);
				case 10:
					desktopPane.remove(iframe3_3);
				case 11:
					desktopPane.remove(iframe4_4);
				}
				desktopPane.repaint();
				iframe1_2.setBounds(0, 0, screenSize.width, screenSize.height-menuBar.getHeight());
				desktopPane.add(iframe1_2);
				try {
					iframe1_2.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag=2;
			}
		});
		
		frontdeskMenuitem3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(flag)
				{
				case 0:
					break;
				case 1:
					desktopPane.remove(iframe1_1);
				case 2:
					desktopPane.remove(iframe1_2);
				case 3:
					desktopPane.remove(iframe1_3);
				case 4:
					desktopPane.remove(iframe2_1);
				case 5:
					desktopPane.remove(iframe2_2);
				case 6:
					desktopPane.remove(iframe2_3);
				case 7:
					desktopPane.remove(iframe2_4);
				case 8:
					desktopPane.remove(iframe3_1);
				case 9:
					desktopPane.remove(iframe3_2);
				case 10:
					desktopPane.remove(iframe3_3);
				case 11:
					desktopPane.remove(iframe4_4);
				}
				
				desktopPane.repaint();
				iframe1_3.setBounds(0, 0, screenSize.width, screenSize.height-menuBar.getHeight());
				desktopPane.add(iframe1_3);
				try {
					iframe1_3.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag=3;
			}
		});


		
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
		

		reserveMenuitem1.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(flag)
				{
				case 0:
					break;
				case 1:
					desktopPane.remove(iframe1_1);
				case 2:
					desktopPane.remove(iframe1_2);
				case 3:
					desktopPane.remove(iframe1_3);
				case 4:
					desktopPane.remove(iframe2_1);
				case 5:
					desktopPane.remove(iframe2_2);
				case 6:
					desktopPane.remove(iframe2_3);
				case 7:
					desktopPane.remove(iframe2_4);
				case 8:
					desktopPane.remove(iframe3_1);
				case 9:
					desktopPane.remove(iframe3_2);
				case 10:
					desktopPane.remove(iframe3_3);
				case 11:
					desktopPane.remove(iframe4_4);
				}
			
				desktopPane.repaint();
				iframe2_1.setBounds(0, 0, screenSize.width, screenSize.height-menuBar.getHeight());
				desktopPane.add(iframe2_1);
				try {
					iframe2_1.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag=4;
			}
		});
		
		reserveMenuitem2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(flag)
				{
				case 0:
					break;
				case 1:
					desktopPane.remove(iframe1_1);
				case 2:
					desktopPane.remove(iframe1_2);
				case 3:
					desktopPane.remove(iframe1_3);
				case 4:
					desktopPane.remove(iframe2_1);
				case 5:
					desktopPane.remove(iframe2_2);
				case 6:
					desktopPane.remove(iframe2_3);
				case 7:
					desktopPane.remove(iframe2_4);
				case 8:
					desktopPane.remove(iframe3_1);
				case 9:
					desktopPane.remove(iframe3_2);
				case 10:
					desktopPane.remove(iframe3_3);
				case 11:
					desktopPane.remove(iframe4_4);
				}
			
				desktopPane.repaint();
				iframe2_2.setBounds(0, 0, screenSize.width, screenSize.height-menuBar.getHeight());
				desktopPane.add(iframe2_2);
				try {
					iframe2_2.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag=5;
			}
		});
		
		reserveMenuitem3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(flag)
				{
				case 0:
					break;
				case 1:
					desktopPane.remove(iframe1_1);
				case 2:
					desktopPane.remove(iframe1_2);
				case 3:
					desktopPane.remove(iframe1_3);
				case 4:
					desktopPane.remove(iframe2_1);
				case 5:
					desktopPane.remove(iframe2_2);
				case 6:
					desktopPane.remove(iframe2_3);
				case 7:
					desktopPane.remove(iframe2_4);
				case 8:
					desktopPane.remove(iframe3_1);
				case 9:
					desktopPane.remove(iframe3_2);
				case 10:
					desktopPane.remove(iframe3_3);
				case 11:
					desktopPane.remove(iframe4_4);
				}
			
				desktopPane.repaint();
				iframe2_3.setBounds(0, 0, screenSize.width, screenSize.height-menuBar.getHeight());
				desktopPane.add(iframe2_3);
				try {
					iframe2_3.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag=6;
			}
		});
		
		
		reserveMenuitem4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(flag)
				{
				case 0:
					break;
				case 1:
					desktopPane.remove(iframe1_1);
				case 2:
					desktopPane.remove(iframe1_2);
				case 3:
					desktopPane.remove(iframe1_3);
				case 4:
					desktopPane.remove(iframe2_1);
				case 5:
					desktopPane.remove(iframe2_2);
				case 6:
					desktopPane.remove(iframe2_3);
				case 7:
					desktopPane.remove(iframe2_4);
				case 8:
					desktopPane.remove(iframe3_1);
				case 9:
					desktopPane.remove(iframe3_2);
				case 10:
					desktopPane.remove(iframe3_3);
				case 11:
					desktopPane.remove(iframe4_4);
				}
			
				desktopPane.repaint();
				iframe2_4.setBounds(0, 0, screenSize.width, screenSize.height-menuBar.getHeight());
				desktopPane.add(iframe2_4);
				try {
					iframe2_4.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag=7;
			}
		});
		
		
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
		
		customerMenuitem1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(flag)
				{
				case 0:
					break;
				case 1:
					desktopPane.remove(iframe1_1);
				case 2:
					desktopPane.remove(iframe1_2);
				case 3:
					desktopPane.remove(iframe1_3);
				case 4:
					desktopPane.remove(iframe2_1);
				case 5:
					desktopPane.remove(iframe2_2);
				case 6:
					desktopPane.remove(iframe2_3);
				case 7:
					desktopPane.remove(iframe2_4);
				case 8:
					desktopPane.remove(iframe3_1);
				case 9:
					desktopPane.remove(iframe3_2);
				case 10:
					desktopPane.remove(iframe3_3);
				case 11:
					desktopPane.remove(iframe4_4);
				}
			
				desktopPane.repaint();
				iframe3_1.setBounds(0, 0, screenSize.width, screenSize.height-menuBar.getHeight());
				desktopPane.add(iframe3_1);
				try {
					iframe3_1.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag=8;
			}
		});
		
		customerMenuitem2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(flag)
				{
				case 0:
					break;
				case 1:
					desktopPane.remove(iframe1_1);
				case 2:
					desktopPane.remove(iframe1_2);
				case 3:
					desktopPane.remove(iframe1_3);
				case 4:
					desktopPane.remove(iframe2_1);
				case 5:
					desktopPane.remove(iframe2_2);
				case 6:
					desktopPane.remove(iframe2_3);
				case 7:
					desktopPane.remove(iframe2_4);
				case 8:
					desktopPane.remove(iframe3_1);
				case 9:
					desktopPane.remove(iframe3_2);
				case 10:
					desktopPane.remove(iframe3_3);
				case 11:
					desktopPane.remove(iframe4_4);
				}
			
				desktopPane.repaint();
				iframe3_2.setBounds(0, 0, screenSize.width, screenSize.height-menuBar.getHeight());
				desktopPane.add(iframe3_2);
				try {
					iframe3_2.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag=9;
			}
		});
		
		customerMenuitem3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(flag)
				{
				case 0:
					break;
				case 1:
					desktopPane.remove(iframe1_1);
				case 2:
					desktopPane.remove(iframe1_2);
				case 3:
					desktopPane.remove(iframe1_3);
				case 4:
					desktopPane.remove(iframe2_1);
				case 5:
					desktopPane.remove(iframe2_2);
				case 6:
					desktopPane.remove(iframe2_3);
				case 7:
					desktopPane.remove(iframe2_4);
				case 8:
					desktopPane.remove(iframe3_1);
				case 9:
					desktopPane.remove(iframe3_2);
				case 10:
					desktopPane.remove(iframe3_3);
				case 11:
					desktopPane.remove(iframe4_4);
				}
			
				desktopPane.repaint();
				iframe3_3.setBounds(0, 0, screenSize.width, screenSize.height-menuBar.getHeight());
				desktopPane.add(iframe3_3);
				try {
					iframe3_3.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag=10;
			}
		});


		
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
		JMenuItem queryMenuitem4=new JMenuItem("房间汇总");
		
		queryMenu.add(queryMenuitem1);
		queryMenu.add(queryMenuitem2);
		queryMenu.add(queryMenuitem3);
		queryMenu.add(queryMenuitem4);
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
		
		queryMenuitem4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(flag)
				{
				case 0:
					break;
				case 1:
					desktopPane.remove(iframe1_1);
				case 2:
					desktopPane.remove(iframe1_2);
				case 3:
					desktopPane.remove(iframe1_3);
				case 4:
					desktopPane.remove(iframe2_1);
				case 5:
					desktopPane.remove(iframe2_2);
				case 6:
					desktopPane.remove(iframe2_3);
				case 7:
					desktopPane.remove(iframe2_4);
				case 8:
					desktopPane.remove(iframe3_1);
				case 9:
					desktopPane.remove(iframe3_2);
				case 10:
					desktopPane.remove(iframe3_3);
				case 11:
					desktopPane.remove(iframe4_4);
				}
			
				desktopPane.repaint();
				iframe4_4.setBounds(0, 0, screenSize.width, screenSize.height-menuBar.getHeight());
				desktopPane.add(iframe4_4);
				try {
					iframe4_4.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag=11;
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
