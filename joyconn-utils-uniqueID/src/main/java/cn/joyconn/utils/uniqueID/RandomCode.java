package cn.joyconn.utils.uniqueID;
/**
 * Created by Eric.Zhang on 2017/4/1.
 */
public class RandomCode {
    /** 自定义进制(0,1没有加入,容易与o,l混淆) */
    private static final char[] GENERATE_SOURCE=new char[]{'Q', 'W', 'E', '8', 'A', 'S', '2', 'D', 'Z', 'X', '9', 'C', '7', 'P', '5',  'K', '3', 'M', 'J', 'U', 'F', 'R', '4', 'V', 'Y',  'T', 'N', '6', 'B', 'G', 'H'};

    /** (不能与自定义进制有重复) */
    private static final char B='o';
    /** 进制长度 */
    private static final int BIN_LEN=GENERATE_SOURCE.length;
    public static String generateRandomStr(int len) {
        String rtnStr = "";
        for (int i = 0; i < len; i++) {
            //循环随机获得当次字符，并移走选出的字符
            String nowStr = String.valueOf(GENERATE_SOURCE[((int) Math.floor(Math.random() * GENERATE_SOURCE.length))]);
            rtnStr += nowStr;
        }
        return rtnStr;
    }
}
