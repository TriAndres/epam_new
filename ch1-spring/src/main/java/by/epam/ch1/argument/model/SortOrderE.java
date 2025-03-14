package by.epam.ch1.argument.model;

public enum SortOrderE {
    ASCENDING, DESCENDING;

    public static SortOrderE from(String order) {
        return switch (order.toLowerCase()) {
            case "ascending", "asc" -> ASCENDING;
            case "descending", "desc" -> DESCENDING;
            default -> null;
        };
    }
}