package com.petshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servicos")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do serviço é obrigatório")
    @Size(max = 100, message = "O nome do serviço deve ter no máximo 100 caracteres")
    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

    @Positive(message = "O preço deve ser um valor positivo")
    @Column(nullable = false)
    private BigDecimal preco;

    @PositiveOrZero(message = "A duração deve ser um valor positivo ou zero")
    @Column
    private int duracaoMinutos;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public int getDuracaoMinutos() { return duracaoMinutos; }
    public void setDuracaoMinutos(int duracaoMinutos) { this.duracaoMinutos = duracaoMinutos; }
}