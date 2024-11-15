# README

## Tổng quan dự án

Dự án này sử dụng Java để thực hiện việc lấy dữ liệu JSON từ API công khai và xuất dữ liệu ra các file định dạng `.xlsx` và `.txt`. Các thành phần chính của dự án bao gồm:

- **API Endpoint**: `https://jsonplaceholder.typicode.com/albums`
- **Các lớp xử lý lấy dữ liệu**:
    - `URLConnectionAlbumsService`: Sử dụng `HttpURLConnection` để lấy dữ liệu.
    - `HttpClientAlbumService`: Sử dụng `HttpClient` để lấy dữ liệu.
- **Xuất dữ liệu**:
    - **Apache POI**: Xuất dữ liệu sang file `.xlsx`.
    - **FileWriter**: Xuất dữ liệu sang file `.txt`.

Cả hai lớp lấy dữ liệu đều kế thừa từ lớp abstract `AbstractAlbumService`, với hai phương thức abstract:
- `findAll`: Lấy toàn bộ danh sách album.
- `findById`: Lấy thông tin chi tiết của một album theo ID.

---

## Hướng dẫn sử dụng

### 1. Cài đặt và yêu cầu môi trường
- **Java**: Phiên bản 11 trở lên.
- **Thư viện cần thiết**:
    - Apache POI: [Tải Apache POI](https://poi.apache.org/)
    - json-simple.

### 2. Cách chạy dự án
- **Clone dự án**:
  ```bash
  git clone https://github.com/sonnguyen400/APIClient111152024.git
  ```

## 3. Các chức năng chính

### Lấy toàn bộ danh sách album
- Gọi phương thức `findAll()` từ một trong hai lớp:
    - `URLConnectionAlbumsService`
    - `HttpClientAlbumService`

### Lấy chi tiết album theo ID
- Gọi phương thức `findById(id)` với `id` là ID của album.

### Xuất dữ liệu ra file
- Lớp XlsxFileUtils Sử dụng **Apache POI** để xuất file `.xlsx`.
- Lớp TextFileUtils dụng **FileWriter** để xuất file `.txt`.

---

## Cấu trúc dự án

```plaintext
src/
├── model/
│   ├── Album.java   
├── services/
│   ├── AbstractAlbumService.java    // Lớp abstract định nghĩa các phương thức chung
│   ├── URLConnectionAlbumsService.java  // Lấy dữ liệu bằng HttpURLConnection
│   └── HttpClientAlbumService.java      // Lấy dữ liệu bằng HttpClient
├── utils/
│   ├── XlsxFileUtils.java            // Hỗ trợ xuất file xlsx
│   └── TextFileUtils.java             // Hỗ trợ xuất file txt
└── Main.java                         // Điểm bắt đầu của chương trình

