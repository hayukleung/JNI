package com.hayukleung.jni;

/**
 * JNIInterface.java
 * <p>
 * Created by hayukleung on 2/25/16.
 */
public class JNIInterface {

  static {
    System.loadLibrary("com_hayukleung_jni_JNIInterface");
  }

  public native String stringFromJNI();
}
