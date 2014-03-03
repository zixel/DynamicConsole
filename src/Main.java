import java.io.Console;
import java.io.IOException;

/**
 * Developed by Gennady Ma.
 * zixel@me.com
 * zixel.github.io
 */

public class Main {
    public static void main(String[] args){

        if(System.console() == null){
            System.out.println("Found not supported environment.");
            System.out.println("Don't use IDE to run.");
            System.exit(0);
        }

        try {
            printProgress();
        } catch (InterruptedException e) {
            System.out.println("======ERROR======");
            e.printStackTrace();
            System.out.println("======ERROR======");
        }
    }

    public static void printProgress() throws InterruptedException {
        /**
         * Динамический вывод информации в консоль
         * \u0008 – backspace
         *
         * Пример вывода консольного прогресс-бара
         */

        Console console = System.console();
        String progressBar = "Progress :: [--------------------] [0 %]";
        System.out.print(progressBar);

        //Кол-во процентов загрузки для самого прогресс-бара
        int procValue;

        for(int proc = 1; proc <= 100; proc++){
            Thread.sleep(100);
            procValue = (int) (proc * 0.2) + 1;

            //Обновляем прогресс бар
            for(int o = 0; o <= progressBar.length() + 2; o++)
                console.printf("%s", "\u0008");

            String progress = "";

            for(int o = 0; o < procValue; o++)
                progress += "=";

            for(int o = 20 - procValue; o >= 0; o--)
                progress += "-";

            console.printf("Progress :: [%s] [%s]", progress, proc + " %");
        }
        System.out.println();
    }

}
