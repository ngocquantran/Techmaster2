import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Post {
    private int id;
    private String title;
    private String content;
    private String description;
    private String thumbnail;
    private int idCategory;
    private int idAuthor;
    private LocalDate createAt;
    private String status;

    public Post( String title, String content, String description, String thumbnail, int idCategory, int idAuthor, LocalDate createAt, String status) {

        this.title = title;
        this.content = content;
        this.description = description;
        this.thumbnail = thumbnail;
        this.idCategory = idCategory;
        this.idAuthor = idAuthor;
        this.createAt = createAt;
        this.status = status;
    }



    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", idCategory='" + idCategory + '\'' +
                ", idAuthor='" + idAuthor + '\'' +
                ", createAt='" + createAt + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
