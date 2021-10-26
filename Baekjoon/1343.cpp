#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

void findAndReplaceAll(std::string & data, std::string toSearch, std::string replaceStr)
{
    size_t pos = data.find(toSearch);
    while( pos != std::string::npos)
    {
        data.replace(pos, toSearch.size(), replaceStr);
        pos = data.find(toSearch, pos + replaceStr.size());
    }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  
  string board;
  cin >> board;

  const string TYPE_A = "AAAA";
  const string TYPE_B = "BB";

  findAndReplaceAll(board, "XXXX", TYPE_A);
  findAndReplaceAll(board, "XX", TYPE_B);
  
  if (board.find("X") != string::npos) {
    cout << "-1" << '\n';
  } else {
    cout << board << '\n';
  }
  return 0;
}