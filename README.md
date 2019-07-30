# springboot2_dubbo

#### 项目介绍
springboot2+dubbo集成例子,包含dubbo的Filter用法。



#### 软件架构
软件架构说明
springboot-dubbo-consumer 消费者
springboot-dubbo-provider 提供者
springboot-dubbo-api      服务接口

#### 安装教程



``` shell

# docker build

docker build -t <name> .

# dubbo admin
docker run -d --net dubbo_default  -p 8080:8080 -e dubbo.registry.address=zookeeper://zookeeper:2181 -e dubbo.admin.root.password=root -e dubbo.admin.guest.password=guest  chenchuxin/dubbo-admin 

```
