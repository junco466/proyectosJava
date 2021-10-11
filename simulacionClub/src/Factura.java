public class Factura {

    private String concepto;
    private float valor;
    private String nombre;
    
    public Factura(String concept, float value, String name){
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarInfo(){
        System.out.print("Nombre: " + nombre);
        System.out.println("Concepto: " + concepto);
        System.out.println("Valor: " + valor);
    }
    
}
