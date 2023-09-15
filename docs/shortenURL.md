## 基于哈希算法的短链接服务

### 生成短链接

| ![](https://raw.githubusercontent.com/CompetitiveLin/ImageHostingService/picgo/imgs/202309101933889.png) | ![](https://raw.githubusercontent.com/CompetitiveLin/ImageHostingService/picgo/imgs/202309101933936.png) | ![](https://raw.githubusercontent.com/CompetitiveLin/ImageHostingService/picgo/imgs/202309101934749.png) |
|----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|

访问量的设计欠妥，如果数据量大可以考虑使用 Redis 的 Hyperloglog 数据结构而不是存储在 MySQL 中。

### 短链接跳转

http://localhost:8080/u/4dUMi1

![](https://raw.githubusercontent.com/CompetitiveLin/ImageHostingService/picgo/imgs/202309101938394.png)
