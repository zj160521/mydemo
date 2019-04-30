package com.demo.Io_Serializable;

import java.io.*;
import java.text.MessageFormat;

/**
 *
 *一、对象的序列化主要有两种用途：
 *1） 把对象的字节序列永久地保存到硬盘上，通常存放在一个文件中；
 *2） 在网络上传送对象的字节序列。
 * 在很多应用中，需要对某些对象进行序列化，让它们离开内存空间，入住物理硬盘，以便长期保存。比如最常见的是Web服务器中的Session对象，
 * 当有 10万用户并发访问，就有可能出现10万个Session对象，内存可能吃不消，于是Web容器就会把一些seesion先序列化到硬盘中，等要用了，再把保存在硬盘中的对象还原到内存中。
 * 当两个进程在进行远程通信时，彼此可以发送各种类型的数据。无论是何种类型的数据，都会以二进制序列的形式在网络上传送。发送方需要把这个Java对象转换为字节序列，才能在网络上传送；
 * 接收方则需要把字节序列再恢复为Java对象
 * 
 * 二、通过实现Serializable接口进行的序列化，被transient修饰的字段不能序列化
 * 
 * 三、序列化实质上也是加密的一种应用，防止数据在传输过程中被串改
 * 
 *  sr com.demo.Io_Serializable.Person?GV"? I ageL namet Ljava/lang/String;xp   t gacl（这是对象写进文件的内容）
 * com.demo.Io_Serializable.Person：表明反序列化接收对象
 * serialVersionUID 相当于算法密钥，进行内容解密，然后进行对象赋值
 */
public class Serializable {
	public static void main(String[] args) throws Exception {
		Person person = new Person();
        person.setName("但是");
        person.setAge(25);
        person.setSex("男");
		SerializePerson(person);//序列化Person对象
        Person p = DeserializePerson();//反序列化Perons对象
        System.out.println(MessageFormat.format("name={0},age={1},sex={2}",p.getName(), p.getAge(), p.getSex()));
	}
	
    /**
     * MethodName: SerializePerson 
     * Description: 序列化Person对象
     * @author xudp
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void SerializePerson(Person person) throws FileNotFoundException,
            IOException {
        // ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("E:/Person.txt")));
        oo.writeObject(person);
        System.out.println("Person对象序列化成功！");
        oo.close();
    }

    /**
     * MethodName: DeserializePerson 
     * Description: 反序列Perons对象
     * @author xudp
     * @return
     * @throws Exception
     * @throws IOException
     */
    private static Person DeserializePerson() throws Exception, IOException {
        @SuppressWarnings("resources")
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("E:/Person.txt")));
        Person person = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return person;
    }
}
