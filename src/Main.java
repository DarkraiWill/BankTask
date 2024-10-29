//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Date;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Создаем массив из 10 банковских счетов
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 10000); // Идентификатор от 0 до 9 и начальный баланс 10 000 рублей
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите идентификатор счета (0-9): ");
            int id = scanner.nextInt();

            // Проверяем корректность введенного id
            if (id < 0 || id >= accounts.length) {
                System.out.println("Некорректный идентификатор. Пожалуйста, попробуйте снова.");
                continue;
            }

            // Главное меню
            while (true) {
                System.out.println("\nГлавное меню:");
                System.out.println("1. Просмотреть текущий баланс");
                System.out.println("2. Снять деньги со счета");
                System.out.println("3. Внести деньги на счет");
                System.out.println("4. Выйти из основного меню");
                System.out.print("Выберите пункт меню: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Просмотр текущего баланса
                        System.out.printf("Текущий баланс счета %d: %.2f рублей%n", accounts[id].getId(), accounts[id].getBalance());
                        break;
                    case 2:
                        // Снятие денег со счета
                        System.out.print("Введите сумму для снятия: ");
                        double withdrawAmount = scanner.nextDouble();
                        accounts[id].withdraw(withdrawAmount);
                        break;
                    case 3:
                        // Внесение денег на счет
                        System.out.print("Введите сумму для внесения: ");
                        double depositAmount = scanner.nextDouble();
                        accounts[id].deposit(depositAmount);
                        break;
                    case 4:
                        // Выход из основного меню
                        System.out.println("Выход из основного меню.");
                        break;
                    default:
                        System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
                }

                // Если выбрано 4, выходим из внутреннего меню
                if (choice == 4) {
                    break;
                }
            }
}

        }
    public static class Account {
        private int id = 0; // Идентификатор счета
        private double balance = 0; // Остаток счета
        private static double annualInterestRate = 0; // Годовая процентная ставка
        private Date dateCreated; // Дата создания счета

        // Безаргументный конструктор
        public Account() {
            this.dateCreated = new Date(); // Устанавливаем дату создания счета на текущую дату
        }

        // Конструктор с параметрами
        public Account(int id, double balance) {
            this.id = id;
            this.balance = balance;
            this.dateCreated = new Date(); // Устанавливаем дату создания счета на текущую дату
        }

        // Getter и setter для id
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        // Getter и setter для balance
        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        // Getter и setter для annualInterestRate
        public static double getAnnualInterestRate() {
            return annualInterestRate;
        }

        public static void setAnnualInterestRate(double annualInterestRate) {
            Account.annualInterestRate = annualInterestRate;
        }

        // Getter для dateCreated
        public Date getDateCreated() {
            return dateCreated;
        }

        // Метод для получения ежемесячного процента
        public double getMonthlyInterest() {
            return (annualInterestRate / 100) / 12 * balance;
        }

        // Метод для снятия суммы со счета
        public void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Недостаточно средств для снятия.");
            }
        }

        // Метод для пополнения счета
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Сумма пополнения должна быть положительной.");
            }
        }
    }

}
