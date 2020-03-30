package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import PersonajeObervadoresRecolectores.ObservadorRecolector;
import PersonajeObervadoresRecolectores.ObservadorReyA;
import PersonajeObervadoresRecolectores.ObservadorReyB;
import elementosEscenario_Composite.DibujoComponente;
import elementosEscenario_Composite.DibujoComposicion;
import elementosEscenario_Composite.DibujoComposicionBosque;
import elementosEscenario_Composite.DibujoEspecifico;
import elementosEscenario_Composite.DibujoEspecificoArbol;
import partesPersonaje.ArmaduraPersonaje;
import partesPersonaje.CodigoElemtoJuego;
import partesPersonaje.HabilidadMagoFuego;
import partesPersonaje.HabilidadPersonaje;
import partesPersonaje.HerramientaPersonaje;
import partesPersonaje.ListaObjetosJuego;
import personajeCompleto.PersonajeAnimado;
import personajeCompleto.PersonajeRecolector;
import personajeCompleto.PersonajeRey;
import personajeEstados.PersonajeEstadoVisual;
import personajeEstados.PersonajeEstadoVisualRecolectorA;
import personajeEstados.PersonajeEstadoVisualRecolectorB;
import personajeEstados.PersonajePoder;
import personajeOrdenarConstruccion.BuilderRecolector;
import personajeOrdenarConstruccion.BuilderRey;
import personajeOrdenarConstruccion.Director;
import personajeRecubridor_Decorador.ReyMago;
import plantillas.PlantillaCreacionImagenes;

public class PanelBosque extends JPanel{
	//Atributos
	
	//Para Laberinto
	private int fila;
	private int columna;
	private final int numFilas = 10;
	private final int numColumnas = 11;
	private int ancho = 40, alto = 40;
	private String laberinto[][];
	private String mensajeFinal;
	private Font mifuente;
	
	private ListaObjetosJuego lisObjJuego;
	private ArrayList<DibujoEspecifico> miElementosBosque; 
	private ArrayList<CodigoElemtoJuego> listaCodigos; 
	
	private int acumuladorLista = 0;
	private int acumuladorLista2 = 0;
	
	//Elementos necesarios para crear un bosque
	DibujoComposicion miComposicionBosque;
	
	//para recolector
	private BuilderRecolector ordenRecolector = new BuilderRecolector();
	private Director directorRecolector = new Director();
	private PersonajeAnimado miPersonajeAnimado = null;
	
	
	//Para reyes
	private PersonajeAnimado miPerRey = null;
	private PersonajeAnimado miClonRey = null;
	private BuilderRey ordenRey = new BuilderRey();
	private ObservadorRecolector mensajeroReyA;
	private ObservadorRecolector mensajeroReyB;
	private PersonajePoder poder;
	
	
	private static boolean TURNOREY = true;
	
