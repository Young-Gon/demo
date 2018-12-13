package com.example.demo.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_order", schema = "helloworld", catalog = "")
public class TbOrderEntity {
    private int id;
    private String orderName;
    @Nullable
    private PersonEntity person;
    private int personId;

    public TbOrderEntity() {
    }

    public TbOrderEntity(@NotNull String orderName, @Nullable PersonEntity person) {
        this.orderName = orderName;
        this.person = person;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_name")
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Basic
    @Column(name = "person_id")
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbOrderEntity that = (TbOrderEntity) o;
        return id == that.id &&
                personId == that.personId &&
                Objects.equals(orderName, that.orderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderName, personId);
    }
}
