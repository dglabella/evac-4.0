package ar.edu.unsl.evac.scenarios.gol;

import java.io.Serializable;
import java.util.List;
import ar.edu.unsl.evac.engine.domain.Agent;
import ar.edu.unsl.evac.engine.domain.CellDefinition;
import ar.edu.unsl.evac.engine.domain.PropertiesBundle;
import ar.edu.unsl.evac.engine.utils.Loc;
import ar.edu.unsl.evac.engine.utils.Neighborhood;

public class GameOfLifeDefinition implements CellDefinition {

    private GameOfLifePropertiesBundle propertiesBundle;

    public GameOfLifeDefinition() {}

    public GameOfLifeDefinition(GameOfLifePropertiesBundle propertiesBundle) {
        this.propertiesBundle = propertiesBundle;
    }

    @Override
    public PropertiesBundle getPropertiesBundle() {
        return (PropertiesBundle) this.propertiesBundle;
    }

    @Override
    public List<Loc> setUpNeighborhood(int i, int j, int width, int height) {
        try {
            return Neighborhood.Moore(i, j, 1, width, height, false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CellDefinition applyRule(int i, int j, Agent agent, List<PropertiesBundle> neighbors) {
        int neighborsAlive = 0;

        for (PropertiesBundle propertiesBundle : neighbors) {
            if (((GameOfLifePropertiesBundle) propertiesBundle).isAlive())
                neighborsAlive++;
        }

        if (this.propertiesBundle.isAlive()) {
            this.propertiesBundle
                    .setPostAlive((neighborsAlive == 2 || neighborsAlive == 3) ? true : false);
        } else {
            this.propertiesBundle.setPostAlive(neighborsAlive == 3 ? true : false);
        }

        return null;
    }

    @Override
    public void update() {
        this.propertiesBundle.setAlive(this.propertiesBundle.isPostAlive());
    }

    @Override
    public String getCodification() {
        return this.propertiesBundle.isAlive() ? " # " : "   ";
    }

    @Override
    public int typeId() {
        // TODO Auto-generated method stub
        return 0;
    }
}
