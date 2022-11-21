#include <iostream>
using namespace std;

int min(int a, int b);
int cmm(const int d[], int i, int j);
int memo[101][101];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int t, n;

    cin >> t;

    for (int i = 0; i < t; i++) {
        cin >> n;
        int d[n + 1];

        for (int j = 0; j < n + 1; j++) {
            cin >> d[j];
        }

        for (int j = 0; j < n + 1; j++) {
            for (int k = 0; k < n + 1; k++) {
                memo[j][k] = -1;
            }
        }

        cout << cmm(d, 1, n) << '\n';
    }

    return 0;
}

int cmm(const int d[], int i, int j) {
    if (i == j) {
        return 0;
    }

    if (memo[i][j] != -1) {
        return memo[i][j];
    }

    memo[i][j] = 1000000000;

    for (int k = i; k <= j - 1; k++) {
        memo[i][j] = min(memo[i][j], cmm(d, i, k) + cmm(d, k + 1, j) +
                                         d[i - 1] * d[k] * d[j]);
    }
    return memo[i][j];
}

int min(int a, int b) { return a < b ? a : b; }