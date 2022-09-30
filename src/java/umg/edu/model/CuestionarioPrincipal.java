package umg.edu.model;

public class CuestionarioPrincipal  {
    private static int correlativo=1;
    private int pin;
    private String titulo;
    private String descripción;

    public CuestionarioPrincipal(String titulo, String descripción) {
        this.pin = correlativo;
        this.titulo = titulo;
        this.descripción = descripción;
        correlativo++;
    }

    public int getId() {
        return pin;
    }

    public void setId(int id) {
        this.pin = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }
}
