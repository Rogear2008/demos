package com.rogear;

/**
 * 插入排序法
 * Created by Rogear on 2020/8/19
 **/
public class InsertSort {

    /**
     * 直接插入排序
     * 将一个元素插入到已拍好序的序列中，从而得到一个新的序列
     * 例如将元素3放到{1,2,4,5}中，将比3大的元素往后移一位然后插入元素3
     * @param a
     * @return
     */
    public void directInsertSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            //待插入的数
            int temp = a[i];
            //应该插入的位置
            int j = 0;
            for (j = i-1; j >= 0; j--) {
                //如果待插入元素比前面的数字小，则把前面的元素往后移一位
                if (temp < a[j]){
                    a[j+1] = a[j];
                } else{
                    break;
                }
            }
            //移动完以后插入数据
            a[j+1] = temp;
        }
        printResult("直接插入排序法",a);
    }

    /**
     * 二分法插入排序
     * 在直接插入法的基础上进行升级，直接插入法是一个一个元素比较最后找到元素应该存放的位置
     * 二分法每次舍去一般元素找到元素应该存放的位置
     * @param a
     */
    public void binarySort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i -1;
            int mid = 0;
            while(left <= right){
                //获取中间值
                mid = (left + right)/2;
                if (temp > a[mid]){
                    //temp比中间值大，让left移动到mid+1的位置
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            //将大于temp的元素移一位
            for (int j = i-1; j >= left; j--) {
                a[j+1] = a[j];
            }
            //插入元素
            a[left] = temp;
        }
        printResult("二分法插入排序",a);
    }

    /**
     * 希尔排序
     * 按照不同增量将原来的数据分为小组，小组内进行直接插入排序，直到增量减小到1
     * @param a
     */
    public void shellInsertSort(int[] a){
        //增量
        int d = a.length;
        while (true){
            //每次增量减半
            d = d/2;
            for (int i = 0; i < d; i++) {
                //子数组进行插入排序
                for (int j = i+d; j < a.length; j += d) {
                    int temp = a[j];
                    //应该插入的位置
                    int k = i;
                    for (k = j-d; k >= 0; k -= d) {
                        //将大的数据往后移
                        if (a[k] > temp){
                            a[k+d] = a[k];
                        } else {
                            break;
                        }
                    }
                    //插入数据
                    a[k+d] = temp;
                }
            }
            //直到增量为1的时候结束
            if (d == 1){
                break;
            }
        }
        printResult("希尔排序",a);
    }

    public static void main(String[] args) {
        int[] a = {2,1,1,5,9,7,3,2,8,6,4};
        System.out.println("排序前：");
        for(int i : a){
            System.out.print(i+" ");
        }
        System.out.println();
        InsertSort insertSort = new InsertSort();
//        insertSort.directInsertSort(a);
//        insertSort.binarySort(a);
        insertSort.shellInsertSort(a);
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
