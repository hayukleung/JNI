#!/usr/bin/env bash

####################################################################################################
# 根据Java Native接口生成对应的C头文件
# ./jni_header_generator.sh {java_file_name} {class_full_name}
# .e.g
# ./jni_header_generator.sh com/hayukleung/appjni/IHelloJni.java com.hayukleung.appjni.hellojni.IHelloJni
# hayukleung@gmail.com
# 2016-02-25 18:26
# Chargerlink
####################################################################################################

####################################################################################################
# 配置部分
# user主目录
PATH_USER="/Users/hayukleung"
# module根目录
PATH_MODULE="${PATH_USER}/Development/github/hayukleung/JNI/app"
####################################################################################################

# java文件存放路径
PATH_JAVA="${PATH_MODULE}/src/main/java"
# 头文件存放路径
PATH_HEADER="${PATH_MODULE}/src/main/cpp"
# class文件存放路径
PATH_CLASS="${PATH_MODULE}/src/main/cpp/class"

# 输入参数检查
if [ $# -ne 2 ]; then
    echo "-- execute like this"
    echo "-- ./jni_header_generator.sh {java_file_name} {class_full_name}"
    echo "-- e.g."
    echo "-- ./jni_header_generator.sh com/hayukleung/jni/JNIInterface.java com.hayukleung.jni.JNIInterface"
    exit
fi
# 如果class文件夹存在，删除它
if [ -d ${PATH_CLASS} ]; then
    echo ">> deleting ${PATH_CLASS}"
    rm -r ${PATH_CLASS}
fi
# 新建class文件夹
echo ">> building ${PATH_CLASS}"
mkdir ${PATH_CLASS}
# 生成class文件
echo ">> generating class file for ${PATH_JAVA}/$1"
# 生成jni interface基类class文件
javac "${PATH_JAVA}/$1" -d ${PATH_CLASS}
javac -cp ${PATH_CLASS} "${PATH_JAVA}/$1" -d ${PATH_CLASS}
# 生成头文件
echo ">> generating header file for ${PATH_JAVA}/$1"
javah -jni -classpath ${PATH_CLASS} -d ${PATH_HEADER} $2
# 删除class文件
echo ">> deleting ${PATH_CLASS}"
rm -r ${PATH_CLASS}
echo ">> all done"