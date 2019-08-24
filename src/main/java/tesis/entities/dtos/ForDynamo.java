package tesis.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForDynamo {

    @JsonProperty("table_name")
    String tableName;

    @JsonProperty("table_primary")
    String tablePrimary;

    @JsonProperty("index_name")
    String indexName;

    @JsonProperty("search_pattern")
    String searchPattern;

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

    public String getIndexName() { return indexName; }

    public void setIndexName(String indexName) { this.indexName = indexName;}

    public String getSearchPattern() { return searchPattern; }

    public void setSearchPattern(String searchPattern) { this.searchPattern = searchPattern; }

    public void  setSearchParams ( String indexName, String searchParams) {
        this.setIndexName(indexName);
        this.setSearchPattern(searchParams);
    }

}
