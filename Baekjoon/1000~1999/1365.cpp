#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int findBound(vector<int> v, int num) {
  int low = 0, high = v.size() - 1;
  while (low < high) {
    int mid = (low + high) / 2;
    if (v[mid] >= num) {
      high = mid;
    } else {
      low = mid + 1;
    }
  }
  return high;
}

int Lower_Bound(vector<int> v, int num) {
  int low = 0, high = v.size() - 1;
  while (low < high) {
      int mid = (low + high) / 2;
      if (v[mid] >= num)
          high = mid;
      else
          low = mid + 1;
  }
  return high;
}
 
int main(void)
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, num;
  cin >> n;
  vector<int> v;
  v.push_back(-1);
  for (int i = 0; i < n; i++) {
    cin >> num;
    if (num > v[v.size()-1]) {
      v.push_back(num);
    }
    else {
      v[Lower_Bound(v, num)] = num;
    }
  }
  cout << n - v.size() + 1 << '\n';
  return 0;
}
