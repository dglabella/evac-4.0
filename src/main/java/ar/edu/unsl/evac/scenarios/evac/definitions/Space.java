package ar.edu.unsl.evac.scenarios.evac.definitions;

import java.util.List;
import ar.edu.unsl.evac.engine.domain.Agent;
import ar.edu.unsl.evac.engine.domain.CellDefinition;
import ar.edu.unsl.evac.scenarios.evac.definitions.elements.Fire;
import ar.edu.unsl.evac.scenarios.evac.definitions.elements.Smoke;

public class Space implements CellDefinition {

    private int sizeFactorNeighborhood = 1;
    private boolean isModularNeighborhood = false;

    private Fire fire;
    private Smoke smoke;

    public Space() {
        this.fire = new Fire();
        this.smoke = new Smoke();
    }

    // =========================== getters and setters ===========================
    public int getSizeFactorNeighborhood() {
        return this.sizeFactorNeighborhood;
    }

    public void setSizeFactorNeighborhood(int sizeFactorNeighborhood) {
        this.sizeFactorNeighborhood = sizeFactorNeighborhood;
    }

    public boolean isIsModularNeighborhood() {
        return this.isModularNeighborhood;
    }

    public void setIsModularNeighborhood(boolean isModularNeighborhood) {
        this.isModularNeighborhood = isModularNeighborhood;
    }

    // @Override
    // public List<int[]> setUpNeighborhood(int i, int j, int width, int height) {
    // try {
    // return Neighborhood.Moore(i, j, this.sizeFactorNeighborhood, width, height,
    // this.isModularNeighborhood);
    // } catch (Exception e) {
    // e.printStackTrace();
    // return null;
    // }
    // }
}
