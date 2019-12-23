package com.ntuzy.responsibilitychain;

public class Client {
    public static void main(String[] args){
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 5000, 1);

        // 创建相关的审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("主任");
        CollegeApprover collegeApprover = new CollegeApprover("院长");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("副校长");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("校长");


        // 将各个审批级别下一个人处理 (处理人构成环形) 确认任意人处理都可以正常执行
        // 否则只能从开头进行
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        departmentApprover.processRequest(purchaseRequest);

        schoolMasterApprover.processRequest(purchaseRequest);

    }
}
