import java.util.*;

public class Lab2Model {
	
	private HashMap<String, String> mnemonicToBinaryMap;
	
	public Lab2Model() {
        initializeMnemonicToBinaryMap();
	}
	
	String displayIntAsHex(int x) {
		String ans = "";
		for(int i=0; i<8; i++) {
			int hex = x & 15;
			char hexChar = "0123456789ABCDEF".charAt(hex);
			ans = hexChar + ans;
			x = (x >> 4);
			
		}
		return ans;
	}
	
	String displayShortAsHex(short x) {
		String ans = "";
		for(int i = 0; i <4; i++) {
			int hex = x & 15;
			char  hexChar = "0123456789ABCDEF".charAt(hex);
			ans = hexChar + ans;
			x = (short)(x >> 4);
		}
		return ans;
	}
	
	String displayIntAsBinary(int x) {
		String ans = "";
		for(int i = 0; i < 32; i++) {
			 ans = (x & 1) + ans;
			x = (x >> 1);
		}
		return ans;
	}
	
	String displayShortAsBinary(short x) {
		String ans = "";
		for(int i = 0; i < 16; i ++) {
			ans = (x & 1) + ans;
			x = (short)(x >> 1);
		}
		return ans;
	}
	
	private void initializeMnemonicToBinaryMap() {
        // Initialize the mapping of mnemonics to binary codes for ARM7 instructions
        mnemonicToBinaryMap = new HashMap<>();
        mnemonicToBinaryMap.put("AND", "0000");
        mnemonicToBinaryMap.put("EOR", "0001");
        mnemonicToBinaryMap.put("SUB", "0010");
        mnemonicToBinaryMap.put("RSB", "0011");
        mnemonicToBinaryMap.put("ADD", "0100");
        mnemonicToBinaryMap.put("ADC", "0101");
        mnemonicToBinaryMap.put("SBC", "0110");
        mnemonicToBinaryMap.put("RSC", "0111");
        mnemonicToBinaryMap.put("TST", "1000");
        mnemonicToBinaryMap.put("TEQ", "1001");
        mnemonicToBinaryMap.put("CMP", "1010");
        mnemonicToBinaryMap.put("CMN", "1011");
        mnemonicToBinaryMap.put("ORR", "1100");
        mnemonicToBinaryMap.put("MOV", "1101");
        mnemonicToBinaryMap.put("BIC", "1110");
        mnemonicToBinaryMap.put("MVN", "1111");
    }
	
	

}
