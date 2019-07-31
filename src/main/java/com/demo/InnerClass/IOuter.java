package com.demo.InnerClass;

/**
 * @Description:
 * @Author: zhouj
 * @Date: 2019/7/31 9:53
 */
public interface IOuter {
    public void send(IMsg msg);
    interface IMsg{
        public String getMsg();
    }
    class InOuterImpl implements IOuter{
        public void send(IMsg msg) {
            System.out.println("normal class");
        }
    }
    public static InOuterImpl getInstance() {
        return new InOuterImpl();
    }
}

class OuterImpl implements IOuter {
    public void send(IMsg msg) {
        System.out.println("消息：" + msg.getMsg());
    }

    class MsgImpl implements IMsg {
        public String getMsg() {
            return "inner interface";
        }
    }
}
