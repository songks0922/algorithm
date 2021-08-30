#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int getParent(int parent[], int x) {
  if(parent[x] == x) {
    return x;
  } else {
    return parent[x] = getParent(parent, parent[x]);
  }
}

void _union(int parent[], int x, int y) {
  x = getParent(parent, x);
  y = getParent(parent, y);

  if (x < y) {
    parent[y] = x;
  } else {
    parent[x] = y;
  }
}

int find(int parent[], int x, int y) {
  x = getParent(parent, x);
  y = getParent(parent, y);
  if(x == y) return 1;
  return 0;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m, turn = 0;
	bool isCycle = false;
  cin >> n >> m;

  int parent[n];
  for(int i = 0; i < n; i++) {
    parent[i] = i;
  }

  for(int i = 0; i < m; i++) {
    int b, c;
    cin >> b >> c;
    if(!isCycle && find(parent, b, c)) {
      turn = i + 1;
      isCycle = true;
    }
    _union(parent, b, c);
  }
  cout << turn << '\n';
 
  return 0;
}