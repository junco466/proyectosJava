import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Club {

    static ArrayList<Socio> socios = new ArrayList<Socio>();
    static Scanner input = new Scanner(System.in);


    static int verificarSocio(int cedula){

        //flag = true;
        if (socios != null || socios.size() != 0){
            for (int i=0; i < socios.size(); i++){
                if (socios.get(i).getCedula() == cedula){
                    //bvip = false;
                    return i;
                }
            }
            // for (Regular i: regulares){
            //     if (i.getCedula() == cedula){
            //         flag = false;
            //         break;
            //     }
            // }
        // }else if (vip != null || vip.size() != 0){
        //     for (int i=0; i < vip.size(); i++){
        //         if (vip.get(i).getCedula() == cedula){
        //             bvip = true;
        //             return i;
        //         }
        //     }
            // for (VIP i: vip){
            //     if (i.getCedula() == cedula){
            //         flag = false;
            //         break;
            //     }
            // }
        }
        return -1;
    }


    static void afiliarSocio(int cedula){
        int flag = verificarSocio(cedula);

        if (flag == -1){
            
            System.out.println("Ingrese el nombre del socio: ");
            String nombre = input.nextLine();

            while (true){
                System.out.println("Ingrese la suscripcion del socio: (VIP/REGULAR)");
                String sus = input.nextLine().toLowerCase();

                if (sus.equals("vip")){
                    //System.out.println("entre a vip");
                    Socio socio = new Socio(nombre, cedula, true);
                    socios.add(socio);
                    System.out.println("Se inscribio al nuevo socio satisfactoriamente");
                    break;
                }else if (sus.equals("regular")){
                    Socio socio = new Socio(nombre, cedula , false);
                    socios.add(socio);
                    System.out.println("Se inscribio al nuevo socio satisfactoriamente");
                    break;
                }else{
                    System.out.println("No ingreso una suscripcion valida,verifique de nuevo");
                }
            }
        }else{

            System.out.println("Esta persona ya es socio del club.");
        
        }
    }


    public static void registrarAfiliado(int cedula){
        
        int ind = verificarSocio(cedula);

        if (ind != -1){

            System.out.println("ingrese el nombre del afiliado: ");
            String nombre = input.nextLine();
            socios.get(ind).agregarAfiliado(nombre);
            System.out.println("Se ingreso satisfactoriamente un nuevo afiliado a la lista del socio");
        
        }else{
            System.out.println("No hay socio registrado con esta identificacion");
        }
    }


    public static void eliminarAfiliado(int cedula){
        
        int ind = verificarSocio(cedula);

        if (ind != -1){

            System.out.println("ingrese el nombre del afiliado: ");
            String nombre = input.nextLine();
            socios.get(ind).removerAfiliado(nombre);
        
        }else{
            System.out.println("No hay socio registrado con esta identificacion");
        }

    }


    public static void aumentarFondos(int cedula){
        
        int valor;
        int ind = verificarSocio(cedula);
        if (ind != -1){
            System.out.println("Ingrese la cantidad que desea consignar a la cuenta: ");
            valor = input.nextInt(); 
            socios.get(ind).setFondos(valor);
            System.out.println("Se ingresaron " + valor + " pesos, satisfactoriamente");
        }else{
            System.out.println("No hay socio registrado con esta identificacion");
        }
    }


    public static boolean EliminarSocio(int cedula){
        
        int ind = verificarSocio(cedula);
        
        if (ind != -1){

            Socio socio = socios.get(ind);

            if (socio.isVip()){

                System.out.println("NO se puede eliminar, el socio es VIP");
                return false;

            }else{ 
                
                if(socio.getAfiliados().size() <= 1){
                    if (socio.getFacturasSocio().size() == 0 && socio.verFacturasAfiliado()){
                        socios.remove(ind);
                        System.out.println("Se elimino satisfactoriamente al socio");
                        return true;
                    }else{
                        System.out.println("NO se puede eliminar, el socio tiene facturas por pagar");
                        return false;
                    }
                }else {
                    System.out.println("No se puede eliminar, el socio tiene mas de un afiliado");
                    return false;
                }
                
            }
            
        }
        
        System.out.println("NO hay ningun socio registrado con esta identificacion");
        return false;
    }


    public static void consumo(int cedula){

        int ind = verificarSocio(cedula);

        if (ind != -1){

            
            System.out.println("Nombre del cliente: ");
            String nombre = input.nextLine();
            
            System.out.println("Concepto de consumo: ");
            String concepto = input.nextLine();;

            System.out.println("Valor de consumo: ");
            int valor = input.nextInt();
            input.nextLine();

            socios.get(ind).nuevaFactura(concepto, valor, nombre);
        }else{
            System.out.println("NO hay ningun socio registrado con esta identificacion");
        }

    }


    public static void pagarConsumo(int cedula){
        
        int ind = verificarSocio(cedula);

        if (ind != -1){

            Socio socio = socios.get(ind);
            LinkedList<Afiliado> afiliados = new LinkedList<Afiliado>();
            afiliados = socio.getAfiliados();
            boolean flag = false;
            char op;

            System.out.println("A CONTINUACION PODRA VER LAS FACTURAS, EN ORDEN DE CREACION: ");
            
            while(true){

                flag = socio.pagarFacturaSocio();
                if (flag){
                    return;
                }

                for (Afiliado i: afiliados){
                    flag = i.pagarFacturaAfilado(socio);
                }

                if (flag){
                    return;
                }
                System.out.println("¿Desea volver a ver la lista de facturas? (SI/NO)");
                op = input.nextLine().toLowerCase().charAt(0);

                if(op == 'n'){
                    break;
                }
    
            }   
        }else{
            System.out.println("NO hay ningun socio registrado con esta identificacion");
        } 
    }


    public static void totalConsumos(int cedula){
        
        int ind = verificarSocio(cedula);

        if (ind != -1){

            System.out.println("El total de la deuda del socios es: ");
            System.out.println(socios.get(ind).getTotalDeuda());
        
        }else{
            System.out.println("No hay socio registrado con esta identificacion");
        }
    }


    public static void mostrarSocios(){
        for (Socio h: socios){
            System.out.println(h.getNombre());
            System.out.println(h.getFondos());
            System.out.println(h.getCedula());
            System.out.println(h.getSuscripcion());
        }
    }
}
