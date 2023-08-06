package Java8ByProgRank;

public class SortCollectionUsingLambda {
    private String EmpName;
    private int empID;



    public SortCollectionUsingLambda(String empName, int empID)
    {
        super();
        this.EmpName=empName;
        this.empID=empID;
    }

    public String getEmpName() {
        return EmpName;
    }

    public int getEmpID() {
        return empID;
    }

    @Override
    public String toString() {
        return "SortCollectionUsingLambda{" + "EmpName='" + EmpName + '\'' + ", empID=" + empID + '}';
    }
}
