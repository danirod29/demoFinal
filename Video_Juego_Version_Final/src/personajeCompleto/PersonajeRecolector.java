package personajeCompleto;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import PersonajeObervadoresRecolectores.ObservadorRecolector;
import controlador.EventoTeclado;
import partesPersonaje.CodigoElemtoJuego;
import personajeEstados.PersonajeEstadoVisual;
import personajeOrdenarConstruccion.BuilderRecolector;
import personajeOrdenarConstruccion.Director;
import vistas.PanelBosque;

public class PersonajeRecolector extends PersonajeAnimado{
	//Atributos
	
	private String laberinto[][];
	
	private PersonajeAnimado perSonajeRey;
	private PersonajeEstadoVisual imgEstadoVisual = null;
	
	private ArrayList<CodigoElemtoJuego> listaCodigos;
	private ArrayList<ObservadorRecolector> listObservadores = new ArrayList<ObservadorRecolector>();
	
	
	//Constructor
	public void PersonajeRecolector() {	
	}
	
	//Asigna los dato del personaje
	@Override
	public void asignarDatos() {
		this.oficio = "Recolector";
	}
	
	//Asigna la imagen del personaje en tiempode ejecución (Estado)
	public void asignarEstadoImg(PersonajeEstadoVisual imgEstadoVisual) {
		this.imgEstadoVisual = imgEstadoVisual;
	}
	
	//Retorna la img del personaje
	@Override
	public Image imgPersonaje() {
		return imgEstadoVisual.asignarImagen();
	}
	
	//Registra los observadores para el reyA y el reyB
	public void registrarObservadores(ObservadorRecolector obServador) {
		listObservadores.add(obServador);
	}
	
	//Permite tomar los elementos del escenario (habilidades, herramientas o armaduras)
	public PersonajeAnimado realizarAccion(PersonajeAnimado rey) {
		perSonajeRey = rey;
		int acumulador = 0;
		
		if(EventoTeclado.TOMARobjA || EventoTeclado.TOMAobjS) {
			if((laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)-1] != "0" ) && (laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)-1] != "1")) {
				acumulador = 1;
			}else if((laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)+1] != "0" ) && (laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)+1] != "1")) {
				acumulador = -1;
			}
			//Recorre la lista de los elementos del juego y la matriz del tablero
			for(int i=0; i<listaCodigos.size(); i++) {
				if(laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)-acumulador] == listaCodigos.get(i).retornarCodigo()){
					this.ejecutarAccion(rey, listaCodigos.get(i));
					
					//remueve el elemento de la lista de elementos del juego
					listaCodigos.remove(i);
				}
			
			}
			//Cambia el campo de la matriz del tablero
			laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)-acumulador] = "0"; 
		}
		return perSonajeRey;
	}	
	
	//Notifica a los diferentes observadores
	public void ejecutarAccion(PersonajeAnimado rey, CodigoElemtoJuego codigo) {
		//Notifica al observador para el reyA
		if(PanelBosque.retornarTurno()) {
		
			listObservadores.get(0).notificar(rey, codigo);
			//Retorna al reyA con las nuevas caracteristicas adquiridas 
			perSonajeRey =  listObservadores.get(0).retornarNuevoEstado();
			
			
			//Notifica al observador para el reyB
		}else if(PanelBosque.retornarTurno() == false){
			
			listObservadores.get(1).notificar(rey, codigo);
			//Retorna al reyB con las nuevas caracteristicas adquiridas
			perSonajeRey = listObservadores.get(1).retornarNuevoEstado();
			
		}
		
		PanelBosque.asignarTurno(!PanelBosque.retornarTurno());
	}
	
	//Permite realizar el desplazamiento del personaje
	@Override
	public void asignarDesplazamiento() {
		if(EventoTeclado.DERECHA) {
			if(laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)+1] == "0") {
				posicionX = posicionX + desPlazamiento;
			}
		}
		if(EventoTeclado.IZQUIERDA==true) {
			if(laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)-1] == "0") {
				posicionX = posicionX - desPlazamiento;
			}
		}
		if(EventoTeclado.ABAJO) {
			if(laberinto[(posicionY/desPlazamiento)+1][(posicionX/desPlazamiento)] == "0") {
				posicionY = posicionY + desPlazamiento;
			}
			
		}
		if(EventoTeclado.ARRIBA) {
			if(laberinto[(posicionY/desPlazamiento)-1][(posicionX/desPlazamiento)] == "0") {
				posicionY = posicionY - desPlazamiento;
			}
		}
	}
	
	
	
	//Metodos(Getter and setter)
	//---------------------------------------------------------------------------------------------
	public String[][] getLaberinto() {
		return laberinto;
	}

	public void setLaberinto(String[][] laberinto) {
		this.laberinto = laberinto;
	}

	public ArrayList<CodigoElemtoJuego> getListaCodigos() {
		return listaCodigos;
	}

	public void setListaCodigos(ArrayList<CodigoElemtoJuego> listaCodigos) {
		this.listaCodigos = listaCodigos;
	}
	
	//Clones personaje
	@Override
	public PersonajeAnimado clonarPersonaje() {
		PersonajeAnimado miClonRecolector;
        //Se Determinan las partes del Mago
        Director miDirector = new Director();
        BuilderRecolector miBuilderRecolector = new BuilderRecolector();
        miDirector.construir(miBuilderRecolector);
        //Se instancia el objeto para que sea Mago
        miClonRecolector = miBuilderRecolector.obtenerPerAnimado();
        //Metodos que reciben parametros   
		return miClonRecolector;
	}

	@Override
	public void realizarAccion() {
	}
}
