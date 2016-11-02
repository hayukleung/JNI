# CMake Build
## 各模块说明
0. Hello World - JNIInterface
1. JAVA调用C/C++函数DEMO - Fibonacci
2. C/C++调用JAVA方法DEMO - Callback

## 根据JAVA接口生成C/C++头文件
运行根目录下脚本 jni_header_generator.sh，比如：
```shell
./jni_header_generator.sh com/hayukleung/jni/JNIInterface.java com.hayukleung.jni.JNIInterface
```

## 附录

| Java类型 |对应的签名            | 例子 |
|:-------- | :------------------ | :-- |
| boolean | Z ||
| byte	  | B ||
| char	  | C ||
| short   | S ||
| int	    | I ||
| long	  | L ||
| float   | F ||
| double  | D ||
| void    | V ||
| Object	| L用/分割包的完整类名; | Ljava/lang/String; |
| Array	  | [签名                | [I or [Ljava/lang/String; |
