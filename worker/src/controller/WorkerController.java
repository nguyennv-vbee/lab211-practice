package controller;

import constants.Message;
import constants.SalaryStatus;
import dto.SalaryChangeRequestDTO;
import dto.WorkerRequestDTO;
import services.Management;
import view.WorkerView;

// Controller only coordinates DTO -> Service -> View.
public class WorkerController {
    private final Management management;
    private final WorkerView workerView;

    public WorkerController() {
        management = new Management();
        workerView = new WorkerView();
    }

    public void addWorker(WorkerRequestDTO request) throws Exception {
        if (management.addWorker(request)) {
            workerView.showMessage(Message.ADD_SUCCESS);
        }
    }

    public void changeSalary(SalaryStatus status, SalaryChangeRequestDTO request) {
        if (management.changeSalary(status, request.getCode(), request.getAmount())) {
            workerView.showMessage(Message.CHANGE_SUCCESS);
        }
    }

    public void showSalaryHistory() {
        workerView.showSalaryHistory(management.getSalaryHistoryResponse());
    }
}
