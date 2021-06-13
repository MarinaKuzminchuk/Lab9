import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;

import org.junit.jupiter.api.Test;

class UserInterfaceHexTest {

	@Test
	void testGuiActionsWithHexNumbers() {
		CalcEngineHex calc = new CalcEngineHex();
		UserInterfaceHex gui = new UserInterfaceHex(calc);
		ActionEvent e1 = new ActionEvent(this, 0, "a");
		ActionEvent e2 = new ActionEvent(this, 0, "*");
		ActionEvent e3 = new ActionEvent(this, 0, "2");
		ActionEvent e4 = new ActionEvent(this, 0, "f");
		ActionEvent e5 = new ActionEvent(this, 0, "=");
		gui.actionPerformed(e1);
		gui.actionPerformed(e2);
		gui.actionPerformed(e3);
		gui.actionPerformed(e4);
		gui.actionPerformed(e5);
		gui.redisplay();
		String output = gui.display.getText();
		assertEquals("1D6", output);
	}

	@Test
	void testGuiActionsWithDecimalNumbers() {
		CalcEngineHex calc = new CalcEngineHex();
		UserInterfaceHex gui = new UserInterfaceHex(calc);
		ActionEvent e0 = new ActionEvent(this, 0, "hex");
		ActionEvent e1 = new ActionEvent(this, 0, "9");
		ActionEvent e2 = new ActionEvent(this, 0, "+");
		ActionEvent e3 = new ActionEvent(this, 0, "4");
		ActionEvent e4 = new ActionEvent(this, 0, "5");
		ActionEvent e5 = new ActionEvent(this, 0, "=");
		gui.actionPerformed(e0);
		gui.actionPerformed(e1);
		gui.actionPerformed(e2);
		gui.actionPerformed(e3);
		gui.actionPerformed(e4);
		gui.actionPerformed(e5);
		gui.redisplay();
		String output = gui.display.getText();
		assertEquals("54", output);
	}
}
