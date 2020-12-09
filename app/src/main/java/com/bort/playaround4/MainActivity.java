package com.bort.playaround4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private int arr[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arr  = new int[9];
        arr[0]=8;
        arr[1]=5;
        arr[2]=6;
        arr[3]=2;
        arr[4]=3;
        arr[5]=9;
        arr[6]=1;
        arr[7]=10;
        arr[8]=4;
        mergeSort(arr,0,arr.length);
        printValues(arr);

        arr[0]=8;
        arr[1]=5;
        arr[2]=6;
        arr[3]=2;
        arr[4]=3;
        arr[5]=9;
        arr[6]=1;
        arr[7]=10;
        arr[8]=4;
        quickSort(arr,0, arr.length);
        Log.d("berttest","quicksort");
        printValues(arr);
    }

    public void quickSort(int[] a, int l, int r){
        int mid = partition(a, l, r);
        quickSort(a, l, mid-1);
        quickSort(a, mid+1, r);
    }

    public int partition(int[] a, int l, int r){
        int largerindex=0;
        int index = l;
        int pivot = a[r];

        while(index<r){
            if(a[index] < pivot){
                //swap
                int temp = a[index];
                a[index] = a[largerindex];
                a[largerindex] = temp;
                largerindex++;
            }
            index++;
        }

        //swap pivot to position at i+1 to put pivot in place
        int temp = a[r];
        a[r] = a[largerindex];
        a[largerindex] = temp;

        return largerindex;
    }

    public void mergeSort(int[] a, int l, int r){
        int m = (l+r)/2;

        mergeSort(a, l, m);
        mergeSort(a, m, r);
        merge(a, l, m, r);
    }

    public void merge(int[] a, int l, int m, int r){
        //create 2 arrays and merge

        int[] left = new int[m-l+1];
        int[] right = new int[r-m];

        for(int i=0; i<left.length; i++){
            left[i] = a[l+i];
        }
        for(int i=0; i<right.length; i++){
            right[i] = a[m+1+i];
        }

        int lc=0,rc=0;
        int index = l;
        while(lc<left.length && rc<right.length){
            if(left[lc]<right[rc]){
                a[index] = left[lc];
                index++;
                lc++;
            }
            else{
                a[index] = right[rc];
                index++;
                rc++;
            }
        }
        while(lc<left.length){
            a[index] = left[lc];
            index++;
            lc++;
        }
        while(rc<right.length){
            a[index] = right[lc];
            index++;
            rc++;
        }

    }

    public void printValues(int a[]){
        for(int i=0; i<a.length; i++){
            Log.d("berttest", "print values: " + a[i]);
        }
    }
}