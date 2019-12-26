
public class TheTour {
	private int [][] board = new int [8][8];
	private int dirX[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
    private int dirY[] = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public TheTour()
	{
		for(int i = 0; i < board.length;i++)
		{
			for(int j = 0; j < board.length;j++)
			{
				board[i][j]= -1;
			}
		}
		board[0][0]=0;
		theTour(0,0,1);
	}
	
	public boolean theTour(int x, int y, int count)
	{
		if (count == 64)
		{
			return true;
		}
		else 
		{
			int nextX,nextY;
	
			for(int i = 0;i<8;i++)
			{
				nextX = x + dirX[i];
				nextY = y + dirY[i];
				if(check(nextX,nextY))
				{
					board[nextX][nextY] = count;
					if(theTour(nextX, nextY,count+1))
					{
						return true;
					}
					else 
					{
						board[nextX][nextY] = -1;
					}
				}
			}
			return false;
		}
	}
	
	public boolean check(int x, int y)
	{
		if((x >= 0 && x < 8) && (y >= 0 && y < 8) && (board[x][y] == -1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void show()
	{
		for(int i = 0; i < board.length;i++)
		{
			for(int j = 0; j < board.length;j++)
			{
				if(board[i][j] >=10)
					System.out.print(board[i][j]+" ");
				else
					System.out.print(board[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	
	
}
