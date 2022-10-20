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

class Edge {
public:
  int node[2];
  int dist;
  Edge(int x, int y, int dist) {
    this->node[0] = x;
    this->node[1] = y;
    this->dist = dist;
  }

  bool operator <(Edge const& other) {
    return this->dist < other.dist;
  }
};

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m;
	vector<Edge> v;
	while(1) {
    cin >> n >> m;
    if (n == 0 && m == 0) {
      break;
    }
    for(int i = 0; i < m; i++) {
      int a, b, c;
      cin >> a >> b >> c;
      v.push_back(Edge(a, b, c));
    }
    
    sort(v.begin(), v.end());
    
    int parent[n];
    for(int i = 0; i < n; i++) {
      parent[i] = i;
    }
    
    int sum = 0;
    int total = 0;
    for(int i = 0; i < v.size(); i++) {
      // 즉 사이클이 발생하지 않을 때만 선택
      total += v[i].dist;
      if(!find(parent, v[i].node[0], v[i].node[1])) {
        sum += v[i].dist; 
        _union(parent, v[i].node[0], v[i].node[1]);
      }
    }
    
    cout << total - sum << '\n';
    v.clear();

  }
  return 0;
}