package roundrobin;

/**
 *
 * @author Alfonso Felix
 */
public class Proceso {
    private String nombre;
    private int rafaga;
    private int restante;
    
    public Proceso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRafaga() {
        return rafaga;
    }

    public void setRafaga(int rafaga) {
        this.rafaga = rafaga;
        this.restante=rafaga;
    }

    public int getRestante() {
        return restante;
    }

    public void setRestante(int restante) {
        this.restante = restante;
    }
}
