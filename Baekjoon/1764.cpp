#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int N, M, cnt = 0;

  string s;
  vector<string> result;
  map<string, bool> list;

  cin >> N >> M;

  for (int i = 0; i < N; i++) {
    cin >> s;
    list.insert(make_pair(s, true));
  }


  for (int i = 0; i < M; i++) {
    cin >> s;
    if (list[s]) {
      result.push_back(s);
      cnt++;
    }
  }

  sort(result.begin(), result.end());
  cout << cnt << '\n';
  for (int i = 0; i < result.size(); i++) {
    cout << result[i] << '\n';
  }

  
  return 0;
}