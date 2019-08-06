package tesis.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForDynamo {

    @JsonProperty("table_name")
    String tableName;

    @JsonProperty("table_primary")
    String tablePrimary;

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
