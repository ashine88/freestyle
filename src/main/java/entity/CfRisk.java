package entity;/**
 * Created by liushuai2 on 2018/4/11.
 */

/**
 * Package : entity
 *
 * @author YixinCapital -- liushuai2
 *         2018年04月11日 15:28
 */
public class CfRisk {
    private String id;
    private String applyNo;
    private String flowingAccount;
    private String results;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getFlowingAccount() {
        return flowingAccount;
    }

    public void setFlowingAccount(String flowingAccount) {
        this.flowingAccount = flowingAccount;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }
}
