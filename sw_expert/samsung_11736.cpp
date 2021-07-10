#include <iostream>
#include <vector>
using namespace std;

int main()
{
  int test_case;
  int T;

  cin >> T;

  for (test_case = 1; test_case <= T; ++test_case)
  {
    int n, pi, cnt = 0;

    cin >> n;
    vector<int> v;
    for (int i = 0; i < n; i++)
    {
      cin >> pi;
      v.push_back(pi);
    }

    for (int i = 1; i < v.size() - 1; i++)
    {
      if ((v[i - 1] < v[i] && v[i + 1] < v[i]))
        cnt++;
      else if ((v[i - 1] > v[i] && v[i + 1] > v[i]))
        cnt++;
    }
    cout << "#" << test_case << " " << n - cnt - 2 << endl;
    cnt = 0;
    v.clear();
  }
  return 0;
}
