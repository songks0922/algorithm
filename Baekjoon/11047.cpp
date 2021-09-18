#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  int n, k, coin, cnt = 0;
  vector<int> coins;
  cin >> n >> k;

  for (int i = 0; i < n; i++) {
    cin >> coin;
    coins.push_back(coin);
  }

  while (k) {
    if (k >= coins.back()) {
      k -= coins.back();
      cnt++;
    } else {
      coins.pop_back();
    }
  }

  cout << cnt << '\n';
  return 0;
}

// #include <iostream>
// #include <vector>
// using namespace std;

// int main() {
//     int n, k, x, num = 0;
//     vector<int> v;
//     cin >> n >> k;
//     for (int i = 0; i < n; i++) {
//         cin >> x;
//         v.push_back(x);
//     }
//     for (int i = v.size() - 1; i >= 0; i--) {
//         if (k == 0)break;
//         if (v[i] <= k) {
//             num += k / v[i];
//             k %= v[i];
//         }
//     }
//     cout << num << '\n';
// }