# se317lab7

SE 317: Lab 7
Interactive GUI System Testing
The Scientific Calculator
• This Lab Assignment can be done individually, or in a team of two (max).
• If two students want to collaborate on this assignment, each one will still submit individually.
• In your submission, you must indicate if you did the assignment alone, or with another person (both
names and IDs must be included).
In this lab assignment you will build and test a simple GUI calculator using the MVC pattern (or any of
it’s simplified versions.) The Observer class in java is a good example.
The GUI side (the observer) will display a graphical image of your interactive calculator
The Model Side (the observable) will receive input from the user’s interaction with the GUI displayed
on the screen, performs the selected operations on them, and return the results to the screen to be
displayed.
Your calculator will have the following features and functions:
• 0-9 digit buttons
• The decimal point.
• 4 basic math operations: add, subtract, multiply, divide
• 2 advanced operations: square and square root (use text or a suitable icon on each button)
• Memory functions:
Your calculator will have one memory to store a value, add or subtract the result of a successfully
executed operation, or reuse this value as an operand in a new operation.
M+ to add the output of a successfully executed (and displayed) math operation to the value
currently stored in its memory (negative values allowed).
Note: A math operation is executed when you enter one (or two) valid numbers
(operands) and a valid operation, then press the = sign to execute.
For example, the following operations are valid (operands in blue, operations in red,
result in black:
1+1 = 2
4.2 * 2 = 8.4
16 (Square Root) = 4
8 (square) = 64
• Some operations take two operands (like +, -), other operations take one operand (like square
root and square)
• Only valid results can be added to memory. i.e. You can only store the results of executed
operations. Entering a number (like 3232) then pressing M+ will give an error as below:
3232 M+ à “Error”
M- to subtract the number on the calculator screen from the number stored in its memory,
negative values allowed
M-Recall to recall the number in the memory and use it as an input operand to current
calculation
M-Clear to delete the memory contents
2
• Delete: will delete the last digit or the decimal point entered by the user. Multiple Delete
operations will delete multiple digits in reverse order (including the decimal point). For
example:
If you enter 1234.5 then press the Delete key three times, you will delete 5, then the decimal point
then the 4, You will end up with 123 as your current operand.
Notes:
a. Only the operands and the result are displayed on the calculator screen. The operations
are NOT displayed
b. When pressed, each operation button on the screen changes its visual appearance to
show it is pressed and is currently active (they get bold or change color to show being
active).
Each time you press an operation, the first operand remains on screen, and the operation button
changes it’s visual look to show it is being active. When you start typing the second operand (if the
operation needs two operands), the screen refreshes, showing the second operand as you type it. For
example if you want to add the two numbers [111111 + 222222 =], your display will have the
following three consecutive values displayed on the screen (each screen will replace the previous one:
111111 (the display will show 111111)
+ (the display will continue to show 111111, and the + button will change
its look to indicate being active)
222222 (the display will refresh, showing 222222)
= (the display will refresh, showing the result 333333 (or an error for
invalid operations like division by zero or an out-of-range value)
Output on the screen: 333333
Notes: You don’t need to use colors on the display
In your GUI, each button will have two images, one when in idle state and one when depressed
or active (or both). That includes all buttons on the GUI (digits, operations, etc.)
You only display the digits, the decimal point, and the negative sign on your display. You don’t
need to display the active operations on the screen
• Clear: will reset the calculator to a blank start, including clearing the memory.
------
Guidelines:
A. Design Architecture: Use MVC or the simple Java Observer class for implementation
B. Source Code:
1- Use ChatGPT or any existing code that closely matches your project, but make sure to
adjust the code to match the specifications above.
2- Use exception handling and add appropriate comments to your code
3- Interaction I/O will be done using interactive GUI
4- Add a Read-me file of how to deploy and use your assignment
Deliverables:
A comprehensive test plan of your calculator code and the GUI (user interface).
A. The Model will be tested at the code level by simulated function calls using Java test code,
with screenshots of the output (like all previous assignments)
B. The GUI will be tested using a UI test tool (Cypress, Selenium, Testigma, or similar)
3
Write down the test cases to be run on the interactive GUI with the expected results
1- Test requirement [TR]: Test GUI functions.
Test cases [T]: identify 6 test cases. Ex: Test Case: 12 + 34, Expected result: 46
2- Test requirement [TR]: Only operands and results are displayed on the calculator
screen.
Test cases [T]: identify 3 test cases
3- Test requirement [TR]: When pressed, each operation button on the screen changes
its state (visual appearance) to show it is pressed and is currently active
Test cases [T]: identify 3 test cases
You will need to use the UI test tool to run each UI test as a sequence of GUI inputs and record
the test result”.
2- A detailed report covering the documented testing process and the corresponding results.
Additional examples:
Division by zero test case:
Input sequence:
222 / 0 =
expected result: Error
Actual result: Error
Out of range test case...
Etc.
Additional details and Q&A will be discussed in class.
Good luck,
