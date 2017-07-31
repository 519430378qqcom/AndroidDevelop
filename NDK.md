###NDK开发
####1.导入NDK环境
<pre>
在local.properties 文件中确保加入:
ndk.dir=C\:\\Android\\sdk\\ndk-bundle  ndk配置路径
sdk.dir=C\:\\Android\\sdk  
</pre>
####2.建立调用c++代码的Java类
<pre>
 public class NDK {
     static {
         System.loadLibrary("MyJni");
     }
     public native String getTime();
     public native String getTime1();
     public native String getTime2();
     public native String getTime3();
     public native String getTime4();
 }
 System.loadLibrary("MyJni");加载库，
 需要注意的是加载的库名即编译生成的库名，去掉前缀lib和后缀so。
 然后make project一下，目的就是编译成对应的class文件。
 然后根据生成的class文件，利用javah生成对应的 .h头文件
 </pre>
####3.生成.h头文件
<pre>
1.AS中点击Terminal，cd app\src\main,进入src\main\目录下:
2.执行Javah命令 
javah -d jni -classpath C:\Android\sdk\platforms\android-24\android.jar
;..\..\build\intermediates\classes\debug\ com.dong.develop.utils.NDK

<h4>命令说明</h4>
<pre>
javah -d jni -classpath
javah是生成头文件的工具，-d jni 在工程下生成jni目录，到时会在这个目录下建JNI开始的C/C++源文件的。
<br>
C:\Android\sdk\platforms\android-24\android.jar 
这个就是你SDK文件下android.jar所在的文件位置
<br>
;..\..\build\intermediates\classes\debug\ com.dong.develop.utils.NDK
在这个目录下找到对应的.Class文件，如果没有先make project
3.执行完这个命令后，会在main文件夹下自动生成jni目录和.h头文件
4.创建c文件实现native方法
最后还有配置一个地方：build.gradle文件的defaultConfig中加ndk
 ndk {
            moduleName "MyJni"
            abiFilters "arm64-v8a","armeabi-v7a","x86_64"
        }
</pre>
