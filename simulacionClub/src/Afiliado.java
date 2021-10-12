import java.util.LinkedList;
import java.util.Scanner;

public class Afiliado {

    private String nombre;
    private LinkedList<Factura> facturas = new LinkedList<Factura>();

    public Afiliado(String nombre){
        this.nombre = nombre;
    }

    public void facturaAfiliado(String concepto, int valor){
        Factura factura = new Factura(concepto,valor,this.nombre);
        facturas.add(factura);
        System.out.println("La factura se genero satisfactoriamente");
    }

    public boolean pagarFacturaAfilado(Socio socio){

        char op;
        Scanner input = new Scanner(System.in);

        System.out.println("estoy entrando en pagar factura afiliado");

        for (Factura i: facturas){
            i.mostrarInfo();
            System.out.println("¿Desea pagar esta factura? (SI/NO)");
            op = input.nextLine().toLowerCase().charAt(0);

            if(op == 's'){
                System.out.println("");
                socio.setTotalDeuda(socio.getTotalDeuda() - i.getValor());
                facturas.remove(i);
                System.out.println("Se pago satisfactoriamente la factura, y sera ramovida");
                //input.close();
                return true;
            }else if(op == 'n'){
                System.out.println("");
            }
        }
        //input.close();
        return false;
    
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
