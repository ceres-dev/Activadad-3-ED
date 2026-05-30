package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.MedicalFormula;
import dev.cerez.command.BaseCommand;
import dev.cerez.command.Status;

import java.util.List;

public class UndoExecution extends BaseCommand {
    @Override
    public void execute(List<String> arguments) {
        MedicalFormula ultimo = Main.deque.pop();
        ultimo.setStatus(Status.PENDING);
        Main.queue.offer(ultimo);
    }
}
