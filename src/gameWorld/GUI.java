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
		private JLabel label = new JLabel("What do you want to do?");
		private JButton button = new JButton("Execute");
		private JTextField textField = new JTextField();
	
		public GUI() {
			buildWindow();
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			String s = textField.getText();
			Game.processCommand(s);
		}
		
		private void buildWindow() {
			setTitle("Game Title");
			setLayout(new BorderLayout());
			panel.setLayout(new GridLayout(3,1));
			add(textArea,BorderLayout.CENTER);
			add(panel,BorderLayout.SOUTH);
			label.setFont(new Font(null,Font.BOLD,20));
			label.setForeground(Color.BLACK);
			label.setBackground(Color.WHITE);
			panel.add(label,0);
			TextField text = new TextField(" ");
			text.setForeground(Color.BLACK);
			text.setBackground(Color.WHITE);
			panel.add(text,1);
			button.addActionListener(this);
			button.setFont(new Font(null,Font.BOLD,15));
			button.setForeground(Color.WHITE);
			button.setBackground(Color.BLACK);
			panel.add(button,2);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(500, 500);
			setLocationRelativeTo(null);
			setVisible(true);
		}