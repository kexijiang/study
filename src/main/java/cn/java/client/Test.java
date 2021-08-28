package cn.java.client;

/**
 * @author: Jiang
 * @createTime: 2021-07-01 22:12
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        KXMeipo kxo = new KXMeipo();
        IPerson zhangsan  = kxo.getInstance(new ZhangSan());
        zhangsan.findlove();
//        IPerson zhangsan = proxy.getInstance(new ZhangSan());
//        zhangsan.findlove();
    }
}
