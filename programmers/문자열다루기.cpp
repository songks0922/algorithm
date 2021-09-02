#include <string>
#include <vector>
#include <cctype>
using namespace std;

bool solution(string s) {
    bool answer = true;
    
    for(int i = 0; i < s.length(); i++) {
        if(!isdigit(s[i]))  {
            return false;
        }
    }
    if(s.length() == 4 || s.length() == 6) {
        return answer;
    } else {
        return false;
    }
    
}