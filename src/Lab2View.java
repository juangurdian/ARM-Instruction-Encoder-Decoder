import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab2View extends JFrame {
	/*
	 * First I need to create the class and put the imports
	 * After this I need to call my buttons, labels and all that.
	 */
		public JButton encodeButton, decodeBinaryButton, decodeHexButton, clearButton;
		private JLabel alLabel, binaryInstructionLabel, hexInstructionLabel;
		public JTextField assemblyTextArea, binaryTextArea, hexTextArea, resultTextArea;
		private Color tcuPurple = new Color(52, 42, 123);
		
		//Now I create my constructor
		public Lab2View() {
			
			setTitle("Encoding Arm Instructions");
	        setSize(800, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());
	        getContentPane().setBackground(new Color(77, 25, 121));
	        
	        
	        handleCenter();
	        handleWest();
	        handleEast();
	        handleSouth();
	        
	        setVisible(true);
	        
		}
		public void handleNorth() {
			
		}
		
		public void handleSouth() {
			resultTextArea = new JTextField("");
			resultTextArea.setEditable(false);
			
			add(resultTextArea, BorderLayout.SOUTH);
		}
		
		public void handleWest() {
			
			JPanel layout = new JPanel(new GridLayout(3,1,10, 10));
			layout.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			getContentPane().setBackground(new Color(77, 25, 121));
			
			alLabel = new JLabel("To Assembly Language");
			binaryInstructionLabel = new JLabel("Binary Instruction");	
			hexInstructionLabel = new JLabel("Hex Instruction");
			
			layout.add(alLabel);
			layout.add(binaryInstructionLabel);
			layout.add(hexInstructionLabel);
			
			add(layout,BorderLayout.WEST);
		}
		
		public void handleCenter() {
			JPanel centerPanel = new JPanel(new GridLayout(3,1));
			centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			
			JPanel centerPanelOne = new JPanel(new BorderLayout());
			assemblyTextArea = new JTextField(3);
			assemblyTextArea.setEditable(true);
			centerPanelOne.add(assemblyTextArea, BorderLayout.CENTER);
			
			JPanel centerPanelTwo = new JPanel(new BorderLayout());
			binaryTextArea = new JTextField(3);
			binaryTextArea.setEditable(true);
			centerPanelTwo.add(binaryTextArea, BorderLayout.CENTER);
			
			JPanel centerPanelThree = new JPanel(new BorderLayout());
			hexTextArea = new JTextField(3);
			hexTextArea.setEditable(true);;
			centerPanelThree.add(hexTextArea, BorderLayout.CENTER);
			
			centerPanel.add(centerPanelOne);
			centerPanel.add(centerPanelTwo);
			centerPanel.add(centerPanelThree);
			
			add(centerPanel, BorderLayout.CENTER);
		}
		
		public void handleEast() {
			JPanel eastPanel = new JPanel(new GridLayout(3,1));
			eastPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			
			encodeButton = new JButton("Encode");
			eastPanel.add(encodeButton);
			
			decodeBinaryButton = new JButton("Decode Binary");
			eastPanel.add(decodeBinaryButton);
			
			decodeHexButton = new JButton("Decode Hex");
			eastPanel.add(decodeHexButton);
			
			add(eastPanel, BorderLayout.EAST);
		}
}
