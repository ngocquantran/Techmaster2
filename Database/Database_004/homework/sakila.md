## Truy vấn Sakila

**_Tính trung bình cộng rental_rate của các bộ phim có rating là R_**

```sql
SELECT AVG(f.rental_rate)
FROM film f
WHERE f.rating ='R'
```

![image](img/2.2.PNG)

**_Đếm các bộ phim có special_features là Deleted Scenes_**

```sql
SELECT COUNT(f.film_id)
FROM film f
WHERE f.special_features LIKE '%Deleted Scenes%'
```

![image](img/2.1.PNG)

**_Tìm các bộ phim theo tên có chứa ‘ACADEMY’_**

```sql
SELECT *
FROM film f
WHERE f.title  LIKE '%ACADEMY%'
```

![image](img/2.3.PNG)
