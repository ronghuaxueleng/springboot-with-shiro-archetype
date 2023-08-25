支持使用maven插件将程序部署到docker，具体操作如下

1、编译程序

```shell script
mvn clean package -pl internet-hospital-regulation-web -am -Ptest -DskipTests=true
```

2、将编译后的程序发布到docker
```shell script
mvn -DskipTests=true docker:stop docker:remove docker:build docker:start
```


> 这里使用了 fabric8io的docker-maven-plugin，
> 更多操作请浏览 https://github.com/fabric8io/docker-maven-plugin/



| Goal                                                         | 描述                                             | Default Lifecycle Phase |
| ------------------------------------------------------------ | ------------------------------------------------ | ----------------------- |
| [`docker:start`](https://fabric8io.github.io/docker-maven-plugin/#docker:start) | Create and start containers                      | pre-integration-test    |
| [`docker:stop`](https://fabric8io.github.io/docker-maven-plugin/#docker:stop) | Stop and destroy containers                      | post-integration-test   |
| [`docker:build`](https://fabric8io.github.io/docker-maven-plugin/#docker:build) | Build images                                     | install                 |
| [`docker:watch`](https://fabric8io.github.io/docker-maven-plugin/#docker:watch) | Watch for doing rebuilds and restarts            |                         |
| [`docker:push`](https://fabric8io.github.io/docker-maven-plugin/#docker:push) | Push images to a registry                        | deploy                  |
| [`docker:remove`](https://fabric8io.github.io/docker-maven-plugin/#docker:remove) | Remove images from local docker host             | post-integration-test   |
| [`docker:logs`](https://fabric8io.github.io/docker-maven-plugin/#docker:logs) | Show container logs                              |                         |
| [`docker:source`](https://fabric8io.github.io/docker-maven-plugin/#docker:source) | Attach docker build archive to Maven project     | package                 |
| [`docker:save`](https://fabric8io.github.io/docker-maven-plugin/#docker:save) | Save image to a file                             |                         |
| [`docker:volume-create`](https://fabric8io.github.io/docker-maven-plugin/#docker:volume-create) | Create a volume to share data between containers | pre-integration-test    |
| [`docker:volume-remove`](https://fabric8io.github.io/docker-maven-plugin/#docker:volume-remove) | Remove a created volume                          | post-integration-test   |