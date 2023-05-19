

// я сделал 2 в 1, прокоментировал каждый шаг, как полагаю и требуется
public class add_3_numbers {
    public static void main(String[] args) {
        int sum = add(2, 3, 5); // задаем числа -> получаем число

        System.out.println(sum); // виводин в консоль
    }

    // функция складывания 3-ёх чисел
    public static int add(int int1, int int2, int int3) { // передаем 3 числа

        int sum; // объявляем куда записывать числа, потому что java
        sum = int1 + int2 + int3; // складываем 3 числа
        return sum; // возваращаем их сумму
    }
}
