public class UserInterfaceString extends UserInterfaceHex{
	private CalcEngineString calcEngineString;

	public UserInterfaceString(CalcEngineString engine) {
		super(engine);
		calcEngineString = engine;
		
	}
	
	@Override
	protected void redisplay() {
		display.setText(calcEngineString.getDisplayValueString());
	}

}
