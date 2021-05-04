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
        //mergeSort(arr,0,arr.length);
        //printValues(arr);

        arr[0]=8;
        arr[1]=5;
        arr[2]=6;
        arr[3]=2;
        arr[4]=3;
        arr[5]=9;
        arr[6]=1;
        arr[7]=10;
        arr[8]=4;
        //quickSort(arr,0, arr.length);
        Log.d("berttest","quicksort");
        //printValues(arr);

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
        //mergeSort1(arr,0,arr.length);
        Log.d("berttest","mergeSort1");
        //printValues(arr);

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
        //quickSort1(arr,0,arr.length);
        Log.d("berttest","quickSort1");
        //printValues(arr);

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
        mergeSort2(arr,0,arr.length);
        Log.d("berttest","mergeSort2");
        printValues(arr);


        arr  = new int[9];
        arr[0]=1;
        arr[1]=3;
        arr[2]=2;
        arr[3]=4;
        arr[4]=5;
        merge2(arr,0,2,4);
        Log.d("berttest","merge2");
        printValues(arr);


    }

    public void mergeSort2(int[] a, int l, int r){
        if(l<r){
            int m = l + (l+r)/2;
            if(l<m){
                mergeSort2(a,l,m);
            }
            if(m+1<r){
                mergeSort2(a,m+1,r);
            }
            merge2(a,l,m,r);
        }

    }

    public void merge2(int[] a, int l, int m, int r){
        int[] left = new int[m-l];
        int[] right = new int[r-m+1];

        for(int i=0; i<left.length; i++){
            left[i] = a[l+i];
        }
        for(int i=0; i<right.length; i++){
            right[i] = a[m+i];
        }

        int lc = 0;
        int rc = 0;
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
            lc++;
            index++;
        }
        while(rc<right.length){
            a[index] = right[rc];
            rc++;
            index++;
        }
    }









    public void quickSort1(int[] a, int l, int r){
        int mid = partition1(a,l,r);
        quickSort1(a,l,mid-1);
        quickSort1(a,mid+1,r);
    }

    //take right most as pivot
    public int partition1(int[]a, int l, int r){
        int pivot = a[r];

        int indexsmall = -1;
        for(int i = l; i < r -1 ; i++){
            if(a[i] < pivot){
                indexsmall++;
            }
            else{//if current larger than pivot
                swap(a,i, indexsmall);
            }
        }

        return 1;
    }

    public void swap(int[] a, int l, int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
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


    public static void mergeSort1(int[] a, int l, int r){
        int m = (r-l)/2;
        mergeSort1(a,l,m);
        mergeSort1(a,m+1,r);
        merge1(a,l,m,r);
    }

    public static void merge1(int[] a, int l, int m, int r){
        //create arrays
        int[] left = new int[m-l];
        int[] right = new int[r-m+1];

        for(int i=0; i<left.length; i++){
            left[i] = a[l+i];
        }
        for(int i=0; i<right.length; i++){
            right[i] = a[m+i];
        }

        int rc = 0;
        int lc = 0;
        int index = 0;
        //merge
        while(lc < left.length && rc < right.length){
            if(right[rc]<left[lc]){
                a[index] = right[rc];
                rc++;
                index++;
            }
            else{
                a[index] = left[lc];
                lc++;
                index++;
            }
        }
        while(lc < left.length){
            a[index] = a[lc];
            lc++;
            index++;
        }
        while(rc < right.length){
            a[index] = a[rc];
            rc++;
            index++;
        }



    }
























    public void printValues(int a[]){
        for(int i=0; i<a.length; i++){
            Log.d("berttest", "print values: " + a[i]);
        }
    }
}