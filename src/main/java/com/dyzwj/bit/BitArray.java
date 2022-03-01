package com.dyzwj.bit;


import java.util.Arrays;

/**
 * int实现bit数组
 */
public class BitArray {


    public static final int TRUE = 1;
    public static final int FALSE = 0;

    protected final int BYTE_SHIFT = 3;

    //存储数据的字节数组 1byte = 8bit
    protected final byte[] bitmap;
    //最大位数
    protected final int size;
    public BitArray() {
        this(8, FALSE);
    }

    public BitArray(int size) {
        this(size, FALSE);
    }

    public BitArray(byte[] bitmap) {
        this.bitmap = Arrays.copyOf(bitmap, bitmap.length);
        size = bitmap.length * 8; // length << BYTE_SHIFT
    }

    /**
     *
     * @param size
     * @param value：1 - 将所有的位设置为1
     */
    public BitArray(int size, int value) {
        //bit转为字节
        int bytes = (int) Math.ceil((double) size / 8);//number of bytes
        bitmap = new byte[bytes];
        this.size = size;
        if (value == TRUE)
            for (int i = 0; i < size; i++)
                set(i);
    }

    //设置position位为1
    public void set(int position) {
        if (position > size ) {
            return;
        }




    }


}
