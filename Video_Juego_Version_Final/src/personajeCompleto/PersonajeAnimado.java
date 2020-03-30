package personajeCompleto;

import java.awt.Image;

import partesPersonaje.ArmaduraPersonaje;
import partesPersonaje.HabilidadPersonaje;
import partesPersonaje.HerramientaPersonaje;
import personajeEstados.PersonajePoder;
import plantillas.PlantillaCreacionImagenes;

public abstract class PersonajeAnimado {
	//Atributos
	
	public String oficio;
	protected int nivelDeVida;
	public int experiencia = 0;
	public int posicionX = 0;
	public int posicionY = 0;
	protected int acumulador=1;
	
	public final int desPlazamiento = 50;
	
	protected ArmaduraPersonaje armaduraPer;
	protected HerramientaPersonaje herramientaPer;
	protected HabilidadPersonaje habilidadPer;
	
	public PlantillaCreacionImagenes imgPerAni = new PlantillaCreacionImagenes();

	private PersonajePoder poderActual;
	
	
	//Constructor
	public PersonajeAnimado() {
		
	}
	
	//Metodos
	
	 //Se instancian las partes del personaje
	//------------------------------------------------------------------------ 
    public void asigArmadura(ArmaduraPersonaje armaduraPer){
        this.armaduraPer = armaduraPer;
        if(armaduraPer!=null) {
        	experiencia = experiencia + armaduraPer.dagno;
        }
    }
    
    public void asigHerramienta(HerramientaPersonaje herramientaPer){
        this.herramientaPer = herramientaPer;
        if(herramientaPer!=null) {
        	experiencia = experiencia + herramientaPer.dagno;
        }
    }
    
    public void asigHabilidad(HabilidadPersonaje habilidadPer){
        this.habilidadPer = habilidadPer;
        if(habilidadPer!=null) {
        	experiencia = experiencia + habilidadPer.dagno;
        }
    }
    //---------------------------------------------------------------------------
    
    //Asigna el poder del personaje
    public void asignarPoderActual(PersonajePoder poderActual) {
    	this.poderActual = poderActual;
    }
    
    //Retorna la imagen de la habilidad, herramienta o armadura utilizada por el personaje
    public Image realizarPoderActual() {
    	return poderActual.retornarPoder();
    }
    
    //Retorna el estado del poder(Si actualmente esta realizando alguno)
    public boolean retornarEstadoPoder() {
    	if(poderActual==null) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    //Asigna la posicion del personaje actual
    public  void asignarDesplazamiento(int posicionX, int posiciony) {
    	this.posicionX = posicionX;
    	this.posicionY = posiciony;
    }
    
    public Image mostrarMuerte(String imgMuerte) {
		this.imgPerAni.numImg = "";
		this.imgPerAni.setNombreImg(imgMuerte);
		return imgPerAni.getImagenMov2(); 
    }	
    
    public abstract void realizarAccion();
    public  abstract void asignarDesplazamiento();
    public abstract PersonajeAnimado clonarPersonaje();
    public abstract Image imgPersonaje();
    public abstract void asignarDatos();

	//Metodos getters
	public ArmaduraPersonaje getArmaduraPer() {
		return armaduraPer;
	}

	public HerramientaPersonaje getHerramientaPer() {
		return herramientaPer;
	}
	
	public HabilidadPersonaje getHabilidadPer() {
		return habilidadPer;
	}	
	

}
