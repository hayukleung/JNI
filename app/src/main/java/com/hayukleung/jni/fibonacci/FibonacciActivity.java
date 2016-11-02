package com.hayukleung.jni.fibonacci;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.hayukleung.jni.R;

/**
 * JNI
 * com.hayukleung.jni
 * FibonacciActivity.java
 *
 * by hayukleung
 * at 2016-11-01 10:47
 */

public class FibonacciActivity extends AppCompatActivity {

  private TextView mResultRecursive1;
  private TextView mTimeRecursive1;

  private TextView mResultRecursive2;
  private TextView mTimeRecursive2;

  private TextView mResultIterative1;
  private TextView mTimeIterative1;

  private TextView mResultIterative2;
  private TextView mTimeIterative2;

  private IFibonacci mFibonacci;

  private boolean mDone1 = true;
  private boolean mDone2 = true;
  private boolean mDone3 = true;
  private boolean mDone4 = true;

  private Handler mHandler = new Handler() {
    @Override public void handleMessage(Message msg) {
      switch (msg.what) {
        case 1:
          mResultRecursive1.setText(String.valueOf(msg.obj));
          mTimeRecursive1.setText(String.format("%d ms", msg.arg1));
          mDone1 = true;
          break;
        case 2:
          mResultRecursive2.setText(String.valueOf(msg.obj));
          mTimeRecursive2.setText(String.format("%d ms", msg.arg1));
          mDone2 = true;
          break;
        case 3:
          mResultIterative1.setText(String.valueOf(msg.obj));
          mTimeIterative1.setText(String.format("%d ms", msg.arg1));
          mDone3 = true;
          break;
        case 4:
          mResultIterative2.setText(String.valueOf(msg.obj));
          mTimeIterative2.setText(String.format("%d ms", msg.arg1));
          mDone4 = true;
          break;
      }
    }
  };

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    mResultRecursive1 = (TextView) findViewById(R.id.result_recursive_1);
    mTimeRecursive1 = (TextView) findViewById(R.id.time_recursive_1);

    mResultRecursive2 = (TextView) findViewById(R.id.result_recursive_2);
    mTimeRecursive2 = (TextView) findViewById(R.id.time_recursive_2);

    mResultIterative1 = (TextView) findViewById(R.id.result_iterative_1);
    mTimeIterative1 = (TextView) findViewById(R.id.time_iterative_1);

    mResultIterative2 = (TextView) findViewById(R.id.result_iterative_2);
    mTimeIterative2 = (TextView) findViewById(R.id.time_iterative_2);

    findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        if (mDone1) {
          mDone1 = false;
          mResultRecursive1.setText("");
          mTimeRecursive1.setText("");
          new Thread(new FibonacciRunnable(mFibonacci, 1, mHandler)).start();
        }
        if (mDone2) {
          mDone2 = false;
          mResultRecursive2.setText("");
          mTimeRecursive2.setText("");
          new Thread(new FibonacciRunnable(mFibonacci, 2, mHandler)).start();
        }
        if (mDone3) {
          mDone3 = false;
          mResultIterative1.setText("");
          mTimeIterative1.setText("");
          new Thread(new FibonacciRunnable(mFibonacci, 3, mHandler)).start();
        }
        if (mDone4) {
          mDone4 = false;
          mResultIterative2.setText("");
          mTimeIterative2.setText("");
          new Thread(new FibonacciRunnable(mFibonacci, 4, mHandler)).start();
        }
      }
    });

    mFibonacci = new IFibonacci();
  }

  static class FibonacciRunnable implements Runnable {

    private IFibonacci fibonacci;
    private int type;
    private Handler handler;

    public FibonacciRunnable(IFibonacci fibonacci, int type, Handler handler) {
      this.fibonacci = fibonacci;
      this.type = type;
      this.handler = handler;
    }

    @Override public void run() {
      Looper.prepare();
      long start = System.currentTimeMillis();
      long result = fibonacci.getFibonacci(40L, type);
      long finish = System.currentTimeMillis();
      Message message = handler.obtainMessage();
      message.obj = result;
      message.arg1 = (int) (finish - start);
      message.what = type;
      handler.sendMessage(message);
      Looper.loop();
    }
  }
}
