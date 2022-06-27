package dev.lambdac.clibatchgenrestinterface.model;

import javax.persistence.*;

@Entity
@Table(name = "data_record")
public class DataRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "address")
    private String address;

    @Column(name = "asset_id")
    private String assetId;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "amount")
    private long amount;

}
