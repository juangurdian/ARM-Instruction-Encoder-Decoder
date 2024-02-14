import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

import javax.swing.*;

public class Lab2Controller {
	private Lab2View view;
	private Lab2Model model;
	
	public Lab2Controller(Lab2View view, Lab2Model model) {
		this.view = view;
		this.model = model;
		initController();
	}
	
	private void initController() {
		view.encodeButton.addActionListener(e -> encodeAssembly());
        view.decodeBinaryButton.addActionListener(e -> decodeBinary());
        view.decodeHexButton.addActionListener(e -> decodeHex());
	}
	/*
	private void encodeAssembly() {
		
		String assembly = view.assemblyTextArea.getText().trim().toUpperCase();
		
		String fixedOne = "1110000";
		String fixedTwo = "00000000";
		
		StringTokenizer token = new StringTokenizer(assembly," ");
		if(token.countTokens() != 2) {
			view.resultTextArea.setText("ERROR: ILLEGAL ASSEMBLY FORMAT");
			return;
		}
		
		String opcode = token.nextToken();
		String operands = token.nextToken();
		
		token = new StringTokenizer(operands,",",true);
		int num = 0;
		
		
		
		
		
		
	}
	*/
	 void encodeAssembly() {
	    String assembly = view.assemblyTextArea.getText().trim().toUpperCase();
	    String fixedOne = "1110"; // Condition
	    String fixedTwo = "000";  // Format
	    String fixedThree = "0";  // S

	    StringTokenizer token = new StringTokenizer(assembly, " ");
	    if (token.countTokens() != 2) {
	        view.resultTextArea.setText("ERROR: ILLEGAL ASSEMBLY FORMAT");
	        return;
	    }

	    String opcode = token.nextToken();
	    String operands = token.nextToken();

	    // Convert mnemonic to binary opcode using if-else statements
	    String binaryOpcode = getOpcodeBinary(opcode);
	    if (binaryOpcode == null) {
	        view.resultTextArea.setText("ERROR: UNKNOWN MNEMONIC");
	        return;
	    }

	    token = new StringTokenizer(operands, ",");
	    if (token.countTokens() != 3) {
	        view.resultTextArea.setText("ERROR: EXPECTED THREE OPERANDS");
	        return;
	    }

	    // Convert registers to binary
	    String destReg = convertRegisterToBinary(token.nextToken());
	    String op1Reg = convertRegisterToBinary(token.nextToken());
	    String op2Reg = convertRegisterToBinary(token.nextToken());

	    if (destReg == null || op1Reg == null || op2Reg == null) {
	        view.resultTextArea.setText("ERROR: INVALID REGISTER");
	        return;
	    }

	    // Construct the final 32-bit binary instruction
	    String binaryInstruction = fixedOne + fixedTwo + binaryOpcode + fixedThree + op1Reg + destReg + "00000000" + op2Reg;
	    view.binaryTextArea.setText(binaryInstruction);
	    System.out.println(binaryInstruction);
	    int instruction = 0;
	    String binary = binaryInstruction;
	    
	    
	    if(binary.length() != 32) {
			view.resultTextArea.setText(" ERROR: THE BINARY NUMBER MUST BE 16 OR 32 DIGITS");
			return;
		}
	    try {
	    	
	    	long longValue = Long.parseLong(binary, 2);
	    	instruction = (int) longValue;
	    	

	    } catch(NumberFormatException nfe) {
	        view.resultTextArea.setText("ERROR: ILLEGAL BINARY NUMBER");
	        return;
	    }
	    
	    // Convert the binary instruction to hexadecimal and display it
	    String hexInstruction = Integer.toHexString(instruction).toUpperCase();
	    view.hexTextArea.setText(hexInstruction);
	}

	private String getOpcodeBinary(String opcode) {
	    switch (opcode) {
	        case "AND": return "0000";
	        case "EOR": return "0001";
	        case "SUB": return "0010";
	        case "RSB": return "0011";
	        case "ADD": return "0100";
	        case "ADC": return "0101";
	        case "SBC": return "0110";
	        case "RSC": return "0111";
	        case "TST": return "1000";
	        case "TEQ": return "1001";
	        case "CMP": return "1010";
	        case "CMN": return "1011";
	        case "ORR": return "1100";
	        case "MOV": return "1101";
	        case "BIC": return "1110";
	        case "MVN": return "1111";
	        default: return null;
	    }
	}

