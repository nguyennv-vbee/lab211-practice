package view;

import constants.Message;
import dto.SalaryHistoryResponseDTO;
import java.util.List;

public class WorkerView {
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showSalaryHistory(List<SalaryHistoryResponseDTO> histories) {
        if (histories.isEmpty()) {
            showMessage(Message.NO_HISTORY);
            return;
        }
        System.out.println(Message.HISTORY_TITLE);
        System.out.printf(Message.HISTORY_HEADER, "Code", "Name", "Age", "Salary", "Status", "Date");
        System.out.println(Message.HISTORY_SEPARATOR);
        for (SalaryHistoryResponseDTO history : histories) {
            System.out.printf(Message.HISTORY_ROW, history.getCode(), history.getName(),
                    history.getAge(), history.getSalary(), history.getStatus(), history.getDate());
        }
    }
}
