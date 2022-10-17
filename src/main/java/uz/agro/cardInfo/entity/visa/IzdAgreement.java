package uz.agro.cardInfo.entity.visa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "izd_agreement")
public class IzdAgreement {

    @Id
    private Integer AGRE_NOM;
    private String CLIENT;
    private String GROUPC;
    private String BINCOD;
    private LocalDate ENROLLED;
    private String CONTRACT;
    private String RISK_LEVEL;
    private String STREET;
    private String CITY;
    private String COUNTRY;
    private String POST_IND;
    private String BANK_CODE;
    private String BRANCH;
    private String BANK_C;
    private String USRID;
    private LocalDate CTIME;
    private String REP_LANG;
    private String STATUS;
    private String COMENT;
    private String DISTRIB_MODE;
    private String E_MAILS;
    private String ISURANCE_TYPE;
    private String U_COD4;
    private String U_CODE5;
    private String U_CODE6;
    private String U_FIELD3;
    private String U_FIELD4;
    private Integer IN_FILE_NUM;
    private Integer B_BR_ID;
    private String PRODUCT;
    private Integer PARENT_AGRE_NOM;
    private String PARENT_CLIENT;
    private String PARENT_BANK_C;
    private String PARENT_GROUPC;
    private String OFFICE;
    private Integer OFFICE_ID;
    private Integer IN_ORDER_NUMBER;
    private Integer COMBI_ID;
    private String COMBI_TYPE;





}
