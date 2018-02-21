import kotlin.system.*

class SudokuValidated (density: Double) : SudokuRandom(density){
    override fun create()
    {
    	super.create()
		var iter = 1
		while (!validate())
		{
			board = initBoard()
			cull(false)
			++iter
		}
		print("It took " + " attempts to create a \'valid\' sudoku board.")
    }
	private fun validate() : Boolean
	{
		for (i in 0..8)
		{
			for (j in 0..8)
			{
				//checks to see if there is any of the same number in the same row, column, or box
				if (!checkVertical(i, j)) return false;
				if (!checkHorizontal(i, j)) return false;
				if (!checkBox(i, j)) return false;
			}
		}
		return true;
	}
	private fun checkVertical(row: Int, col: Int) : Boolean
	{
		for (r in 0..8)
		{
			if(board[row][col] == board[r][col]) return false;
		}
		return true;
	}
	private fun checkHorizontal(row: Int, col: Int) : Boolean
	{
		for (c in 0..8)
		{
			if(board[row][col] == board[row][c]) return false;
		}
		return true;
	}
	
	// trust me, this properly checks to see if the value
	private fun checkBox(row: Int, col: Int) : Boolean
	{
		val ro = row - (row % 3)
		val co = col - (col % 3)
		for (i in ro..(ro+3))
		{
			for (j in co..(co+3))
			{
				// this is a Kotlin idiomatic way of checking to see if (row, col) == (i, j)
				if ((Pair(row, col) != Pair(i, j)) && board[row][col] == board[i][j]) return false;
			}
		}
		return true;
	}
	
}