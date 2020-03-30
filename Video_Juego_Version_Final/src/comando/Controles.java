package comando;

//comando concreto 
public class Controles implements Command{
	//instancia de la clase con las instrucciones
	private Mostrar mostrar;
	
	public Controles(Mostrar mostrar) {
		this.mostrar= mostrar;
	}
	
	//ejecuta el metodo
	@Override
	public void execute() {
	
		mostrar.mostrarControles();
		
	}
	
	

}
