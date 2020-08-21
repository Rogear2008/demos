package com.rogear;

/**
 * 选择排序
 * Created by Rogear on 2020/8/19
 **/
public class SelectSort {

    /**
     * 简单选择排序
     * @param a
     */
    public void selectSort(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        printResult("简单选择排序",a);

    }

    public static void main(String[] args) {
        int[] a = {2,1,1,5,9,7,3,2,8,6,4,3};
        System.out.println("排序前：");
        for(int i : a){
            System.out.print(i+" ");
        }
        System.out.println();
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(a);
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
