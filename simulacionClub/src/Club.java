import java.util.ArrayList;
import java.util.Scanner;

public class Club {

    static ArrayList<Regular> regulares = new ArrayList<Regular>();
    static ArrayList<VIP> vip = new ArrayList<VIP>();
    static boolean bvip;

    static int verificarSocio(int cedula){

        //flag = true;
        if (regulares != null || regulares.size() != 0){
            for (int i=0; i < regulares.size(); i++){
                if (regulares.get(i).getCedula() == cedula){
                    bvip = false;
                    return i;
                }
            }
            // for (Regular i: regulares){
            //     if (i.getCedula() == cedula){
            //         flag = false;
            //         break;
            //     }
            // }
        }else if (vip != null || vip.size() != 0){
            for (int i=0; i < vip.size(); i++){
                if (vip.get(i).getCedula() == cedula){
                    bvip = true;
                    return i;
                }
            }
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

        Scanner input = new Scanner(System.in);
        int flag = verificarSocio(cedula);

        if (flag == -1){
            
            System.out.println("Ingrese el nombre del socio: ");
            String nombre = input.nextLine();
            input.nextLine();

            while (true){
                System.out.println("Ingrese la suscripcion del socio: (VIP/REGULAR)");
                String sus = input.nextLine().toLowerCase();
                input.nextLine();

                if (sus == "vip"){
                    VIP socio = new VIP(nombre, cedula);
                    vip.add(socio);
                    break;
                }else if (sus == "regular"){
                    Regular socio = new Regular(nombre, cedula);
                    regulares.add(socio);
                }else{
                    System.out.println("No ingreso una suscripcion valida,verifique de nuevo");
                }
            }
        }else{

            System.out.println("Esta persona ya es socio del club.");
        
        }

        input.close();
    }

    public static void registrarAfiliado(int cedula){
        
        Scanner input = new Scanner(System.in);
        int ind = verificarSocio(cedula);

        if (ind != -1){

            System.out.println("ingrese el nombre del afiliado: ");
            String nombre = input.nextLine();
            input.nextLine();

            if (bvip){
                vip.get(ind).agregarAfiliado(nombre);
            }else{
                regulares.get(ind).agregarAfiliado(nombre);
            }

        }else{
            System.out.println("No hay socio registrado con esta identificacion");
        }
        input.close();
    }

    public static void aumentarFondos(int cedula, int valor){
        int ind = verificarSocio(cedula);
        if (ind != -1){
            if (bvip){
                vip.get(ind).setFondos(valor);
            }else{
                regulares.get(ind).setFondos(valor);
            }
        }else{
            System.out.println("No hay socio registrado con esta identificacion");
        }
    }

    public static boolean EliminarSocio(int cedula){
        
        int ind = verificarSocio(cedula);
        
        if (ind != -1){
            if (bvip == false){
                Regular socio = regulares.get(ind);
                if(socio.afiliados.size() <= 1){
                    if (socio.facturasSocio.size() !=0 && socio.facturasAfiliado.size() !=0){
                        vip.remove(ind);
                        return true;
                    }else{
                        System.out.println("NO se puede eliminar, el socio tiene facturas por pagar");
                        return false;
                    }
                }else {
                    System.out.println("No se puede eliminar, el socio tiene mas de un afiliado");
                    return false;
                }
            }else{ 
                System.out.println("NO se puede eliminar, el socio es VIP");
                return false;
            }
            
        }
        
        System.out.println("NO hay ningun socio registrado con esta identificacion");
        return false;
    }

    public static void consumo(int cedula){

        Scanner input = new Scanner(System.in);
        int ind = verificarSocio(cedula);

        if (ind != -1){

            System.out.println("¿El comprador es Afiliado o Socio?");
            boolean afiliado = input.nextBoolean();
            input.nextLine();

            System.out.println("Concepto de consumo: ");
            String concepto = input.nextLine();
            input.nextLine();

            System.out.println("Valor de consumo: ");
            int valor = input.nextInt();

            System.out.println("Nombre: ");
            String nombre = input.nextLine();
            input.nextLine();

            if (bvip){
                if (afiliado){
                    vip.get(ind).facturasAfiliado.add()
                }
            }else{

            }
        }else{
            System.out.println("NO hay ningun socio registrado con esta identificacion");
        }

        input.close();
    }

}
