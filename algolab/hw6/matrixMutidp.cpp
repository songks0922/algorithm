#include <iostream>
using namespace std;

int cmm(const int d[], int n);
void order(int i, int j);
int dp[101][101];
int p[101][101];

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

    for (int i = 1; i < n; i++)
    {
      dp[i][i] = 0;
      p[i][i] = 0;
    }

    int answer = cmm(d, n + 1);

    cout << '\n'
         << answer << '\n';
  }

  return 0;
}

int cmm(const int d[], int n)
{
  for (int diagonal = 1; diagonal <= n - 1; diagonal++)
  {
    for (int i = 1; i <= n - diagonal; i++)
    {
      int j = i + diagonal;
      dp[i][j] = 1000000000;
      for (int k = i; k <= j - 1; k++)
      {
        int temp = dp[i][k] + dp[k + 1][j] + d[i - 1] * d[k] * d[j];
        if (temp < dp[i][j])
        {
          dp[i][j] = temp;
          p[i][j] = k;
        }
      }
    }
  }
  order(1, n - 1);
  return dp[1][n - 1];
}

void order(int i, int j)
{
  int k = p[i][j];
  if (i == j)
  {
    cout << "M" << i;
  }
  else
  {
    cout << "(";
    order(i, k);
    order(k + 1, j);
    cout << ")";
  }
}