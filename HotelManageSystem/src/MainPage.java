import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPage{

	
	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取用户电脑屏幕数据

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
		frame.setBounds(0, -10, screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, screenSize.width, screenSize.height);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
}
