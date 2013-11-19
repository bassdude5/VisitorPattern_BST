========================================================================
Design Patterns, Assignment #3
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
0 - Prints out the results from the class equality check
1 - Does not print the equality check results

I did not add any other debug values, though I included the option to pass
the debug value into most of the class constructors.
I felt that because I used extensive amounts of try catch blocks and error
checking that for the most part my code would not need debug values.


========================================================================
Error Values:
========================================================================
The following are the possible (non-standard) error values that can
be returned from this program if there is a error thrown:

1 - Process class error
2 - Deserialize class error
3 - DeserializeTypes error
4 - Serialize class error
5 - SerailizeTypes class error

========================================================================
Approach and Justifications:
========================================================================

I decided that there was no logical reason to use an interface for the
types classes since they only share 1 to 2 common methods, and it 
really would not enforce much of a pattern.

The process class I added, just to make the driver class super short 
and basic. In addition this would mean that if you truely wanted to
spawn more processes or threads you could simply implement a more 
driver and then use the process class.

I created a method that uses regular expressions to parse the data in
the Deserialize class, and then used the DeserializeTypes class as a
parsing class that will take in a string argument and just output 
the parsed value. All the method calling was done with Reflection,
and the classes were created using reflection as well.

All of the serialization is done using reflection, and should output
a exact copy of the original file passed in.

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
