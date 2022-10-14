#include <stdio.h>
using namespace std;

struct node {
  int data;
  struct node* left = nullptr;
  struct node* right = nullptr;
  node(int data) {
    this->data = data;
  }
};

void insert(struct node** root, int data);
void preOrder(struct node* root);
void inOrder(struct node* root);
void postOrder(struct node* root);
int size(struct node* root);
int height(struct node* root);
int sumOfWeight(struct node* root);
int maxPathWeight(struct node* root);
int maxPath(struct node* root, int& maxSum);
void mirror(struct node** root);
void destruct(struct node** root);

int main() {

  int numTestCases;
  scanf("%d", &numTestCases);

  while (numTestCases--) {
    int num, i;
    struct node* root = nullptr;

    scanf("%d", &num);

    for (i = 0; i < num; i++) {
      int data;
      scanf("%d", &data);
      insert(&root, data);
    }
    printf("%d\n", size(root));
    printf("%d\n", height(root)-1);
    printf("%d\n", sumOfWeight(root));
    printf("%d\n", maxPathWeight(root));

    mirror(&root);
    preOrder(root); printf("\n");
    inOrder(root); printf("\n");
    postOrder(root); printf("\n");
    destruct(&root);

    if (root == nullptr) printf("0\n");
    else printf("1\n");
  }
  return 0;
}

void insert(struct node** root, int data) {
  if (*root == nullptr) {
    *root = new node(data);
    return;
  }

  if (data < ((*root) -> data)) {
    insert(&(*root)->left, data);
  } else {
    insert(&(*root)->right, data);
  }
}

void preOrder(struct node* root) {
  if (root == nullptr) {
    return;
  } else {
    printf("%d ", root->data);
    preOrder(root->left);
    preOrder(root->right);
  }
}

void inOrder(struct node* root) {
  if (root == nullptr) {
    return;
  }
  inOrder(root->left);
  printf("%d ", root->data);
  inOrder(root->right);
}

void postOrder(struct node* root) {
  if (root == nullptr) {
    return;
  }
  postOrder(root->left);
  postOrder(root->right);
  printf("%d ", root->data);
}

int size(struct node* root) {
  if (root == nullptr) return 0;
  else return(size(root->left) + 1 + size(root->right));
}

int max(int a, int b) {
  return a > b ? a : b;
}

int height(struct node* root) {
  if (root == nullptr) return 0;
  else return 1 + max(height(root->left), height(root->right));
}

void swapNode(struct node** left, struct node** right) {
  struct node* temp;
  temp = *left;
  *left = *right;
  *right = temp; 
}

void mirror(struct node** root) {
  if (*root == nullptr) return;
  else {
    struct node** temp;

    mirror(&(*root)->left);
    mirror(&(*root)->right);
    swapNode(&(*root)->left, &(*root)->right);
  }
}

int sumOfWeight(struct node* root) {
  if (root == nullptr) return 0;
  else return (root->data + sumOfWeight(root->right) + sumOfWeight(root->left));
}

int maxPathWeight(struct node* root) {
  if (root == nullptr) return 0;
  int maxSum = -2147483647;

  return maxPath(root, maxSum);
}

int maxPath(struct node* root, int& maxSum) {
  if (root == nullptr) return 0;

  int leftSum = maxPath(root->left, maxSum);
  int rightSum = maxPath(root->right, maxSum);

  int result = max(max(leftSum, rightSum) + root->data, root->data);
  int temp = max(result, leftSum + rightSum + root->data);

  maxSum = max(maxSum, temp);

  return result;
}

void destruct(struct node** root) {
  if (*root != nullptr) {
    destruct(&(*root)->right);
    destruct(&(*root)->left);
    delete *root;
    *root = nullptr;
  }
}