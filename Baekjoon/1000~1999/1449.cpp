#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int list[1001];
  int N, L, water, answer = 1;

  cin >> N >> L;

  for (int i = 0; i < N; i++) {
    cin >> list[i];
  }

  sort(list, list+N);
  water = list[0];

  for (int i = 1; i < N; i++) {
    if (list[i] - water + 1 > L) {
      answer++;
      water = list[i];
    }
  }

  cout << answer;
  return 0;
}