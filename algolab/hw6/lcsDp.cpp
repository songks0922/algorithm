#include <iostream>

#define MAX_LENGTH 101

using namespace std;

int lcs(char a[], char b[], int m, int n);
int max(int a, int b);
int strLen(char a[]);
void printLCS(char a[], char b[], int m, int n);
int L[MAX_LENGTH][MAX_LENGTH];
int S[MAX_LENGTH][MAX_LENGTH];

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int t;

  char a[MAX_LENGTH], b[MAX_LENGTH];

  cin >> t;

  for (int i = 0; i < t; i++)
  {
    cin >> a >> b;
    int m = strLen(a);
    int n = strLen(b);
    cout << lcs(a, b, m, n) << " ";
    printLCS(a, b, m, n);
    cout << '\n';
  }

  return 0;
}

int lcs(char a[], char b[], int m, int n)
{

  for (int i = 0; i <= m; i++)
  {
    L[i][0] = 0;
  }

  for (int i = 0; i <= n; i++)
  {
    L[0][i] = 0;
  }

  for (int i = 1; i <= m; i++)
  {
    for (int j = 1; j <= n; j++)
    {
      if (a[i - 1] == b[j - 1])
      {
        L[i][j] = L[i - 1][j - 1] + 1;
        S[i][j] = 0;
      }
      else
      {
        L[i][j] = max(L[i][j - 1], L[i - 1][j]);

        if (L[i][j] == L[i][j - 1])
        {
          S[i][j] = 1;
        }
        else
        {
          S[i][j] = 2;
        }
      }
    }
  }

  return L[m][n];
}

void printLCS(char a[], char b[], int m, int n)
{
  if (m == 0 || n == 0)
  {
    return;
  }

  if (S[m][n] == 0)
  {
    printLCS(a, b, m - 1, n - 1);
    cout << a[m - 1];
  }

  if (S[m][n] == 1)
  {
    printLCS(a, b, m, n - 1);
  }

  if (S[m][n] == 2)
  {
    printLCS(a, b, m - 1, n);
  }
}

int max(int a, int b)
{
  return a > b ? a : b;
}

int strLen(char a[])
{
  int len = 0;
  for (int i = 0; a[i] != '\0'; i++)
  {
    len++;
  }
  return len;
}