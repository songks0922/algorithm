import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class MyHeap {
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> pq = new Heap<Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            String operation = st.nextToken().strip();

            Integer k;
            switch(operation) {
                case "insert":
                    k = Integer.parseInt(st.nextToken());
                    pq.insert(k);
                    break;
                case "removemax":
                    k = pq.removeMax();
                    if(k != null)
                        System.out.println("Removed value: " + k);
                    break;
                case "getmax":
                    k = pq.getMax();
                    if(k != null)
                        System.out.println("Found value: " + k);
                    break;
                case "size":
                    System.out.println("PQ size: " + pq.size());
                    break;
                case "clear":
                    System.out.println(pq);
                    pq.clear();
                    System.out.println("PQ is initialized.");
                    break;
            }

        }


        br.close();
    }
}

interface PriorityQueue<E>{
    public void insert(E e);
    public E removeMax();
    public E getMax();
    public int size();
    public void clear();
}

class Heap<E extends Comparable<E>> implements PriorityQueue<E>{

    final int DEFAULT_CAPACITY = 10;
    E[] data;
    int size;

    private int parent(int pos) {
        return (pos-1)/2;
    }

    private int leftchild(int pos) {
        return pos * 2 + 1;
    }

    private int rightchild(int pos) {
        return pos * 2 + 2;
    }

    private boolean isleaf(int pos) {
        return pos * 2 + 1 >= size && pos < size;
    }

    public Heap(E[] data) {
        size = data.length;
        for(int i=size/2-1; i>=0; i--) {
            siftdown(i);
        }
    }

    public Heap() {
        data = (E[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }

    /* code here! */
    public void siftdown(int i) {
        E down = data[i];
        int pos = i;

        while(true)
        {
            if (isleaf(pos))
                return;
            if (data[rightchild(pos)] != null)
            {
                if (data[pos].compareTo(data[leftchild(pos)]) > 0 && data[pos].compareTo(data[rightchild(pos)]) > 0)
                {
                    break;
                }
                if (data[leftchild(pos)].compareTo(data[rightchild(pos)]) < 0)
                {
                    data[pos] = data[rightchild(pos)];
                    data[rightchild(pos)] = down;
                    pos = rightchild(pos);
                }
                else if (data[pos].compareTo(data[leftchild(pos)]) < 0)
                {
                    data[pos] = data[leftchild(pos)];
                    data[leftchild(pos)] = down;
                    pos = leftchild(pos);
                }

            }
            else if (data[pos].compareTo(data[leftchild(pos)]) < 0)
            {
                data[pos] = data[leftchild(pos)];
                data[leftchild(pos)] = down;
                break;
            }
            else
            {
                break;
            }
        }

    }
    public void insert(E e) {
        if (data.length == size) {
            this.data = Arrays.copyOf(data, data.length * 2);
        }
        int pos = size;
        data[size++] = e;
        while (data[parent(pos)].compareTo(data[pos]) < 0)
        {
            E temp = data[parent(pos)];
            data[parent(pos)] = data[pos];
            data[pos] = temp;

            pos = parent(pos);
            if (pos == 0)
                break;
        }
    }

    public E removeMax() {
        E maxValue = data[0];
        if (size == 1)
        {
            data[0] = null;
            size--;
            return maxValue;
        }
        else if (size == 0)
        {
            return null;
        }
        data[0] = data[size-1];
        data[size-1] = null;
        size--;

        siftdown(0);

        return maxValue;
    }

    public E getMax() {
        if (size == 0)
            return null;
        return data[0];
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }

    public static void main(String[] args) {

    }
}
