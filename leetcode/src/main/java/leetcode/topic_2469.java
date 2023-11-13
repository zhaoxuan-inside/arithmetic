package leetcode;

/**
 * 给你一个四舍五入到两位小数的非负浮点数 celsius 来表示温度，以 摄氏度（Celsius）为单位。
 * <p>
 * 你需要将摄氏度转换为 开氏度（Kelvin）和 华氏度（Fahrenheit），并以数组 ans = [kelvin, fahrenheit] 的形式返回结果。
 * <p>
 * 返回数组 ans 。与实际答案误差不超过 10-5 的会视为正确答案。
 * <p>
 * 注意：
 * <p>
 * 开氏度 = 摄氏度 + 273.15
 * 华氏度 = 摄氏度 * 1.80 + 32.00
 */
@SuppressWarnings("unused")
public class topic_2469 {

    private final static double[] ANS = new double[2];

    public double[] convertTemperature(double celsius) {
        ANS[0] = celsius + 273.15;
        ANS[1] = celsius * 1.80 + 32.00;
        return ANS;
    }
}
