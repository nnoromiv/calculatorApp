// These import statements are used to import the necessary classes and packages from the Java Swing
// and AWT libraries.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The Calculator class is a Java program that creates a graphical calculator interface with number
 * buttons, function buttons, and text field for input and output, and performs basic arithmetic
 * operations.
 */
public class Calculator implements ActionListener {
// The line `Font _myFont = new Font("Century Gothic", Font.BOLD, 30);` is creating a new Font object
// named `_myFont`. The font is set to "Century Gothic" with a bold style and a size of 30. This font
// will be used for the text displayed in the calculator interface.
    Font _myFont = new Font("Century Gothic", Font.BOLD, 30);

// These lines of code are declaring and initializing instance variables in the Calculator class.
    JFrame _frame;
    JTextField _textField;
    JButton[] _numberButtons = new JButton[10];
    JButton[] _functionButtons = new JButton[10];
    JButton _addButton, _subButton, _mulButton, _divButton, _decButton, _equalButton, _delButton, _clearButton, _percentageButton, _negativeButton;
    JPanel _panel;

// These lines of code are declaring and initializing instance variables in the Calculator class.
    double _num1=0, _num2=0, _result=0;
    char _operator;

// The `Calculator()` method is the constructor of the `Calculator` class. It is responsible for
// initializing the instance variables and creating the graphical user interface (GUI) for the
// calculator.
    Calculator(){
// These lines of code are creating a new JFrame object named `_frame` and setting its properties.
        _frame = new JFrame("Calculator");
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setSize(420, 550);
        _frame.setLayout(null);

// The code is creating a new JTextField object named `_textField`.
        _textField = new JTextField();
        _textField.setBounds(10, 25, 380, 100);
        _textField.setFont(_myFont);
        _textField.setEditable(false);

// These lines of code are creating new JButton objects and assigning them to the corresponding
// instance variables in the Calculator class. Each JButton represents a specific function or
// operation that can be performed in the calculator interface. The text displayed on each
// button represents the function it performs. For example, the JButton with the text "+"
// represents the addition operation, the JButton with the text "-" represents the subtraction
// operation, and so on. These buttons will be added to the calculator interface panel and will
// trigger specific actions when clicked.
        _addButton = new JButton("+");
        _subButton = new JButton("-");
        _mulButton = new JButton("*");
        _divButton = new JButton("/");
        _decButton = new JButton(".");
        _equalButton = new JButton("=");
        _delButton = new JButton("DEL");
        _clearButton = new JButton("AC");
        _percentageButton = new JButton("%");
        _negativeButton = new JButton("+/-");


// The code is assigning specific JButton objects to the elements of the `_functionButtons`
// array. Each element of the array represents a specific function or operation that can be
// performed in the calculator interface.
        _functionButtons[0] = _addButton;
        _functionButtons[1] = _subButton;
        _functionButtons[2] = _mulButton;
        _functionButtons[3] = _divButton;
        _functionButtons[4] = _decButton;
        _functionButtons[5] = _equalButton;
        _functionButtons[6] = _delButton;
        _functionButtons[7] = _clearButton;
        _functionButtons[8] = _percentageButton;
        _functionButtons[9] = _negativeButton;


// The code is creating a for loop that iterates from 0 to 9. Inside the loop, it performs the
// following actions for each iteration:
        for (int i = 0; i < 10; i++) {
            _functionButtons[i].addActionListener(this);
            _functionButtons[i].setFont(_myFont);
            _functionButtons[i].setFocusable(false);
            _functionButtons[i].setBackground(Color.decode("#Ffa500"));
            _functionButtons[i].setBorder(null);
        }

// The code block is creating an array of JButton objects named `_numberButtons` with a length
// of 10. Inside the for loop, it initializes each element of the array with a new JButton
// object. The text displayed on each button is set to the corresponding number from 0 to 9
// using `String.valueOf(i)`. ActionListener is added to each button, which means that when any
// of these buttons are clicked, the `actionPerformed` method in the Calculator class will be
// called. The font, focusability, background color, and border of each button are also set.
        for (int i = 0; i < 10; i++) {
            _numberButtons[i] = new JButton(String.valueOf(i));
            _numberButtons[i].addActionListener(this);
            _numberButtons[i].setFont(_myFont);
            _numberButtons[i].setFocusable(false);
            _numberButtons[i].setBackground(Color.gray);
            _numberButtons[i].setBorder(null);
        }

// The code is creating a new JPanel object named `_panel`. The `setBounds()` method is used to
// set the position and size of the panel within the JFrame. In this case, the panel is
// positioned at (10, 150) and has a width of 380 pixels and a height of 300 pixels.
        _panel = new JPanel();
        _panel.setBounds(10, 150, 380, 300);
        _panel.setLayout(new GridLayout(5,4,10,10));
        
// These lines of code are adding the buttons to the panel in the calculator interface. Each
// button is added to the panel in a specific order to create the layout of the calculator
// interface. The buttons are added using the `add()` method of the panel object `_panel`. The
// buttons are added in a grid layout with 5 rows and 4 columns. The buttons are added in the
// following order:
        _panel.add(_clearButton);
        _panel.add(_delButton);        
        _panel.add(_percentageButton);
        _panel.add(_divButton);

        _panel.add(_numberButtons[7]);
        _panel.add(_numberButtons[8]);
        _panel.add(_numberButtons[9]);
        _panel.add(_mulButton);

        _panel.add(_numberButtons[4]);
        _panel.add(_numberButtons[5]);
        _panel.add(_numberButtons[6]);
        _panel.add(_subButton);

        _panel.add(_numberButtons[1]);
        _panel.add(_numberButtons[2]);
        _panel.add(_numberButtons[3]);
        _panel.add(_addButton);

        _panel.add(_negativeButton);
        _panel.add(_numberButtons[0]);
        _panel.add(_decButton);
        _panel.add(_equalButton);

// These lines of code are adding the text field and panel to the frame and making the frame
// visible.
        _frame.add(_textField);
        _frame.add(_panel);
        _frame.setVisible(true);
    }
/**
 * The main function creates a new instance of the Calculator class.
 */
    public static void main(String[] args) throws Exception {
        new Calculator();
    }

// The above code is implementing the functionality of a basic calculator. It defines an
// actionPerformed method that handles button clicks.
    @Override
    public void actionPerformed(ActionEvent e){
// This code block is checking which number button was clicked by iterating through the
// `_numberButtons` array. It compares the source of the event (`e.getSource()`) with each
// element of the array. If the source matches the current number button, it appends the
// corresponding number to the text in the `_textField` by using the `concat()` method.
        for (int i = 0; i < 10; i++){
            if(e.getSource() == _numberButtons[i]) {
                _textField.setText(_textField.getText().concat(String.valueOf(i)));
            }
        }

// This code block is checking if the source of the event (`e.getSource()`) is the decimal
// button (`_decButton`). If the decimal button is clicked, it appends a decimal point (".") to
// the text in the `_textField` by using the `concat()` method. This allows the user to input
// decimal numbers in the calculator interface.
        if(e.getSource() == _decButton){
            _textField.setText(_textField.getText().concat("."));
        }

// This code block is checking if the source of the event (`e.getSource()`) is the addition
// button (`_addButton`). If the addition button is clicked, it performs the following actions:
// 1. It retrieves the current value in the text field `_textField` using `getText()`.
// 2. It converts the retrieved value to a double using `Double.parseDouble()`.
// 3. It assigns the converted value to the variable `_num1`.
// 4. It assigns the addition operator (`+`) to the variable `_operator`.
// 5. It sets the text in the text field `_textField` to an empty string, clearing the text
// field.
        if(e.getSource() == _addButton){
            _num1 = Double.parseDouble(_textField.getText());
            _operator = '+';
            _textField.setText("");
        }
// This code block is checking if the source of the event (`e.getSource()`) is the subtraction
// button (`_subButton`). If the subtraction button is clicked, it performs the following
// actions:
        if(e.getSource() == _subButton){
            _num1 = Double.parseDouble(_textField.getText());
            _operator = '-';
            _textField.setText("");
        }
// This code block is checking if the source of the event (`e.getSource()`) is the
// multiplication button (`_mulButton`). If the multiplication button is clicked, it performs
// the following actions:
        if(e.getSource() == _mulButton){
            _num1 = Double.parseDouble(_textField.getText());
            _operator = '*';
            _textField.setText("");
        }
// This code block is checking if the source of the event (`e.getSource()`) is the division
// button (`_divButton`). If the division button is clicked, it performs the following actions:
        if(e.getSource() == _divButton){
            _num1 = Double.parseDouble(_textField.getText());
            _operator = '/';
            _textField.setText("");
        }
// The above code is checking if the source of the event is the percentage button. If it is, it
// retrieves the value from the text field, converts it to a double, and assigns it to the
// variable _num1. It then sets the operator variable to '%' and calculates the result by
// dividing _num1 by 100. Finally, it sets the text of the text field to the string
// representation of the result.
        if(e.getSource() == _percentageButton){
            _num1 = Double.parseDouble(_textField.getText());
            _operator = '%';
            _result = _num1 / 100;
            _textField.setText(String.valueOf(_result));
        }

// The above code is checking if the event source is the "_negativeButton". If it is, it checks
// if the "_textField" is empty. If it is empty, it sets the value of "_temp" to 0 and then
// subtracts 1 from it. The resulting value is then set as the text of the "_textField". If the
// "_textField" is not empty, it parses the value of the "_textField" as a double and
// multiplies it by -1. The resulting value is then set as the text of the "_textField".
        if(e.getSource() == _negativeButton){
            if(_textField.getText().isEmpty()){
                int _temp = 0;
                _temp+=-1;
                _textField.setText(String.valueOf(_temp));
            } else {
                double _temp = Double.parseDouble(_textField.getText());
                _temp*=-1;
                _textField.setText(String.valueOf(_temp));
            }
        }

// The above code is handling an event when the equal button is clicked. It first retrieves the
// second number from a text field and converts it to a double. Then, it performs a calculation
// based on the operator stored in a variable. The result of the calculation is then displayed
// in the text field. Finally, the first number is updated with the result for future
// calculations.
        if(e.getSource() == _equalButton){
            _num2 = Double.parseDouble(_textField.getText());

            switch (_operator) {
                case '+':
                    _result = _num1 + _num2;
                    break;
                case '-':
                    _result = _num1 - _num2;
                    break;
                case '*':
                    _result = _num1 * _num2;
                    break;
                case '/':
                    _result = _num1 / _num2;
                    break;
            
                default: _result = _num1;
                    break;
            }
            _textField.setText(String.valueOf(_result));
            _num1 = _result;
        }

// The above code is checking if the source of the event is the "_clearButton" and if it is, it
// sets the text of the "_textField" to an empty string, effectively clearing the text in the
// text field.
        if(e.getSource() == _clearButton){
            _textField.setText("");
        }

// The above code is checking if the source of the event is the "_delButton" button. If it is,
// it retrieves the text from the "_textField" text field, clears the text field, and then
// iterates through each character of the retrieved string (except the last character). It
// appends each character to the text field, effectively deleting the last character from the
// original string.
        if(e.getSource() == _delButton){
            String string = _textField.getText();
            _textField.setText("");
            for (int i = 0; i < string.length() - 1; i++){
                _textField.setText(_textField.getText()+string.charAt(i));
            }
        }
    }
}
