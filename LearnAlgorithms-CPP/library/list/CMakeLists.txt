# 定义一个动态库
add_library(
        simple_list
        SHARED
        DynamicArray.c
        EnterpriseLinkedList.c
        LinkedList.c
        LinkedStack.c
        SeqQueue.c
        SeqStack.c
)

# 包含目录
target_include_directories(simple_list PUBLIC ${CMAKE_CURRENT_SOURCE_DIR})