	//Constructor
	public PanelBosque() {
		miComposicionBosque = new DibujoComposicionBosque();
		miElementosBosque = miComposicionBosque.getElementosDibujo();
		lisObjJuego = new ListaObjetosJuego();
		
		//.......................................................
		//Para personajes
		//Orden de como se construiran las partes del personaje-animado 
		directorRecolector.construir(ordenRecolector);
		//Retorna el personaje-animado con sus respectivas partes
		miPersonajeAnimado = ordenRecolector.obtenerPerAnimado();
		miPersonajeAnimado.asignarDesplazamiento(250, 250);
		laberinto = obtieneLaberinto();
		listaCodigos = lisObjJuego.getLisHerramientas();
		
		//.......................................................
		directorRecolector.construir(ordenRey);
		miPerRey = ordenRey.obtenerPerAnimado();
		miPerRey.asignarDesplazamiento(250, 50);
		miPerRey.asignarDatos();
		miClonRey = miPerRey.clonarPersonaje();	
		
		//........................................................
		mensajeroReyA = new ObservadorReyA();
		mensajeroReyB = new ObservadorReyB();
		((PersonajeRecolector)miPersonajeAnimado).registrarObservadores(mensajeroReyA);
		((PersonajeRecolector)miPersonajeAnimado).registrarObservadores(mensajeroReyB);
		
		mifuente = new Font("Arial", Font.BOLD, 30);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Dibuja el escenario bosque
		for(fila =0; fila<=numFilas-1; fila++) {
			for(columna=0; columna<=numColumnas-1; columna++) {
				if(laberinto[fila][columna] == "1") {	
					g.drawImage(miElementosBosque.get(acumuladorLista).getImagenMov(), columna*DibujoEspecifico.getAncho(),fila*DibujoEspecifico.getAlto(),DibujoEspecifico.getAncho(),DibujoEspecifico.getAlto(),null);
					acumuladorLista++;
				}else if(laberinto[fila][columna] !="0" &&laberinto[fila][columna] !="1" ) {
					g.drawImage(listaCodigos.get(acumuladorLista2).retornarImagen(), columna*PlantillaCreacionImagenes.ANCHO, fila*PlantillaCreacionImagenes.ALTO, PlantillaCreacionImagenes.ANCHO, PlantillaCreacionImagenes.ALTO, null);
					listaCodigos.get(acumuladorLista2).asignarCodigo(laberinto[fila][columna]);
					acumuladorLista2 ++;	
				}				
			}
		}
		acumuladorLista = acumuladorLista2 = 0;
		if(listaCodigos.size()>1) {
			//Actualiza movimiento recolector
			this.actualizarMovimientoPersonaje(g);
			//Actualiza la acción del recolector
			this.actualizarAccion();
			//Actualiza los reyes
			this.dibujarReyes(g);	
		}
		if(listaCodigos.size()<=1) {
			this.dibujarReyMuerte(g);
			g.setFont(mifuente);
			g.drawString(mensajeFinal, 150, 350);
		}
	}
	
	//Actualiza el movimiento del recolector
	public void actualizarMovimientoPersonaje(Graphics g) {
		((PersonajeRecolector)miPersonajeAnimado).setLaberinto(laberinto);
		miPersonajeAnimado.asignarDesplazamiento();
		this.estadoDelRecolector();
		g.drawImage(miPersonajeAnimado.imgPersonaje(), miPersonajeAnimado.posicionX,miPersonajeAnimado.posicionY,PlantillaCreacionImagenes.ANCHO, PlantillaCreacionImagenes.ALTO, null);
	}
	
	//Actualiza la acción de recolector
	public void actualizarAccion() {
		((PersonajeRecolector)miPersonajeAnimado).setLaberinto(laberinto);
		((PersonajeRecolector)miPersonajeAnimado).setListaCodigos(listaCodigos);
		if(TURNOREY) {
			miPerRey = ((PersonajeRecolector)miPersonajeAnimado).realizarAccion(miPerRey);
			
		}else if(!TURNOREY) {
			miClonRey = ((PersonajeRecolector)miPersonajeAnimado).realizarAccion(miClonRey);
			
		}
		laberinto = ((PersonajeRecolector)miPersonajeAnimado).getLaberinto();
		listaCodigos = ((PersonajeRecolector)miPersonajeAnimado).getListaCodigos();
		//miPerRey = ((PersonajeRecolector)miPersonajeAnimado).getReyActual();
	}
	
