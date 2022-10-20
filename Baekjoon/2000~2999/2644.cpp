#include <iostream>
#include <vector>
using namespace std;

int ans = -1;

void dfs(int start, int end, int cnt, bool memo[], vector<int> chons[]){
    memo[start] = true;
    if(end==start){ans = cnt; return;}
    int z = cnt;
    for(int i=0; i<chons[start].size(); i++){
        if(memo[chons[start][i]]==0){
            dfs(chons[start][i],end, cnt+1, memo, chons);
        }
    }
    
    return;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, m, start, end;
  vector<int> chons[101];
  bool memo [101];
	fill(memo, memo+101, false);

  cin >> n >> start >> end >> m;

  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    chons[a].push_back(b);
    chons[b].push_back(a);
  }

  dfs(start, end, 0, memo, chons);
  cout << ans;
  return 0;
}