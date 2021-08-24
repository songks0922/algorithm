#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    vector<int> times;
    vector<int> result;
    int time;
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 6; j++) {
        cin >> time;
        times.push_back(time);
      }
      for(int j = 2; j >= 0; j--) {
        if(times[j] > times[j+3]) {
          times[j+2] -= 1;

          times[j] = 60 + times[j+3] - times[j];
        } else {
          times[j] = times[j+3] - times[j];
        }
        result.push_back(times[j]);
      }
      times.clear();
    }
    for(int i = 0; i < 3; i++) {
      for(int j = 2; j >= 0; j--) {
        cout << result[j + (i * 3)] << " ";
      }
      cout << '\n';
    }
    return 0;
}