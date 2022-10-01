package umg.edu.model;
//
public class Preguntas {
    private static int correlativo=1;
    private int pin;
    private String pregunta;
    private String respuesta;

    public Preguntas( String pregunta, String respuesta) {
        this.pin = pin;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
