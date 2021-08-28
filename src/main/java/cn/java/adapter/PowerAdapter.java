package cn.java.adapter;

/**
 * @author: Jiang
 * @createTime: 2021-07-04 11:29
 * @description:
 */
public class PowerAdapter extends AC220 implements DC5{
    @Override
    public int output5V() {
        int adapterInput = super.outputAC220();
        int adapterOutput = adapterInput/44;
        System.out.println("使用Adapter输入AC" + adapterInput + "V,输出"+adapterOutput+"V");
        return 0;
    }
}
