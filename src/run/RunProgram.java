package run;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.CCPanel;



/**
 * Lily Ellison - lbellison
 * CIS171 20473
 * Apr 28, 2023
 */
public class RunProgram {

	public static void main(String[] args) {
		//Create frame for GUI:
		JFrame frame = new JFrame("Basic Character Creator");
		
		//set size and close:
		frame.setSize(400, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

		//Create panel for GUI:
		JPanel panel = new CCPanel();
		panel.setLayout(new BorderLayout());	
		panel.setPreferredSize(new Dimension(500, 500));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setAlignmentY(Component.CENTER_ALIGNMENT);
		//add panel to frame:
		frame.add(panel);


		
		

		//visible frame:
		frame.setVisible(true);
	}

}
