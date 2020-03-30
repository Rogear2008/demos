# 镜像运行需要的基础镜像
FROM java:8
# 将当前目录下的jar包复制到docker容器的/目录下
ADD dockerfile-demo-0.0.1-SNAPSHOT.jar /dockerfile-demo.jar
# 运行过程中创建一个dockerfile-demo.jar文件
RUN bash -c 'touch /dockerfile-demo.jar'
# 声明8080端口
EXPOSE 8080
# 指定docker容器命令
ENTRYPOINT ["java", "-jar","/dockerfile-demo.jar"]
# 指定维护者的名字
MAINTAINER rogear