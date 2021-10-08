import java.util.LinkedList;
//import java.util.Collections; 

public abstract class Socio {
    
    private int cedula;
    private String nombre;
    protected int fondos;
    // private String suscripcion;
    protected LinkedList<String> afiliados = new LinkedList<String>();
    protected LinkedList<Factura> facturasSocio = new LinkedList<Factura>();
    protected LinkedList<Factura> facturasAfiliado = new LinkedList<Factura>();
   // private LinkedList<String> Autorizados = new LinkedList<String>();

    public Socio() {
    }

    public Socio(String nombre, int cedula){
        this.nombre = nombre;
        this.cedula = cedula;

        // if (VIP == true){
        //     this.fondos = 50000;
        //     this.suscripcion = "VIP";
        // }else{
        //     this.fondos = 100000;
        //     this.suscripcion = "Regular";
        // }
    }

    public void nuevaFactura(String concepto, float valor, String nombre, boolean afiliado){
        
        if (valor < this.fondos){
            
            if (afiliado){
                Factura factura = new Factura(concepto, valor, nombre);
                facturasAfiliado.add(factura);
            }else{
                Factura factura = new Factura(concepto, valor, nombre);
                facturasSocio.add(factura);
            }

        }else{
            System.out.println("Fondos insuficientes");
        }

    }   

    public void agregarAfiliado(String nombre){
        afiliados.add(nombre);
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

    abstract public void setFondos(int valor);

    public long getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    // public String getSuscripcion() {
    //     return suscripcion;
    // }

    // public void setSuscripcion(String suscripcion) {
    //     this.suscripcion = suscripcion;
    // }
    
}
