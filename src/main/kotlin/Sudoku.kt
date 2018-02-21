import java.util.Random

 abstract class Sudoku (val density: Double){
    protected val random = Random()
    protected val MAX_SIZE = (81*density).toInt()
    
    // call create in the init block, which basically works like a constructor
	// interestingly, this did not call the overridden version of create() when a subclass was instantiated which is what I had expected
    init {
        create()
    }
    //randomly fills board
    var board = initBoard()
    // each subclass will have its own version of create
    // create() deletes numbers from the board until we have arrived at the desired density
    // SudokuRandom will do this, well, randomly, but SudokuValidated will keep going until it creates a valid Sudoku puzzle
    // note: "valid" does not mean it is necessarily solvable, just that it has only one of each number in each row, column, and box
    abstract fun create()

    //but they all print themselves the same
    public fun print()
    {
        for (i in 0..8)
        {
            if (i == 3 || i == 6) println("------|------|-----")
            for (j in 0..8)
            {
                // If board[i][j] is zero we want to output a space instead
                if (board[i][j] != 0) print("" + board[i][j] + " ")
                else print("  ")

                if (j == 8) println()
                else if (((j + 1) % 3) == 0) print("|")
            }
        }
    }
	 
	//inclusive range, so randRange(1, 9) => [1, 9]
    protected fun randRange(from: Int, to: Int) : Int
    {
        return random.nextInt(to - from+1) + from
    }
	 
	protected fun initBoard() : Array<IntArray>
	{
	// took me a long time to figure out the initalizer syntax in the next line but it's kinda cool
    // this creates a 9x9 2D array of Ints and initializes each to a random integer from 1 to 9
	// the 2nd argument is a lambda that initializes each element of the outer array to be an IntArray with 9 ints
		return Array(9, {_ -> (intArrayOf(randRange(1, 9), randRange(1, 9), randRange(1, 9), randRange(1, 9), randRange(1, 9), randRange(1, 9), randRange(1, 9), randRange(1, 9), randRange(1, 9)))})
	}
}