package com.hayukleung.jni.callback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * JNI
 * com.hayukleung.jni.callback
 * CallbackActivity.java
 *
 * by hayukleung
 * at 2016-11-01 17:25
 */

public class CallbackActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ICallback iCallback = new ICallback();
    iCallback.callback();
  }
}
