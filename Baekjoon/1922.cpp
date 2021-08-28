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
	cin >> n >> m;
	
	vector<Edge> v;

  for(int i = 0; i < m; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    v.push_back(Edge(a, b, c));
  }
	
	sort(v.begin(), v.end());
	
	int set[n];
	for(int i = 0; i < n; i++) {
		set[i] = i;
	}
	
	int sum = 0;
	for(int i = 0; i < v.size(); i++) {
		// 즉 사이클이 발생하지 않을 때만 선택 
		if(!find(set, v[i].node[0] - 1, v[i].node[1] - 1)) {
			sum += v[i].dist; 
			_union(set, v[i].node[0] - 1, v[i].node[1] - 1);
		}
	}
	
	cout << sum << '\n';
    
    return 0;
}