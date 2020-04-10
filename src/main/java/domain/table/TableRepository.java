package domain.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static Table of(String tableNumber){
        return tables().stream()
            .filter(table -> table.isEquals(tableNumber))
            .findFirst()
            .orElseThrow(()->new InvalidTableException(InvalidTableException.INVALID_TABLE_NUMBER));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }
}
