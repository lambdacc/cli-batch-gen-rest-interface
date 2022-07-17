package dev.lambdac.clibatchgenrestinterface.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "data_record")
@Getter
@Setter
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

    @Override
    public String toString() {
        return String.join(",", String.valueOf(id), address, assetId, assetName, String.valueOf(amount));
    }
}
