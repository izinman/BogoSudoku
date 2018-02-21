class main {
fun main (args: Array<String>)
    {
        println("Welcome to BOGO Sudoku. We will be attempting to create valid  Sudoku puzzles at random.")
		println("Please input a value between .2 and 1 that will be the board density \n(e.g. density .5 will have (.5*81) = 40 numbers on the board")
		
		// The syntax on the next line is interesting. Since the result of both readLine() and toDouble() could be null,
		// we must declare density as nullable (Double?) and use the special ?. operator to call toDouble() if readLine was non-null
        var density : Double? = readLine()?.toDouble()
        if (density != null && (density in 0.2..1.0))
        {
			println("First we will fill the board at random and then go to random parts \nof the board deleting values until we have arrived at the desired density.")
            var sudoku = SudokuRandom(density)
            sudoku.print()
			println("Now we will attempt to create a \'valid\' puzzle (not necessarily  \nsolvable, but with a valid board configuration (see readme).")
			println("This might take a while.")
			var sudoku2 = SudokuValidated(density)
			sudoku2.create()
			sudoku2.print()
        }
        else
        {
            println("Board density must be a double between .2 and 1")
            System.exit(1)
        }
    }
}