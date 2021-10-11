import java.util.LinkedList;
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


    public void nuevaFactura(String concepto, int valor, String nombre){
        
        this.totalDeuda = this.totalDeuda + valor;

        if (this.totalDeuda < this.fondos){
            
            if (nombre == this.nombre){

                Factura factura = new Factura(concepto, valor, this.nombre);
                facturas.add(factura);

            }else{

                for (Afiliado i : afiliados){
                    if (i.getNombre() == nombre){
                        i.facturaAfiliado(concepto, valor);
                        break;
                    }else{
                        System.out.println("Este nombre no corresponde a ninguna persona registrada bajo esta cedula");
                    }
                }
            }

        }else{
            System.out.println("Fondos insuficientes");
        }

    } 

    
    public void pagarFactura(/*int Valor, String nombre*/){

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
            if (nombre == i.getNombre()){
                if (i.getFacturas().size() == 0){
                    afiliados.remove(i);
                }else{
                    System.out.println("El afiliado tiene facturas por pagar.");
                }
            }else{
                System.out.println("No existe ningun afiliado con ese nombre.");
            }
        }        
    }


    public boolean verFacturasAfiliado(){

        for (Afiliado i : afiliados){
            if (i.getFacturas().size() != 0){
                return false;
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


    public void setFondos(int valor){
        if(this.vip){
            int total = valor + this.fondos;
            if (this.fondos < 5000000 && total < 5000000){
                this.fondos = total;
            }else{
                System.out.println("Capacidad maxima");
            }
        }else{
            int total = valor + this.fondos;
            if (this.fondos < 1000000 && total < 1000000){
                this.fondos = total;
            }else{
                System.out.println("Capacidad maxima");
            }
        }
    };


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


}
   
