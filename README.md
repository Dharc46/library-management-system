# Library Management System

Hệ thống quản lý thư viện được phát triển bằng Java với MySQL database, hỗ trợ các chức năng cơ bản như quản lý sách, mượn/trả sách.

## 📋 Yêu cầu hệ thống

- **Java Development Kit (JDK)**: 22 hoặc cao hơn
- **MySQL Server**: 8.0 hoặc cao hơn
- **IDE**: Visual Studio Code (khuyến nghị) hoặc IDE Java khác
- **Hệ điều hành**: Windows 10/11

## 🚀 Hướng dẫn cài đặt

### Bước 1: Cài đặt MySQL Server

1. Tải MySQL Server từ [trang chính thức](https://dev.mysql.com/downloads/mysql/)
2. Chạy file cài đặt và làm theo hướng dẫn
3. Trong quá trình cài đặt:
   - Chọn **Developer Default** configuration
   - Thiết lập mật khẩu cho tài khoản `root`
   - Ghi nhớ mật khẩu này để sử dụng trong project

### Bước 2: Thiết lập Database

1. Mở **Command Promt**
2. Đăng nhập với tài khoản root:
   ```sql
   mysql -u root -p
   ```
3. Tạo database cho project:
   ```sql
   DROP DATABASE IF EXISTS `library`;
   CREATE DATABASE `library`;
   USE library;
   ```

### Bước 3: Cấu hình kết nối Database

1. Mở file `/dao/DatabaseConnection.java`
2. Cập nhật thông tin kết nối trong file DatabaseConnection.java:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/library?useSSL=false&serverTimezone=UTC";
   private static final String USERNAME = "root";
   private static final String PASSWORD = "your_password_here"; // Thay bằng mật khẩu MySQL của bạn
   ```

### Bước 4: Thiết lập VS Code

1. Cài đặt **Extension Pack for Java** trong VS Code
2. Mở project folder trong VS Code
3. Đảm bảo Java SDK được nhận dạng đúng trong VS Code

## ▶️ Chạy ứng dụng

### Cách 1: Sử dụng Batch Script (Khuyến nghị)

1. Mở **File Explorer**
2. Navigate đến thư mục project
3. Double-click file `run_library.bat`
4. Chương trình sẽ khởi động với giao diện console

### Cách 2: Từ Command Line

```bash
cd path/to/project
run_library.bat
```

### Cách 3: Từ VS Code

1. Mở file `main/LibraryManagementSystem.java`
2. Click **Run** hoặc nhấn `F5`

## 🎯 Các chức năng chính

1. **Thêm sách** - Thêm sách mới vào hệ thống
2. **Sửa sách** - Cập nhật thông tin sách
3. **Xóa sách** - Xóa sách khỏi hệ thống
4. **Tìm kiếm theo tiêu đề** - Tìm sách theo tên
5. **Tìm kiếm theo tác giả** - Tìm sách theo tác giả
6. **Mượn sách** - Quản lý việc mượn sách
7. **Trả sách** - Quản lý việc trả sách
8. **Hiển thị tất cả sách** - Xem danh sách toàn bộ sách

## 🔧 Xử lý sự cố

### Lỗi "No suitable driver found"

- Đảm bảo file `mysql-connector-j-9.3.0.jar` có trong thư mục `lib/`
- Kiểm tra classpath trong file batch

### Lỗi kết nối Database

- Kiểm tra MySQL Server đang chạy
- Xác nhận username/password trong `DatabaseConnection.java`
- Đảm bảo database `library` đã được tạo

### Lỗi encoding tiếng Việt

- File batch đã được cấu hình UTF-8
- Nếu vẫn gặp lỗi, chạy `chcp 65001` trong Command Prompt

## 📁 Cấu trúc Project

```
library-management-system/
├── dao/                             # Data Access Object layer
│   ├── DatabaseConnection.java      # Kết nối database
│   └── BookDAO.java                 # Thao tác CRUD với bảng sách
├── lib/                             # Thư viện external
│   └── mysql-connector-j-9.3.0.jar  # MySQL JDBC Driver
├── main/                            # Main application
│   └── LibraryManagementSystem.java # Class chính chạy ứng dụng
├── model/                           # Entity/Model classes
│   ├── Book.java                    # Model cho đối tượng Sách
│   └── User.java
├── service/                         # Business Logic layer
│   └── LibraryService.java          # Logic xử lý nghiệp vụ
├── create_database.sql              # Script tạo database và tables
├── README.md                        # Tài liệu hướng dẫn
└── run_library.bat                  # Script chạy ứng dụng
```

## 👨‍💻 Tác giả

- **Tên**: Nguyễn Khởi Lâm
- **Email**: qwekhoilam@gmail.com

## 📄 Giấy phép

Dự án này được phát hành dưới giấy phép MIT.

---
