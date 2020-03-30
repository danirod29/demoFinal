package comando;

public class Instrucciones implements Command{
	
	private Mostrar mostrar;
	
	public Instrucciones (Mostrar mostrar) {
		this.mostrar=mostrar;
	}

	@Override
	public void execute() {
		mostrar.mostrarInstruciones();
		
	}

	
	
}
