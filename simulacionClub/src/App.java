import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        
        int opc;
        int op;
        int cedula;
        Scanner input = new Scanner(System.in);
        boolean continua = false;

        while (true){
            
            while(true){
                System.out.println();
                System.out.println("BIENVENIDO AL CLUB PIEDRA SOLAR");
                System.out.println("Seleccione que desea realizar: ");
                System.out.println("1. Afiliar un socio al club");
                System.out.println("2. Registrar o eliminar una persona autorizada por un socio");
                System.out.println("3. Pagar una factura");
                System.out.println("4. Resgistrar consumo");
                System.out.println("5. Aumentar fondos de una cuenta");
                System.out.println("6. Elimina a un socio");
                System.out.println("7. Ver la deuda del socio");
               // try{
                    op = input.nextInt();
                    if(op>0 && op<=7){
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

                    try{
                        System.out.println();
                        System.out.println("Vamos a ingresar un nuevo socio");
                        System.out.println("por favor digita la cedula:");
                        cedula = input.nextInt();
                        input.nextLine();
                        Club.afiliarSocio(cedula);
                        break;
                    }catch(Exception e){
                        System.out.println();
                        System.out.println("El campo de cedula es invalido, vuelva a intentarlo");
                        input.nextLine();
                        break;
                    }


                case 2:

                    do{

                        System.out.println();
                        System.out.println("¿Que desea hacer?");
                        System.out.println("1. Agragar afiliado");
                        System.out.println("2. Eliminar afiliado");
                        opc = input.nextInt();
                        input.nextLine();

                        if (opc == 1){
                            try{

                                System.out.println();
                                System.out.println("por favor digita la cedula del socio:");
                                cedula = input.nextInt(); 
                                input.nextLine();
                                Club.registrarAfiliado(cedula);
                                continua = false;

                            }catch(Exception e){
                                System.out.println();
                                System.out.println("El campo de cedula es invalido, vuelva a intentarlo");
                                input.nextLine();
                                continua = true;
                            }

                        }else if (opc == 2){

                            try{
                                System.out.println();
                                System.out.println("por favor digita la cedula del socio:");
                                cedula = input.nextInt();
                                input.nextLine(); 
                                Club.eliminarAfiliado(cedula);
                                continua = false;
                            }catch(Exception e){
                                System.out.println();
                                System.out.println("El campo de cedula es invalido, vuelva a intentarlo");
                                input.nextLine();
                                continua = true;
                            }

                        }else{
                            System.out.println();
                            System.out.println("Usted digito una opcion invalida");
                            continua = true;
                        }

                    }while(continua);
                    break;


                case 3:

                    try{

                        System.out.println();
                        System.out.println("por favor digita la cedula del socio:");
                        cedula = input.nextInt();
                        input.nextLine();
                        Club.pagarConsumo(cedula);
                        break;

                    }catch(Exception e){
                        System.out.println();
                        System.out.println("El campo de cedula es invalido, vuelva a intentarlo");
                        input.nextLine();
                        break;
                    }


                case 4:

                    try{

                        System.out.println();
                        System.out.println("por favor digita la cedula del socio:");
                        cedula = input.nextInt();
                        input.nextLine(); 
                        Club.consumo(cedula);
                        break;

                    }catch(Exception e){
                        System.out.println();
                        System.out.println("El campo de cedula es invalido, vuelva a intentarlo");
                        input.nextLine();
                        break;
                    }


                case 5:

                    try{

                        System.out.println();
                        System.out.println("por favor digita la cedula del socio:");
                        cedula = input.nextInt();
                        input.nextLine();
                        Club.aumentarFondos(cedula);
                        break;

                    }catch(Exception e){
                        System.out.println();
                        System.out.println("El campo de cedula es invalido, vuelva a intentarlo");
                        input.nextLine();
                        break;
                    }


                case 6:
                    try{

                        System.out.println();
                        System.out.println("por favor digita la cedula del socio:");
                        cedula = input.nextInt();
                        input.nextLine();
                        Club.EliminarSocio(cedula);
                        break;

                    }catch(Exception e){
                        System.out.println();
                        System.out.println("El campo de cedula es invalido, vuelva a intentarlo");
                        input.nextLine();
                        break;
                    }

                case 7:

                    try{

                        System.out.println();
                        System.out.println("por favor digita la cedula del socio:");
                        cedula = input.nextInt();
                        input.nextLine();
                        Club.totalConsumos(cedula);
                        break;
                        
                    }catch(Exception e){
                        System.out.println();
                        System.out.println("El campo de cedula es invalido, vuelva a intentarlo");
                        input.nextLine();
                        break;
                    }

            }
        }
    }
}
