import java.util.Scanner;

public class DepositCalculator {
    private static final int PLACES = 2;

    private double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round(pay);
    }

    private double calculateSimplePercent(double amount, double yearRate, int period) {
        return round(amount + amount * yearRate * period);
    }

    private double round(double value) {
        double scale = Math.pow(10, PLACES);
        return Math.round(value * scale) / scale;
    }

    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Введите процентную ставку по вкладу:");
        double yearRate = scanner.nextDouble();
        System.out.println("Выберите тип вклада:");
        System.out.println("1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();
        double newAmount = 0;
        if (action == 1) {
            newAmount = calculateSimplePercent(amount, yearRate, period);
        } else if (action == 2) {
            newAmount = calculateComplexPercent(amount, yearRate, period);
        }
        System.out.println("Результат вклада: " + amount + " за " +
                period + " лет превратятся в " + newAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculate();
    }
}
