package com.hayukleung.jni.fibonacci;

/**
 * IFibonacci.java
 * <p>
 * Created by hayukleung on 3/23/16.
 */
public class IFibonacci {

  static {
    System.loadLibrary("com_hayukleung_jni_fibonacci_IFibonacci");
  }

  /**
   * 获取斐波那契数列的第index个值
   *
   * @param index 序号
   * @param type 方法类型
   * 1 - 递归
   * 2 - 递归优化
   * 3 - 迭代
   * 4 - 迭代优化
   * @return
   */
  public native long getFibonacci(long index, int type);
}
