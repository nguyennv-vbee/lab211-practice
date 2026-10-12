# J1.S.P0071 - Task management

Bài 71 sử dụng cùng cấu trúc với bài `worker`:

```text
src/
├── constants/   Constants, Message, TaskType
├── controller/  TaskController
├── dto/         TaskRequestDTO, TaskResponseDTO
├── main/        Main
├── model/       Task
├── repository/  TaskRepository
├── services/    Management
├── utils/       Validation
└── view/        TaskView
```

`Main` nhập dữ liệu và tạo request DTO. Controller gọi service và view.
Service kiểm tra dữ liệu, tạo model, gọi repository và chuyển model sang response DTO.
Repository lưu dữ liệu trong bộ nhớ; view hiển thị thông báo và bảng task.

Các phương thức theo đề nằm trong `services.Management`:

- `int addTask(String requirementName, String assignee, String reviewer, String taskTypeID, String date, String planFrom, String planTo) throws Exception`
- `void deleteTask(String id) throws Exception`
- `List<Task> getDataTasks()`

Task Type cố định: `1 = Code`, `2 = Test`, `3 = Design`, `4 = Review`.
Ngày được kiểm tra bằng `SimpleDateFormat`, định dạng `dd-MM-yyyy`.
Giờ từ `8.0` đến `17.5`, bước `0.5`, và From phải nhỏ hơn To.
ID bắt đầu từ 1, tăng theo task được thêm thành công gần nhất và không tái sử dụng sau khi xóa.
Bảng hiển thị theo ID tăng dần; cột Time bằng `Plan To - Plan From`.
Dữ liệu tồn tại trong phiên chạy chương trình.

Chạy trong thư mục `task` với JDK 8 trở lên:

```sh
javac -encoding UTF-8 -d out src/*/*.java
java -cp out main.Main
```

Trong IntelliJ IDEA, mở thư mục `task`, chọn JDK, đánh dấu `src` là Sources Root nếu cần,
rồi chạy `src/main/Main.java`.
