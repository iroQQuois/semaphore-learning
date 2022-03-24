package ru.iroqquois;


import ru.iroqquois.resource.MapData;
import ru.iroqquois.threads.handlers.FibonacciThreadHandler;

/**
 * Вычислить и вывести числа фибоначчи от 1 до N. Каждое число вычислить в отдельном потоке "с нуля".
 * Нужно использовать семафор. Одновременно должны работать не более M потоков.
 * В терминал вывести входное число, получившееся число Фибоначчи, а также время вычисления значения.
 *
 * Создать график зависимости времени выполнения (всей работы программы от 1 до N) от числа потоков
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        FibonacciThreadHandler handler = new FibonacciThreadHandler(10, 2);
        handler.start(10);

//        System.out.println(MapData.getInstance().getData().toString());

        // TODO: Вопрос, как получить доступ к Мапе после завершения потоков??
    }
}
