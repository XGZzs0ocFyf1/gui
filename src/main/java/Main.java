import ru.gurzhiy.AppFrame;

import javax.swing.*;
//import java.awt.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        //1. Создать окно для клиентской части чата:
        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("My app");
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            BorderLayout borderLayout = new BorderLayout();
            frame.setLayout(borderLayout);

            var chat = new JTextArea(15, 20);
            chat.setBackground(new Color(190, 134, 243));

            var input = new JTextField(20);
            var sendButton = new JButton("send");

            sendButton.addActionListener(e -> {
                chat.setText(chat.getText() +"\n" +input.getText());
                input.setText("");
            });

            frame.add(chat, BorderLayout.NORTH);
            frame.add(input, BorderLayout.WEST);
            frame.add(sendButton, BorderLayout.EAST);
            frame.setVisible(true);

        });
    }

    //2. Напишите метод, который возвращает индекс первого вхождения данного целого числа в списке.

    public static int getFirstGivenIntegerIndex(Integer number, Integer[] list) {
        return IntStream.range(0, list.length)
                .filter(index -> number.equals(list[index]))
                .findFirst()
                .orElse(-1);
    }


    //   3 Напишите метод, переворачивающий строку.
    public static String reverse(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (a, b) -> b + a, (c, d) -> d + c);

        //   return new StringBuffer(input).reverse().toString();
    }

    //    4  Напишите метод, который возвращает наибольшее целое число в списке.
    public static Integer maximum(Integer[] list) {
        return Arrays.stream(list)
                .max((a,b) -> a.compareTo(b))
                .get();

    }

    //    5. Напишите метод, который возвращает среднее значение из списка целых чисел.
    public static Double average(List<Integer> list) {
        return list.stream().collect(Collectors.averagingDouble(Integer::intValue));
    }

    //Имея список строк, напишите метод, который возвращает список всех строк, которые начинаются с буквы «а» (нижний регистр) и имеют ровно 3 буквы.
    public static List<String> search(List<String> list) {
        return list.stream()
                .filter(s -> s.length() == 3)
                .filter(s -> s.charAt(0) == 'a')
                .collect(Collectors.toList());
    }


//    public static void main(String[] args) {
//        Integer[] input = {3, 2, 3, 4, 5, 6, 30, 3, 7, 8};
//        System.out.println(getFirstGivenIntegerIndex(3, input));
//        System.out.println(getFirstGivenIntegerIndex(2, input));
//        System.out.println(getFirstGivenIntegerIndex(11, input));
//
//        System.out.println(reverse("abcdef"));
//
//        System.out.println(maximum(input));
//
//        var ints = List.of(10, 10, 10, 50);
//        System.out.println(average(ints));
//
//        var words = List.of("average", "abb", "amo", "test", "angular", "time", "power");
//        System.out.println(search(words).size());
//        search(words).forEach(System.out::println);
//    }


}
