import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalcEngineHexTest {

	@Test
	void testAddition() {
		CalcEngineHex calc = new CalcEngineHex();
		calc.numberPressed(0xA);
		calc.plus();
		calc.numberPressed(5);
		calc.equals();
		int result = calc.getDisplayValue();
		assertEquals(0xF, result);
	}

	@Test
	void testSubtraction() {
		CalcEngineHex calc = new CalcEngineHex();
		calc.numberPressed(0xC);
		calc.minus();
		calc.numberPressed(4);
		calc.equals();
		int result = calc.getDisplayValue();
		assertEquals(8, result);
	}

	@Test
	void testMultiplication() {
		CalcEngineHex calc = new CalcEngineHex();
		calc.numberPressed(0xB);
		calc.multiply();
		calc.numberPressed(3);
		calc.equals();
		int result = calc.getDisplayValue();
		assertEquals(33, result);
	}

	@Test
	void testLongHexDisplayValue() {
		CalcEngineHex calc = new CalcEngineHex();
		calc.numberPressed(1);
		calc.numberPressed(0xB);
		calc.numberPressed(2);
		calc.numberPressed(0xF);
		int result = calc.getDisplayValue();
		assertEquals(0x1B2F, result);
	}
}
