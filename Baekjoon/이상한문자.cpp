#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include<sstream>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    string inStr;
    string ans = "";
    getline(cin, inStr);
    istringstream ss(inStr);
    string stringBuffer;
    int ascChar;
    vector<string> temp;
    temp.clear();
    bool isLastSapce = false;
    while (getline(ss, stringBuffer, ' ')) {
      temp.push_back(stringBuffer);
    }

    if (inStr.substr(inStr.length() - 1, inStr.length()) == " ") {
      isLastSapce = true;
    }

    for (int i = 0; i < temp.size(); i++) {
      if(temp[i] == " ") {
        temp.erase(temp.begin() + i);
        i--;
      }
    }
    
    for(string word : temp) {
      
      for(int i = 0; i < word.length(); i++) {
        ascChar = word[i];
        
        
        if(i % 2 == 0) {
          if (ascChar >= 97 && ascChar <= 122) {
            ans += ascChar - 32;
          } else {
            ans += word[i];
          }
        }else {
          if (ascChar < 97 && ascChar > 64) {
           ans += ascChar + 32;
          } else {
            ans += word[i];
          }
        }
      } 
      ans += " ";
    }
    if(isLastSapce) {
      cout << ans << "\n";
    } else {
      cout << ans.substr(0, ans.length()-1) << "\n";
    }
    return 0;
}