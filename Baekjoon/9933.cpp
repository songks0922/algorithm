#include <iostream>
#include <string>
#include <algorithm>
#include <map>

using namespace std;
 
map<string, bool> visited;

int main(void)
{

    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
      string s;
      cin >> s;
      string temp = s;
      reverse(temp.begin(), temp.end());
             
      if (s == temp || visited.count(temp))
      {
        cout << s.length() << " " << s[s.length() / 2] << "\n";
        break;
      }
      else
        visited[s] = true;
    }
    return 0;
}