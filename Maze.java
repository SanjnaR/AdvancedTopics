
public class Maze
{
   	   private char[][] maze;
   	   private int iOrigin;
   	   private int jOrigin;
   	   private int iExit;
   	   private int jExit;
   	   private int width;
   	   private int height;
   	   private int steps;
   	
   	public Maze(char[][] aMaze, int i, int j)
   	{
   		maze = aMaze;
   		iOrigin = i;
   		jOrigin = j;
   		height = maze.length;
   		width = maze[0].length;
   		steps = 0;
   	}
  
   	public boolean findExit()
    {
   		return escape(iOrigin, jOrigin);
    }
  
    private boolean escape(int i, int j)
    {
	    if(move(i - 1, j))
	    	return true;
	    else if(move(i + 1, j))
	    	return true;
	    else if(move(i, j -1))
	    	return true;
	    else if(move(i, j + 1))
	    	return true;
	    else
	    return false;
    }
 
    private boolean move(int i, int j)
    {
    	display();
    	if(i < 0 || j < 0 || i > height - 1 || j > width - 1)
    	{
    		iExit = i;
    		jExit = j;
    		return true;
    	}
    	char x = maze[i][j];
    	if(x != ' ')
    	{
    		return false;
    	}
    	else
    	{
    		steps++;
    		maze[i][j] = (char)('A' + steps - 1);
    		return escape(i, j);
    	}
    }
  
    /*private boolean isExit(int i, int j)
    { 
	    if(i == 0 || i == height - 1)
	    {
	    	if(j == 0 || j == width - 1)
	    	{
	    		if(maze[i][j] == ' ')
	    		{
	    			return true;
	    		}
	    	}
	    }
    }*/
  
    public int getIExit()
    {
	    return iExit;
    }
 
    public int getJExit()
    {
	    return jExit;
    }
   
    public int getSteps()
    {
    	return steps;
    }
 
   public void display()
   {
	   for(int x = 0; x < maze.length; x++)
	   {
		   for(int y = 0; y < maze[0].length; y++)
		   {
			   System.out.print(maze[x][y] + " ");
		   }
		   System.out.println();
	   }
   }


   public static void main(String args[])
   {
	   char[][] m = {
      {'*', ' ', '*', '*', '*', '*', '*', '*', '*'}, 
      {'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*'}, 
      {'*', ' ', '*', '*', '*', '*', '*', ' ', '*'}, 
      {'*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*'}, 
      {'*', ' ', '*', ' ', '*', '*', '*', ' ', '*'}, 
      {'*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*'}, 
      {'*', '*', '*', ' ', '*', ' ', '*', ' ', '*'}, 
      {'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*'}, 
      {'*', '*', '*', '*', '*', '*', '*', '*', '*'}
      };
      
 
	   Maze maze = new Maze(m, 4, 3); //(m, xStart, yStart)
	   maze.display();
	   if (maze.findExit())
		   System.out.println("There is an exit at (" + maze.getIExit() + ", "
            + maze.getJExit() + ")");
	   else
		   System.out.println("No exit was found");
   
	   System.out.println();
	   System.out.println();
	   maze.display();
	   System.out.println("Steps:" + maze.getSteps());
   } 
}