	private String convertRegisterToBinary(String register) {
	    if (register.length() != 2 || !register.startsWith("R")) {
	        return null;
	    }

	    int regNum;
	    try {
	        regNum = Integer.parseInt(register.substring(1));
	    } catch (NumberFormatException e) {
	        return null;
	    }

	    if (regNum < 0 || regNum > 15) {
	        return null;
	    }

	    return String.format("%4s", Integer.toBinaryString(regNum)).replace(' ', '0');
	}

	
	
	void decodeBinary() {
		//view.assemblyTextArea.setText("");
		//view.binaryTextArea.setText("");
		int instruction = 0;
		String binary = view.binaryTextArea.getText().trim();
		
		if(binary.length() != 16 && binary.length() != 32) {
			view.resultTextArea.setText(" ERROR: THE BINARY NUMBER MUST BE 16 OR 32 DIGITS");
			return;
		}
		try {
			instruction = Integer.parseInt(binary, 2);
			} catch(NumberFormatException nfe) {
				view.resultTextArea.setText("ERRO: ILLEGAL BINARY NUMBER");
				
			}
		if((binary.length() == 32) && ((instruction & 0xFFFF0000) == 0)) {
			view.resultTextArea.setText("ERROR: ILLEGAL INSTRUCTION");
		}
		if((instruction & 0xFFFF0000) != 0) {
			view.hexTextArea.setText(model.displayIntAsHex(instruction));
		}
		else {
			view.hexTextArea.setText(model.displayShortAsHex((short)instruction));
		}
		String assemblyInstruction = decodeBinaryToAssembly(view.binaryTextArea.getText().trim());
	    view.assemblyTextArea.setText(assemblyInstruction);
		
	}
	
	void decodeHex() {
		int instruction = 0;
		String hex = view.hexTextArea.getText().trim();
		
		if(hex.length() != 4 && hex.length() != 8) {
			view.resultTextArea.setText("ERROR: HEX MUST BE 4 OR 8 DIGITS");
			return;
		}
		try {
			long longValue = Long.parseLong(hex, 16);
			instruction = (int) longValue;

		} catch(NumberFormatException nfe) {
			view.resultTextArea.setText("ERROR: ILLEGAL INSTRUCTION");
			return;
		}
		if((hex.length() == 8) && ((instruction & 0xFFFF0000) == 0)) {
			view.resultTextArea.setText("ERROR: ILLEGAL INSTRUCTION");
			return;
		}
		String binaryRepresentation;
	    if ((instruction & 0xFFFF0000) != 0) {
	        binaryRepresentation = model.displayIntAsBinary(instruction);
	        view.binaryTextArea.setText(binaryRepresentation);
	    } else {
	        binaryRepresentation = model.displayShortAsBinary((short) instruction);
	        view.binaryTextArea.setText(binaryRepresentation);
	    }

	    // Decode binary to assembly and display it
	    String assemblyInstruction = decodeBinaryToAssembly(binaryRepresentation);
	    view.assemblyTextArea.setText(assemblyInstruction);
		
	}
	
	private String decodeBinaryToAssembly(String binary) {
	    if (binary.length() != 32 && binary.length() != 16) {
	        return "ERROR: INVALID BINARY LENGTH";
	    }

	    String opcodeBinary = binary.substring(7, 11); // Extract the opcode from the binary
	    String op1RegBinary = binary.substring(12, 16);
	    String destRegBinary = binary.substring(16, 20);
	    String op2RegBinary = binary.substring(28, 32);

	    String opcode = getMnemonicFromBinary(opcodeBinary);
	    String op1Reg = "r" + Integer.parseInt(op1RegBinary, 2);
	    String destReg = "r" + Integer.parseInt(destRegBinary, 2);
	    String op2Reg = "r" + Integer.parseInt(op2RegBinary, 2);

	    return opcode + " " + destReg + "," + op1Reg + "," + op2Reg;
	}

	private String getMnemonicFromBinary(String binary) {
	    switch (binary) {
	        case "0000": return "AND";
	        case "0001": return "EOR";
	        case "0010": return "SUB";
	        case "0011": return "RSB";
	        case "0100": return "ADD";
	        case "0101": return "ADC";
	        case "0110": return "SBC";
	        case "0111": return "RSC";
	        case "1000": return "TST";
	        case "1001": return "TEQ";
	        case "1010": return "CMP";
	        case "1011": return "CMN";
	        case "1100": return "ORR";
	        case "1101": return "MOV";
	        case "1110": return "BIC";
	        case "1111": return "MVN";
	        default: return "UNKNOWN";
	    }
	}

}
