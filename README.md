# Spring Cloud Stream 简介

​			

​	Spring Cloud Stream是用于构建消息驱动的微服务应用程序的框架。Spring Cloud Stream基于Spring Boot来创建独立的生产级Spring应用程序，并使用Spring Integration提供与消息代理的连接。它提供了来自**多家供应商**的合理配置，并介绍了持久性发布-订阅语义，使用者组和分区的概念。 *（来自Google翻译）*

[	Getting Started with Stream Processing](https://cloud.spring.io/spring-cloud-static/spring-cloud-stream/current/reference/html/spring-cloud-stream.html#spring-cloud-stream-overview-introducing)

### **应用模型**

<img src="https://github.com/moholi/spring-cloud-stream-samples/blob/master/blob/images/SpringCloudStreamApplication.jpg" style="zoom: 150%;" />

​	Spring Cloud Stream Applicaiton 划出使用Spring Cloud Stream后项目与中间件之间的关系，其中Applicaiton Core可以理解为**消息处理函数**。

​	inputs(多个输入)和outputs(多个输出)旁边的管道表示**消息处理函数**与Binder的交互即**消息通道**

​	Middleware **消息中间件**(Kafka,Rabbit,Redis,IbmMQ等等等)

​	Binder  **消息中间件**与**消息处理函数**之间的**消息绑定器**

​		Spring Cloud Stream 对不同消息队列中间件的支持请 [敲这儿个自去看](https://github.com/spring-cloud?q=binder&type=&language=)

### **抽象Binder**

​	Binder 抽象可以让项目灵活的连接到中间件。

### 持久化消息数据

​	你可以持久化消息数据，做法就是起一个保存消息的服务把raw-sensor-data声明为输入（没搞懂）

### 消费者组

​	通过`spring.cloud.stream.bindings.<channelName>.group`属性指定消费者组名。

​	消费者组，消息分发时分组的意思。分布式系统监听queue消息时，消息中间件会保证消息只发到某台服务器上，这样就不用担心消息被重复消费。这种天然的优势来自于queue-name，同一套环境配置起N个服务，这N个服务监听同一个队列即可。

​	Spring-cloud-stream 提供的消费者组也是这个原理，在RabbitMQ控制台中，可以看到同一个消费者组建立了同样名称的Queue，命名规则"<channelName>.<groupName>"  例如：input.moho。配置了同样组名称的项目启动时，在控制台-队列详情下能看到增加的Consumer。

Spring 团队对消费则组的描述图：

![SCSt小组](https://github.com/moholi/spring-cloud-stream-samples/blob/master/blob/images/SpringCloudStreamConsumerGroup.jpg)

### 消费者类型

支持两种类型的使用者：

- 消息驱动（有时称为异步）
- 轮询（有时称为同步）

在2.0版之前，仅支持异步使用者。消息一旦可用，就会被传递，并且有线程可以处理它。

当您希望控制消息的处理速率时，可能需要使用同步使用者。  *（来自Google翻译）*

#### Spring 团队对耐用性，分区支持也做出了描述，详见[点击](https://cloud.spring.io/spring-cloud-static/spring-cloud-stream/current/reference/html/spring-cloud-stream.html#durability)

