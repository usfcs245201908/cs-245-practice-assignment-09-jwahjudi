public class BinaryHeap {


    int a[];
    int size;

    public BinaryHeap()
    {
        a = new int[10];
        size = 0;
    }

    public void add(int v)
    {
        if (size == a.length)
            growArray();
        a[size++] = v;
        int child = size-1;
        int parent = (child-1)/2;
        while(parent >= 0 && a[parent] > a[child])
        {
            int temp = a[parent];
            a[parent] = a[child];
            a[child] = temp;
            child = parent;
            parent = (child-1)/2;
        }
    }

    public int remove()
    {
        int removed = a[0];
        a[0] = a[--size];
        siftDown(0);
        return removed;
    }

    public void siftDown(int pos)
    {
        int child = 2 * pos + 1;
        if (child + 1 < size && a[child] > a[child + 1])
            ++child;
        if (child <= size)
            if (a[pos] > a[child])
            {
                int temp = a[pos];
                a[pos] = a[child];
                a[child] = temp;
                siftDown(child);
            }
    }

    public void growArray()
    {
        int [] temp = new int[a.length*2];
        for (int index=0; index < a.length; index++)
            temp[index] = a[index];
        a = temp;
    }

    public static void main(String[] args)
    {
        BinaryHeap heap = new BinaryHeap();
        heap.add(15);
        heap.add(10);
        heap.add(20);
        heap.add(8);
        heap.add(283);
        heap.add(1);
        heap.add(1231);
        heap.add(282);
        heap.add(746);
        heap.add(1123);
        heap.add(84);
        heap.add(2);
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
    }
}
