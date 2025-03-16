package by.epam.ch1.number.model;

public enum SortOrderN {
    ASCENDING, DESCENDING;

    public static SortOrderN from(String order) {
        return switch (order.toLowerCase()) {
            case "ascending", "asc" -> ASCENDING;
            case "descending", "desk" -> DESCENDING;
            default -> null;
        };
    }
}
