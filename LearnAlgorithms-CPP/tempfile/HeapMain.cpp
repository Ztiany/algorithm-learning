/*
 ============================================================================

 Author      : Ztiany
 Description : 堆排序测试

 ============================================================================
 */

#include "heap/HeapSort.h"
#include "heap/IndexMaxHeapV1.h"
#include "heap/IndexMaxHeapV2.h"
#include "heap/MaxHeap.h"
#include "heap/OriginMaxHeapV1.h"
#include "heap/OriginMaxHeapV2.h"
#include "sort/InsertSort.h"
#include "tools/Arrays.h"
#include "tools/Student.h"
#include <cstdlib>

using namespace std;

int main() {
  int n = 100000;
  int *randomArr = Arrays::generateRandomArray(n, 0, n);
  Arrays::testSort("heap    SortV1", heapSortV3, randomArr, n);
  delete[] randomArr;

  // 学生排序
  std::cout << "testSort Students-----------------------------------------"
            << std::endl;
  Student students[] = {Student("A", 96), Student("B", 96), Student("C", 99),
                        Student("D", 98)};
  insertionSortV2(students, 4);
  Arrays::printArray(students, 4);

  return EXIT_SUCCESS;
}