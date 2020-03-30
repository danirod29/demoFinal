package comando;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	
	private List<Command> comandos = new ArrayList<Command>();
	
	
	public void TomarComando(Command comando) {
		comandos.add(comando);
	}
	
	public void Ordenar() {
		for(Command comando: comandos) {
			comando.execute();
		}
		comandos.clear();
	}

}
