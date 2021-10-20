#include <iostream>
using namespace std;

int n;
bool areFriends[10][10]; 
bool taken[10]{ false };

int countPairings(bool taken[10]) {
	int ret = 0;
	int firstFree = -1;
	for (int i = 0; i < n; i++) {
		if (!taken[i]) {
			firstFree = i;
			break;
		}
	}
	if (firstFree == -1) return 1;
	for (int pairwith = firstFree + 1; pairwith < n; ++pairwith) {
		if (!taken[pairwith] && areFriends[firstFree][pairwith]) {
			taken[firstFree] = taken[pairwith] = true;
			ret += countPairings(taken);
			taken[firstFree] = taken[pairwith] = false;
		}
	}
	return ret;
}

void check(int m) {
	int a, b;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		areFriends[a][b] = areFriends[b][a] = true;
	}
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	int testcase, m, ans;
	cin >> testcase;
	for (int i = 0; i < testcase; i++) {
		cin >> n >> m;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				areFriends[i][j] = false;
			}
		}
		check(m);
		ans = countPairings(taken);
		cout << ans << endl;
	}
}