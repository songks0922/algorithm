#include <algorithm>
#include <iostream>
#include <queue>
#include <vector>

#define MAX 250

using namespace std;

int r, c;
char map[MAX][MAX];
bool visited[MAX][MAX];

int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};

int totalWolf = 0, totalSheep = 0;

void bfs(int x, int y);

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  cin >> r >> c;

  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      cin >> map[i][j];
    }
  }

  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      if (!visited[i][j]) {
        bfs(i, j);
      }
    }
  }

  cout << totalSheep << " " << totalWolf;

  return 0;
}

void bfs(int x, int y) {
  int wolf = 0, sheep = 0;

  queue<pair<int, int>> queue;
  queue.push(make_pair(x, y));
  visited[x][y] = true;

  while (!queue.empty()) {
    int x = queue.front().first;
    int y = queue.front().second;
    queue.pop();

    if (map[x][y] == 'v') wolf++;
    if (map[x][y] == 'o') sheep++;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
        if (!visited[nx][ny] && map[nx][ny] != '#') {
          visited[nx][ny] = true;
          queue.push(make_pair(nx, ny));
        }
      }
    }
  }

  if (sheep > wolf) {
    totalSheep += sheep;
  } else {
    totalWolf += wolf;
  }
}