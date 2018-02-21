open class SudokuRandom(density: Double) : Sudoku(density) {
    override fun create() 
	{
		cull(true)
    }
	protected fun cull(b : Boolean)
	{
		var currNum = 81;
		// This is BOGO Sudoku, after all
		// Randomly attempts to delete until enough have been deleted
		var iter = 0
        while (currNum > MAX_SIZE)
        {
            val i = randRange(0, 8)
            val j = randRange(0, 8)
            if (board[i][j] != 0)
            {
                board[i][j] = 0
                currNum--
            }
			iter++;
        }
		if (b) println("Culling numbers from the board took " + iter + " iterations")
	}
}