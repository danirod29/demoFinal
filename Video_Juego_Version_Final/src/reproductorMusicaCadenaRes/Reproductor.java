package reproductorMusicaCadenaRes;


//clase handler
public abstract class Reproductor {
	//asignar siguente en la cadena
	Reproductor siguiente;
	
	public Reproductor getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Reproductor siguiente) {
		this.siguiente = siguiente;
	}
	//metodo para implementar
	public abstract void reproducir(int op);

}

