package xframe.codec;

import java.util.zip.CRC32;

/**
 * CRC32方法，支持文件内容和字符串
 *
 * @author : zhangqiang
 * @version : 2014-8-19 10:34
 */
public class CrcUtils
{
    public static long encode(String data)
    {
        return encode(data.getBytes());
    }

    public static long encode(byte[] data)
    {
        CRC32 crc = new CRC32();
        crc.update(data);
        return crc.getValue();
    }
}
