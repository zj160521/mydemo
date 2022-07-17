package com.demo.innerClass;

/**
 * @Description:
 * @Author: zhouj
 * @Date: 2019/7/31 10:39
 */
public interface StaticIOuter {
    static interface IInMsg{
        public String getMsg();
    }
    public void send(IInMsg inMsg);
}

class DefaultMsg implements StaticIOuter.IInMsg {
    public String getMsg() {
        return "static interface msg";
    }
}

class StaticIImpl implements StaticIOuter {
    public void send(IInMsg inMsg) {
        System.out.println(inMsg.getMsg());
    }
}
