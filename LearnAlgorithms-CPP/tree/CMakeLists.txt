cmake_minimum_required(VERSION 3.7)
project(DataStructure-Tree)
set(CMAKE_C_STANDARD 99)

#二叉树
set(
        SOURCE_FILES
        ../list/LinkedStack.c
        tree/BinaryTree.c
)

set(SOURCE_FILES BinaryTree.c)
add_executable(DataStructure-Tree ${SOURCE_FILES})