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
@Table(name = "izd_branches")
public class IzdBranches {

    @Id
    private String BRANCH;
    private String BANK_CODE;
    private String BRANCH_NAME;
    private String POST_IND;
    private String CITY;
    private String STREET;
    private String MFO;
    private String BANK_C;
    private String USRID;
    private LocalDate CTIME;
    private String REG_KODS_UR;
    private String REG_KODS_VID;
    private Integer B_BR_ID;
    private String E_MAILS;
    private String IN_PATH;
    private String OUT_PATH;
    private String FAX_NO;
    private String ENCRYPT_KEY;
    private String COR_PREFIX;
    private String XML_BRANCH;
    private String ACC_NUM_SEQ;
    private String BIC;
    private Integer OCATO_CODE;
}
