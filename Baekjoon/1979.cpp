#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> parent;
vector<int> path; //여행 경로

int N,M;
int map[201][201]={0};

int find(int node) {
  if (parent[node] == node) {
    return node;
  } else {
    return parent[node] = find(parent[node]);
  }
}

void union_(int x,int y){
    
    x=find(x);
    y=find(y);
    
    if(x < y) {
      parent[y]=x;
    } else {
      parent[x]=y;
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    cin>>N>>M;
    
    parent.resize(N+1);
    path.resize(M+1);
    parent[0] = 0;
    path[0] = 0;

    for(int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= N; j++) {
        cin >> map[i][j];

        if(map[i][j]) {
          union_(i, j);
        }
      }
    }

    for(int i = 1; i <= M; i++) {
      cin >> path[i];
    }

    bool check=true;
    for(int i=1;i<M;i++){
        if(find(path[i])!=find(path[i+1])){
            check=false;
            break;
        }
    }
    
    if(check) {
      cout<<"YES"<<endl;
    }
    else {
      cout<<"NO"<<endl;
    }

    return 0;
}