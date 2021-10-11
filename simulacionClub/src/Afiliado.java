import java.util.LinkedList;

public class Afiliado {

    private String nombre;
    private LinkedList<Factura> facturas = new LinkedList<Factura>();

    public Afiliado(String nombre){
        this.nombre = nombre;
    }

    public void facturaAfiliado(String concepto, int valor){
        Factura factura = new Factura(concepto,valor,this.nombre);
        facturas.add(factura);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Factura> getFacturas() {
        return facturas;
    }
    
}
