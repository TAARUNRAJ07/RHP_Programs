#include <iostream>
#include <queue>
#include <vector>
using namespace std;

class Solution
{
public:
    int nearestExit(vector<vector<char>> &maze, vector<int> &ent)
    {
        int R = maze.size(), C = maze[0].size();
        queue<tuple<int, int, int>> q;
        q.push(make_tuple(ent[0], ent[1], 0));
        maze[ent[0]][ent[1]] = '?';
        while (!q.empty())
        {
            auto [row, col, steps] = q.front();
            q.pop();
            if (row == 0 || row == R - 1 || col == 0 || col == C - 1)
            {
                if (maze[row][col] != '?')
                {
                    return steps;
                }
            }

            int d[] = {0, 1, 0, -1, 0};
            for (int i = 0; i < 4; i++)
            {
                int ar = row + d[i], ac = col + d[i + 1];
                if (ar >= 0 && ar < R && ac >= 0 && ac < C && maze[ar][ac] == '.')
                {
                    q.push(make_tuple(ar, ac, steps + 1));
                    maze[ar][ac] = '+';
                }
            }
        }
        return -1;
    }
};