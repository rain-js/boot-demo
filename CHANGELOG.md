# 项目改动记录

## 2026-11-21 新增 User 查询模块（启用 Spring Data JPA + MySQL）

本次改动的核心是**搭建了一条完整的「用户查询」三层架构（Controller → Service → DAO），并启用了 Spring Data JPA + MySQL 数据访问能力**。共涉及 7 个文件、约 127 行新增。

### 1. 配置层：打开 JPA 能力

- `pom.xml`：把之前被注释掉的 `spring-boot-starter-data-jpa` 依赖恢复启用（MySQL 驱动 `mysql-connector-j` 原本就在依赖里）。
- `src/main/resources/application.properties`：新增服务器端口（8080）和数据源配置，连接本地 MySQL 的 `demo_db` 数据库。

### 2. 新增 User 模块的四层代码

| 文件 | 作用 |
|---|---|
| `entity/User.java` | JPA 实体类，映射 `users` 表，含 `id`（自增主键）、`name`、`email` 三个字段 |
| `dao/UserDao.java` | 继承 `JpaRepository<User, Long>`，自带 `findById`，并定义了方法名派生查询 `findByName` |
| `service/UserService.java` / `service/UserServiceImpl.java` | 服务接口及其实现，注入 DAO，封装按 ID / 按姓名查用户两个方法 |
| `controller/UserController.java` | `@RestController`，暴露两个 JSON 查询接口：`GET /api/users/{id}` 和 `GET /api/users/name?name=xxx`，返回 200 + 用户数据 |

### 3. 整体调用链

```
HTTP 请求 → UserController → UserServiceImpl → UserDao (JPA) → MySQL users 表
```

### 小结

本次改动把项目从「刚初始化的空壳 Spring Boot」变成了一个**可以查询 MySQL 中用户数据的最小 Web 应用**。目前只提供查询（读）功能，尚未包含增删改接口。
