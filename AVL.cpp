#include <iostream>
#include <stack>
#include <algorithm>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

struct Node{
	int key;
	int bf = 0;
	int height = 1;
  int noNode = 1;
	Node* left = NULL;
	Node* right = NULL;
};

Node* getAVLNode(){ // 노드 사이즈만큼 할당
Node* temp = (Node*)malloc(sizeof(Node));
  return temp;
};

void deleteAVLNode(Node* T){ // 할당한 사이즈 다시 돌려줌
  free(T);
};

int height(Node* T){
  if (T == nullptr) return 0;
  return T->height;
};

int noNodes(Node* T){
  if (T == nullptr) return 0;
  return T->noNode;
};

int balancingFactor(Node* T) {
  if (T == nullptr) {
    return 0;
  }
  else {
    return height(T->left) - height(T->right);
  }
}

void checkBalance(Node** T, int newKey, Node* p, Node* q,string* rotationType) {
  Node *x = *T;
  Node *y = nullptr;

  while(y->key != newKey) {
    x->bf = balancingFactor(x);

    if(x->bf < -1 || x->bf > 1) { // bf차이가 2 이상 날 때
      p = x;  
      q = y;
    }

    y = x;

    if(newKey < x->key) { // newKey의 위치를 찾는 과정
      x = x->left; // newKey가 작을 경우 
    }
    else {
      x = x->right; // newKey가 클 경우
    }
  }
	if (p->bf == 0){ // p의 bf 가 0 인 경우 ( 양쪽이 균형이 맞는 경우 )
		*rotationType = "NO";
	}
	else if (p->bf > 1) { // p의 bf 가 1보다 큰 경우 (왼쪽의 높이가 큰 경우)
		if ((p->left)->bf >= 0){
			*rotationType = "LL"; // p의 왼쪽 자식노드의 bf가 0보다 크거나 같은 경우
		}
		else {
			*rotationType = "LR";// p의 왼쪽 자식노드의 bf가 0보다 큰 경우
		}
	}
	else { // p의 bf가 -1 보다 작은 경우 (오른쪽의 높이가 큰 경우)
		if ((p->right)->bf >= 0){ // p의 오른쪽 자식노드의 bf가 0보다 크거나 같은 경우
		*rotationType = "LL"; // p의 왼쪽 자식노드의 bf가 0보다 크거나 같은 경우
		}
		else{
		*rotationType = "LR";// p의 왼쪽 자식노드의 bf가 0보다 큰 경우
		}
	}
}

Node* maxNode(Node* T){
  if (T == NULL){
    return NULL;
  }
  if (T->right == NULL){
    return T;
  }
  else{
    return maxNode(T->right);
  }
};

Node* minNode(Node* T){
  if (T == NULL){
    return NULL;
  }
  if (T->left == NULL){
    return T;
  }
  else{
    return minNode(T->left);
  }
};

Node* searchBST(Node* T, int searchKey) {
  Node* p = T;
  if (p == NULL) {
    return NULL;
    }

  if (searchKey == p->key) {
    return p;
    }

  if (searchKey > p->key) {
    return searchBST(p->right, searchKey);
    }

  else {
    return searchBST(p->left, searchKey);
    }
};

void rotateLL(Node** T, Node* p, Node* q){ // LL 회전
	Node *leftSubTree = p->left;
	p->left = leftSubTree->right;
	leftSubTree->right = p;
}

void rotateRR(Node** T, Node* p, Node* q){ // RR 회전
	Node *RightSubTree = p->right;
	p->right = RightSubTree->right;
	RightSubTree->left = p;
}

void rotateLR(Node** T, Node* p, Node* q){ // LR 회전
	rotateRR(T, p->left, p);
	rotateLL(T, p, q);
} 

void rotateRL(Node** T, Node* p, Node* q){ // RL 회전
	rotateLL(T, p->right, p);
	rotateRR(T, p, q);
}

void rotateTree(Node**T, string* rotationType, Node* p, Node* q){ // rotationType을 받아서 직접 회전시키는 함수
	if (*rotationType == "LL"){ // rotationType 이 LL일 경우
		rotateLL(T,p,q);
    cout << "LL";
	}
	else if (*rotationType == "RR"){// rotationType 이 RR일 경우
		rotateRR(T,p,q);
    cout << "RR";
	}
	else if (*rotationType == "LR"){// rotationType 이 LR일 경우
		rotateLR(T,p,q);
    cout << "LR";
	}
	else if (*rotationType == "RL"){// rotationType 이 RL일 경우
		rotateRL(T,p,q);
    cout << "RL";
	}
	// NO 의 경우 회전 X 
}

