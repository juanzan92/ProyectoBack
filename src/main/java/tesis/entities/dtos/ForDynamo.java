package tesis.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
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

    public void setSearchParams(String indexName, String searchParams) {
        this.setIndexName(indexName);
        this.setSearchPattern(searchParams);
    }
}
