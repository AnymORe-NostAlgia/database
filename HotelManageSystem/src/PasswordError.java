import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class PasswordError {

	private JFrame frame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//��ȡ�û�������Ļ����
	
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
		
		JLabel ErrorIcon = new JLabel("");
		ErrorIcon.setBounds(22, 33, 40, 40);
		frame.getContentPane().add(ErrorIcon);
		
		JLabel ErrorText = new JLabel("����������ٴ����룡");
		ErrorText.setFont(new Font("����", Font.BOLD, 14));
		ErrorText.setBounds(60, 30, 165, 27);
		frame.getContentPane().add(ErrorText);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 274, 131);
		frame.getContentPane().add(panel);
		panel.setBackground(Color.ORANGE);
		//panel.setOpaque(true);
		
	}
}
