# Maven Example Project

Apache Maven 是 apache 下的一个用于项目构建和依赖管理的项目管理工具。它的官网是：<https://maven.apache.org/>。

pom.xml 文件是 Maven 的主要配置文件，配置项目的 `groupId`、`artifactId`、`version` 等 Maven 项目必要信息；配置 Maven 项目使用的远程仓库；定义 Maven 项目打包形式；定义 Maven 项目的依赖关系等。

## 安装配置

1. 下载 maven 最新版本，<https://maven.apache.org/download.cgi>
2. 解压下载的安装包（例如：apache-maven-3.6.3-bin.zip）到某个目录（注意：目录最好不要带中文和空格，例如：windows解压至 d:\soft\maven；mac 解压至 /Users/sh/soft/maven）
3. 配置环境变量，以上述目录为例
    - windows 环境下将目录 `d:\soft\maven\bin` 添加到环境变量 Path 上
    - mac 环境，在 `~/.bash_profile` 文件中加入一行，然后执行一下 `source ~/.bash_profile` 使之生效
        ```
        export PATH=/Users/sh/maven/bin:$PATH
        ```
4. 命令行下执行 `mvn --version`，如果能正确显示版本号，说明安装正确，比如显示内容如下：

    ```
    ➜ mvn --version
    Apache Maven 3.6.1 (d66c9c0b3152b2e69ee9bac180bb8fcc8e6af555; 2019-04-05T03:00:29+08:00)
    Maven home: /Users/sh/bin/mvn
    Java version: 1.8.0_212, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_212.jdk/Contents/Home/jre
    Default locale: zh_CN, platform encoding: UTF-8
    OS name: "mac os x", version: "10.15", arch: "x86_64", family: "mac"
    ```

## Maven 项目结构

- `src/main/java` 项目 Java 源文件（.java）
- `src/main/resources` 项目资源文件
- `src/test/java` 项目测试 Java 源文件（.java），单元测试/集成测试等
- `src/test/resources` 项目测试资源文件
- `target` 项目输出目录，项目编译产出物以及编译中产生的临时文件
- `pom.xml` Maven配置文件（POM, Project Object Model）

## Maven 常用命令

- `mvn compile` 编译源代码
- `mvn package` 根据pom.xml中的配置生成构件包（例如：jar包、war包）
- `mvn install` 将生成的构件包安装到本地仓库 Repository 中
- `mvn deploy` 将生成的构件包部署到远程仓库
- `mvn test-compile` 编译测试源代码
- `mvn test` 运行测试
- `mvn clean` 清空项目编译输出目录（即 target 目录）
- `mvn clean package -Dmaven.test.skip=true` 先清空项目编译输出目录再打包，跳过测试

## pom.xml 配置项说明

### groupId / artifactId / verion

在 maven 中，由 `groupId + artifactId + verion` 来唯一确定一个项目的其中一个版本。

- groupId：组织名称，可表示为公司下的某个项目，例如：com.zeroten.javales 表示ZeroTen旗下的Java课程项目
- artifactId：项目里某个模块，例如：java-les-maven-example 表示Java课程项目下的Maven示例模块
- verion：版本号，例如：1.0.0
