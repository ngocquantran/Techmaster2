public class Bai0622 {

    private int[] arr;
    private int headIndex = -1;
    private int tailIndex = -1;


    public Bai0622(int k) {
        this.arr = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (headIndex == -1) {
            headIndex++;
        }
        tailIndex++;
        if (tailIndex > arr.length - 1) {
            tailIndex = tailIndex - arr.length;
        }
        arr[tailIndex] = value;
        return true;
    }

    public boolean deQueue() {
        if (headIndex == -1 && tailIndex == -1) {
            return false;
        }
        if (headIndex == tailIndex) {
            headIndex = -1;
            tailIndex = -1;
        } else {
            headIndex++;
            if (headIndex > arr.length - 1) {
                headIndex = headIndex - arr.length;
            }
        }
        return true;
    }

    public int Front() {
        if (headIndex == -1 && tailIndex == -1) {
            return -1;
        }
        return arr[headIndex];
    }

    public int Rear() {
        if (headIndex == -1 && tailIndex == -1) {
            return -1;
        }
        return arr[tailIndex];
    }

    public boolean isEmpty() {
        return (headIndex == -1 && tailIndex == -1);
    }

    public boolean isFull() {
        if (headIndex - tailIndex == 1) {
            return true;
        }
        if (headIndex == 0 && tailIndex == arr.length - 1) {
            return true;
        }
        return false;
    }
}
