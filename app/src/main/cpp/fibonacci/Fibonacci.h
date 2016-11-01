#ifndef _FIBONACCI_H_
#define _FIBONACCI_H_

#include <stdint.h>

// 递归及迭代的方法计算斐波那契数列

/**
 * 斐波那契
 */
extern uint64_t recursive_1(uint64_t index);

/**
 * 斐波那契
 */
extern uint64_t recursive_2(uint64_t index);

/**
 * 斐波那契
 */
extern uint64_t iterative_1(uint64_t index);

/**
 * 斐波那契
 */
extern uint64_t iterative_2(uint64_t index);

#endif