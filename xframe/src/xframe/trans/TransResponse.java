package xframe.trans;

import java.io.Serializable;

/**
 * 通信协议返回值
 *
 * @author zhangqiang
 * @version 2014-07-31 10:13:28
 */
public class TransResponse implements Serializable
{
    private String ret;
    private String msg;
    private String value;
	public String getRet()
    {
        return ret;
    }

    public void setRet(String ret)
    {
        this.ret = ret;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
