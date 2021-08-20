#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int num1, num2;
    long long answer = 0;
    cin >> num1 >> num2;
    if(num1 > num2) {
        int temp = num2;
        num2 = num1;
        num1 = temp;
    }
    for(long long i = num1; i <= num2; i++) {
      answer += i;
    }
    cout << answer << '\n';
    return 0;
}