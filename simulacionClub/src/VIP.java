public class VIP extends Socio {
    public VIP(String nombre, int cedula){
        super(nombre,cedula);
        this.fondos = 100000;
    }
    
    @Override
    public void setFondos(int valor){
        int total = valor + this.fondos;
        if (this.fondos < 5000000 && total < 5000000){
            this.fondos = total;
        }else{
            System.out.println("Capacidad maxima");
        }
    }
}
