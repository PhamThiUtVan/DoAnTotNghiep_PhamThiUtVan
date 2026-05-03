Đồ Án Tốt Nghiệp - Framework Kiểm Thử Tự Động

Giới thiệu
Đề tài: Nghiên cứu và xây dựng quy trình kiểm thử tự động sử dụng các công cụ kiểm thử phổ biến
Sinh viên: Phạm Thị Út Vân
MSV: 2022606199
Ngành: Kỹ thuật phần mềm
GVHD: ThS. Ngô Thị Bích Thúy
Đại học Công nghiệp Hà Nội - Năm 2026

Công nghệ sử dụng
Selenium WebDriver — Tự động hóa thao tác trình duyệt
TestNG — Framework điều phối và thực thi test
Maven — Quản lý dependency
Java 17 — Ngôn ngữ lập trình
Page Object Model (POM) + Data-Driven Testing — Mô hình thiết kế

Cấu trúc project
TestScript/
├── src/test/java/
│   ├── Common/                 # Tiện ích dùng chung
│   ├── CommonScreen/           # Page Object Models
│   ├── CSVDataProvider/        # Đọc dữ liệu từ CSV
│   └── TestSuite/              # Test cases
│       ├── AccountManagement/  # Đăng ký, Đăng nhập
│       ├── CategoryProductManagement/
│       ├── Order/
│       └── ProductManagement/
├── src/test/resources/
│   ├── test\_data/              # 5 file CSV dữ liệu kiểm thử
│   ├── log4j2.properties
│   └── testng.xml
└── pom.xml

Phạm vi kiểm thử
Áp dụng vào website thương mại điện tử Clothing Store với 5 chức năng và 136 test case:
| Chức năng | Đối tượng | Số test case |
| Đăng ký | Người dùng | 28 |
| Đăng nhập | Người dùng | 21 |
| Đặt hàng | Người dùng | 59 |
| Quản lý danh mục sản phẩm | Quản trị viên | 16 |
| Quản lý sản phẩm | Quản trị viên | 12 |
| Tổng | | 136 |

Kết quả thực thi
Tổng test case: 136
Pass:76 (55,88%)
Thời gian thực thi:30 phút (nhanh hơn \~6 lần so với kiểm thử thủ công)
Phát hiện: 15 nhóm lỗi thực tế trong hệ thống

\## License

Đồ án phục vụ mục đích học thuật.

