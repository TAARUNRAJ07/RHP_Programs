#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class Solution
{
public:
    const int d[5] = {0, 1, 0, -1, 0};
    int orangesRotting(vector<vector<int>> &grid)
    {
        int R = grid.size(), C = grid[0].size();
        int oranges = 0;
        queue<pair<int, int>> q;
        for (int i = 0; i < R; i++)
        {
            for (int j = 0; j < C; j++)
            {
                if (grid[i][j] != 0)
                    oranges++;
                if (grid[i][j] == 2)
                {
                    q.push(make_pair(i, j));
                    grid[i][j] = 0;
                }
            }
        }
        if (oranges == 0)
            return 0;
        int min = -1;
        while (!q.empty())
        {
            min++;
            int qsz = q.size();
            oranges -= qsz;
            while (qsz--)
            {
                auto [r, c] = q.front();
                q.pop();
                for (int i = 0; i < 4; i++)
                {
                    int ar = r + d[i], ac = c + d[i + 1];
                    if (ar >= 0 && ar < R && ac >= 0 && ac < C && grid[ar][ac] == 1)
                    {
                        q.push(make_pair(ar, ac));
                        grid[ar][ac] = 0;
                    }
                }
            }
        }
        return oranges == 0 ? min : -1;
    }
};