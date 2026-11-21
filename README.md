# boot-demo

一个基于 Spring Boot 的用户查询示例项目，演示了 Controller → Service → DAO 三层架构 + Spring Data JPA 访问 MySQL 的标准写法。

## 技术栈

| 组件 | 版本 |
|---|---|
| Spring Boot | 4.2.0 |
| Java | 17 |
| Spring Data JPA | 随父 POM 管理 |
| MySQL 驱动 | mysql-connector-j |
| 构建工具 | Maven（含 Wrapper） |

## 项目结构

```
src/main/java/com/example/boot_demo/
├── BootDemoApplication.java      # 启动类
├── controller/
│   └── UserController.java       # REST 接口层
├── service/
│   ├── UserService.java          # 服务接口
│   └── UserServiceImpl.java      # 服务实现
├── dao/
│   └── UserDao.java              # JPA 仓库接口
└── entity/
    └── User.java                 # JPA 实体，映射 users 表
```

## 环境要求

- JDK 17+
- MySQL 8.x（本地运行，监听 3306 端口）

## 快速开始

1. 创建数据库（JPA 建表行为未显式配置，首次启动需确认表已存在或自行配置 `spring.jpa.hibernate.ddl-auto`）：

   ```sql
   CREATE DATABASE IF NOT EXISTS demo_db
     DEFAULT CHARACTER SET utf8mb4
     DEFAULT COLLATE utf8mb4_unicode_ci;
   ```

2. 根据本机情况修改 `src/main/resources/application.properties` 中的数据库账号密码（当前为 `root`、空密码）。

3. 启动应用：

   ```bash
   ./mvnw spring-boot:run
   ```

   应用默认监听 `http://localhost:8080`。

## API 接口

| 方法 | 路径 | 说明 | 示例 |
|---|---|---|---|
| GET | `/api/users/{id}` | 按 ID 查询用户 | `curl http://localhost:8080/api/users/1` |
| GET | `/api/users/name?name=xxx` | 按姓名查询用户 | `curl "http://localhost:8080/api/users/name?name=小明"` |

返回值为 JSON 格式的 `User` 对象（查不到时返回 `null`）：

```json
{
  "id": 1,
  "name": "小明",
  "email": "xiaoming@example.com"
}
```

## 相关文档

- 改动记录见 [CHANGELOG.md](CHANGELOG.md)
- Spring Initializr 生成的参考链接见 [HELP.md](HELP.md)
