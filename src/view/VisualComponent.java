package view;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * Lily Ellison - lbellison
 * CIS171 20473
 * Apr 29, 2023
 */
public class VisualComponent extends JComponent{
	//Character icons:	
	ImageIcon allThree = createImageIcon("characterIcons.png", "Rogue, Wizard, and Dwarf");
	ImageIcon wizardIcon = createImageIcon("wizard.png", "Wizard image");
	ImageIcon rogueIcon = createImageIcon("rogue.png", "Rogue image");
	ImageIcon fighterIcon = createImageIcon("fighter.png", "Fighter image");
	//Dice icons:
	//Before roll:
	ImageIcon allDice = createImageIcon("allDice.jpg", "Set of dice");
	//D6 for human/wizard:
	ImageIcon d601 = createImageIcon("1.png", "1 on d6");
	ImageIcon d602 = createImageIcon("2.png", "2 on d6");
	ImageIcon d603 = createImageIcon("3.png", "3 on d6");
	ImageIcon d604 = createImageIcon("4.png", "4 on d6");
	ImageIcon d605 = createImageIcon("5.png", "5 on d6");
	ImageIcon d606 = createImageIcon("6.png", "6 on d6");
	//D8 for elf/rogue:
	ImageIcon d801 = createImageIcon("D8/1.jpg", "1 on d8");
	ImageIcon d802 = createImageIcon("D8/2.jpg", "2 on d8");
	ImageIcon d803 = createImageIcon("D8/3.jpg", "3 on d8");
	ImageIcon d804 = createImageIcon("D8/4.jpg", "4 on d8");
	ImageIcon d805 = createImageIcon("D8/5.jpg", "5 on d8");
	ImageIcon d806 = createImageIcon("D8/6.jpg", "6 on d8");
	ImageIcon d807 = createImageIcon("D8/7.jpg", "7 on d8");
	ImageIcon d808 = createImageIcon("D8/8.jpg", "8 on d8");
	//D10 for dwarf/fighter:
	ImageIcon d1001 = createImageIcon("D10/1.jpg", "1 on d10");
	ImageIcon d1002 = createImageIcon("D10/2.jpg", "2 on d10");
	ImageIcon d1003 = createImageIcon("D10/3.jpg", "3 on d10");
	ImageIcon d1004 = createImageIcon("D10/4.jpg", "4 on d10");
	ImageIcon d1005 = createImageIcon("D10/5.jpg", "5 on d10");
	ImageIcon d1006 = createImageIcon("D10/6.jpg", "6 on d10");
	ImageIcon d1007 = createImageIcon("D10/7.jpg", "7 on d10");
	ImageIcon d1008 = createImageIcon("D10/8.jpg", "8 on d10");
	ImageIcon d1009 = createImageIcon("D10/9.jpg", "9 on d10");
	ImageIcon d1010 = createImageIcon("D10/10.jpg", "10 on d10");
	
	//marker variables for changing images:
	String characterDisplayed = "all";
	
	int diced = 0;
	
	//labels used to display images:
	public JLabel diceDisplayed = new JLabel(allDice);
	
	public JLabel characterDisplay = new JLabel(allThree);
	
	/**
	 * Processes an image file into an icon used in the program
	 * Prints error if file not found.
	 */
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
	
	/**
	 * Changes the character image when a character is selected.
	 */
	
	public void changeImage() {
		if(characterDisplayed.equals("W")) {
			characterDisplay.setIcon(wizardIcon);
		}
		else if(characterDisplayed.equals("R")) {
			characterDisplay.setIcon(rogueIcon);
		}
		else if(characterDisplayed.equals("D")) {
			characterDisplay.setIcon(fighterIcon);
		}
		else if(characterDisplayed.equals("all")) {
			characterDisplay.setIcon(allThree);
		}
		repaint();
	}	
	
	/**
	 * Changes the image of the die when a d6 is rolled for the 
	 * human/wizard.
	 */
	
	public void changeImageD6(int roll) {
		if(roll == 0) {
			diceDisplayed.setIcon(allDice);
			repaint();
			diceDisplayed.setText("");
			return;
		}
		else if (roll == 1) {
			diceDisplayed.setIcon(d601);	
		}
		else if (roll == 2) {
			diceDisplayed.setIcon(d602);	
		}
		else if (roll == 3) {
			diceDisplayed.setIcon(d603);	
		}
		else if (roll == 4) {
			diceDisplayed.setIcon(d604);	
		}
		else if (roll == 5) {
			diceDisplayed.setIcon(d605);	
		}
		else if (roll == 6) {
			diceDisplayed.setIcon(d606);	
		}
		diceDisplayed.setText("You rolled a " + String.valueOf(roll) + 
				"!\n Your total hit points are: " + String.valueOf(roll+6));
		repaint();
	}


	/**
	 * Changes the image of the die when a d8 is rolled for the elf/rogue.
	 */
	public void changeImageD8(int roll) {
		if (roll == 1) {
			diceDisplayed.setIcon(d801);	
		}
		else if (roll == 2) {
			diceDisplayed.setIcon(d802);	
		}
		else if (roll == 3) {
			diceDisplayed.setIcon(d803);	
		}
		else if (roll == 4) {
			diceDisplayed.setIcon(d804);	
		}
		else if (roll == 5) {
			diceDisplayed.setIcon(d805);	
		}
		else if (roll == 6) {
			diceDisplayed.setIcon(d806);	
		}
		else if (roll == 7) {
			diceDisplayed.setIcon(d807);	
		}
		else if (roll == 8) {
			diceDisplayed.setIcon(d808);	
		}
		
		diceDisplayed.setText("You rolled a " + String.valueOf(roll) + 
				"!\n Your total hit points are: " + String.valueOf(roll+8));
		repaint();
	}
	

	/**
	 * Changes the image of the die when a d10 is rolled for the 
	 * dwarf/fighter.
	 */
	
	public void changeImageD10(int roll) {
		if (roll == 1) {
			diceDisplayed.setIcon(d1001);	
		}
		else if (roll == 2) {
			diceDisplayed.setIcon(d1002);	
		}
		else if (roll == 3) {
			diceDisplayed.setIcon(d1003);	
		}
		else if (roll == 4) {
			diceDisplayed.setIcon(d1004);	
		}
		else if (roll == 5) {
			diceDisplayed.setIcon(d1005);	
		}
		else if (roll == 6) {
			diceDisplayed.setIcon(d1006);	
		}
		else if (roll == 7) {
			diceDisplayed.setIcon(d1007);	
		}
		else if (roll == 8) {
			diceDisplayed.setIcon(d1008);	
		}
		else if (roll == 9) {
			diceDisplayed.setIcon(d1009);	
		}
		else if (roll == 10) {
			diceDisplayed.setIcon(d1010);	
		}
				
		diceDisplayed.setText("You rolled a " + String.valueOf(roll) + 
				"!\n Your total hit points are: " + String.valueOf(roll+10));
		repaint();
	}

	/**
	 * @return the characterDisplayed for testing
	 */
	public String getCharacterDisplayed() {
		return characterDisplayed;
	}

	/**
	 * @return the diced for testing
	 */
	public int getDiced() {
		return diced;
	}
	
}
