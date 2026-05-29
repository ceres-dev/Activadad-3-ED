package dev.cerez;

import dev.cerez.command.HanderCommand;
import dev.cerez.command.commands.Help;
import dev.cerez.command.commands.Register;
import dev.cerez.command.commands.SeeList;
import dev.cerez.command.commands.Stop;

import java.util.*;

public class Main {

    public static final HanderCommand HANDER = new HanderCommand();

    public static final List<MedicalFormula> list = new ArrayList<>();
    public static final Queue<MedicalFormula> queue = new LinkedList<>();
    public static final Deque<MedicalFormula> deque = new ArrayDeque<>();
    public static final Map<Integer, MedicalFormula> map = new HashMap<>();


    private static boolean isRunning = true;

    public static void main(String[] args) {

        HANDER.register(
                new Help(),
                new Register(),
                new SeeList(),
                new Stop()
        );

        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            String arg = scanner.nextLine();
            HANDER.execution(arg);
        }
    }

    public static void stop() {
        isRunning = false;
    }
}