package com.desafio_android_franklin_gaspar.model.to;

import java.util.List;

public class DataPersonagens {

    private Integer offset;
    private Integer limit;
    private Integer total;
    private Integer count;
    private List<ResultadoPersonagem> results;

    public List<ResultadoPersonagem> getResults() {
        return results;
    }

    public void setResultadoPersonagems(List<ResultadoPersonagem> resultadoPersonagems) {
        this.results = resultadoPersonagems;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
