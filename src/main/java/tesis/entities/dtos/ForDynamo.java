package tesis.entities.dtos;

public class ForDynamo {

    String tableName;
    String tablePrimary;
    String tableIndex;
    String searchValue;

    public ForDynamo(String tableName, String tablePrimary, String tableIndex, String searchValue) {
        this.tableName = tableName;
        this.tablePrimary = tablePrimary;
        this.tableIndex = tableIndex;
        this.searchValue = searchValue;
    }

    public ForDynamo(String tableName, String tablePrimary) {
        this.tableName = tableName;
        this.tablePrimary = tablePrimary;
        }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTablePrimary() {
        return tablePrimary;
    }

    public void setTablePrimary(String tablePrimary) {
        this.tablePrimary = tablePrimary;
    }
}
