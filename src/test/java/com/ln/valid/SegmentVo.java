package com.ln.valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
//    @GroupSequence({SegmentVo.class})
@GroupSequenceProvider(WCGroupSequenceProvider.class)
public class SegmentVo {

    private boolean flag;

    @NotNull
    @NotEmpty(groups={AvailableFlightGroup.class},message="城市不能为空")
    private String deptCity;


    @Pattern(regexp="[A-Z]{3}", groups={DestinationFlightGroup.class})
    @NotEmpty(groups={DestinationFlightGroup.class},message="到达城市不能为空")
    private String arrCity;


    @NotEmpty(message = "出发日期不能为空")
    private String deptDate;

    @NotEmpty(message = "到达日期不能为空")
    private String arrDate;

    @NotEmpty(message = "邮件不能为空")
    private String email;

    public String getDeptCity() {
        return deptCity;
    }

    public void setDeptCity(String deptCity) {
        this.deptCity = deptCity;
}

    public String getArrCity() {
        return arrCity;
    }

    public void setArrCity(String arrCity) {
        this.arrCity = arrCity;
    }

    public String getDeptDate() {
        return deptDate;
    }

    public void setDeptDate(String deptDate) {
        this.deptDate = deptDate;
    }

    public String getArrDate() {
        return arrDate;
    }

    public void setArrDate(String arrDate) {
        this.arrDate = arrDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
