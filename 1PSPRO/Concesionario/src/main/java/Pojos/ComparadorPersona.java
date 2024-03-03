/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pojos;

import java.util.Comparator;

public class ComparadorPersona implements Comparator<Persona>{

    @Override
    public int compare(Persona p1, Persona p2) {
         
        return Integer.compare(p2.getEdad(),p1.getEdad());
    }
}
/*
jugadores.stream().filter(jugador -> jugador.getPuntos() > puntos).forEach((jugador -> jugadoresFiltrados.add(jugador)));

List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
		cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
		cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
		cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
		cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300 ));

		//Obtener la cantidad de cursos con una duración mayor a 5 horas.
		List<Curso> actividad1 = cursos.stream().filter(curso->curso.getDuracion()>5).toList();
		
		//Obtener la cantidad de cursos con una duración menor a 2 horas.
		List<Curso> actividad2 = cursos.stream().filter(curso->curso.getDuracion()<5).toList();
		
		//Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.
		List<Curso> actividad3 = cursos.stream().filter(curso->curso.getVideos()>50).toList();
		
		//Mostrar en consola el título de los 3 cursos con mayor duración.
		List<Curso> actividad4 = cursos.stream().sorted(Comparator.comparingDouble(curso->((Curso) curso).getDuracion()).reversed()).limit(3).collect(Collectors.toList());
		actividad4.forEach(element->System.out.println(element));
		
		//Mostrar en consola la duración total de todos los cursos.
		int actividad5 = cursos.stream().mapToInt(curso->(int)curso.getDuracion()).sum();
		
		//Mostrar en consola todos aquellos libros que superen el promedio en cuanto a duración se refiere.
		float media =(float)cursos.stream().mapToInt(curso->(int)curso.getDuracion()).average().orElseThrow();
		List<Curso> actividad6 = cursos.stream().filter(curso->curso.getDuracion()>media).toList();
		
		//Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.
		List<Curso> actividad7 = cursos.stream().filter(curso->curso.getAlumnos()<500).toList();

		//Obtener el curso con mayor duración.
		float mayorDuracion = (float) cursos.stream().mapToDouble(curso->(double)curso.getDuracion()).max().orElseThrow();
		Optional<Curso> actividad8 = cursos.stream().filter(curso->curso.getDuracion()==mayorDuracion).findFirst();
	
		//Crear una lista de Strings con todos los títulos de los cursos.
		List<String> actividad9 = cursos.stream().map(curso->curso.getTitulo()).collect(Collectors.toList());
*/
