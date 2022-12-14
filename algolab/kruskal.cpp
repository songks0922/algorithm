#include <algorithm>
#include <iostream>
using namespace std;

int parent[100001];
int m, n;

class Edge {
 public:
  int x;
  int y;
  int cost;
  Edge(int x, int y, int cost) {
    this->x = x;
    this->y = y;
    this->cost = cost;
  }

  Edge() {}

  bool operator<(const Edge &edge) const { return cost < edge.cost; }
};

int find(int x) {
  while (x != parent[x]) {
    parent[x] = parent[parent[x]];
    x = parent[x];
  }
  return x;
}

void merge(int x, int y) {
  x = find(x);
  y = find(y);
  if (x != y) {
    parent[y] = x;
  }
}

// kruskal algorithm function
int kruskal(Edge edges[]) {
  int total = 0;
  for (int i = 0; i < m; i++) {
    int x = find(edges[i].x);
    int y = find(edges[i].y);
    if (x != y) {
      merge(x, y);
      total += edges[i].cost;
    }
  }
  return total;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  cin >> n >> m;

  Edge edges[100001];

  for (int i = 0; i < m; i++) {
    int x, y, cost;
    cin >> x >> y >> cost;
    edges[i] = Edge(x, y, cost);
  }

  sort(edges, edges + m);

  for (int i = 1; i <= n; i++) {
    parent[i] = i;
  }

  cout << kruskal(edges);

  return 0;
}