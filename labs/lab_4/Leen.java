package lab_4;

public class Leen {
  private int W      = 9;         // ширина рабочего поля
  private int H      =  9;         // высота рабочего поля

  public static int WALL   = -1;         // непроходимая ячейка
  public static int BLANK  = -2;         // свободная непомеченная ячейка
 
  private int[] px = new int[W * H];
  private int[] py = new int[W * H];      // координаты ячеек, входящих в путь 

  private int len;                       // длина пути
  private int[][] grid = new int[H][W];                // рабочее поле
 
// Перед вызовом lee() массив grid заполнен значениями WALL и BLANK

public Leen(int[][] matrix) {
  grid = matrix;
}

public boolean lee(int ax, int ay, int bx, int by)   // поиск пути из ячейки (ax, ay) в ячейку (bx, by)
{
  int dx[] = {1, 0, -1, 0};   // смещения, соответствующие соседям ячейки
  int dy[] = {0, 1, 0, -1};   // справа, снизу, слева и сверху
  int d, x, y, k;

  boolean stop;
  // распространение волны
  
  d = 0;

  grid[ax][ay] = 0;            // стартовая ячейка помечена 0
  grid[bx][by] = -2;

  do {
    stop = true;               // предполагаем, что все свободные клетки уже помечены

    for ( y = 0; y < 9; y++ )
      for ( x = 0; x < 9; x++ )
        if ( grid[y][x] == d )                         // ячейка (x, y) помечена числом d
        {
          for ( k = 0; k < 4; k++ )                    // проходим по всем непомеченным соседям
            if (((x + dx[k]) < 9) && ((x + dx[k]) >= 0 ) && ((y + dy[k]) < 9) && ((y + dy[k]) >= 0) && grid[y + dy[k]][x + dx[k]] == BLANK )
            {
              stop = false;                            // найдены непомеченные клетки

              grid[y + dy[k]][x + dx[k]] = d + 1;      // распространяем волну
            }
            
        }
    
    d++;
  } while ( !stop && grid[bx][by] == BLANK );
 
  if (grid[bx][by] == BLANK) {
    return false;}  // путь не найден
 
  // восстановление пути
  len = grid[bx][by];            // длина кратчайшего пути из (ax, ay) в (bx, by)

  x = bx;
  y = by;

  d = len;
  while ( d > 0 )
  {
    px[d] = x;
    py[d] = y;                   // записываем ячейку (x, y) в путь

    d--;
    for (k = 0; k < 4; k++)
      if (((x + dx[k]) < 9) && ((x + dx[k]) >= 0 ) && ((y + dy[k]) < 9) && ((y + dy[k]) >= 0) && grid[y + dy[k]][x + dx[k]] == d)
      {
        x = x + dx[k];
        y = y + dy[k];           // переходим в ячейку, которая на 1 ближе к старту

        break;
      }
  }
  
  px[0] = ax;
  py[0] = ay;        
             // теперь px[0..len] и py[0..len] - координаты ячеек пути
  return true;
}               // поиск пути из ячейки (3,6) в ячейку (3, 0) (см. рис.)
}
