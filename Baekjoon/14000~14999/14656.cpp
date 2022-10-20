#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int N, num, cnt = 0;
  vector<int> student;

  cin >> N;
  for (int i = 0; i < N; i++) {
    cin >> num;
    student.push_back(num);
  }

  for (int i = 1; i < student.size() + 1; i++) {
    if (i != student[i-1]) cnt++;
  }

  cout << cnt << '\n';
  return 0;
}