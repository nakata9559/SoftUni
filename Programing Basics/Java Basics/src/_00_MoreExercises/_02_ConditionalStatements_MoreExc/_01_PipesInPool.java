package _00_MoreExercises._02_ConditionalStatements_MoreExc;

import java.util.Scanner;

public class _01_PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първият ред съдържа числото V – Обем на басейна в литри – цяло число в интервала [1…10000].
        //•	Вторият ред съдържа числото P1 – дебит на първата тръба за час – цяло число в интервала [1…5000].
        //•	Третият ред съдържа числото P2 – дебит на втората тръба за час– цяло число в интервала [1…5000].
        //•	Четвъртият ред съдържа числото H – часовете които работникът отсъства – реално число в интервала [1.0…24.00]

        int volume = Integer.parseInt(scanner.nextLine());
        int pipeOne = Integer.parseInt(scanner.nextLine());
        int pipeTwo = Integer.parseInt(scanner.nextLine());
        double hours = Double.parseDouble(scanner.nextLine());

        //Да се отпечата на конзолата едно от двете възможни състояния:
        //•	До колко се е запълнил басейна и коя тръба с колко процента е допринесла.
        //o	"The pool is {запълненост на басейна в проценти}% full. Pipe 1: {процент вода от първата тръба}%. Pipe 2: {процент вода от втората тръба}%."
        //Aко басейнът се е препълнил – с колко литра е прелял за даденото време.
        //o	"For {часовете, които тръбите са пълнили вода} hours the pool overflows with {литрите вода в повече} liters."

        double fillPercentage = ((pipeOne + pipeTwo) * hours) / volume * 100;
        double fillPipeOne =  (pipeOne * hours) / ((pipeOne + pipeTwo) * hours) * 100;
        double fillPipeTwo = (pipeTwo * hours) / ((pipeOne + pipeTwo) * hours) * 100;
        double overflown = (pipeOne + pipeTwo) * hours - volume;

        if (volume >= (pipeOne + pipeTwo) * hours) {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%.Pipe 2: %.2f%%.", fillPercentage, fillPipeOne, fillPipeTwo);

        } else {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", hours, overflown);
        }

    }
}
