package com.company;

import java.util.*;

public class Main {
    /**
     * 1. BUBBLE SORT
     */
    static int[] BubbleSort(int[] arr) {
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < arr.length - 1; ++i) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    sorted = false;
                }
            }
        } while (!sorted);

        return arr;
    }

    // swap arr[i+1] and arr[i]
    public static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /**
     * 2.MERGE SORT
     */
    static int[] MergeSort(int[] arr) {
        if (arr.length > 1) {

            int mid = arr.length / 2;

            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            MergeSort(left);
            MergeSort(right);

            arr = merge(left, right);
        }
        return arr;
    }

    // merge two sub arrays
    public static int[] merge(int[] arr1, int[] arr2) {

        int[] merged = new int[arr1.length + arr2.length];
        int k = 0;
        int index1 = 0;
        int index2 = 0;

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                merged[k] = arr1[index1++];
            } else {
                merged[k] = arr2[index2++];
            }
            k++;
        }
        while (index1 < arr1.length) {
            merged[k] = arr1[index1++];
            k++;
        }
        while (index2 < arr2.length) {
            merged[k] = arr2[index2++];
            k++;
        }
        return merged;
    }

    /**
     * 3.QUICK SORT
     */
    static int[] QuickSort(int[] arr, int start, int end) {
        if (start < end) {
            int part = partition(arr, start, end);

            QuickSort(arr, start, part - 1);
            QuickSort(arr, part + 1, end);
        }
        return arr;
    }

    //last element as pivot, and places the pivot element at correct position
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];

        for (int i = start; i < end; ++i) {
            if (arr[i] < pivot) {
                swap(arr, start, i);
                start++;
            }
        }
        swap(arr, start, end);

        return start;
    }

    //print array
    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        System.out.println("Enter the size of Array");
        int size = scr.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter numbers of Array");
        for (int i = 0; i < size; i++) {
            arr[i] = scr.nextInt();
        }

        //BUBBLE SORT
        int[] arr1 = BubbleSort(arr);
        System.out.print("Bubble Sort ");
        printArray(arr1);

        //MERGE SORT
        int[] arr2 = MergeSort(arr);
        System.out.print("Merge Sort ");
        printArray(arr2);

        //QUICK SORT
        int[] arr3 = QuickSort(arr, 0, arr.length - 1);
        System.out.print("Quick Sort ");
        printArray(arr3);
    }
}
