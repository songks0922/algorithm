#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int N, weight, height;
    vector<pair<int, int>> person;

    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> weight >> height;
        person.push_back(make_pair(weight, height));    
    }

    for (int i = 0; i < N; i++) {
        int rank = 1;

        for (int j = 0; j < N; j++) {
            if (i == j) continue;
            if (person[i].first < person[j].first && person[i].second < person[j].second) {
                rank++;
            }
        }
        cout << rank << " ";
    }
    cout << '\n';
    return 0;
}