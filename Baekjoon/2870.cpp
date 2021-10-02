#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;
 
void Erase(string& s) {
	while (1) {
		if (s.size() == 1 && s == "0") { 
			break;
		}
		if (s[0] == '0') { 
			s.erase(0, 1); 
		}
		else {
			break;
		}
	}
}
 
bool compare(string a, string b) { 
	if (a.size() == b.size()) { 
		int sz = a.size();
		for (unsigned int i = 0; i < sz; i++) { 
			if (a[i] == b[i]) { 
				continue; 
			}
			else { 
				return a[i] < b[i]; 
			}
		}
	}
	return a.size() < b.size(); 
}
 
 
int main() {
	int n; 
	cin >> n; 
	vector<string> v; 
	while (n--) {
		string s;
		string check;
		cin >> s;
		for (unsigned int i = 0; i < s.size(); i++) {
			if ('0' <= s[i] && s[i] <= '9') { 
				check = check + s[i];
			}
			else {
				if (check.size() == 0) { 
					continue; 
				}
				else { 
					if (check != "0") { 
						Erase(check); 
					}
					v.push_back(check); 
					check.clear(); 
				}
			}
			if (i == s.size() - 1) { 
				if (check.size() != 0) {
					if (check != "0") { 
						Erase(check); 
					}
					v.push_back(check);
					check.clear(); 
				}
			}
		}
	}
    
    
	vector<string>::iterator iter; 
	sort(v.begin(), v.end(),compare); 
	for (iter = v.begin(); iter != v.end(); iter++) {
		cout << *iter << '\n';
	}
    
}