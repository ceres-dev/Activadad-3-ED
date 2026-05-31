package dev.cerez;

import dev.cerez.command.Category;
import dev.cerez.command.Status;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Data
public final class MedicalFormula {
    @NotNull private final String formulaMedica;
    @NotNull private final Category category;
    @NotNull private Status status = Status.PENDING;
    @Getter(AccessLevel.NONE)
    private Integer code = null;


    public MedicalFormula(
            @NotNull String formulaMedica,
            @NotNull Category category
    ) {
        this.formulaMedica = formulaMedica;
        this.category = category;
    }

    public int codeFormula() {
        return Objects.requireNonNullElse(code, code = hashCode());
    }

    public boolean isCancel() {
        return status == Status.CANCELLED;
    }

}
