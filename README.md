Trong quá trình cấu hình CI/CD, execution logs của GitHub
Actions đã báo lỗi thất bại ở pha compile với thông báo
invalid target release: 26. Nhờ đọc log, em phát hiện
ra có sự sai lệch phiên bản môi trường: File pom.xml 
cầu Java 26 nhưng Workflow runner đang sử dụng JDK 17.
Để khắc phục, em đã hạ cấp (downgrade) target release
trong pom.xml về 17 để đồng bộ với runner. Sau khi commit
bản sửa lỗi, hệ thống CI đã tự động kích hoạt lại và build
thành công, xuất ra file Artifact đúng như mong đợi. Điều này
chứng minh sức mạnh của CI trong việc phát hiện sớm các lỗi về
môi trường triển khai (Environment Mismatch) trước khi code được
đưa lên Production.