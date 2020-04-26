# ByteExtensions
提供有關位元運算常用的 function
## Gradle Setup
build.gradle(project)
```
allprojects {
  repositories {
    maven { url "https://jitpack.io" }
  }
}
```
build.gradle(app)
```
dependencies {
  implementation 'com.github.kmgs4524:byteextensions:v1.0.8'
}
```
## Usage
Byte 轉十六進制數字
```
Byte.toHexString(): String
```
ByteArray 轉十六進制數字
```
ByteArray.toHexString(): String
```
Int 轉 ByteArray
```
Int.toBytes(byteOrder: ByteOrder): ByteArray
```
ByteArray 轉 Int
```
ByteArray.toInt(): Int
```
取 ByteArray 最後幾個 byte
```
ByteArray.lastOf(byteCount: Int): ByteArray
```

