package pkgenum;

import java.util.Scanner;


public class Enum {
    private static final Scanner ENTRADA = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE PEDIDOS ===");
        int capacidad = leerEnteroPositivo("Capacidad máxima de pedidos: ");
        GestorPedidos gestor = new GestorPedidos(capacidad);

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarPedido(gestor);
                    break;
                case 2:
                    buscarPedido(gestor);
                    break;
                case 3:
                    cambiarEstado(gestor);
                    break;
                case 4:
                    listarPorEstado(gestor);
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Agregar pedido");
        System.out.println("2. Buscar pedido por ID");
        System.out.println("3. Cambiar estado de un pedido");
        System.out.println("4. Listar pedidos por estado");
        System.out.println("0. Salir");
    }

    private static void registrarPedido(GestorPedidos gestor) {
        System.out.println("\n--- NUEVO PEDIDO ---");
        int id = leerEntero("ID: ");
        String cliente = leerTexto("Cliente: ");
        double monto = leerDoubleNoNegativo("Monto: ");

        System.out.println("1. Nacional");
        System.out.println("2. Internacional");
        int tipo = leerOpcionEnRango("Tipo de pedido: ", 1, 2);
        double tarifaBase = leerDoubleNoNegativo("Tarifa base: ");

        Pedido pedido;
        if (tipo == 1) {
            double tarifaPorKilometro = leerDoubleNoNegativo("Tarifa por kilómetro: ");
            double distanciaKm = leerDoubleNoNegativo("Distancia en kilómetros: ");
            pedido = new PedidoNacional(
                    id, cliente, monto, tarifaBase, tarifaPorKilometro, distanciaKm);
        } else {
            double costoAduana = leerDoubleNoNegativo("Costo de aduana: ");
            String paisDestino = leerTexto("País de destino: ");
            pedido = new PedidoInternacional(
                    id, cliente, monto, tarifaBase, paisDestino, costoAduana);
        }

        try {
            gestor.agregarPedido(pedido);
            System.out.println("Pedido agregado correctamente.");
        } catch (CapacidadException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void buscarPedido(GestorPedidos gestor) {
        int id = leerEntero("ID del pedido: ");
        try {
            System.out.println(gestor.buscarPorId(id));
        } catch (PedidoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void cambiarEstado(GestorPedidos gestor) {
        int id = leerEntero("ID del pedido: ");
        EstadoPedido nuevoEstado = seleccionarEstado();

        try {
            gestor.cambiarEstado(id, nuevoEstado);
            System.out.println("Estado actualizado correctamente.");
        } catch (PedidoNoEncontradoException | TransicionEstadoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listarPorEstado(GestorPedidos gestor) {
        EstadoPedido estado = seleccionarEstado();
        Pedido[] encontrados = gestor.listarPorEstado(estado);

        if (encontrados.length == 0) {
            System.out.println("No hay pedidos en el estado " + estado + ".");
            return;
        }

        System.out.println("\nPedidos en estado " + estado + ":");
        for (Pedido pedido : encontrados) {
            System.out.println(pedido);
        }
    }

    private static EstadoPedido seleccionarEstado() {
        EstadoPedido[] estados = EstadoPedido.values();
        System.out.println("Estados disponibles:");
        for (int i = 0; i < estados.length; i++) {
            System.out.println((i + 1) + ". " + estados[i]
                    + " - " + estados[i].getDescripcion());
        }

        int opcion = leerOpcionEnRango("Seleccione un estado: ", 1, estados.length);
        return estados[opcion - 1];
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String valor = ENTRADA.nextLine().trim();
            try {
                return Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    private static int leerEnteroPositivo(String mensaje) {
        while (true) {
            int valor = leerEntero(mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("El valor debe ser mayor que cero.");
        }
    }

    private static int leerOpcionEnRango(String mensaje, int minimo, int maximo) {
        while (true) {
            int opcion = leerEntero(mensaje);
            if (opcion >= minimo && opcion <= maximo) {
                return opcion;
            }
            System.out.println("Seleccione una opción entre " + minimo + " y " + maximo + ".");
        }
    }

    private static double leerDoubleNoNegativo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String valor = ENTRADA.nextLine().trim().replace(',', '.');
            try {
                double numero = Double.parseDouble(valor);
                if (Double.isFinite(numero) && numero >= 0) {
                    return numero;
                }
            } catch (NumberFormatException e) {
                
            }
            System.out.println("Ingrese un número válido mayor o igual que cero.");
        }
    }

    private static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = ENTRADA.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("El texto no puede estar vacío.");
        }
    }
}
