# simplypojo

Place the following in your build.gradle file and then execute the task simplyGenerate

``` java
buildscript {
    repositories {
        maven { url "https://github.com/QVDev/simplypojo/raw/create_gradle_plugin/lib/releases" }
    }
    dependencies {    
        classpath 'qvdev.utils.simplypojo:simplypojo:1.0.0-SNAPSHOT'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }

    apply plugin: 'qvdev.utils.simplypojo.plugin'
}

simplyConfiguration {
    urls = ["Example": "https://ajax.googleapis.com/ajax/services/feed/find?v=1.0&q=Official%20Google%20Blogs"]
    destination = getProjectDir().absolutePath.toString() + '/src/main/java'
    packageName = "com.android.library.generated"
}
```
