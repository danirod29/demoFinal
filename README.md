# demoFinal

Daniel Rodriguez 20172020120

Angiu Vanessa Ramirez 20172020100

Cristian Torres 20172020116

JUEGO DE ESTRATEGIA POR TURNOS

Es un juego por turnos de dos jugadores, donde cada jugador representa un rey. El juego consta de un controlar un recolector el cual toma los poderes repartidos por el mapa, estos poderes tienen distintos valores de daño y al tomar un poder estos van sumandole experiencia al rey que represente, el juego termina cuando no queden mas poderes en el mapa y el ganador es el rey con mas experiencia.

Implementa los patrones command, chain of responsability, composite, abtract factory, builder, state, observer

El tablero se ambienta en un bosque y para dibujarlo se usa composite siendo un dibujo complejo compuesto de arboles.

Para la construccion de los personajes se usa el patron abstract factory y builder siendo la fabrica el personaje como tal con productos como armadura, habilidad y herramienta para que finalmente los distintos personajes sean construidos por medio del builder.

Entre turnos el estado del recolector cambia haciendo que se modifique su aspecto para lo cual usamos state

De igual manera el aspecto del rey cambia al momento de tomar un poder para mostrar el uso de este, para esto usamos observer para que una vez el recolector escoga un poder este notifique y ordene el cambio del aspecto del rey de acuerdo al poder seleccionado



Para la musica continua del juego se implementa un ciclo donde pasado un tiempo pasa a la siguiente cancion pero estas al tener distinto formato se usa chain of responsability para reproducir la cancion con su reproductor adecuado.

al presionar la tecla c o i se abrira una ventana mostrando los controles y las instrucciones respectivamente para esto usamos command enviando la instruccion que deseamos ejecutar.
