cmake_minimum_required(VERSION 3.8)
project(AlgorithmsCPP)

set(CMAKE_CXX_STANDARD 11)

# dirs
aux_source_directory(sort SORT)
aux_source_directory(list LIST)
aux_source_directory(heap HEAP)
aux_source_directory(bst BST)
aux_source_directory(tools TOOLS)
aux_source_directory(union-find UNION_FIND)
aux_source_directory(graph GRAPH)

# build
add_executable(SortBase SortBasicMain.c)
add_executable(TreeBase BinaryTreeMain.c ${LIST})
add_executable(ListMain ListMain.c ${LIST})

add_executable(SortMain SortMain.cpp ${SORT})
add_executable(BSMain BSMain.cpp ${BST} ${SORT})
add_executable(HeapMain HeapMain.cpp ${HEAP})
add_executable(GraphMain GraphMain.cpp ${GRAPH})
add_executable(UFMain UFMain.cpp ${UNION_FIND})
