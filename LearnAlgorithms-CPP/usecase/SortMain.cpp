/*
 ============================================================================

 Author      : Ztiany
 Description : 排序初级

 ============================================================================
 */

#include "tools/Arrays.h"
#include "sort/SelectionSort.h"
#include "sort/InsertSort.h"
#include "tools/Student.h"
#include "sort/ShellSort.h"
#include "sort/BubbleSort.h"
#include "sort/MergeSort.h"
#include "sort/QuickSort.h"
#include "sort/QuickSort3Ways.h"

void testSort(int *arr, int n) {
//    int *arrCopy5 = Arrays::copyIntArray(arr, n);
//    Arrays::testSort("bubbleSort  Sort", bubbleSort, arrCopy5, n);
//    delete[] arrCopy5;

//    int *arrCopy1 = Arrays::copyIntArray(arr, n);
//    Arrays::testSort("selection   Sort", selectionSort, arrCopy1, n);
//    delete[] arrCopy1;

//    int *arrCopy2 = Arrays::copyIntArray(arr, n);
//    Arrays::testSort("insertionV1 Sort", insertionSortV1, arrCopy2, n);
//    delete[] arrCopy2;

//    int *arrCopy3 = Arrays::copyIntArray(arr, n);
//    Arrays::testSort("insertionV2 Sort", insertionSortV2, arrCopy3, n);
//    delete[] arrCopy3;

    int *arrCopy4 = Arrays::copyIntArray(arr, n);
    Arrays::testSort("Shell       Sort", shellSort, arrCopy4, n);
    delete[] arrCopy4;

    int *arrCopy6 = Arrays::copyIntArray(arr, n);
    Arrays::testSort("Merge       Sort", mergeSortBU, arrCopy6, n);
    delete[] arrCopy6;

    int *arrCopy7 = Arrays::copyIntArray(arr, n);
    Arrays::testSort("Quick       Sort", quickSort3Ways, arrCopy7, n);
    delete[] arrCopy7;


    delete[] arr;
}

int main() {
    /*数组排序，对比插入排序、选择排序、冒泡排序、希尔排序*/
    int n = 500000;//数组长度
    std::cout << "testSort by RandomArray size = " << n << ", random range [" << 0 << ", " << 100000
              << "]" << std::endl;
    int *arr1 = Arrays::generateRandomArray(n, 0, 100000);//随机数组
    testSort(arr1, n);

    ::cout << "testSort by NearlyOrderedArray size = " << n << ", swap time = " << 100 << std::endl;
    int *arr2 = Arrays::generateNearlyOrderedArray(n, 100);//近乎有序的数组
    testSort(arr2, n);

    std::cout << "testSort by RandomArray size = " << n << ", random range [" << 0 << ", " << 10
              << "]" << std::endl;
    int *arr3 = Arrays::generateRandomArray(n, 0, 10);//随机数组
    testSort(arr3, n);

    //学生排序
    std::cout << "testSort Students-----------------------------------------" << std::endl;
    Student students[] = {Student("A", 96), Student("B", 96), Student("C", 99), Student("D", 98)};
    selectionSort(students, 4);
    Arrays::printArray(students, 4);

    return EXIT_SUCCESS;
}