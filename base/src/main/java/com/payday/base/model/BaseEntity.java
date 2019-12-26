package com.payday.base.model;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    @Column(name = "update_date")
    private Date updateDate;

}
