import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        
        int opc;
        int op;
        int cedula;
        Scanner input = new Scanner(System.in);
        while (true){
            
            while(true){
                System.out.println("BIENVENIDO AL CLUB PIEDRA SOLAR");
                System.out.println("Seleccione que desea realizar: ");
                System.out.println("1. Afiliar un socio al club");
                System.out.println("2. Registrar o eliminar una persona autorizada por un socio");
                System.out.println("3. Pagar una factura");
                System.out.println("4. Resgistrar consumo");
                System.out.println("5. Aumentar fondos de uan cuenta");
                System.out.println("6. Elimina a un socio");
               // try{
                    op = input.nextInt();
                    if(op>0 && op<=6){
                        break;
                    }else{
                        System.out.println("Se debe ingresar un numero entero entre 1 y 6");
                    }
                // }catch(Exception excepcion){
                //     System.out.println("Se fffffdebe ingresar un numero entero entre 1 y 6");
                // }
            }

            switch(op){

                case 1:

                    System.out.println("Vamos a ingresar un nuevo socio");
                    System.out.println("por favor digita la cedula:");
                    cedula = input.nextInt();
                    Club.afiliarSocio(cedula);
                    System.out.println(Club.socios.get(0).getFondos());
                    break;


                case 2:

                    System.out.println("¿Que desea hacer?");
                    System.out.println("1. Agragar afiliado");
                    System.out.println("¿2. Eliminar afiliado");
                    opc = input.nextInt();

                    while (true){

                        if (opc == 1){
                            System.out.println("por favor digita la cedula del socio:");
                            cedula = input.nextInt(); 
                            Club.registrarAfiliado(cedula);
                            break;
                        }else if (opc == 2){
                            System.out.println("por favor digita la cedula del socio:");
                            cedula = input.nextInt(); 
                            Club.eliminarAfiliado(cedula);
                            break;
                        }else{
                            System.out.println("Usted digito una opcion invalida");
                        }
                    }
                    break;


                case 3:
                    break;


                case 4:

                    System.out.println("por favor digita la cedula del socio:");
                    cedula = input.nextInt(); 
                    Club.consumo(cedula);
                    break;


                case 5:

                    System.out.println("por favor digita la cedula del socio:");
                    cedula = input.nextInt();
                    Club.aumentarFondos(cedula);
                    break;


                case 6:

                    System.out.println("por favor digita la cedula del socio:");
                    cedula = input.nextInt();
                    Club.EliminarSocio(cedula);
                    break;

            }
        }
    }
}
