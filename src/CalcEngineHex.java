
public class CalcEngineHex extends CalcEngine {
	private boolean hexEnabled = true;

    @Override
    public void numberPressed(int number) {
        if (buildingDisplayValue) {
            // Incorporate this digit.
        	if(hexEnabled) {
                displayValue = displayValue * 16 + number;
        	} else {
        		displayValue = displayValue * 10 + number;
        	}
        } else {
            // Start building a new number.
            displayValue = number;
            buildingDisplayValue = true;
        }
    }
    
    public void setHexEnabled(boolean hexEnabled) {
    	this.hexEnabled = hexEnabled;
    }
}
