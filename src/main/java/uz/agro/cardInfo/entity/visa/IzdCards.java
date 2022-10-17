package uz.agro.cardInfo.entity.visa;

import io.swagger.models.auth.In;
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
@Table(name = "IZD_CARDS")
public class IzdCards {

    @Id
    private String CARD;

    private String CARD_SUFIKS;
    private String CARD_NUM;
    private String CARD_TYPE;
    private Integer CL_ACCT_KEY;
    private Integer AGREEMENT_KEY;
    private String BASE_SUPP;
    private String COND_SET;
    private String RISK_LEVEL;
    private String STATUS1;
    private String STATUS2;
    private LocalDate EXPIRY1;
    private LocalDate EXPIRITY2;
    private LocalDate REC_DATE;
    private String RENEW;
    private LocalDate RENEW_DATE;
    private String CARD_NAME;
    private String MC_NAME;
    private String M_NAME;
    private String RELATION;
    private String ID_CARD;
    private LocalDate B_DATE;
    private String PIN_NR;
    private String PIN_ENCR;
    private String CVC1_1;
    private String CVC1_2;
    private String CVC2_1;
    private String CVC2_2;
    private String PVV_1;
    private String PVV_2;

    private String PVV2_1;
    private String PVV2_2;

    private String TRACK1_1;
    private String TRACK1_2;

    private String TRACK2_1;
    private String TRACK2_2;

    private String PIN_FLAG;
    private String PIN_OPER;

    private LocalDate PIN_RECDAT;
    private String REGION;

    private LocalDate PURGE_DAT;

    private String ROUT_FLAG;
    private String BANK_C;
    private String USRID;
    private LocalDate CTIME;
    private String GROUPC;
    private String OPER_OWNER;
    private String CMPG_NAME;
    private String STOP_CAUSE;
    private String INSURANC_TYPE;
    private LocalDate INSURANC_DATE;
    private String CRD_HOLD_MSG;
    private String U_COD9;
    private String U_COD10;
    private String U_FIELD7;
    private String U_FIELD8;
    private Integer IN_FILE_NUM;
    private Integer BR_ID;
    private LocalDate RENEW1_DATE;
    private String COLLECTION;
    private Integer COLL_STATUS;
    private Integer OUT_FILE_NUM;
    private Integer EMB_SESSION;
    private String RENEW_SHADOW;
    private LocalDate EXPIRY2_SHADOW;
    private LocalDate RENEWED_CARD;
    private Integer LS_ACCOUNT_NO;
    private String CALL_ID;
    private String F_NAMES;
    private String SURNAME;
    private LocalDate DOC_SINCE;
    private String PLAY_FLAG;
    private String MPLAY_FLAG;
    private String SEQUENCE_NR;
    private String LAST_SEQ_NR;
    private Integer DESIGN_ID;
    private Integer CHIP_APP_ID;
    private LocalDate LAST_EMB_DATETIME;
    private String DKI_0;
    private String DKI_1;
    private String DKI_2;
    private String INDIVIDUALIZED;
    private String TRACK2_EQUIV_DATA;
    private String INDIVIDUALIZED_PREV;
    private String MB_PHONE;
    private String MB_KEY_PUB;
    private String MB_KEY_PRIV;
    private Integer MB_SIM_ID;
    private Integer MB_MCARD;
    private Integer MB_STATUS;
    private String MB_LANG;
    private String PVKI_1;
    private String PVKI_2;
    private String CARD_SERVICES_SET;
    private LocalDate OUTSIDE_REQUESTED_EXPIRY;
    private Integer IN_ORDER_NUMBER;
    private String PIN_ZPK;
    private String CARD_FEES;
    private Integer OFFLINE_LIMIT1;
    private Integer OFFLINE_LIMIT2;
    private Integer SHADOW_APP_ID;
    private String SHADOW_RISK;
    private String OFF_COND;
    private Integer CC_PIN;
    private String PARTNER_ID;
    private String F_NAME1;
    private String MIDLE_NAME;
    private String SERIAL_NO;
    private String PARAM_112;
    private String insurance_flag;
    private LocalDate ins_begin_date;
    private LocalDate ins_end_date;
    private String in_renew_card;
    private LocalDate in_renew_expiry;
    private LocalDate last_activity_date;
    private Integer pvv_count_1;
    private Integer pvv_count_2;
    private LocalDate status_change_date;
    private String hint_question;
    private String hint_answer;
    private String mb_notify;
    private String mb_agr_nr;
    private String renew_comment;
    private String renew_status1;
    private String RENEW_STOP_CAUSE;
    private LocalDate effective_date1;
    private LocalDate effective_date2;
    private String csc4_1;
    private String csc5_1;
    private String csc4_2;
    private String csc5_2;
    private String client_id;
    private String cl_role;
    private String STOP_CAUSE2;
    private String in_renew_bin;
    private Integer in_renew_design;
    private String in_renew_cond_set;
    private String inactive1;
    private String inactive2;
    private String cond_set_2;
    private LocalDate cond_change_date;
    private LocalDate change_back_date;
    private String u_cod10_1;
    private String u_field8_1;
    private String design_change;
    private String u_field11;
    private String u_field12;
    private String u_field13;
    private String u_field14;
    private LocalDate relink_date;
    private String no_name;
    private Integer internal_no;
    private Integer combi_id;
    private String e_file_flag;
    private String e_file_flag2;
    private String pin_phone;
    private String pin_e_mail;
    private Integer token_design_id;
    private String add_info;
    private String combi_status;
    private String ico_export;
    private String vau_q_flag;
    private String vau_replace_flag;
    private String post_delivery_type;
    private String suppl_algo_option;
    private Integer suppl_algo_seq_nr;
    private String play2_flag;
    private LocalDate renew2_date;
    private String doublet_Fee_flag;
    private String waived_emb;
    private LocalDate rl_start_date;
    private LocalDate rl_end_date;
    private String rl_change_reason;













}
