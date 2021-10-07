import java.util.LinkedList;
//import java.util.Collections; 

public class Socio {
    
    private int cedula;
    private String nombre;
    private float fondos;
    private  String suscripcion;
    private LinkedList<Factura> facturas = new LinkedList<Factura>();
   // private LinkedList<String> Autorizados = new LinkedList<String>();

    public Socio() {
    }

    public Socio(String nombre, boolean VIP, int cedula, int limitVIP){
        this.nombre = nombre;
        this.cedula = cedula;

        if (VIP == true && limitVIP <= 3){
            this.fondos = 50000;
            this.suscripcion = "VIP";
        }else{
            this.fondos = 100000;
            this.suscripcion = "Regular";
        }
    }

    public void nuevaFactura(String concepto, float valor, String nombre){
        Factura factura = new Factura(concepto, valor, nombre);
        facturas.add(factura);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getFondos() {
        return fondos;
    }

    public void setFondos(float fondos) {
        this.fondos = fondos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(String suscripcion) {
        this.suscripcion = suscripcion;
    }
    
}
