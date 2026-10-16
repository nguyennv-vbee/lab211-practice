# J1.S.P0052 - Manage East Asia Countries

Bài 52 dùng cấu trúc phân lớp giống bài 71:

```text
src/
├── constants/   Constants, Message
├── controller/  CountryController
├── dto/         CountryRequestDTO, CountryResponseDTO
├── main/        Main
├── model/       Country, EastAsiaCountries
├── repository/  CountryRepository
├── services/    ManageEastAsiaCountries
├── utils/       Validation
└── view/        CountryView
```

`Main` nhập dữ liệu và tạo request DTO. Controller gọi service và view.
Service kiểm tra dữ liệu, gọi repository và chuyển model thành response DTO.
Repository lưu dữ liệu trong bộ nhớ; view hiển thị kết quả.

`Country` có các thuộc tính `protected`, constructor không tham số/có tham số,
getter/setter và `display()`. `EastAsiaCountries extends Country`, thêm
`countryTerrain`, gọi `super(...)` và override `display()` theo đề.

Bốn phương thức theo đề nằm trong `services.ManageEastAsiaCountries`:

- `void addCountryInformation(EastAsiaCountries country) throws Exception`
- `EastAsiaCountries getRecentlyEnteredInformation() throws Exception`
- `EastAsiaCountries[] searchInformationByName(String name) throws Exception`
- `EastAsiaCountries[] sortInformationByAscendingOrder() throws Exception`

Mỗi lần chọn mục 1 nhập một quốc gia, tổng cộng tối đa 11 quốc gia.
Mã quốc gia không trùng nhau, không phân biệt chữ hoa/thường.
Các trường văn bản không để trống; diện tích là số hữu hạn lớn hơn 0.
Mục 2 hiển thị **một quốc gia được thêm thành công gần nhất**, theo kiểu trả về
`EastAsiaCountries` của đề. Tìm kiếm theo một phần tên, không phân biệt hoa/thường.
Sắp xếp tên tăng dần không phân biệt hoa/thường và không thay đổi thứ tự nhập.
Dữ liệu tồn tại trong phiên chạy chương trình.

Chạy trong thư mục `country` với JDK 8 trở lên:

```sh
javac -encoding UTF-8 -d out src/*/*.java
java -cp out main.Main
```

Trong IntelliJ IDEA, mở thư mục `country`, chọn JDK, đánh dấu `src` là Sources Root
nếu cần rồi chạy `src/main/Main.java`.
