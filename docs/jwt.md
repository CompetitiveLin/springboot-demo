## 基于JWT的认证授权

配合 `@PreAuthorize("hasAuthority('student')")` 可对特定接口设置访问权限

具体实现详见：

```java
@Override
public Collection<?extends GrantedAuthority> getAuthorities(){
        if(userInfo.getPermission()==(byte)0)return Arrays.asList(new SimpleGrantedAuthority("student"));
        else if(userInfo.getPermission()==(byte)1)return Arrays.asList(new SimpleGrantedAuthority("teacher"));
        return Arrays.asList(new SimpleGrantedAuthority("parents"));
        }
```

![](https://raw.githubusercontent.com/CompetitiveLin/ImageHostingService/picgo/imgs/202309151927390.png)

### 刷新JWT

![](https://raw.githubusercontent.com/CompetitiveLin/ImageHostingService/picgo/imgs/202309151930558.png)