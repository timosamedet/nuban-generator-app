package com.aggregate.solution.nuban.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Timosamedet
 * @since Dec 6, 2023 1:26:21 PM
 */
@Entity
@Table(name = "nuban")
@Getter
@Setter
@NoArgsConstructor
public class Nuban implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "serialNumber", length = 9, unique = true)
    private String serialNumber;

    @Column(name = "bankCode", length = 3)
    private String bankCode;

    @Column(name = "nubanGenerated", length = 10, unique = true)
    private String nubanGenerated;

    @Column(name = "checkCode", length = 1)
    private int checkDigit;

    private String bankName;

    @Override
    public String toString()
    {
        return "Nuban{" + "serialNumber=" + serialNumber + ", bankCode=" + bankCode + ", nubanGenerated=" + nubanGenerated + ", checkDigit=" + checkDigit + ", bankName=" + bankName + '}';
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        final Nuban other = (Nuban)obj;
        if(!Objects.equals(this.serialNumber, other.serialNumber))
            return false;
        if(!Objects.equals(this.bankCode, other.bankCode))
            return false;
        if(!Objects.equals(this.nubanGenerated, other.nubanGenerated))
            return false;
        return Objects.equals(this.checkDigit, other.checkDigit);
    }

}
