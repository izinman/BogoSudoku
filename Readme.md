Welcome to BOGO Sudoku! BOGO Sudoku is a project written in Kotlin by Isaac Zinman for CS162 with Professor Hardekopf.

*Building and Running*
 * I had a LOT of problems with this aspect. I had the most success with Eclipse initially, then that stopped working and I figured out how to get it to run in IntelliJ IDEA. So I guess that would be my recommended way to run it.

Steps to run with Eclipse:
 * Install the latest Eclipse release (Eclipse Mars for Java developers)
 * Install the Kotlin Eclipse plugin
 * Create a new Project… and then select Kotlin project from the dialog that shows up
 * Paste the four .kt files in the src directory and then click the Run button at the top
 * Hopefully, it will automatically configure the build, compile, and run everything for you
 * You may have to set a custom run configuration but this should be straightforward
 * Note: at one point, the Eclipse build tool stopped re-compiling when I clicked Run, and kept running the old version, making me go crazy because I thought I had fixed the bug that was still showing up in the output. I believe this is a bug with Eclipse’s Kotlin build process.

Alternatives if the above doesn’t work:
 * Try the same process described with Eclipse, but with IntelliJ IDEA - install the Kotlin plugin, then create a new project, copy the files in, and run it from there
 * Try to build with Gradle using the build.gradle file supplied. Theoretically, running the command gradle compileKotlin and then gradle jar should create an executable JAR file in the /build/libs/ directory. If you can figure out why the JAR gives the usual “main class not found” error, you’re smarter than I am.

*Program Description*

BOGO Sudoku attempts to randomly create Sudoku puzzles, inspired by BOGO Sort:

`while (!list.isSorted()) randomShuffle(list)`

Sudoku rules are here in case you are unfamiliar: http://www.counton.org/sudoku/rules-of-sudoku.php

In the source files there are 3 classes, the inheritance hierarchy of which goes Sudoku -> SudokuRandom -> SudokuValidated (Sudoku is at the top) and a main class where main() is defined.
At the beginning the program will ask you to supply a `density` between .2 and 1. This is the “fill level” of the board, i.e. what proportion of the squares will be filled in with numbers. Then it will create a SudokuRandom and a SudokuValidated.
SudokuRandom simply fills the board with numbers 1-9, and then goes to random spots on the board and deletes numbers until the board is at the user-specified density.
SudokuValidated continually re-initializes the board using the random culling process from SudokuRandom and checks to see if it has created a valid\* puzzle, stopping when it does. (Disclaimer: it probably won't. Like, highly probably.)
\*Note: 'valid' does not mean solvable, just that there is no more than one of each digit in each row, column, and box.

I haven’t bothered trying to do the math of how unlikely it is that SudokuValidated actually creates a valid Sudoku puzzle, although I suspect that it is Very Unlikely.

I hope you enjoyed your time here at BOGO Sudoku, have an awesome day!
