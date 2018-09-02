package top.aprillie.module.user.entity;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class UserAuth {
    private Long id;

    private Long userId;

    private Byte identityType;

    private Boolean activation;

    private Boolean verification;

    private String identifier;

    @NotBlank(message = "密码不能为空！")
    private String credential;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Byte identityType) {
        this.identityType = identityType;
    }

    public Boolean getActivation() {
        return activation;
    }

    public void setActivation(Boolean activation) {
        this.activation = activation;
    }

    public Boolean getVerification() {
        return verification;
    }

    public void setVerification(Boolean verification) {
        this.verification = verification;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}