	//Dibuja a los dos reyes del juego
	public void dibujarReyes(Graphics g) {
		miPerRey.realizarAccion();
		miClonRey.realizarAccion();
		g.drawImage(miPerRey.imgPersonaje(), miPerRey.posicionX, miPerRey.posicionY, PlantillaCreacionImagenes.ANCHO, PlantillaCreacionImagenes.ALTO, null);
		g.drawImage(miClonRey.imgPersonaje(), miClonRey.posicionX, miClonRey.posicionY, PlantillaCreacionImagenes.ANCHO, PlantillaCreacionImagenes.ALTO, null);
		
		//Realiza las animaciones para el poder de cada jugador
		if(!miPerRey.retornarEstadoPoder()) {
			g.drawImage(miPerRey.realizarPoderActual(), miClonRey.posicionX-30, miClonRey.posicionY+10, PlantillaCreacionImagenes.ANCHO+70, PlantillaCreacionImagenes.ALTO+15, null);
		}
		if(!miClonRey.retornarEstadoPoder()) {
			g.drawImage(miClonRey.realizarPoderActual(), miPerRey.posicionX-30, miPerRey.posicionY+10, PlantillaCreacionImagenes.ANCHO+70, PlantillaCreacionImagenes.ALTO+15, null);
		}
	}
	
	
	public void dibujarReyMuerte(Graphics g) {
		if(miPerRey.experiencia> miClonRey.experiencia) {
			g.drawImage(miClonRey.mostrarMuerte("muerteB"), miClonRey.posicionX, miClonRey.posicionY, PlantillaCreacionImagenes.ANCHO, PlantillaCreacionImagenes.ALTO, null);
			g.drawImage(miPerRey.mostrarMuerte("Rey1"), miPerRey.posicionX, miPerRey.posicionY, PlantillaCreacionImagenes.ANCHO, PlantillaCreacionImagenes.ALTO, null);
			TURNOREY = true;
			mensajeFinal = "Gana Rey-Humano.";
		}else {
			g.drawImage(miPerRey.mostrarMuerte("muerteA"), miPerRey.posicionX, miPerRey.posicionY, PlantillaCreacionImagenes.ANCHO, PlantillaCreacionImagenes.ALTO, null);
			g.drawImage(miClonRey.mostrarMuerte("ReyB1"), miClonRey.posicionX, miClonRey.posicionY, PlantillaCreacionImagenes.ANCHO, PlantillaCreacionImagenes.ALTO, null);
			TURNOREY = false;
			mensajeFinal = "Gana Rey-Ogro.";
		}
		this.actualizarMovimientoPersonaje(g);
		this.actualizarAccion();
	}
		
	//---------------------------------------------------------------------------------------------
	
	//Dependiendo del turno cambia el estado del recolector del juego
	public void estadoDelRecolector() {
		if(TURNOREY==true) {
			((PersonajeRecolector)miPersonajeAnimado).asignarEstadoImg(new PersonajeEstadoVisualRecolectorA());
		
		}else if(TURNOREY==false) {
			((PersonajeRecolector)miPersonajeAnimado).asignarEstadoImg(new PersonajeEstadoVisualRecolectorB());	
		}
		
	}
	
	
	//Retorna el turno del juego
	public static boolean retornarTurno() {
		return TURNOREY;
	}
	
	//Asigna el turno del juego
	public static void asignarTurno(Boolean turno) {
		TURNOREY = turno;
	}
	//-------------------------------------------------------------------------------------------------
	
	//Matriz del juego
	public String [][] obtieneLaberinto(){
		String laberinto[][]=
		{
			{"1","1","1","1","0","0","0","1","1","1","1"},
			{"1","1","1","1","0","0","0","1","1","1","1"},
			{"1","1","1","1","0","0","0","1","1","1","1"},
			{"1","1","1","1","0","0","0","1","1","1","1"},
			{"1","0","0","1","1","1","1","1","0","0","1"},
			{"1","C1","A1","0","0","0","0","0","A2","A3","1"},
			{"1","A4","A5","0","0","0","0","B2","A6","A7","1"},
			{"1","A8","A9","C2","0","0","0","0","A10","A11","1"},
			{"1","A12","A13","0","0","0","0","0","A14","B1","1"},
			{"1","1","1","1","1","1","1","1","1","1","1"}
			
		};
		return laberinto;
	}
}
