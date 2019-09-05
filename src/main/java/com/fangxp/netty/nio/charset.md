### ASCII (Merican Standard Code for Information Interchange,美国信息交换标准)
7 bit 来表示一个字符，共计可以表示128种字符

计算机传播到其他国家，ASCII码 不够用

### ISO-8859-1 
8 bit 表示一个字符，即用一个字节（byte）8bit 来表示一个字符，共计可以表示256个字符

中文等语言无法表示

### GB2312
国标标准，2个字节表示一个汉字；无法表示生僻字

### GBK
是GB2312的超级 

### GB18030
最完整的汉字标准

### big5
繁体中文  台湾香港澳门等

### unicode (编码方式)
采用两个字节表示一个字符
\uxxxx
存储空间对于英文浪费

### UTF (存储方式)
unicode Translation Format


unicode 与 UTF 区别：
unicode是一种编码方式，UTF是一种存储方式；UTF-8是Unicode是实现方式


UTF-16LE(little endian) ， UTF-16BE(big endian)
Zero Width No-Break Space ，0xFEFF (BE), 0xFFFE(LE)
2个字节存储

UTF-8，变长字节表示形式
一般用3个字节表示中文
 






