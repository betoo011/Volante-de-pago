package practica_proyecto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Practica_proyecto {

    public static void main(String[] args) throws IOException {
        Scanner opcion = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner scNombre = new Scanner(System.in);
        int n1 = 0;

        ArrayList<Object[]> matriz = new ArrayList<Object[]>();

        File archivo; //Manipular el archivo
        FileWriter escribir; //Para escribir en el archivo
        PrintWriter linea; //Escribir debajo

        archivo = new File("nomina.txt");//Preparando el archivo

        do {

            System.out.println("--------------------Opcion de menu--------------------");
            System.out.println("1.Empleado Administrativo");
            System.out.println("2.Empleado Operativo");
            System.out.print("Ingrese una opcion (1/2): ");
            n1 = opcion.nextInt();
            System.out.println("");
            switch (n1) {

                case 1:
                    String tipo = "ADMINISTRATIVO";
                    System.out.println("--------------------Administrativo--------------------");
                    int hora,
                     horaExtra,
                     horasTrabajadas,
                     salarioBruto,
                     pagoExtras,
                     extrasTrabajadas,
                     salario;
                    float ARL,
                     salud,
                     pension,
                     totalDescuentos,
                     totalPago;
                    String cargo,
                     nombre;
                    hora = 20000;
                    horaExtra = 25000;
                    ARL = 0.00522f;

                    cargo = "Auxliar administrativo";

                    Scanner string = new Scanner(System.in);
                    System.out.println("Ingrese nombre del empleado: ");
                    nombre = string.nextLine();

                    System.out.println("Ingrese numero de horas trabajadas:  ");
                    horasTrabajadas = string.nextInt();
                    salarioBruto = hora * horasTrabajadas;

                    System.out.println("Ingrese numero de horas extras trabajadas: ");
                    extrasTrabajadas = string.nextInt();
                    pagoExtras = horaExtra * extrasTrabajadas;

                    salario = salarioBruto + pagoExtras;

                    salud = 0.4f * salario;
                    pension = 0.4f * salario;
                    ARL = 0.00522f * salario;
                    totalDescuentos = salud + pension + ARL;

                    totalPago = salario - totalDescuentos;

                    String[] encabezados = {"Nombre", "Tipo", "Cargo", "HT", "Salario", "HE",
                        "TPHE", "Salud", "ARL", "Total a pagar"};

                    // Agregamos los encabezados a la matriz
                    matriz.add(encabezados);

                    // Creamos un arreglo con los datos del usuario
                    Object[] datosUsuario = {nombre, tipo, cargo, horasTrabajadas, salarioBruto,
                        extrasTrabajadas, pagoExtras, salud, ARL, totalPago};

                    // Agregamos los datos del usuario a la matriz
                    matriz.add(datosUsuario);

                    System.out.println("---------------------------------------------------------");
                    System.out.println("-------------------- Volante de pago --------------------");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Nombre:" + nombre);
                    System.out.println("Cargo:" + cargo);
                    System.out.println("Horas Trabajadas(mes):" + horasTrabajadas);
                    System.out.println("Salario Bruto : " + salarioBruto);
                    System.out.println("Horas Extras :" + extrasTrabajadas);
                    System.out.println("Total Pago Horas Extras :" + pagoExtras);
                    System.out.println("------------------------------------------------------------");
                    System.out.println("-------------------- Descuentos De Ley ---------------------");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Salud (4%) :" + salud);
                    System.out.println("Pension (4%) :" + pension);
                    System.out.println("ARL (0,522 %) : " + ARL);
                    System.out.println("Total Descuentos :" + totalDescuentos);
                    System.out.println("Total a Pagar :" + totalPago);
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("-------------------- Fin Volante De Pago --------------------");
                    System.out.println("-------------------------------------------------------------");

                    String formatoTabla = "%-20s | %-20S | %-22S | %-4S | %-10S | %-4S | %-10S | %-10S | %-10S | %-10S%n";

                    if (!archivo.exists()) { //Crear archivo

                        archivo.createNewFile();
                        escribir = new FileWriter(archivo, true); //escribir en el archivo
                        PrintWriter pw = new PrintWriter(archivo);

                        // se escribe el encabezado
                        pw.printf(formatoTabla, encabezados); // Escribimos los encabezados en el archivo de texto

                        pw.close();
                        escribir.close();

                    }
                    escribir = new FileWriter(archivo, true); //escribir en el archivo
                    PrintWriter pw = new PrintWriter(archivo);

                    // Escribimos los datos de los usuarios en el archivo de texto
                    pw.printf(formatoTabla, datosUsuario);

                    pw.close();
                    escribir.close();

                    System.out.println("Archivo Guardado");
                    System.out.println("");

                case 2:
                    tipo = "OPERATIVO";

                    System.out.println("Ingrese Tipo de Cargo : ");
                    System.out.print("1. conductor \n2.Oficios varios\n3.Vigilante   ");
                    n1 = opcion.nextInt();
                    System.out.print("Digite su nombre: ");
                    nombre = scNombre.nextLine();

                    int valoHora = 40000;
                    switch (n1) {

                        case 1: {
                            cargo = "Conductor";
                            int horas = 160;
                            double sueldo;
                            sueldo = valoHora * horas;
                            double cotizacion;
                            cotizacion = sueldo * 0.4;
                            salud = 4;
                            salud = (float) (cotizacion * 0.125);
                            pension = 4;
                            pension = (float) (cotizacion * 0.16);
                            double arl = cotizacion * 0.01044;
                            System.out.println("---------------------------------------------------------");
                            System.out.println("-------------------- Volante de pago --------------------");
                            System.out.println("---------------------------------------------------------");
                            System.out.println("Nombre: " + nombre);
                            System.out.println("Cargo: " + cargo);
                            System.out.println("Horas Trabajadas(mes): " + horas);
                            System.out.println("----------------------------------------------------------");
                            System.out.println("-------------------- Descuento de ley --------------------");
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Salud: " + salud);
                            System.out.println("Pensión: " + pension);
                            System.out.println("ARL: " + arl);
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("-------------------- Fin volante de pago --------------------");
                            System.out.println("-------------------------------------------------------------");
                            
                            break;
                        }
                        case 2:

                            int horas = 160;
                            cargo = "Oficios varios";
                            int sueldo;
                            sueldo = valoHora * horas;
                            double cotizacion;
                            cotizacion = sueldo * 0.4;
                            salud = 4;
                            salud = (float) (cotizacion * 0.125);
                            pension = 0;
                            pension = (float) (cotizacion * 0.16);
                            double arl;
                            arl = cotizacion * 0.000522;
                            System.out.println("---------------------------------------------------------");
                            System.out.println("-------------------- Volante de pago --------------------");
                            System.out.println("---------------------------------------------------------");
                            System.out.println("Nombre: " + nombre);
                            System.out.println("Cargo: " + cargo);
                            System.out.println("Horas Trabajadas(mes): " + horas);
                            System.out.println("-----------------------------------------------------------");
                            System.out.println(" -------------------- Descuento de ley --------------------");
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Salud: " + salud);
                            System.out.println("Pensión: " + pension);
                            System.out.println("ARL: " + arl);
                            System.out.println("------------------------------------------------------------------");
                            System.out.println(" -------------------- Fin del volante de pago --------------------");
                            System.out.println("------------------------------------------------------------------");
                            
                            break;

                        case 3:
                            cargo = "fdgdg";
                            horas = 336;
                            sueldo = 4;
                            sueldo = valoHora * horas;
                            cotizacion = 4;
                            cotizacion = sueldo * 0.4;
                            salud = 4;
                            salud = (float) (cotizacion * 0.125);
                            pension = 4;
                            pension = (float) (cotizacion * 0.16);
                            arl = 4;
                            arl = cotizacion * 0.0435;
                            System.out.println("----------------------------------------------------------");
                            System.out.println(" -------------------- Volante de pago --------------------");
                            System.out.println("----------------------------------------------------------");
                            System.out.println("Nombre: " + nombre);
                            System.out.println("Cargo: " + cargo);
                            System.out.println("Horas Trabajadas(mes): " + horas);
                            System.out.println("-----------------------------------------------------------");
                            System.out.println(" -------------------- Descuento de ley --------------------");
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Salud: " + salud);
                            System.out.println("Pensión: " + pension);
                            System.out.println("ARL: " + arl);
                            System.out.println("------------------------------------------------------------------");
                            System.out.println(" -------------------- Fin del volante de pago --------------------");
                            System.out.println("------------------------------------------------------------------");
                            
                            break;
                    }
            }

        

    



} while (n1 < 1 || n1
                > 2);

    }

}
