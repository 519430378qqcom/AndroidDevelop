###walle快速打包
####1.Gradle插件配置
<pre>
配置build.gradle

在位于项目的根目录 build.gradle 文件中添加Walle Gradle插件的依赖， 如下：

buildscript {
    dependencies {
        classpath 'com.meituan.android.walle:plugin:1.1.4'
    }
}
并在当前App的 build.gradle 文件中apply这个插件，并添加上用于读取渠道号的AAR

apply plugin: 'walle'

dependencies {
    compile 'com.meituan.android.walle:library:1.1.4'
}
配置插件

walle {
    // 指定渠道包的输出路径
    apkOutputFolder = new File("${project.buildDir}/outputs/channels");
    // 定制渠道包的APK的文件名称
    apkFileNameFormat = '${appName}-${packageName}-${channel}-${buildType}-v${versionName}-${versionCode}-${buildTime}.apk';
    // 渠道配置文件
    channelFile = new File("${project.getProjectDir()}/channel")
}
配置项具体解释：

apkOutputFolder：指定渠道包的输出路径， 默认值为new File("${project.buildDir}/outputs/apk")

apkFileNameFormat：定制渠道包的APK的文件名称, 默认值为'${appName}-${buildType}-${channel}.apk'
可使用以下变量:

     projectName - 项目名字
     appName - App模块名字
     packageName - applicationId (App包名packageName)
     buildType - buildType (release/debug等)
     channel - channel名称 (对应渠道打包中的渠道名字)
     versionName - versionName (显示用的版本号)
     versionCode - versionCode (内部版本号)
     buildTime - buildTime (编译构建日期时间)
     fileSHA1 - fileSHA1 (最终APK文件的SHA1哈希值)
     flavorName - 编译构建 productFlavors 名
</pre>
####2.拷贝channel文件到app目录下
<pre>
写法参考此项目,#号添加注释。
</pre>
####3.在application中设置友盟渠道编号
<pre>
    /**
     * 初始化友盟渠道
     */
    private void initUMChannel() {
        String channel = WalleChannelReader.getChannel(mContext);
        MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(mContext, Secret.getUmkey(),channel));
    }
    Secret.getUmkey()即为友盟appkey这里为了安全使用Jin写在了so库里。
</pre>
####4.打多渠道包
<pre>
在AndroidStudio右上角找到gradle -> Tasks ->package->选择打包命令
如果配置了Flavors打包选择assemble渠道号ReleaseChannels同事支持Flavors的单渠道打包
若果只配置了walle打包选择assembleReleaseChannels即可
</pre>