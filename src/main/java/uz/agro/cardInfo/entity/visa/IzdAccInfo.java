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
@Table(name = "izd_acc_info")
public class IzdAccInfo {

    @Id
    private Integer ACCOUNT_NO;
    private String CLIENT;
    private String CARD_ACCT;
    private String BANK_C;
    private String GROUPC;
    private LocalDate CTIME;
    private String AC_STATUS;
    private String CL_STATUS;
    private String ACC_PRTY;
    private String C_ACCNT_TYPE;
    private String CCY;
    private String COND_SET;
    private Integer CRD;
    private Integer MIN_BAL;
    private Integer NON_REDUCE_BAL;
    private Integer AUTH_BONUS;
    private LocalDate AB_EXPIRITY;
    private String CYCLE;
    private Integer B_BR_ID;
    private String CLN_CAT;
    private String CL_TYPE;
    private String RESIDENT;
    private String REGION;
    private String CL_COMP_CODE;
    private String PERSON_CODE;
    private String F_NAMES;
    private String SURNAME;
    private String CMP_NAME;
    private String REP_LANG;
    private String PRODUCT;
    private String DISTRIB_MODE;
    private String COUNTRY;
    private String CITY;
    private String STREET;
    private String POST_IND;
    private String E_MAILS;
    private String U_COD1;
    private String U_COD2;
    private String U_COD3;
    private String U_COD7;
    private String U_COD8;
    private String PAY_CODE;
    private String PAY_FREQ;
    private String CALCUL_MODE;
    private String INSIDER_LABEL;
    private String EKONOMIC_SECTOR;
    private LocalDate CRD_EXPIRY;
    private String F_NAME1;
    private String MIDLE_NAME;
    private String FORM_OF_PROPERTY;
    private String BUSINESS_SUBJ;
    private String BRANCH_OF_ECONOMIC;
    private String SMALL_BUSINES_TYPE;
    private String TRANZ_ACCT;
    private String R_COUNTRY;
    private String OFFICE;
    private Integer OFFICE_ID;
    private String CONTACT;
    private Integer MAIN_ROW;
    private String CLIENT_B;
    private String SEARCH_NAME;
    private String CMPG_NAME;
    private String U_FIELD5;
    private String U_FIELD6;
    private String DOC_TYPE;
    private Integer TAB_KEY;
    private String BRANCH;
    private LocalDate CREATED_DATE;
    private String U_FIELD2;

}
