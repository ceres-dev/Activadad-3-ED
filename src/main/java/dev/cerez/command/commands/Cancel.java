package dev.cerez.command.commands;

import dev.cerez.Main;
import dev.cerez.MedicalFormula;
import dev.cerez.command.BaseCommand;
import dev.cerez.command.Status;

import java.util.List;
import java.util.Objects;

public class Cancel extends BaseCommand {
    @Override
    public void execute(List<String> arguments) {
        MedicalFormula medicalFormula = Objects.requireNonNull(
                Main.map.getOrDefault(Integer.parseInt(arguments.getFirst()), null)
        , "El elemento no existe");

        if (medicalFormula.getStatus() == Status.PENDING) {
            medicalFormula.setStatus(Status.CANCELLED);
        }else {
            throw new IllegalStateException("Solo se pueden cancelar elementos pendientes.");
        }
    }
}
