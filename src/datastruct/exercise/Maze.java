package datastruct.exercise;

import datastruct.implement.StackSLinked;
import datastruct.interfaces.Stack;

/**
 * @author KeHao 求解迷宫
 */
public class Maze {

	public static void main(String[] args) {
		char[][] maze = { { '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '1', '1', '0', '0', '1', '1' },
				{ '1', '0', '0', '1', '1', '0', '0', '1', '0', '1' },
				{ '1', '0', '0', '0', '0', '0', '0', '1', '0', '1' },
				{ '1', '0', '0', '0', '0', '1', '1', '0', '0', '1' },
				{ '1', '0', '0', '1', '1', '1', '0', '0', '0', '1' },
				{ '1', '0', '0', '0', '0', '1', '0', '1', '0', '1' },
				{ '1', '0', '1', '1', '0', '0', '0', '1', '0', '1' },
				{ '1', '1', '0', '0', '0', '0', '1', '0', '0', '1' },
				{ '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' } };
		mazeExit(maze, 2, 8, 1, 7);
	}

	/**
	 * 迷宫路径计算方法
	 * 
	 * @param maze
	 * @param sx
	 * @param sy
	 * @param ex
	 * @param ey
	 */
	public static void mazeExit(char[][] maze, int sx, int sy, int ex, int ey) {
		Cell[][] cells = createMaze(maze);
		printMaze(cells);
		System.out.println("---------------------------");
		Stack<Cell> s = new StackSLinked<Cell>();
		Cell startCell = cells[sx][sy];
		Cell endCell = cells[ex][ey];
		s.push(startCell);
		startCell.visited = true;
		while (!s.isEmpty()) {
			Cell current = (Cell) s.peek();
			if (current == endCell) {
				while (!s.isEmpty()) {
					Cell cell = (Cell) s.pop();
					cell.c = '*';
					while (!s.isEmpty() && !isAdjoinCell((Cell) s.peek(), cell)) {
						s.pop();
					}
				}
				System.out.println("找到从起点到终点的路径");
				printMaze(cells,startCell,endCell);
				return;
			} else {// 如果当前位置不是终点
				int x = current.x;
				int y = current.y;
				int count = 0;
				if (isValidWay(cells[x + 1][y])) {
					s.push(cells[x + 1][y]);
					cells[x + 1][y].visited = true;
					count++;
				}
				if (isValidWay(cells[x][y + 1])) {
					s.push(cells[x][y + 1]);
					cells[x][y + 1].visited = true;
					count++;
				}
				if (isValidWay(cells[x - 1][y])) {
					s.push(cells[x - 1][y]);
					cells[x - 1][y].visited = true;
					count++;
				}
				if (isValidWay(cells[x][y - 1])) {
					s.push(cells[x][y - 1]);
					cells[x][y - 1].visited = true;
					count++;
				}
				if (count == 0) {
					s.pop();
				}
			}
		}
		System.out.println("没有从起点到终点的路径");
	}

	/**
	 * 构造迷宫方法
	 * 
	 * @param maze
	 * @return
	 */
	private static Cell[][] createMaze(char[][] maze) {
		Cell[][] cells = new Cell[maze.length][];
		for (int x = 0; x < maze.length; x++) {
			char[] row = maze[x];
			cells[x] = new Cell[row.length];
			for (int y = 0; y < row.length; y++) {
				cells[x][y] = new Cell(x, y, maze[x][y], false);
			}
		}
		return cells;
	}

	/**
	 * 打印迷宫形状
	 * @param cells
	 */
	private static void printMaze(Cell[][] cells) {
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[x].length; y++) {
					System.out.print(cells[x][y].c+" ");
			}
			System.out.println();
		}
	}
	/**
	 * 打印迷宫路线方法
	 * 
	 * @param cells
	 */
	private static void printMaze(Cell[][] cells,Cell start,Cell end) {
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[x].length; y++) {
				if((x==start.x&&y==start.y)){
					System.out.print(cells[x][y].c+" ");//
				}else if((x==end.x&&y==end.y)){
					System.out.print(cells[x][y].c+" ");//
				}else{
					System.out.print(cells[x][y].c+" ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * 是否为相邻接点
	 * 
	 * @param cell1
	 * @param cell2
	 * @return
	 */
	private static boolean isAdjoinCell(Cell cell1, Cell cell2) {
		if (cell1.x == cell2.x && Math.abs(cell1.y - cell2.y) < 2) {
			return true;
		}
		if (cell1.y == cell2.y && Math.abs(cell1.x - cell2.x) < 2) {
			return true;
		}
		return false;
	}

	/**
	 * 节点可访问性
	 * 
	 * @param cell
	 * @return
	 */
	private static boolean isValidWay(Cell cell) {
		return cell.c == '0' && !cell.visited;
	}
}

/**
 * @author KeHao 迷宫格子类
 */
class Cell {
	int x = 0;
	int y = 0;
	boolean visited = false;
	char c = ' ';

	public Cell(int x, int y, char c, boolean visited) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
		this.visited = visited;
	}
}