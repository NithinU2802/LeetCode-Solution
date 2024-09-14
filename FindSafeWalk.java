/******************************************************************************

100414. Find a Safe Walk Through a Grid

You are given an m x n binary matrix grid and an integer health.

You start on the upper-left corner (0, 0) and would like to get to the lower-right corner (m - 1, n - 1).

You can move up, down, left, or right from one cell to another adjacent cell as long as your health remains positive.

Cells (i, j) with grid[i][j] = 1 are considered unsafe and reduce your health by 1.

Return true if you can reach the final cell with a health value of 1 or more, and false otherwise.

 

Example 1:

Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]], health = 1

Output: true

Explanation:

The final cell can be reached safely by walking along the gray cells below.


Example 2:

Input: grid = [[0,1,1,0,0,0],[1,0,1,0,0,0],[0,1,1,1,0,1],[0,0,1,0,1,0]], health = 3

Output: false

Explanation:

A minimum of 4 health points is needed to reach the final cell safely.


Example 3:

Input: grid = [[1,1,1],[1,0,1],[1,1,1]], health = 5

Output: true

Explanation:

The final cell can be reached safely by walking along the gray cells below.



Any path that does not go through the cell (1, 1) is unsafe since your health will drop to 0 when reaching the final cell.

 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
2 <= m * n
1 <= health <= m + n
grid[i][j] is either 0 or 1.

*******************************************************************************/
import java.util.*;

class Cood {
    int x;
    int y;

    public Cood(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cood cood = (Cood) o;
        return x == cood.x && y == cood.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int r = grid.size(), c = grid.get(0).size();
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<Cood> queue = new LinkedList<>();
        Map<Cood, Integer> map = new HashMap<>();
        Cood start = new Cood(0, 0);
        queue.add(start);
        map.put(start, health - grid.get(0).get(0));

        while (!queue.isEmpty()) {
            Cood cod = queue.remove();
            int x = cod.x, y = cod.y;

            if (x == r - 1 && y == c - 1 && map.get(cod) > 0) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int xx = x + dir[i][0], yy = y + dir[i][1];

                if (xx >= 0 && yy >= 0 && xx < r && yy < c) {
                    Cood node = new Cood(xx, yy);
                    int rem = map.get(cod) - grid.get(xx).get(yy);

                    if (!map.containsKey(node) || rem > map.get(node)) {
                        map.put(node, rem);
                        queue.add(node);
                    }
                }
            }
        }

        return false;
    }
}


public class FindSafeWalk
{
	public static void main(String[] args) {
	    List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1, 1, 1));
        grid.add(Arrays.asList(1, 0, 1));
        grid.add(Arrays.asList(1, 1, 1));
        int health = 5;
		Solution s=new Solution();
		System.out.println(s.findSafeWalk(grid,health));
	}
}
