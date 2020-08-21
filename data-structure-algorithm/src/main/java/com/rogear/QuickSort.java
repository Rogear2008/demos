package com.rogear;

/**
 * 快速排序
 * Created by Rogear on 2020/8/20
 **/
public class QuickSort {

    /**
     * 快速排序
     * 先选择一个元素，一般是第一个或者最后一个元素，然后从左边去找比他大的数，从右边去找比它小的数进行替换（从小到大排序）
     * 然后以这个元素为分界线，将原来的数据分为两部分，再用相同的方法进行排序，直到所有数据被排完
     * @param a
     * @param left
     * @param right
     */
    public void quickSort(int[] a,int left,int right){
        int temp = a[left];
        int i = left;
        int j = right;
        while(i < j){
            //从右往左找比temp小的数
            while(a[j] > temp && i < j){
                j--;
            }
            //从左往右找比temp大的数
            while(a[i] < temp && i < j){
                i++;
            }
            if (a[i] == a[j] && i < j){
                i++;
            } else {
                //交换数据
                int k = a[i];
                a[i] = a[j];
                a[j] = k;
            }
        }
        //左边的子数组按照相同的方法进行排序
        if (i-1 > left){
            quickSort(a,left,i-1);
        }
        //右边的子数组按照相同的方法进行排序
        if (j+1 < right){
            quickSort(a,j+1,right);
        }
    }
    public static void main(String[] args) {
        int[] a = {2,1,1,5,9,7,3,2,8,6};
        System.out.println("排序前：");
        for(int i : a){
            System.out.print(i+" ");
        }
        System.out.println();
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(a,0,a.length-1);
        quickSort.printResult("快速排序",a);
    }

    /**
     * 打印结果
     * @param name
     */
    private void printResult(String name,int[] result) {
        System.out.println(name + " 排序结果：");
        for(int i : result){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
