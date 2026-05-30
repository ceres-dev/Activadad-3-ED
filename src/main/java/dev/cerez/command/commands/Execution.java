package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.MedicalFormula;
import dev.cerez.command.BaseCommand;
import dev.cerez.command.Status;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

// 4. Procesar siguiente elemento
public class Execution extends BaseCommand {
    @Override
    public void execute(List<String> arguments) {
        MedicalFormula medicalFormula = Objects.requireNonNull(Main.queue.poll());
        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1)); // Simular tiempo de procesamiento
        medicalFormula.setStatus(Status.COMPLETED);
        Main.deque.push(medicalFormula);
    }
}
