/**
 * 抽象处理者类
 */
public abstract class Handler {
    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVEN = 7;

    // 领领导处理的请假天数区间
    private int numStart;
    private int numEnd;

    // 声明后继者
    private Handler nextHandler;

    public Handler(int numStart) {
        this.numStart = numStart;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;  // 最大处理天数
    }

    /**
     * 设置上机领导（后继者）
     * @param nextHandler 上级领导
     */
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // 各级领导处理请假条的方法
    protected abstract void handleLevel(LeaveRequest leave);

    // 提交请假条
    public final void submit(LeaveRequest leave) {
        // 领导进行审批
        this.handleLevel(leave);
        if (this.nextHandler != null && leave.getNum() > this.numEnd) {
            // 提交上级领导审批
            this.nextHandler.submit(leave);
        }else {
            System.out.println("流程结束");
        }
    }
}
