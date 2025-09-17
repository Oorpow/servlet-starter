# 创建现代 Servlet + Tomcat 项目核心要素总结

以下是搭建一个基于 Jakarta EE 9+ 的现代 Servlet + Tomcat 项目所需的核心要素和最佳实践。

### 1. Maven 项目配置 (`pom.xml`)

- **打包方式**：必须设置为 `war`，以构建 Web 应用包。
  ```xml
  <packaging>war</packaging>
  ```
- **Java 版本**：在 `<properties>` 中明确指定项目使用的 Java 版本。
  ```xml
  <properties>
      <maven.compiler.source>17</maven.compiler.source>
      <maven.compiler.target>17</maven.compiler.target>
  </properties>
  ```

### 2. 核心依赖 (`pom.xml`)

- **Servlet API**：对于 Tomcat 10 及更高版本，必须使用 `jakarta` 命名空间的 API。
  ```xml
  <dependency>
      <groupId>jakarta.servlet</groupId>
      <artifactId>jakarta.servlet-api</artifactId>
      <version>5.0.0</version> <!-- 或更高版本 -->
      <scope>provided</scope>
  </dependency>
  ```
- **`scope` 必须为 `provided`**：这至关重要，它确保 Servlet API 仅用于编译，而不会被打包到 `.war` 文件中，避免与 Tomcat 服务器内置的 API 发生冲突。

### 3. Servlet 编写 (Java 代码)

- **继承 `HttpServlet`**：Servlet 类需要继承 `jakarta.servlet.http.HttpServlet`。
- **使用 `@WebServlet` 注解**：这是现代 Servlet 的首选配置方式，用于将 Servlet 映射到 URL 路径，可以完全替代 `web.xml`。
  ```java
  import jakarta.servlet.annotation.WebServlet;
  import jakarta.servlet.http.HttpServlet;
  
  @WebServlet("/your-path")
  public class MyServlet extends HttpServlet {
      // ...
  }
  ```

### 4. Web 应用配置 (`web.xml` 的处理)

- **建议完全删除 `web.xml`**：对于一个纯注解驱动的应用，`src/main/webapp/WEB-INF/` 目录下**不需要** `web.xml` 文件。它的存在（即使内容为空）有时会干扰容器的注解扫描机制。

### 5. 运行与部署 (Maven 插件)

- **选择兼容的插件**：
  - **不要用 `tomcat7-maven-plugin`**：它与 `jakarta.*` 命名空间不兼容，无法识别 `@WebServlet` 注解。
  - **推荐用 `cargo-maven3-plugin`**：它可以配置为自动下载并运行任何版本的 Tomcat，包括与 Jakarta EE 兼容的 Tomcat 10+。

- **正确的运行命令**：
  ```bash
  mvn clean package cargo:run
  ```
  - `clean`：清理旧的构建，避免残留文件影响结果。
  - `package`：在运行前，确保项目被正确编译和打包成 `.war` 文件。
  - `cargo:run`：启动 Cargo 插件并运行你的应用。
