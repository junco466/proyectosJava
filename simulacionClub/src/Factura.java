public class Factura {

    private String concepto;
    private int valor;
    private String nombre;
    
    public Factura(String concept, int value, String name){
        this.concepto = concept;
        this.valor = value;
        this.nombre = name;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarInfo(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Concepto: " + this.concepto);
        System.out.println("Valor: " + this.valor);
    }
    
}
