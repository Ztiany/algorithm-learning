#ifndef  SEQ_STACK_H
#define  SEQ_STACK_H

#define MAX_SEQ_SIZE 1024

#define SEQ_STACK_TRUE 1
#define SEQ_STACK_FALSE 0

//定义结构体栈
typedef struct
{
    void* data[MAX_SEQ_SIZE];
    int size;
} SeqStack;

//初始化栈
SeqStack* Init_SeqStack();

//入栈
void Push_SeqStack(SeqStack* stack, void* data);

//返回栈顶元素
void* Top_SeqStack(SeqStack* stack);

//出栈
void Pop_SeqStack(SeqStack* stack);

//判断是否为空
int IsEmpty(SeqStack* stack);

//返回栈中元素的个数
int Size_SeqStack(SeqStack* stack);

//清空栈
void Clear_SeqStack(SeqStack* stack);

//销毁
void FreeSpace_SeqStack(SeqStack* stack);

#endif
