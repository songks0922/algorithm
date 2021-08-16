#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int>> arr;
vector<bool> check;
int cnt = 0;

void dfs(int x) {
  cnt++;
  check[x] = true;
  for(int i = 0; i < arr[x].size(); i++) {
    if (!check[arr[x][i]])
      dfs(arr[x][i]);
  }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int n, m;

    cin >> n >> m;
    arr.resize(n+1);
    check.resize(n+1);

    for(int i = 0; i < m; i++) {
      int first, second;
      cin >> first >> second;
      arr[first].push_back(second);
      arr[second].push_back(first);
    }
    dfs(1);
    cout << cnt-1;
    
    return 0;
}