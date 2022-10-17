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
@Table(name = "izd_clients")
public class IzdClients {

    @Id
    private String client;

    private String bank_c;

    private String client_b;

    private String clType;

    private String clnCat;

    private LocalDate recDate;

    private String fNames;

    private String surname;

    private String title;

    private String mName;

    private LocalDate bDate;

    private char resident;

    private String idCard;

    private String docType;

    private String rPhone;

    private String empName;

    private String position;

    private LocalDate date;

    private String workPhone;

    private String rStreet;
    private String rCity;
    private String rCntry;
    private String rPcode;
    private String cSince;
    private String cmpName;
    private String cmpgName;
    private String coPosition;
    private String contact;
    private String cntTitle;
    private String cntPhone;
    private String cntFax;
    private String mngPosit;
    private String mngName;
    private String mngPhone;
    private String mngTitle;
    private String mngFax;
    private String crStreet;
    private String crCntry;
    private String crPcode;
    private String usrid;
    private LocalDate ctime;
    private String status;
    private String coment;
    private String region;
    private String personCode;
    private LocalDate residentSince;
    private Integer yearInc;
    private String ccyForIncom;
    private Integer immPropValue;
    private String searchName;
    private char maritalStatus;
    private String coCode;
    private String empCode;
    private char sex;
    private String serial_no;
    private LocalDate docSince;
    private String issuedBy;
    private String empAdr;
    private String empFax;
    private String emp_e_mails;
    private String r_e_mails;
    private String r_mob_phone;
    private String r_fax;
    private String cnt_e_mails;
    private String cntMobPhone;
    private String mngMobPhone;
    private String mng_e_mails;
    private String cr_e_mails;
    private Integer inFileNum;
    private String u_cod1;
    private String u_cod2;
    private String u_cod3;
    private String u_field1;
    private String u_field2;
    private String callId;
    private String homeNumber;
    private String building;
    private String street1;
    private String apartment;
    private String mbMerchantId;
    private Integer mbClient;
    private String insiderLabel;
    private String economicSector;
    private String formOfProperty;
    private String businessSubj;
    private String branchOfEconomy;
    private String smallBusinesFlag;
    private String f_name1;
    private String midleName;
    private String branchOfEconomic;
    private String smallBusinesType;
    private LocalDate amexMemberSince;
    private String nationality;
    private Integer inOrderNumber;
    private LocalDate statusChangeDate;
    private String rewardNo;
    private LocalDate wlcmUpdTime;
    private LocalDate dciMemberSince;
    private LocalDate discoverMemberSince;















}
