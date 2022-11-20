#include <iostream>
using namespace std;

int min(int a, int b);
int cmm(const int d[], int i, int j);

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t, n;

  cin >> t;

  for (int i = 0; i < t; i++)
  {
    cin >> n;
    int d[n + 1];

    for (int j = 0; j < n + 1; j++)
    {
      cin >> d[j];
    }

    cout << cmm(d, 1, n) << '\n';
  }

  return 0;
}

int cmm(const int d[], int i, int j)
{
  if (i == j)
  {
    return 0;
  }
  int minValue = 1000000000;

  for (int k = i; k <= j - 1; k++)
  {
    minValue = min(minValue, cmm(d, i, k) + cmm(d, k + 1, j) + d[i - 1] * d[k] * d[j]);
  }
  return minValue;
}

int min(int a, int b)
{
  return a < b ? a : b;
}