package dev.cerez;

import dev.cerez.command.Category;
import dev.cerez.command.Status;
import lombok.Data;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Data
public final class MedicalFormula {
    @NotNull private final String name;
    @NotNull private final Status status;
    @NotNull private final Category category;
    @NotNull private Boolean cancel = false;

    public MedicalFormula(
            String name,
            Status status,
            Category category
    ) {
        this.name = name;
        this.status = status;
        this.category = category;
    }

    public int codeFormula() {
        return hashCode();
    }

}
