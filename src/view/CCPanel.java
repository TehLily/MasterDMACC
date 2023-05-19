package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lily Ellison - lbellison
 * CIS171 20473
 * Apr 28, 2023
 */
public class CCPanel extends JPanel {
	//labels to identify/greet:
	private JLabel greeting = new JLabel("  ~~~Welcome To:~~~   \n");
	private JLabel title = new JLabel("  >>>Basic Character Creator<<<   ");
	
	private JLabel instructions;
	//Creating icons:
	ImageIcon wizardIcon = createImageIcon("wizard.png", "Wizard image");
	ImageIcon rogueIcon = createImageIcon("rogue.png", "Rogue image");
	ImageIcon fighterIcon = createImageIcon("fighter.png", "Fighter image");
	//buttons to select a race/class:
	private JButton humanWiz = new JButton("Human/Wizard", wizardIcon);
	private JButton elfRog = new JButton("Elf/Rogue", rogueIcon);
	private JButton dwarfFight = new JButton("Dwarf/Fighter", fighterIcon);
	//button to roll die:
	private JButton rollDice = new JButton("Roll");
	//create a new instance for a dice graphic and character graphic:
	VisualComponent diceRolled = new VisualComponent();
	VisualComponent charImage = new VisualComponent();
	//button to reset:
	private JButton resetButton = new JButton("Reset");
	//button to close:
	private JButton exitButton = new JButton("Exit");
	
	//constructor:
	public CCPanel() {
		//from JPanel:
		super();
			
		//add labels to subPanel:
		add(greeting);
		add(title);
		instructions = new JLabel ("PLease select a race and class combo:");
		add(instructions);
		
		//Create new listener for race/class select buttons:
		RaceClassListener rcSelectListener = new RaceClassListener();
		humanWiz.addActionListener(rcSelectListener);
				
		elfRog.addActionListener(rcSelectListener);
				
		dwarfFight.addActionListener(rcSelectListener);
		
		//add the race/class buttons:		
		add(humanWiz);
		add(elfRog);
		add(dwarfFight);
		
		//add the character image:
		add(charImage.characterDisplay);
		//further instructions:
		instructions = new JLabel ("Then roll dice to get hit points:");
		add(instructions);
		
		//add a listener for the roll button:
		RollButtonListener rollListener = new RollButtonListener();
		rollDice.addActionListener(rollListener);
		//Disabled until a class is selected:
		rollDice.setEnabled(false);
		//add the button and an image:
		add(rollDice);
		add(diceRolled.diceDisplayed);
		//add listener and reset button:
		ResetButtonListener resetListener = new ResetButtonListener();
		resetButton.addActionListener(resetListener);
		
		add(resetButton);
		
		//add listener and exit button:
		ExitButtonListener exitListener = new ExitButtonListener();
		exitButton.addActionListener(exitListener);
		
		add(exitButton);
		
	}
	
	//class for reset listener:
	public class ResetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			rollDice.setEnabled(false);
			charImage.characterDisplayed = "all";
			charImage.changeImage();
			diceRolled.changeImageD6(0);
			
			
		}
		
	}

	//class for the race/class listener:
	public class RaceClassListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//determines which button that has this listener was clicked:
			Object source = e.getSource();
			//initialize hitdie variable:
			int hd = 0;
			//activate/enable the roll button:
			rollDice.setEnabled(true);
			//settings for human/wizard:
			if(source == humanWiz) {
				hd = 6;
				charImage.characterDisplayed = "W";
			};
			//settings for elf/rogue:
			if(source == elfRog) {
				hd = 8;
				charImage.characterDisplayed = "R";
			};
			//settings for dwarf/fighter:
			if(source == dwarfFight) {
				hd = 10;
				charImage.characterDisplayed = "D";
			};
			//calls the function that changes the image:
			charImage.changeImage();
			//sets the number for the type of die rolled 
			//and the starting hit points
			diceRolled.diced = hd;
		}
	}
	
	//listener for the roll button:
	public class RollButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//calls the function that simulates a die roll:
			int rollValue = rollDice(diceRolled.diced);
			//uses the type of die and the roll value 
			//to call the correct image:
			if(diceRolled.diced == 6) {
				diceRolled.changeImageD6(rollValue);				
			}
			if(diceRolled.diced == 8) {
				diceRolled.changeImageD8(rollValue);				
			}
			if(diceRolled.diced == 10) {
				diceRolled.changeImageD10(rollValue);				
			}
		}
	}
	
	public static int rollDice(int maxValue) {  //random number generator to simulate dice roll 
		Random r = new Random();  //priming random number generator
		int result = r.nextInt(maxValue) + 1;  //assigns a number between 1 and the max of the chosen hit die (6, 8, or 10)
		return result; //returns random number within range
	}	
	
	/** Returns an ImageIcon, or null if the path was invalid.
	 * From docs.Oracle.com */
	protected ImageIcon createImageIcon(String path,
	                                           String description) {
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
}
