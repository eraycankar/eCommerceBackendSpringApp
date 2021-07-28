package com.dev.ecommerce.dto;

import java.time.LocalDate;
import java.util.Objects;

public class GetOrdersFromDateRange {
    Long id;
    LocalDate creationDate;

    public GetOrdersFromDateRange() {
    }

    public GetOrdersFromDateRange(Long id, LocalDate creationDate) {
        this.id = id;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetOrdersFromDateRange that = (GetOrdersFromDateRange) o;
        return Objects.equals(id, that.id) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate);
    }
}
