
public class Calculator {
      // Метод для суммирования двух чисел
      public double add(double a, double b) {
        return a + b;
    }

    // Метод для вычитания двух чисел
    public double subtract(double a, double b) {
        return a - b;
    }

    // Метод для умножения двух чисел
    public double multiply(double a, double b) {
        return a * b;
    }

    // Можете добавить больше методов при необходимости, например, деление
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider cannot be 0");
        }
        return a / b;
    }
    
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        // Тестовые вызовы
        System.out.println("3 + 4 = " + calculator.add(3, 4));
        System.out.println("5 - 2 = " + calculator.subtract(5, 2));
        System.out.println("6 * 7 = " + calculator.multiply(6, 7));
        System.out.println("8 / 2 = " + calculator.divide(8, 2));
    }
    
}

ПЕТЯ ХЕ-ХЕ-ХЕ 