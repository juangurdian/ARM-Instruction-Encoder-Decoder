# ARM Instruction Encoder/Decoder

This Java project provides a GUI application for encoding and decoding ARM assembly instructions. It utilizes the Swing library for the user interface, making it a desktop application suitable for educational purposes and those interested in computer architecture, specifically ARM instruction sets.

## Features

- **Encode ARM Assembly Instructions**: Convert human-readable ARM assembly instructions into their binary and hexadecimal representations.
- **Decode Binary and Hexadecimal Instructions**: Convert binary and hexadecimal representations of ARM instructions back into their assembly language form.
- **Error Handling**: Provides feedback for incorrect formats or unsupported instructions, ensuring users input valid assembly, binary, or hexadecimal codes.

## Components

- `Lab2App.java`: The main class that initializes the MVC (Model-View-Controller) components.
- `Lab2Controller.java`: Handles user interactions, processing encode and decode requests.
- `Lab2Model.java`: Contains logic for conversion between assembly, binary, and hexadecimal formats.
- `Lab2View.java`: Manages the GUI layout, including buttons, text areas, and labels for user input and results.

## How to Run

1. Ensure Java is installed on your system.
2. Compile the Java files using a Java compiler (e.g., `javac Lab2*.java`).
3. Run the application with `java Lab2App`.

## Usage

- **Encoding**: Enter an ARM assembly instruction in the designated text field and click the "Encode" button. The application will display the binary and hexadecimal representation of the instruction.
- **Decoding**: Input a binary or hexadecimal instruction and click the respective "Decode Binary" or "Decode Hex" button. The assembly language equivalent will be displayed.

## Example

- Input (Assembly): `ADD R1, R2, R3`
- Output (Binary): `11100000001000100000000000110011`
- Output (Hex): `E0823003`

## Limitations

- Supports a limited set of ARM instructions for educational purposes.
- Error handling is basic and may not cover all edge cases.

## Acknowledgements

This project is designed for educational use, providing a hands-on approach to understanding the ARM instruction set and the basics of assembly language encoding and decoding.

## License

This project is open-sourced under the MIT License.
