import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class PasswordError {

	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取用户电脑屏幕数据
	
	/**
	 * Create the application.
	 */
	public PasswordError() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(screenSize.width/2-145, screenSize.height/2-85, 290, 170);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Error");
		
		ImageIcon error=new ImageIcon("img/Error.png");
		
		JLabel ErrorIcon = new JLabel(error);
		ErrorIcon.setBounds(18, 27, 40, 40);
		frame.getContentPane().add(ErrorIcon);
		
		JLabel ErrorText = new JLabel("密码错误，请再次输入！");
		ErrorText.setFont(new Font("宋体", Font.BOLD, 14));
		ErrorText.setBounds(60, 30, 165, 27);
		frame.getContentPane().add(ErrorText);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 274, 131);
		frame.getContentPane().add(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		//panel.setOpaque(true);
		
	}
}
