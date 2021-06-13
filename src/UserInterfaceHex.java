import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class UserInterfaceHex extends UserInterface {
	// panel that stores hex buttons
	private JPanel buttonPanel;
	// flag for hex buttons state - enabled/disabled
	private boolean hexEnabled;
	// calculator engine that can deal with hex numbers
	private CalcEngineHex engine;

	public UserInterfaceHex(CalcEngineHex engine) {
		super(engine);
		this.engine = engine;
	}

	// adds a panel with hex buttons 
	@Override
	protected void makeFrame() {
		super.makeFrame();
		// by default the hex panel is enabled 
		hexEnabled = true;
		JPanel contentPane = (JPanel) frame.getContentPane();
		buttonPanel = new JPanel(new GridLayout(4, 2));
		addButton(buttonPanel, "a");
		addButton(buttonPanel, "b");
		addButton(buttonPanel, "c");
		addButton(buttonPanel, "d");
		addButton(buttonPanel, "e");
		addButton(buttonPanel, "f");
		addButton(buttonPanel, "hex");
		contentPane.add(buttonPanel, BorderLayout.WEST);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals("a")
				|| command.equals("b") 
				|| command.equals("c") 
				|| command.equals("d")
				|| command.equals("e") 
				|| command.equals("f")) {
			// convert hex digit to integer
			int number = Integer.parseInt(command, 16);
			calc.numberPressed(number);
			redisplay();
		} else if(command.equals("hex")){
			// invert hex panel state
			hexEnabled = !hexEnabled;
			// change calculator engine logic
			engine.setHexEnabled(hexEnabled);
			// find hex digit buttons and invert their state
			Component[] components = buttonPanel.getComponents();
			for(Component component : components) {
				JButton button = (JButton)component;
				if(button.getText().equals("a") 
						||button.getText().equals("b")
						||button.getText().equals("c") 
						||button.getText().equals("d") 
						||button.getText().equals("e") 
						||button.getText().equals("f")) {
					button.setEnabled(hexEnabled);
				}
			}
			redisplay();
		} else {
			super.actionPerformed(event);
		}
	}

	@Override
	protected void redisplay() {
		if(hexEnabled) {
			// Convert display value integer to hex string and set it to display
			display.setText(Integer.toHexString(calc.getDisplayValue()).toUpperCase());
		} else {
			// Convert display value integer to decimal string and set it to display
			super.redisplay();
		}
	}

}
