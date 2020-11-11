package datastructures.stack;

import java.util.EmptyStackException;

public class FixedMultiStack {
    private final int NUMBEROFSTACKS = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackCapacity) {
        this.stackCapacity = stackCapacity;
        this.values = new int[NUMBEROFSTACKS * stackCapacity];
        this.sizes = new int[NUMBEROFSTACKS];
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            throw new FullStackException();
        }

        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int res = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return res;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        return values[indexOfTop(stackNum)];
    }

    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
