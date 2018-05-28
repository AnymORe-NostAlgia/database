import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReserveQueryFrame {

	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取用户电脑屏幕数据
	private JTextField textField;
	private JPanel panel;
	
	/**
	 * Create the application.
	 */
	public ReserveQueryFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setTitle("\u9884\u8BA2\u4FE1\u606F\u67E5\u8BE2");
		frame.setBounds(screenSize.width/2-118, screenSize.height/2-121, 256, 135);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);     //禁止改变大小
		
		textField = new JTextField();
		textField.setBounds(107, 21, 80, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8BA2\u5355\u53F7\uFF1A");
		lblNewLabel.setBounds(10, 23, 98, 16);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		
		panel = new JPanel();
		panel.setBounds(0, 0, 240, 96);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		frame.setVisible(true);
	}

}