void insertBST(Node** T, int newKey) {
  Node* q = NULL;
  Node* p = *T;
  stack<Node*> s;
  // find position to insert newKey while storing parent node on stack
  while(p != NULL) {
    if (newKey == p->key){ 
      cout << "i "<< newKey << ": The key already exists\n";
      return;
    }
    q = p;
    s.push(q);
    
    if (newKey < p->key){
      p = p->left;
    }

    else{
      p = p->right;
    }
  }
  // create new node
  Node* newNode = getAVLNode();
  newNode->key = newKey;
  // insert newNode as a child of q
  if (*T == NULL){
    *T = newNode;
  }
  else if (newKey < q->key){
    q->left = newNode; 
  }
  else{
    q->right = newNode;
  }
  // update height, noNode while popping parent node from stack
  while(s.empty() != true) {
    Node* tmp = s.top();

    s.top()->height = 1 + max(height(s.top()->left), height(s.top()->right)); // 높이 갱신
    s.top()->noNode = 1 + noNodes(s.top()->left) + noNodes(s.top()->right); // no node 갱신
    s.pop();
  }
  return;
};

void insertAVL(Node** T, int newKey) { // insert AVL
  Node* q = NULL;
  Node* p = *T;
  stack<Node*> s;
  string rotationType;
	
	insertBST(T, newKey); // BST 삽입 실행
	checkBalance(T, newKey, p,q,&rotationType); // BF를 체크해서 rotationType을 바꿔줌
	rotateTree(T,&rotationType,p,q); // rotationType을 받아서 회전시킴

}

void deleteBST(Node** T, int deleteKey){
  Node* p = *T;
  Node* q = NULL;
  Node* tempNode;
  stack<Node*> s;
  // find position of deleteKey while storing parent node on stack
  while ((p != NULL) && (deleteKey != p->key)){ 
    q = p;
    s.push(q);
    if (deleteKey < p->key){
      p = p->left;
    }
    else{
      p = p->right;
    }
  }

  // deleteKey was not found
  if (p == NULL){
    cout <<"d "<<  deleteKey << ": The key does not exist\n";
    return;
  }
  
  if ((p->left != NULL) && (p->right != NULL)){// case of degree 2 is reduced to case of degree 0 or case of degree 1
    s.push(p);
    tempNode = p;
    if (height(p->left) == height(p->right)){ // 높이 같을때
      if (noNodes(p->left) >= noNodes(p->right)){ // 왼쪽 개수가 더 많거나 같을때
        p = p->left;
        while(p->right != NULL){
          s.push(p);
          p = p->right;
        }
      }
      else{ // 오른쪽 개수가 더 많을때
        p = p->right;
        while(p->left != NULL){
          s.push(p);
          p = p->left;
        }
      }
    }
    else if (height(p->left) < height(p->right)){ //오른쪽 높이가 더 높을 때
      p = p->right;
      while(p->left != NULL){
        s.push(p);
        p = p->left;
      }
    }
    else{ // 왼쪽 높이가 더 높을 때
      p = p->left;
      while(p->right != NULL){
        s.push(p);
        p = p->right;
      }
    }
  tempNode->key = p->key;
  q = s.top();
  }

  // now degree of p is 0 or 1
  // delete p from T
  if ((p->left == NULL) && (p->right == NULL)){// case of degree 0  
    if (q == NULL){ // case of root
      *T = NULL;
    }
    else if (q->left == p){
      q->left = NULL;
    }
    else{
      q->right = NULL;
    }
  }
  else { // case of degree 1
    if (p->left != NULL){
      if (q == NULL){
        *T = (*T)->left; // case of root 
      }
      else if (q->left == p){
        q->left = p->left;
      }
      else {
        q->right = p->left;
      }
    }
    else {
      if (q == NULL){
        *T = (*T)->right; // case of root
      }
      else if (q->left == p){
        q->left = p->right;
      }
      else {
        q->right = p->right;
      }
    }
  }
  deleteAVLNode(p);
// update height, noNode while popping parent node from stack
  while(s.empty() != true) {
    s.top()->height = 1 + max(height(s.top()->left), height(s.top()->right)); // 높이 갱신
    s.top()->noNode = 1 + noNodes(s.top()->left) + noNodes(s.top()->right); // no node 갱신
    s.pop();
  }
};

// void deleteAVL()
vector<string> split(string str, char Delimiter) {
    istringstream iss(str);
    string buffer;

    vector<string> result;

    while (getline(iss, buffer, Delimiter)) {
        result.push_back(buffer);
    }
    return result;
}
void Inorder(Node* node)
{
  if(node != nullptr)
  {
    Inorder(node->left);             // 왼쪽 서브 트리 중위 순회(왼쪽 노드 방문)
    cout << node->key << " ";  // 루트 노드 출력(방문)
    Inorder(node->right);            // 오른쪽 서브 트리 중위 순회(오른쪽 노드 방문)
  }
}

int main() {
  ifstream read("AVL-input.txt");
  string str;
  Node* root = NULL;

  while (getline(read, str)){
    vector<string> result = split(str, ' ');
    if (result[0] == "i") {
        insertAVL(&root, stoi(result[1]));
        Inorder(root);
        cout  << endl;
      }
    else {
      deleteBST(&root, stoi(result[1]));
      Inorder(root);
      cout << endl;
    }
  }
  read.close();
};
