package utils;

public class DataStore {
    private static Object idReserva;

    public static Object getIdReserva() {
        return idReserva;
    }

    public static void setIdReserva(Object value) {
        idReserva = value;
    }
}
