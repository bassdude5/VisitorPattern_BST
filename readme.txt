========================================================================
Design Patterns, Assignment #4
Team members: Michael Welte
========================================================================
Compilation and running:
========================================================================
To compile this, navigate to the parent directory and run
"ant compile" in the terminal.

Modify the build.xml file at the bottom in the "arg value" tag to change
the debug value, (see below for debug value details) and the input and
output file names. To run the program, run the command "ant run"
in the terminal.

========================================================================
Debug Values:
========================================================================
This program uses the following debug value scheme:
0 - No debug value (basic output)
1 - Print to stdout each time a constructor is called, and with what
     parameters the constructor was called with (excluding node class)
2 - Print to stdout each time a new tree is created
3 - Print to stdout each time a node constructor is called

========================================================================
Error Values:
========================================================================
The following are the possible (non-standard) return values that can
be returned from this program if there is a error caught:

1 - Driver error value
2 - BSTBuilder error value
3 - BST error value
4 - Node error value

========================================================================
Approach and Justifications:
========================================================================


========================================================================
Slack days:
========================================================================
The number of slack days I have used so far is: 3

========================================================================
Contributions:
========================================================================
Michael Welte:
	-Entire projects

========================================================================
