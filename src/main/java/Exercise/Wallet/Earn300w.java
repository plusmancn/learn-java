package Exercise.Wallet;

import java.math.BigDecimal;

/**
 * 任何东西都会回归数据的本质
 *
 * 假定月化收益 1%，初始本金 30w，每个月收入为 xW
 * 请问需要多久能够收益达到 300w
 * @author plusman
 * @since 2020/9/7
 */
public class Earn300w {
    public static void main(String[] args) {
        BigDecimal monthlyEarn = new BigDecimal("1.0");
        BigDecimal initialMoney = new BigDecimal("30.0");
        BigDecimal monthlyRate = new BigDecimal("1.01");

        BigDecimal target = new BigDecimal("300");
        BigDecimal nowMoney = initialMoney;

        int workMonths = 0;
        while ((target.subtract(nowMoney)).compareTo(BigDecimal.ZERO) >= 0) {
            BigDecimal preMoney = nowMoney;
            nowMoney = nowMoney.add(monthlyEarn);
            nowMoney = nowMoney.multiply(monthlyRate);
            workMonths++;

            System.out.println(
                String.format("第 %d 个月收入为 %s，当前收入为 %s",
                    workMonths,
                    (nowMoney.subtract(preMoney)).setScale(2, BigDecimal.ROUND_UP).toString(),
                    nowMoney.setScale(2, BigDecimal.ROUND_UP).toString()
                )
            );
        }

        System.out.println("以目前收入，你还需要工作：" + workMonths + " 月");
    }
}
