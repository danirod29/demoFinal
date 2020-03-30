package comando;
//comando concreto
public class ComandoDefecto implements Command{
	
	private Mostrar mostrar;
	
	public ComandoDefecto(Mostrar mostrar) {
		this.mostrar=mostrar;
	}

	@Override
	public void execute() {
		mostrar.mostrarImg();
		
	}

}
