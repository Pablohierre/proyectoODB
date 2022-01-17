
import com.mycompany.proyectoobjectdb.models.Producto;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author hierr
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        /*Declaración de variables*/
        int opcion;
        Boolean paraLlevar=false;
        Long producto;
        long millis=System.currentTimeMillis();
        java.sql.Date fechaHoy=new java.sql.Date(millis); 
        Scanner sc= new Scanner(System.in);
        
        
        System.out.println("Gestión cafetería");
        System.out.println("1-Crear nuevo pedido");
        System.out.println("2-Eliminar pedido existente");
        System.out.println("3-Marcar pedido como recogido");
        System.out.println("4-Listar comandas de hoy");
        System.out.println("5-Añadir producto a la carta");
        System.out.println("6-Salir");
        opcion=sc.nextInt();
        
        switch(opcion){
            case 1:
                DAO.mostrarCarta();
                System.out.println("Insertar número de producto");
                producto=sc.nextLong();
                
                /*System.out.println("¿Para llevar? (S/N)");
                    if(sc.nextLine()== "Sí"){
                        paraLlevar=true;   
                    }else if(sc.nextLine()!="No" && sc.nextLine()!="Sí"){
                        menu();
                    }*/
                DAO.nuevoPedido(producto, paraLlevar);
                menu();
                
                break;
            case 2:
                DAO.mostrarPedidos();
                DAO.eliminarPedido();
                menu();
                break;
            case 3:
                DAO.mostrarPedidos();
                System.out.println("¿Qué producto quieres marcar como entregado?");
                opcion=sc.nextInt();
                DAO.entregarPedido(opcion);
                menu();
                
                break;
            case 4:
                DAO.mostrarPedidos(fechaHoy);
                menu();
                break;
            case 5:
                System.out.println("Introduce el precio del producto");
                Double precio = sc.nextDouble();  
                sc.nextLine();
                
                System.out.println("Introduce el nombre del producto");
                String nombre=sc.nextLine();  
                sc.nextLine();
                
                System.out.println("Introduce descripción");
                String descripcion = sc.nextLine();
                
                
                DAO.anadirProducto(new Producto(nombre,precio,descripcion));
                menu();
                break;
            case 6:
                System.exit(0);
                break;
        }
        
    }
    
}
