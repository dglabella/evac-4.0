package ar.edu.unsl.model.definitions;

import ar.edu.unsl.engine.domain.abstracts.Cell;
import ar.edu.unsl.engine.domain.abstracts.CellDefinition;

public class Grass extends Cell implements CellDefinition {

    private float dryness;

    public Grass(CellDefinition definition) {
        super(definition);
    }

    public float getDryness() {
        return this.dryness;
    }

    public void setDryness(float dryness) {
        this.dryness = dryness;
    }

    @Override
    public void applyRule() {
        // TODO Auto-generated method stub

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCodification() {
        // TODO Auto-generated method stub
        return null;
    }
}
