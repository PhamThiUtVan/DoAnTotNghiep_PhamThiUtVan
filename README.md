# Đồ án Tốt nghiệp

## Đề tài
Nghiên cứu và xây dựng quy trình kiểm thử tự động sử dụng các công cụ kiểm thử phổ biến

## Thông tin chung
- Sinh viên thực hiện: Phạm Thị Út Vân
- Mã sinh viên: 2022606199
- Ngành: Kỹ thuật phần mềm
- Giảng viên hướng dẫn: ThS. Ngô Thị Bích Thúy
- Trường: Đại học Công nghiệp Hà Nội
- Năm: 2026

## Tóm tắt
Đồ án nghiên cứu cơ sở lý thuyết về kiểm thử phần mềm và kiểm thử tự động, khảo sát các công cụ kiểm thử phổ biến và đề xuất quy trình kiểm thử tự động gồm sáu bước có vòng lặp cải tiến. Quy trình được áp dụng vào website thương mại điện tử Clothing Store với năm chức năng tiêu biểu nhằm đánh giá tính khả thi và hiệu quả.

## Công nghệ sử dụng
- Selenium WebDriver
- TestNG
- Maven
- Java 17
- Mô hình thiết kế: Page Object Model (POM) kết hợp Data-Driven Testing

## Cấu trúc dự án
- src/test/java/Common: Các lớp tiện ích dùng chung
- src/test/java/CommonScreen: Các lớp Page Object
- src/test/java/CSVDataProvider: Lớp đọc dữ liệu từ file CSV
- src/test/java/TestSuite: Các lớp test case theo từng nhóm chức năng
- src/test/resources/test_data: Các file dữ liệu kiểm thử CSV
- src/test/resources/testng.xml: File cấu hình TestNG
- pom.xml: File quản lý dependency Maven

## Phạm vi kiểm thử
Áp dụng kiểm thử tự động cho năm chức năng của website Clothing Store với tổng 136 test case, bao gồm: Đăng ký (28), Đăng nhập (21), Đặt hàng (59), Quản lý danh mục sản phẩm (16) và Quản lý sản phẩm (12).

## Kết quả
- Tổng số test case: 136
- Tỷ lệ pass: 55,88% (76/136)
- Thời gian thực thi: 30 phút
- Hiệu quả: nhanh hơn khoảng sáu lần so với kiểm thử thủ công
