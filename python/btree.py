from tkinter.tix import Tree
from typing import Optional


class Stack:
    def __init__(self):
        self.items = []

    def is_empty(self):
        return self.items == []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[len(self.items)-1]

    def size(self):
        return len(self.items)

expr = "( 30 ( 5 ( 2 # ) 40 ( # 80 ) ) )".split()

class TreeNode:
    def __init__(self, elem):
        self.elem= elem
        self.left_child: Optional[TreeNode] = None
        self.right_child: Optional[TreeNode] = None

    def __repr__(self):
        return str(self)

    def __str__(self):
        return f"{self.elem}"

class BTree:
    def __init__(self):
        self.root = None

    def build(self, sexpr):
        stack = Stack()
        it = iter(sexpr)

        root = None

        while stack.is_empty() or it:
            try:
                token = next(it)
            except StopIteration:
                break

            if token != ")":
                if token == "#":
                    token = None
                stack.push(TreeNode(token))
                continue

            right, left = None, None

            if stack.peek().elem != "(":
                right = stack.pop()
                left = stack.pop()

            if stack.is_empty():
                continue

            while stack.peek().elem == "(":
                stack.pop()

            prev = stack.pop()

            root = prev
            root.left_child = left
            root.right_child = right

            if stack.is_empty():
                root = prev
                continue

            stack.push(root)

        if not stack.is_empty():
            raise Exception("expression is wrong")

        self.root = root


if __name__ == "__main__":
    sexpr = "( 30 ( 5 ( 2 # ) 40 ( # 80 ) ) )".split()
    tree = BTree()
    tree.build(sexpr)
    root = tree.root

    print(root)
    print(root.left_child)
    print(root.left_child.left_child)
    print(root.left_child.right_child)
    print(root.right_child)
    print(root.right_child.left_child)
    print(root.right_child.right_child)