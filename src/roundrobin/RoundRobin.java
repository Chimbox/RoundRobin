package roundrobin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Alfonso Felix
 */
public class RoundRobin {

    private static final int QUANTUM = 2;
    private static Queue<Proceso> procesador;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        procesador = new LinkedList<>();

        Proceso proceso1 = new Proceso("Netbeans");
        proceso1.setRafaga(6);

        Proceso proceso2 = new Proceso("Chrome");
        proceso2.setRafaga(4);

        Proceso proceso3 = new Proceso("AndroidStudio");
        proceso3.setRafaga(8);

        Proceso proceso4 = new Proceso("Discord");
        proceso4.setRafaga(2);

        Proceso proceso5 = new Proceso("VisualStudio");
        proceso5.setRafaga(10);

        Proceso proceso6 = new Proceso("SharpDevelop");
        proceso6.setRafaga(7);

        procesador.add(proceso1);
        procesador.add(proceso2);
        procesador.add(proceso3);
        procesador.add(proceso4);
        procesador.add(proceso5);
        procesador.add(proceso6);

        muestraProcesos();

        tec.nextLine();

        while (true) {
            Proceso p = null;
            if ((p = procesador.poll()) != null) {
                int diferencia = p.getRestante() - QUANTUM;
                if (diferencia > 0) {
                    p.setRestante(diferencia);
                    procesador.add(p);
                } else if (procesador.isEmpty()) {
                    break;
                }

                muestraProcesos();
                tec.nextLine();
            } else {
                break;
            }
        }

        System.out.println("\n\nTodos los procesos han terminado.");
    }

    private static void muestraProcesos() {
        System.out.println("- - - - - - P R O C E S A D O R - - - - - -");
        System.out.println("Q U A N T U M = " + QUANTUM);

        System.out.println("\nN O M B R E          R Á F A G A          R E S T A N T E");
        for (Proceso proceso : procesador) {
            if (proceso.equals(procesador.peek())) {
                System.out.format("%-21s%-21d%-15d\n", ("[A]>"+proceso.getNombre()+"<[A]"), proceso.getRafaga(), proceso.getRestante());
            } else {
                System.out.format("%-21s%-21d%-15d\n", proceso.getNombre(), proceso.getRafaga(), proceso.getRestante());
            }
        }
    }
}
