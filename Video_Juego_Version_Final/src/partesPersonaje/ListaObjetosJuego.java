package partesPersonaje;

import java.awt.Image;
import java.util.ArrayList;

import elementosEscenario_Composite.DibujoComponente;
import elementosEscenario_Composite.DibujoEspecifico;

public class ListaObjetosJuego {
	//Atributos
    protected ArrayList<CodigoElemtoJuego> listaElementosJuego = new ArrayList<>();
    protected HerramientaPersonaje herramienta[];
    protected HabilidadPersonaje habilidad [];
    protected ArmaduraPersonaje armadura [];
    
    //Atributos
    public ListaObjetosJuego() {
    	this.asignarArmaduras();
    	this.asignarHabilidades();
    	this.asignarHerramientas();
    }
    
    //Asigna todos los elementos armadura para el juego
    public void asignarArmaduras() {
    	armadura = new ArmaduraPersonaje[2];
    	armadura[0] = new ArmaduraCaballeroOro();
    	listaElementosJuego.add(armadura[0]);
    	listaElementosJuego.add(armadura[0].clonarArmadura());
    }
    
    //Asigna todos los elementos Habiidades para el juego
    public void asignarHabilidades() {
    	habilidad = new HabilidadPersonaje[4];
    	habilidad[0] = new HabilidadMagoFuego(); 
    	habilidad[1] = new HabilidadMagoHielo();
    	habilidad[2] = new HabilidadArqueroMira();
    	habilidad[3] = new HabilidadCaballeroGolpeCritico();
    	
    	listaElementosJuego.add(habilidad[0]);
    	listaElementosJuego.add(habilidad[1]);
    	listaElementosJuego.add(habilidad[2]);
    	listaElementosJuego.add(habilidad[3]);
    	
    	
    	listaElementosJuego.add(habilidad[0].clonarHabilidad());
    	listaElementosJuego.add(habilidad[1].clonarHabilidad());
    	listaElementosJuego.add(habilidad[2].clonarHabilidad());
    	listaElementosJuego.add(habilidad[3].clonarHabilidad());
    	
    	listaElementosJuego.add(habilidad[0].clonarHabilidad());
    	listaElementosJuego.add(habilidad[1].clonarHabilidad());
    	listaElementosJuego.add(habilidad[2].clonarHabilidad());
    	listaElementosJuego.add(habilidad[3].clonarHabilidad());
    	
    	listaElementosJuego.add(habilidad[0].clonarHabilidad());
    	listaElementosJuego.add(habilidad[1].clonarHabilidad());
    	listaElementosJuego.add(habilidad[2].clonarHabilidad());
    }
	
    //Asigna todas las herramientas para el juego
    public void asignarHerramientas() {
    	herramienta = new HerramientaPersonaje[2];
    	herramienta[0] = new HerramientaArqueroDiamante();
    	
    	listaElementosJuego.add(herramienta[0]);
    	listaElementosJuego.add(herramienta[0].clonarHerramienta());
    }
    //--------------------------------------------

    //Retorna la lista con todos los elemtos del juego(Habilidades, herramientas, armaduras)
	public ArrayList<CodigoElemtoJuego> getLisHerramientas() {
		return listaElementosJuego;
	}
}
