#include <iostream>

using namespace std;

class SizeIsZero
{
};
template <class T>
class heap
{
private:
    int maxSize = 10;
    T *data;
    int size;

    int parent(int pos)
    {
        return (pos - 1) / 2;
    }

    int leftchild(int pos)
    {
        return pos * 2 + 1;
    }

    int rightchild(int pos)
    {
        return pos * 2 + 2;
    }

    bool isleaf(int pos)
    {
        return leftchild(pos) >= size && size;
    }

public:
    heap(int capacity)
    {
        maxSize = capacity;
        data = new T[capacity];
        size = 0;
    }

    void swap(T &a, T &b)
    {
        T t = a;
        a = b;
        b = t;
    }

    void insert(T item)
    {
        // 배열이 꽉찼으면 더블링
        if (size == maxSize)
        {
            T *temp = new T[maxSize * 2];
            for (int i = 0; i < maxSize; i++)
            {
                temp[i] = data[i];
            }
            delete[] data;
            data = temp;
        }
        int pos = size;
        data[size++] = item;
        //sift up
        while (data[pos] < data[parent(pos)])
        {
            int par = parent(pos);
            swap(data[pos], data[par]);
            pos = par;
            if (pos == 0)
            {
                break;
            }
        }
    }

    T removeMin()
    {
        T minValue = data[0];

        if (size == 1)
        {
            size--;
            return minValue;
        }
        else if (size == 0)
        {
            throw SizeIsZero();
            return -1;
        }
        data[0] = data[size - 1];
        size--;
        siftdown(0);
        return minValue;
    }

    void siftdown(int i)
    {
        T down = data[i];
        int pos = i;
        while (!isleaf(pos))
        {
            int cmp = leftchild(pos);
            int right = cmp + 1;
            while (right < size && data[cmp] > data[right])
            {
                cmp = right;
            }

            if (data[cmp] < data[pos])
            {
                swap(data[cmp], data[pos]);
                pos = cmp;
            }
            else
                break;
        }
    }

    T getMin()
    {
        if (size == 0)
        {
            throw SizeIsZero();
            return -1;
        }
        return data[0];
    }

    int length()
    {
        return size;
    }

    void clear()
    {
        size = 0;
    }

    bool isEmpty()
    {
        if (size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    ~heap()
    {
        delete[] data;
    }

    template <class U>
    friend ostream &operator<<(ostream &, const heap<U> &);
};

//test print
template <class U>
ostream &operator<<(ostream &os, const heap<U> &a)
{
    os << "[ ";
    for (int i = 0; i < a.size; i++)
    {
        os << a.data[i] << " ";
    }
    os << "]" << endl;
    return os;
}

int main(void)
{
    int n, num;
    cin >> n;
    heap<int> h(n);
    for (int i = 0; i < n; i++)
    {
        cin >> num;
        h.insert(num);
    }

    try
    {
        while (!h.isEmpty())
        {
            cout << h.removeMin() << endl;
        }
        cout << h << endl;
    }
    catch (SizeIsZero &e)
    {
        cout << "size is zero!!!" << endl;
    }

    return 0;
}