#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int s, k, h;
    cin >> s >> k >> h;

    if (s+k+h >= 100) {
      cout << "OK";
    } 
    else {
        if(s < k) {
            if(s < h) {
                cout << "Soongsil" << "\n";
            }else {
                if(h < k) {
                    cout << "Hanyang" << "\n";    
                } else {
                     cout << "Korea" << "\n";
                }
            }
        }
        else {
            if(k < h) {
              cout << "Korea" << "\n";
            } else {
                if(s < h) {
                  cout << "Soongsil" << "\n";
                }  else {
                  cout << "Hanyang" << "\n";
                }
            }
        }
    }
    return 0;
}