package dev.cerez;

import dev.cerez.command.HanderCommand;
import dev.cerez.command.commands.*;

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
                new Cancel(),
                new Execution(),
                new Filter(),
                new Find(),
                new Help(),
                new Register(),
                new SeeHistory(),
                new SeeList(),
                new SeePending(),
                new SeeSize(),
                new SeeStatistics(),
                new Sortd(),
                new Stop(),
                new UndoExecution()
        );

        String cmd = """
                register Alfa INTRADERMAL
                register Beta INTRADERMAL
                register Gamma INTRAVENOUS
                seeList
                execution
                execution
                seeList
                undoExecution
                seeList
                seePending
                find Beta
                Cancel 469768541
                SeeHistory
                SeePending
                undoExecution
                SeeHistory
                stop
                """;

        for (String s : cmd.split("\n")) HANDER.execution(s, true);

        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            String arg = scanner.nextLine();
            HANDER.execution(arg, false);
        }
    }

    public static void stop() {
        isRunning = false;
    }
}