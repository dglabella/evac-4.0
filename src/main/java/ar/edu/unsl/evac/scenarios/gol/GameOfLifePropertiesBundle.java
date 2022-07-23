package ar.edu.unsl.evac.scenarios.gol;

import java.io.Serializable;
import ar.edu.unsl.evac.engine.domain.PropertiesBundle;

public class GameOfLifePropertiesBundle implements PropertiesBundle {

    private boolean alive;
    private boolean postAlive;

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isPostAlive() {
        return this.postAlive;
    }

    public void setPostAlive(boolean postAlive) {
        this.postAlive = postAlive;
    }
}
