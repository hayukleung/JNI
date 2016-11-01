#include "Fibonacci.h"

uint64_t recursive_1(uint64_t index) {

    if (index > 1) {
        return recursive_1(index - 2) + recursive_1(index - 1);
    }

    return index;
}

uint64_t recursive_2(uint64_t index) {

    if (index > 1) {
        uint64_t result = 1;
        do {
            result += recursive_2(index - 2);
            index--;
        } while (index > 1);
        return result;
    }

    return index;
}

uint64_t iterative_1(uint64_t index) {

    if (index > 1) {
        uint64_t a = 0, b = 1;
        do {
            uint64_t tmp = b;
            b += a;
            a = tmp;
        } while (--index > 1);
        return b;
    }

    return index;
}

uint64_t iterative_2(uint64_t index) {

    if (index > 1) {
        uint64_t a, b = 1;
        index--;
        a = index & 1;
        index /= 2;
        while (index-- > 0) {
            a += b;
            b += a;
        }
        return b;
    }

    return index;
}