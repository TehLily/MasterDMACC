import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

import view.CCPanel;
import view.VisualComponent;

/**
 * Lily Ellison - lbellison
 * CIS171 20473
 * Apr 29, 2023
 */
class FinalProjectTest {
	
	JFrame testFrame = new JFrame ("Testing");
	JPanel testPanel = new CCPanel();
	VisualComponent testComponent = new VisualComponent();
	
	@Test
	void testVisualComponentVariables() {
		assertEquals("allThree", testComponent.getCharacterDisplayed());
		assertEquals(0, testComponent.getDiced());
	}
	
	@Test
	void testRollDiceD6() {
		int min = 1;
		int max = 6;
		int testRollD6 = CCPanel.rollDice(max);
		assertTrue(testRollD6 >= min && testRollD6 <= max);
	}
	
	@Test
	void testRollDiceD8() {
		int min = 1;
		int max = 8;
		int testRollD6 = CCPanel.rollDice(max);
		assertTrue(testRollD6 >= min && testRollD6 <= max);
	}
	
	@Test
	void testRollDiceD10() {
		int min = 1;
		int max = 10;
		int testRollD6 = CCPanel.rollDice(max);
		assertTrue(testRollD6 >= min && testRollD6 <= max);
	}

}
