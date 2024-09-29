/*
 ============================================================================
 
 Author      : Ztiany
 Description : 选择排序

 ============================================================================
 */

#ifndef SELECTION_SORT_H
#define SELECTION_SORT_H


/** 选择排序：O(n^2)。*/
template <typename T>
void selectionSort(T* arr, const int length)
{
    for (int i = 0; i < length; ++i)
    {
        int minIndex = i;
        // 每次找到最小值索引
        for (int j = i + 1; j < length; ++j)
        {
            if (arr[j] < arr[minIndex])
            {
                minIndex = j;
            }
        }
        // 每次找到的最小值放到前面
        std::swap(arr[i], arr[minIndex]);
    }
}

#endif
