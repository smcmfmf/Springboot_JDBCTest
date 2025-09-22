package kr.ac.kopo.smcmfmf.springboot_jdbctest.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripion;
    private float weight;
    private float width;
    private float height;

    @OneToOne
    @JoinColumn(name = "product_id")
    @MapsId
    private Product product;
}
