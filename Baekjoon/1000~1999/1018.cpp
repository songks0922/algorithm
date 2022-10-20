#include<iostream>
using namespace std;

int board[51][51];

int check(int x,int y)
{
	int cnt1 = 0;
	int cnt2 = 0;

	for (int i = x; i < x + 8; i++) {
		for (int j = y; j < y + 8; j++) {
			if ((i + j) % 2 == board[i][j]) cnt1++;
			if ((i + j + 1) % 2 == board[i][j]) cnt2++;
		}
	}

	return min(cnt1, cnt2);
}

int main()
{
	int N, M;
	int min = 2500;
	char c;

	cin >> N >> M;

	for (int i = 0; i < N; i++) { 
		for (int j = 0; j < M; j++) {		
			cin >> c;
			if (c == 'B') board[i][j] = 0;
			else board[i][j] = 1;
		}
	}

	for (int i = 0; i <= N-8; i++) {
		for (int j = 0; j <= M-8; j++) {
			if (min > check(i, j)) min = check(i, j);
		}
	}

	cout << min;
}