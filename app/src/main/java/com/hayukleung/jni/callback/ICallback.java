package com.hayukleung.jni.callback;

/**
 * JNI
 * com.hayukleung.jni.callback
 * ICallback.java
 *
 * by hayukleung
 * at 2016-11-01 16:48
 */

public class ICallback {
  static {
    System.loadLibrary("com_hayukleung_jni_callback_ICallback");
  }

  public native long callback(int callback);
}
