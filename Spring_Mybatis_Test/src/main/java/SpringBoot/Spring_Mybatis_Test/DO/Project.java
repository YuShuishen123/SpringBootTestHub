package SpringBoot.Spring_Mybatis_Test.DO;

import lombok.Data;

import java.util.Date;

@Data
public class Project {
    private Integer projectId;
    private String projectName;
    private Date startDate;
    private Date endDate;
}
