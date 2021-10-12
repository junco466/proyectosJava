import java.util.LinkedList;
import java.util.Scanner;
//import java.util.Collections; 

public class Socio {
    
    private int cedula;
    private String nombre;
    private int fondos;
    private int totalDeuda = 0;
    private String suscripcion;
    private boolean vip;
    private LinkedList<Afiliado> afiliados = new LinkedList<Afiliado>();
    private LinkedList<Factura> facturas = new LinkedList<Factura>();
   // private LinkedList<String> Autorizados = new LinkedList<String>();


    public Socio(String nombre, int cedula, boolean vip){
        this.nombre = nombre;
        this.cedula = cedula;
        this.vip = vip;

        if (this.vip){
            this.fondos = 100000;
            this.suscripcion = "VIP";
        }else{
            this.fondos = 50000;
            this.suscripcion = "Regular";
        }
    }


    public void nuevaFactura(String concepto, int valor, String name){
        
        int temp = 0;
        temp = this.totalDeuda + valor;
        //System.out.println("Deuda total = " + totalDeuda);
        if (temp < this.fondos){
            
            //System.out.println("total deuda < fondos");
            //System.out.println("name: " + name);
            //System.out.println("this.nombre: "+ this.nombre);

            if (name.equals(this.nombre)){

                //System.out.println("agregue facura correctamente");
                Factura factura = new Factura(concepto, valor, this.nombre);
                facturas.add(factura);
                this.totalDeuda = temp;
                System.out.println("La factura se genero satisfactoriamente");
                

            }else{

                for (Afiliado i : afiliados){
                    //System.out.println("entre facturas afiliados");
                    if (name.equals(i.getNombre())){
                        //System.out.println("cargue factura afiliado");
                        i.facturaAfiliado(concepto, valor);
                        this.totalDeuda = temp;
                        return;
                    }
                }
                System.out.println("Este nombre no corresponde a ninguna persona registrada bajo esta cedula");
            }

        }else{
            System.out.println("Fondos insuficientes");
        }

    } 

    
    public boolean pagarFacturaSocio(){

        char op;
        Scanner input = new Scanner(System.in);

        //System.out.println("estoy entrando en pagar factura socio");

        for (Factura n: facturas){
            n.mostrarInfo();
            System.out.println("¿Desea pagar esta factura? (SI/NO)");
            op = input.nextLine().toLowerCase().charAt(0);

            if(op == 's'){
                System.out.println("");
                this.totalDeuda = this.totalDeuda - n.getValor();
                facturas.remove(n);
                System.out.println("Se pago satisfactoriamente la factura, y sera ramovida");
                //input.close();
                return true;
            }else{
                System.out.println("");
            }
        }
        //input.close();
        return false;
    
    }


    public void agregarAfiliado(String nombre){

        if (this.fondos > 0){
            Afiliado afiliado = new Afiliado(nombre);
            afiliados.add(afiliado);
        }else{
            System.out.println("Fondos insuficientes.");
        }
    }  
    

    public void removerAfiliado(String nombre){

        for (Afiliado i : afiliados){
            if (nombre.equals(i.getNombre())){
                if (i.getFacturas().size() == 0){
                    afiliados.remove(i);
                    System.out.println("Se elimino el afiliado correctamente de la lista del socio");
                }else{
                    System.out.println("El afiliado tiene facturas por pagar.");
                }
            }else{
                System.out.println("No existe ningun afiliado con ese nombre.");
            }
        }        
    }


    public void setFondos(int valor){
        if(this.vip){
            int total = valor + this.fondos;
            if (this.fondos < 5000000 && total < 5000000){
                this.fondos = total;
            }else{
                System.out.println("Rebaso la capacidad maxima");
            }
        }else{
            int total = valor + this.fondos;
            if (this.fondos < 1000000 && total < 1000000){
                this.fondos = total;
            }else{
                System.out.println("Rebaso la capacidad maxima");
            }
        }
    }


    public boolean verFacturasAfiliado(){

        if (afiliados.size() != 0){
            for (Afiliado i : afiliados){
                if (i.getFacturas().size() != 0){
                    return false;
                }
            }
        }
        return true;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getFondos() {
        return fondos;
    }


    public long getCedula() {
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


    public boolean isVip() {
        return vip;
    }


    public void setVip(boolean vip) {
        this.vip = vip;
    }


    public LinkedList<Afiliado> getAfiliados() {
        return afiliados;
    }


    public LinkedList<Factura> getFacturasSocio() {
        return facturas;
    }


    public int getTotalDeuda() {
        return totalDeuda;
    }


    public void setTotalDeuda(int totalDeuda) {
        this.totalDeuda = totalDeuda;
    }   
     
}
   
