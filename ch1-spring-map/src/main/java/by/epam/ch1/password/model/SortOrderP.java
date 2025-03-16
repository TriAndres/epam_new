package by.epam.ch1.password.model;

public enum SortOrderP {
    ASCENDING, DESCENDING;

    public static SortOrderP from(String order) {
        return switch (order.toLowerCase()) {
            case "ascending", "ask" -> ASCENDING;
            case "descending", "desk" -> DESCENDING;
            default -> null;
        };
    }
}