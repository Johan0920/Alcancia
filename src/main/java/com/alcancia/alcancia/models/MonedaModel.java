package com.alcancia.alcancia.models;


import javax.persistence.*;

@Entity
@Table(name="moneda")
public class MonedaModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer id;
    private Integer valor;
    private String tipo;


    public void setId(Integer id){
        this.id=id;
    }

    public Integer getId(){
        return id;
    }

    public void setValor(Integer valor){
        this.valor=valor;
    }

    public Integer getValor(){
        return valor;
    }

    public void setTipo(String tipo){
            this.tipo=tipo;
    }

    public String getTipo(){
        return tipo;
    }
}
