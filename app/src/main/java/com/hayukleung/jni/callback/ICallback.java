package com.hayukleung.jni.callback;

import android.util.Log;

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

  public native void callback();

  /**
   * 被C调用的JAVA方法
   */
  public void onCallback() {
    Log.e("onCallback", "content callback");
  }

  /**
   * 被C调用的JAVA方法
   *
   * @param intFromC
   */
  public void onCallback(int intFromC) {
    Log.e("onCallback", String.valueOf(intFromC));
  }

  /**
   * 被C调用的JAVA方法
   *
   * @param stringFromC
   */
  public void onCallback(String stringFromC) {
    Log.e("onCallback", stringFromC);
  }




}
