package lab_4;

public class Leen {
  private int W      = 9;         
  private int H      =  9;         

  public static int WALL   = -1;         
  public static int BLANK  = -2;         
 
  private int[] px = new int[W * H];
  private int[] py = new int[W * H];      

  private int len;                       
  private int[][] grid = new int[H][W];                
 


public Leen(int[][] matrix) {
  grid = matrix;
}

public boolean lee(int ax, int ay, int bx, int by)   
{
  int dx[] = {1, 0, -1, 0};   
  int dy[] = {0, 1, 0, -1};   
  int d, x, y, k;

  boolean stop;
  
  
  d = 0;

  grid[ax][ay] = 0;            
  grid[bx][by] = -2;

  do {
    stop = true;               

    for ( y = 0; y < 9; y++ )
      for ( x = 0; x < 9; x++ )
        if ( grid[y][x] == d )                         
        {
          for ( k = 0; k < 4; k++ )                    
            if (((x + dx[k]) < 9) && ((x + dx[k]) >= 0 ) && ((y + dy[k]) < 9) && ((y + dy[k]) >= 0) && grid[y + dy[k]][x + dx[k]] == BLANK )
            {
              stop = false;                            

              grid[y + dy[k]][x + dx[k]] = d + 1;      
            }
            
        }
    
    d++;
  } while ( !stop && grid[bx][by] == BLANK );
 
  if (grid[bx][by] == BLANK) {
    return false;}  
 
  
  len = grid[bx][by];            

  x = bx;
  y = by;

  d = len;
  while ( d > 0 )
  {
    px[d] = x;
    py[d] = y;                   

    d--;
    for (k = 0; k < 4; k++)
      if (((x + dx[k]) < 9) && ((x + dx[k]) >= 0 ) && ((y + dy[k]) < 9) && ((y + dy[k]) >= 0) && grid[y + dy[k]][x + dx[k]] == d)
      {
        x = x + dx[k];
        y = y + dy[k];           

        break;
      }
  }
  
  px[0] = ax;
  py[0] = ay;        
             
  return true;
}               
}
