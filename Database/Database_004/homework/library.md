## Truy vấn Library

**_Lấy ra sách được xuất bản trước năm 1900_**

```sql
SELECT *
FROM book b
WHERE b.year_of_publication <1900
```

**_Lấy ra sách có số lượng dưới 100_**

```sql
SELECT *
FROM book b
WHERE b.page_number <100
```

**_Liệt kê các quyển sách có id_publisher = 1 và sắp xếp theo thứ tự tăng dần của số trang_**

```sql
SELECT *
FROM book b
WHERE b.id_publisher =1
ORDER BY b.page_number ASC
```
