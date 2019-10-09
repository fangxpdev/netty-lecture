1. 一个eventLoopGroup包含一个或多个eventLoop
2. 一个eventLoop在整个生命周期内只与一个Thread绑定
3. 所有由eventLoop所处理的I/O事件都是由它所关联的Thread所处理
4. 一个channel在整个生命周期上只会注册到一个eventLoop上，由于一个
eventLoop只会有一个Thread处理，所以所有操作都是线程安全的
5. 一个eventLoop在运行过程中，会被分配给一个或多个channel;不要在
eventLoop的I/O线程上处理耗时的任务，阻塞线程会导致netty处理能力下降，
可使用业务线程池处理。

### 结论：
1. netty中channel的实现是线程安全的；基于此，我们可以存储一个channel的
引用，并且在需要向远端发送数据时，通过这个引用来调用channel的相应方法；
即使当时有很多线程都在使用它也不会出现多线程问题；并且，消息一定按顺序
发送出去。
2. 业务开发过程中，不要将长时间执行的任务放入到eventLoop的执行队列中，
因为将阻塞该线程所对应的channel上的所有任务，如果需要进行阻塞调用或者
耗时的操作，我们需要使用一个专门的EventExecutor(业务线程池).

业务线程池实现方式：
1. 在channelHandler的回调方法，使用自己定义的线程池，实现异步调用。
2. netty提供的向channelPipeline添加channelHandler时的addLast方法
可指定线程池(EventExecutorGroup)


jdk提供的future只能通过手工方式获取执行结果，而这个操作是阻塞的；
netty则是提供channelFutureListener以回调的方式获取执行结果，
去除了手工检查的阻塞操作；注意：回调方法是由I/O线程执行的，因此不能执行
耗时的操作，否则请使用另外的线程操作


发送消息两种方式：
1. 直接调用channel.writeAndFlush
2. 调用channel对用channelHandlerContext.writeAndFlush

两种方式的区别：第一种会经过channelPipeline上所有的handler，
第二种会经过当前handler的下一个channelHandler开始到最终发送

### 结论：
1. channelHandlerContext与channelHandler之间的绑定是不会改变的，
因此缓存是没有问题的
2. 与channel的方法相比，channelHandlerContext的方法将产生更短的
事件流，在可能的情况下利用channelHandlerContext的方法提高性能。


最佳实践：
client->server1->server2
server1 作为client的服务端 作为server2的客户端
client将消息从发送到server1，server1发送到server2
方案：server1 服务端和客户端公用eventLoopGroup
public void channelActive(ChannelHandlerContext ctx){
    BootStrap b = new BootStrap();
    b.group(ctx.channel().eventLoop())
    .channel(NioSocketChannel.class)
   
}

