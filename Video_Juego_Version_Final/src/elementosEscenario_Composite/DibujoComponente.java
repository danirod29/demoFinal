package elementosEscenario_Composite;

import java.awt.Graphics;

public interface DibujoComponente {
    //Permite crear nuevos elemenentos para (DibujoComposicion)
    public void agregarElementoComposicion(DibujoComponente miComposicion);
    //Permite crear clones
    public DibujoComponente clonarComponente();
}