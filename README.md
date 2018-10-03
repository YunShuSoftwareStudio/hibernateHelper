# hibernateHelper
Package Base Dao Methods
# 导入
[![](https://jitpack.io/v/YunShuSoftwareStudio/hibernateHelper.svg)](https://jitpack.io/#YunShuSoftwareStudio/hibernateHelper)
## maven
```
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```
```
<dependency>
  <groupId>com.github.YunShuSoftwareStudio</groupId>
  <artifactId>hibernateHelper</artifactId>
  <version>1.0.1</version>
</dependency>
```
## gradle
```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
```
dependencies {
  implementation 'com.github.YunShuSoftwareStudio:hibernateHelper:1.0.1'
}
```
# 使用
```
public interface UserDao extends BaseDao<User, String> {
}
```
```
public class UserDaoImpl extends BaseDaoRepository<User, String> implements UserDao 
```
