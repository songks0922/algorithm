#include <iostream>
using namespace std;

template <class T>
class circularQueue
{
private:
  int front, rear, size;
  int maxSize;

public:
  T *arr;
  circularQueue(int capacity)
  {
    maxSize = capacity;
    size = front = rear = 0;
    arr = new T[maxSize];
  }

  void enqueue(T item)
  {
    if ((rear + 1) % maxSize == front)
    {
      T *temp = new T[maxSize * 2];
      maxSize = maxSize * 2;
      int tempIndex = 0;
      for (int i = front; i < maxSize; i++)
      {
        temp[tempIndex++] = arr[i];
      }

      for (int i = 0; i < front; i++)
      {
        temp[tempIndex++] = arr[i];
      }

      delete[] arr;
      arr = temp;
    }
    rear = (rear + 1) % maxSize;
    arr[rear] = item;
    size++;
  }

  T dequeue()
  {
    if (size == 0)
    {
      cout << "queue에 아무것도 없습니다. (return : -1)" << endl;
      return -1;
    }
    else
    {
      size--;
      return arr[++front];
    }
  }

  T frontValue()
  {
    if (size == 0)
    {
      cout << "queue에 아무것도 없습니다. (return : -1)" << endl;
      return -1;
    }
    else
    {
      return arr[front + 1];
    }
  }

  void clear()
  {
    size = front = rear = 0;
  }

  int length()
  {
    return size;
  }

  template <class U>
  friend ostream &operator<<(ostream &, const circularQueue<U> &);
};

template <class U>
ostream &operator<<(ostream &os, const circularQueue<U> &a)
{
  os << "[ ";
  for (int i = a.front + 1; i < (a.rear + 1) % a.maxSize; i++)
  {
    if (i == ((a.rear + 1) % a.maxSize) - 1)
      os << a.arr[i];
    else
      os << a.arr[i] << ", ";
  }

  // for (int i = a.front + 1; i < (a.rear + 1) % a.maxSize; i++) {
  //     if (i ==((a.rear + 1) % a.maxSize) - 1) os << a.arr[i];
  //     else os << a.arr[i] << ", ";
  // }

  os << " ]" << endl;
  return os;
}

int main(void)
{
  circularQueue<int> cq(10);
  for (int i = 1; i <= 8; i++)
  {
    cq.enqueue(i);
  }

  cq.dequeue();
  cq.enqueue(9);

  for (int i = 0; i <= cq.length(); i++)
  {
    cout << cq.arr[i] << " ";
  }

  return 0;
}