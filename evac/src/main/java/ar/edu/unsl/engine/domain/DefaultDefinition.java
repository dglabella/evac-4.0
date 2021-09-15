package ar.edu.unsl.engine.domain;

import ar.edu.unsl.engine.domain.abstracts.CellDefinition;

public class DefaultDefinition implements CellDefinition {

    @Override
    public void applyRule() {
        // defaul definition does nothing here.
    }

    @Override
    public void update() {
        // defaul definition does nothing here.
    }

    @Override
    public String getCodification() {
        return "";
    }
}
