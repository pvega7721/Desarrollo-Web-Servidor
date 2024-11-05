package ejercicio11;

public class Curso {
	private String nombre;
	private Integer duracion;
	private Integer numVideos;
	private Integer numAlumnos;

	public Curso(String nombre, Integer duracion, Integer numVideos, Integer numAlumnos) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.numVideos = numVideos;
		this.numAlumnos = numAlumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getNumVideos() {
		return numVideos;
	}

	public void setNumVideos(Integer numVideos) {
		this.numVideos = numVideos;
	}

	public Integer getNumAlumnos() {
		return numAlumnos;
	}

	public void setNumAlumnos(Integer numAlumnos) {
		this.numAlumnos = numAlumnos;
	}

	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", duracion=" + duracion + ", numVideos=" + numVideos + ", numAlumnos="
				+ numAlumnos + "]";
	}

}
