package ar.edu.unsl.model.definitions;

import ar.edu.unsl.engine.domain.abstracts.Agent;
import ar.edu.unsl.engine.domain.abstracts.Cell;
import ar.edu.unsl.engine.domain.abstracts.CellDefinition;

public class MyDef implements CellDefinition {
    private float fire;
    private float smoke;

    private int contadorTransitoAgentes;
    // se pretende con esta propiedad saber que tan frecuentemente han pasado los agentes por esta
    // celda.
    // con el objetivo de que finalizada la simulacion se pueda determinr los caminos/rutas mas
    // utilizados
    // a lo largo de la evacuacion. Esto nos permitira que dado un habiente sea posible a traves de
    // la simulacion informar
    // al cliente cuales serian las rutas mas utilizadas en una evacuacion con determinadas
    // acarateristicas.
    // Esto permiteria entonces modificar fisicamente el ambiente para facilitar la futura
    // evacuacion.

    @Override
    public void setUp(Agent agent) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setUp(Agent agent, Cell[] neighborhood) {
        // TODO Auto-generated method stub

    }

    @Override
    public void applyRule() {


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
