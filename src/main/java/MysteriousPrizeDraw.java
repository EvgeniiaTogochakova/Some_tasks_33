import toys.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;

import static java.lang.System.*;

/*
Необходимо написать проект, для розыгрыша в магазине игрушек. Функционал должен содержать
добавление новых игрушек и задания веса для выпадения игрушек. Необходимо разработать
класс в виде конструктора (id игрушки, текстовое название и частоту выпадения игрушки).
Из принятой строки id и частоты выпадения(веса) заполнить минимум три массива.
При добавлении элементов в коллекцию использовать java.util.PriorityQueue.
Приложение должно записывать значения в файл.
 */

public class MysteriousPrizeDraw {
    public static void main(String[] args) throws IOException {
        System.out.println("Для организации розыгрыша игрушек давайте сформируем ПЕРВЫЙ набор из 10 игрушек");
        ArrayList<Toy> toyFunList1 = new ArrayList<>(10);
        toyFunList1 = userCommunicationToFillArrayList(toyFunList1);

        String separ = "_".repeat(30);
        System.out.println(separ);
        System.out.println("А теперь давайте сформируем ВТОРОЙ набор из 10 игрушек");
        ArrayList<Toy> toyFunList2 = new ArrayList<>(10);
        toyFunList2 = userCommunicationToFillArrayList(toyFunList2);

        System.out.println(separ);
        System.out.println("Теперь ТРЕТИЙ набор из 10 игрушек");
        ArrayList<Toy> toyFunList3 = new ArrayList<>(10);
        toyFunList3 = userCommunicationToFillArrayList(toyFunList3);

        ArrayList<Toy> commonPrizeList = new ArrayList<>(30);
        commonPrizeList.addAll(toyFunList1);
        commonPrizeList.addAll(toyFunList2);
        commonPrizeList.addAll(toyFunList3);
        System.out.println(separ);
        System.out.println("Печатаю содержимое всех трех наборов!");
        for (var toy : commonPrizeList) {
            System.out.println(toy.getInfo());
        }

        PriorityQueue<Toy> prizePool = new PriorityQueue<>(commonPrizeList);

        int amount = getAmountPrizePool();
        System.out.println(amount);

        makePrizeDrawAndPrintList(amount, prizePool);

        System.out.println(separ);
        System.out.println("Готово! Можете даже распечатать результат (prizelist.txt)!");

    }


    public static ArrayList<Toy> userCommunicationToFillArrayList(ArrayList<Toy> toyFunList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Установите частоту выпадения для игрушек в процентах от 100 (кратно 10): ");
        System.out.print("для куклы Барби: ");
        String barbie = sc.nextLine();
        int barbieFreq = 0;
        try {
            if (checkFrequency(barbie)) {
                barbieFreq = Integer.parseInt(barbie);
            }
        } catch (NumberFormatException e) {
            System.out.println("Это не число!");
            exit(0);
        }

        System.out.print("для плюшевого медвежонка: ");
        String bear = sc.nextLine();
        int bearFreq = 0;
        try {
            if (checkFrequency(bear)) {
                bearFreq = Integer.parseInt(bear);
            }
        } catch (NumberFormatException e) {
            System.out.println("Это не число!");
            exit(0);
        }

        System.out.print("для робота-трансформера Спорткара: ");
        String sportscar = sc.nextLine();
        int sportscarFreq = 0;
        try {
            if (checkFrequency(sportscar)) {
                sportscarFreq = Integer.parseInt(sportscar);
            }
        } catch (NumberFormatException e) {
            System.out.println("Это не число!");
            exit(0);
        }


        System.out.print("для робота-трансформера Бамблби: ");
        String bumble = sc.nextLine();
        int bumbleFreq = 0;
        try {
            if (checkFrequency(bumble)) {
                bumbleFreq = Integer.parseInt(bumble);
            }
        } catch (NumberFormatException e) {
            System.out.println("Это не число");
            exit(0);
        }

        System.out.print("для конструктора Lego Рельсы: ");
        String lego = sc.nextLine();
        int legoFreq = 0;
        try {
            if (checkFrequency(lego)) {
                legoFreq = Integer.parseInt(lego);
            }
        } catch (NumberFormatException e) {
            System.out.println("Это не число");
            exit(0);
        }

        ArrayList<Toy> toyFunnyList = new ArrayList<>();
        if (barbieFreq + bearFreq + sportscarFreq + bumbleFreq + legoFreq == 100) {
            toyFunnyList = fillToyList(toyFunList, barbieFreq, bearFreq, sportscarFreq, bumbleFreq, legoFreq);
        } else {
            System.out.println("Не получается 100% в сумме либо где-то вводили значения, не кратные 10. Необходимо переназначить частоту выпадения игрушек!");
            exit(0);
        }

        System.out.println("Печатаю набор игрушек:");
        for (var i : toyFunnyList) {
            System.out.println(i.getInfo());
        }
        return toyFunnyList;

    }

    public static ArrayList<Toy> fillToyList(ArrayList<Toy> toyList, int barbieFre, int bearFre, int sportscarFre, int bumbleFre, int legoFre) {
        for (int i = 0; i < barbieFre / 10; i++) {
            toyList.add(new BarbieDoll(barbieFre));
        }
        for (int i = 0; i < bearFre / 10; i++) {
            toyList.add(new TeddyBear(bearFre));
        }
        for (int i = 0; i < sportscarFre / 10; i++) {
            toyList.add(new RobotSportscar(sportscarFre));
        }
        for (int i = 0; i < bumbleFre / 10; i++) {
            toyList.add(new RobotBumblebee(bumbleFre));
        }
        for (int i = 0; i < legoFre / 10; i++) {
            toyList.add(new LegoCityTrains(legoFre));
        }
        return toyList;
    }

    public static boolean checkFrequency(String str) {
        return Integer.parseInt(str) % 10 == 0;
    }

    public static int getAmountPrizePool() {
        String separ = "_".repeat(40);
        Scanner scanner = new Scanner(System.in);
        System.out.println(separ);
        System.out.println("Готовы начать РОЗЫГРЫШ ПРИЗОВ?! У нас 30 призов, сколько будем разыгрывать? Ваш ответ: ");
        String amount = scanner.nextLine();
        int count;
        try {
            count = Integer.parseInt(amount);
            if (count < 1 || count > 30) {
                System.out.println("Понимаю, вы волнуетесь. Значит, просто разыграем ВСЕ призы!");
                count = 30;
            }
        } catch (NumberFormatException e) {
            System.out.println("ОК, хоть вы и ошиблись при вводе, полагаю, вы хотите разыграть ВСЕ 30!");
            count = 30;
        }
        scanner.close();
        return count;
    }

    public static Toy getPrize(PriorityQueue<Toy> priorityQueue) {
        return priorityQueue.poll();
    }

    public static void makePrizeDrawAndPrintList(int amountPrizes, PriorityQueue<Toy> priorityQueue ){
        try (FileWriter fw = new FileWriter("prizelist.txt", false)) {
            fw.write("СПИСОК ИГРУШЕК ДЛЯ ПОБЕДИТЕЛЕЙ: " + amountPrizes + "\n");
            for (int i = 0; i < amountPrizes; i++) {
                Toy finalToy = getPrize(priorityQueue);
//                fw.write(finalToy.getInfo());
                fw.write(finalToy.getToyName());
                fw.append('\n');
                fw.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
