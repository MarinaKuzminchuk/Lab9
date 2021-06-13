public class CalcEngineString extends CalcEngineHex{
	
	private String displayValue = "";
	private Postfix postfix = new Postfix();
	private boolean hexEnabled = true;
	
	public CalcEngineString() {
		super();
	}
	// calculate the result using class Postfix from previous lab
	@Override
	public void equals() {
		String postfixExpression = postfix.infixToPostfix(displayValue, radix());
		int result = postfix.evaluate(postfixExpression, radix());
		displayValue = Integer.toString(result, radix());
	}
	private int radix() {
		if (hexEnabled) {
			return 16;
		} else {
			return 10;
		}
	}
	@Override
	public void numberPressed(int number) {
		if(number > 9) {
			displayValue = displayValue + Integer.toHexString(number); // когда нажимаем а в метод приходит 10, но в строке мы видим а
		} else {
			displayValue = displayValue + number;
		}
	}
	@Override
	public void plus() {
		displayValue = displayValue + " + ";
	}
	@Override
	public void minus() {
		displayValue = displayValue + " - ";
	}
	@Override
	public void multiply() {
		displayValue = displayValue + " * ";
	}
	@Override
	public void clear() {
		displayValue = "";
	}
	public String getDisplayValueString() {
		return displayValue;
	}
	@Override
	public void setHexEnabled(boolean hexEnabled) {
		this.hexEnabled = hexEnabled;
		clear();
	}
}

