package gameWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
	public static void main(String[] args) {
			new GUI();
		}
		
		private JTextArea textArea = new JTextArea();
		private JPanel panel = new JPanel();
		private JLabel label = new JLabel();
		private JTextField textField = new JTextField();
		private JButton button = new JButton();
		
		public GUI() {
			buildWindow();
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
		
		}
		
		private void buildWindow() {
			setTitle("Game Title");
			setLayout(new BorderLayout());
			panel.setLayout(new GridLayout(3,1));
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(500, 500);
			setLocationRelativeTo(null); // Center window
			setVisible(true); // Make window appear
		}
}
