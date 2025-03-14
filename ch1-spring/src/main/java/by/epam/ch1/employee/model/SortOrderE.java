package by.epam.ch1.employee.model;

public enum SortOrderE {
    ASCENDING, DESCENDING;

    public static SortOrderE from(String order) {
        return switch (order.toLowerCase()) {
            case "ascending", "asc" -> ASCENDING;
            case "descending", "desk" -> DESCENDING;
            default -> null;
        };
    }
}