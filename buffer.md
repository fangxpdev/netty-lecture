### Heap Buffer （堆缓冲区）
ByteBuf将数据存储到JVM堆空间中，并且将实际的数据存放到byte array（backing byte array）中来实现

优点：由于数据是存储在JVM的堆中，因此可以快速先的创建与快速的释放，并且提供了直接访问内部字节数组的方法
缺点：每次读写数据是，都需要将数据复制到直接缓冲区再进行网络传输

### Direct Buffer(直接缓冲区)
在堆之外直接分配内存空间，直接缓冲区并不会占用堆空间，因为它是由操作系统在本地内存进行数据分配

优点:使用Socket传输时，性能非常好，因为数据直接位于操作系统本地内存中，所以不需要从JVM将数据复制到
直接缓冲区中
缺点：Direct Buffer是直接位于操作系统内存中，所以内存的分配与释放要比堆空间更加复杂，而且速度慢一些；

Netty通过提供内存池来解决这个问题；直接缓冲区并不支持通过字节数组的方式来访问数据。

### 总结
对于后端业务消息的编解码来说，推荐使用HeapByteBuf；对于I/O通信在读写缓冲区时，推荐使用DirectByteBuf


### Composite Buffer (复合缓冲区)


jdk的byteBuffer 与netty的ByteBuf区别：
1、Netty的ByteBuf采用了读写索引分离的策略（readIndex和writeIndex），一个初始化（里面没有数据）的ByteBuf
的readIndex和writeIndex值都为0。
2、当读和写索引位于同一位置时，不能继续读取，否则跑出IndexOutOfBoundsExcepiton
3、对于ByteBuf的任何读写操作都会分别维护读写索引，maxCapacity最打容量的限制是Integer.MAX_VALUE，
支持扩容


jdk的ByteBuffer的缺点：
1、final byte[] hb; 字节数组声明为final，也就是长度是固定的。一旦分配后不能动态扩容与收缩；
而且当待存储的数据字节很大的时候就可能出现IndexOutOfBoundsException.如果要预防这个异常，就需要
存储之前完全确定好待存储的字节大小。如果byteBuffer的空间不足，只有一种解决方案：创造一个全新的ByteBuffer
对象，然后将之前的ByteBuffer中的数据复制过去，这一切操作都需要开发者自己来完成。
2、byteBuffer只使用一个指针来标识位置信息，在进行读写切换需要调用flip方法或者rewind方法，使用不便

netty的byteBuf优点：
1、存储字节数组是动态的，其最大值默认为Integer.MAX_VALUE。write()方法完成
2、byteBuf的读写索引是分离的