package kr.ac.kopo.smcmfmf.springboot_jdbctest.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID의 값이 1씩 자동으로 증가함
    private int id;
    private String name;
    private int age;
    private String email;
}
