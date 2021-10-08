public class Regular extends Socio {

    public Regular(String nombre, int cedula){
        super(nombre,cedula);
        this.fondos = 50000;
    }
    
    @Override
    public void setFondos(int valor){
        int total = valor + this.fondos;
        if (this.fondos < 1000000 && total < 1000000){
            this.fondos = total;
        }else{
            System.out.println("Capacidad maxima");
        }
    }
}
