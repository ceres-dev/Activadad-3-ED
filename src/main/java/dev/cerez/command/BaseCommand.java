package dev.cerez.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public abstract class BaseCommand {

    private final String name = this.getClass().getSimpleName().toLowerCase();

    public abstract void execute(List<String> arguments);

    protected @NotNull String format(String object) {
        return "| %s".formatted(object);
    }
}
