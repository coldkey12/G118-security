package kz.bitlab.G118security.model;

import jakarta.persistence.*;
import kz.bitlab.G118security.enums.MarkEnum;
import kz.bitlab.G118security.model.base.BaseEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Item extends BaseEntity {
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "PRICE", columnDefinition = "TEXT")
    private BigDecimal price;

    @Column(name = "POINT")
    private Integer point;

    @Column(name = "MARK")
    private String mark;
}
