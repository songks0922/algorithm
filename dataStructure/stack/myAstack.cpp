#include <iostream>
using namespace std;

template <class T>
class myStack {
private:
    T *arr;
    int top;
    int maxSize;
public:
    myStack(int capacity) {
        maxSize = capacity;
        top = -1;
        arr = new T[maxSize];
    }

    void clear() {
        top = -1;
    }

    void push(T item) {
        if (this->length() == maxSize) {
            T *temp = new T[maxSize * 2];
            maxSize = maxSize * 2;
            for (int i = 0; i < this->length(); i++)
            {
                temp[i] = arr[i];
            }
            delete[] arr;
            arr = temp;
        }
        arr[++top] = item;
    }

    T pop() {
        if (top != -1) {
            T temp = arr[top];
            top--;
            return temp;
        } else {
            cout << "stack에 아무것도 없습니다." << endl;
        }
        
    }

    int length() {
        return top + 1;
    }

    ~myStack() {
        delete[] arr;
    }
    template<class U>
    friend ostream& operator<<(ostream&, const myStack<U>&);
};

//test print
template <class U>
ostream& operator<<(ostream& os, const myStack<U>& a) {
    os << "[ ";
    for (int i = 0; i < a.top+1; i++) {
        if (i == a.top) os << a.arr[i];
        else os << a.arr[i] << ", ";
    }
    os << " ]" << endl;
    return os;
}

int main(void) {
    myStack<int> ms(10);
    for (int i = 1; i <= 20; i++)
    {
        ms.push(i);
    }
    
    ms.pop();
    cout << ms;
    ms.push(150);
    ms.push(151);
    cout << ms;
    ms.clear();
    cout<< ms;
    return 0;
}